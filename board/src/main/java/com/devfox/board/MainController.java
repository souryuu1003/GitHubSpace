package com.devfox.board;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devfox.board.service.UserService;
import com.devfox.board.vo.UserVO;

@Controller
public class MainController {

	@Resource(name = "userService")
	private UserService userService;
	
	/* main page */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		try {
		    List<UserVO> userList = userService.selectUserList();
		    model.addAttribute("userList", userList);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "forward:index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) throws Exception {
		try {
		    List<UserVO> userList = userService.selectUserList();
		    model.addAttribute("userList", userList);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return "index";
	}
	
	/* login */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
	    return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginForm(Model model, HttpSession session, UserVO userVO) throws Exception {
		try {
			userVO.setUserPw(SHA512(userVO.getUserPw()));
			UserVO loginUser = userService.loginUser(userVO);
			if(null != loginUser && loginUser.getUserRl() == 0) {
				model.addAttribute("errorMessage", "メール認証を行ってください。。");
				return "index";
			}
			else if(null != loginUser && loginUser.getUserRl() > 0) {
				session.setAttribute("loginUser", loginUser);
				model.addAttribute("errorMessage", "Spring Boardへようこそ。");
			}
			else {
				model.addAttribute("errorMessage", "メールアドレスまたはパスワードに間違いがあります。");
				return "login";
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.index(model, session);
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) throws Exception {
		try {
			session.removeAttribute("loginUser");
			model.addAttribute("errorMessage", "ログアウトしました。");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return this.index(model, null);
	}
	
	/* join */
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) throws Exception {
	    return "join";
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinForm(Model model, UserVO userVO) throws Exception {
		try {
			int selectUserNo = userService.selectUserNo(userVO);
			if(selectUserNo == -1 && "" != userVO.getUserId() && "" != userVO.getUserPw()) {
				userVO.setUserPw(SHA512(userVO.getUserPw()));
				userService.joinUser(userVO);
				model.addAttribute("joinUser", userVO);
			}
			else if(userVO.getUserRl() == 1){
				model.addAttribute("errorMessage", "登録が完了されました。");
			}
			else {
				model.addAttribute("errorMessage", "既に登録されているメールアドレスです。");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return this.index(model, null);
	}
	@RequestMapping(value="/joinConfirm", method=RequestMethod.GET)
	public String emailConfirm(Model model, UserVO userVO) throws Exception {
		userVO.setUserRl(1);
		userService.updateUser(userVO);
		return this.joinForm(model, userVO);
	}
	public static String SHA512(String userPw) {
		String hex = null;
		try {
			MessageDigest msg = MessageDigest.getInstance("SHA-512");
			msg.update(userPw.getBytes());
			hex = String.format("%128x", new BigInteger(1, msg.digest()));
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hex; 
	}
}