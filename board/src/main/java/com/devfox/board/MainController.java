package com.devfox.board;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devfox.board.service.BoardService;
import com.devfox.board.service.CommentService;
import com.devfox.board.service.UserService;
import com.devfox.board.vo.BoardVO;
import com.devfox.board.vo.CommentVO;
import com.devfox.board.vo.UserVO;

@Controller
public class MainController {

	@Resource(name = "userService")
	private UserService userService;
	@Resource(name = "boardService")
	private BoardService boardService;
	@Resource(name = "commentService")
	private CommentService commentService;
	
	/* main page */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
	    List<UserVO> userList = userService.selectUserList();
	    model.addAttribute("userList", userList);
	    return "forward:index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model, HttpSession session) throws Exception {
	    List<UserVO> userList = userService.selectUserList();
	    model.addAttribute("userList", userList);
	    return "index";
	}
	
	/* login */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws Exception {
	    return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginForm(Model model, HttpSession session, UserVO userVO) throws Exception {
		UserVO loginUser = userService.loginUser(userVO);
		if(null != loginUser) {
			session.setAttribute("loginUser", loginUser);
			model.addAttribute("errorMessage", "Spring Boardへようこそ。");
		}
		else {
			model.addAttribute("errorMessage", "メールアドレスまたはパスワードに間違いがあります。");
			return "login";
		}
		return this.index(model, session);
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) throws Exception {
		session.removeAttribute("loginUser");
		model.addAttribute("errorMessage", "ログアウトしました。");
	    return this.index(model, null);
	}
	
	/* join */
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) throws Exception {
	    return "join";
	}
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinForm(Model model, UserVO userVO) throws Exception {
		int selectUserNo = userService.selectUserNo(userVO);
		if(selectUserNo == -1 && "" != userVO.getUserId() && "" != userVO.getUserPw())
			userService.joinUser(userVO);
		else
			model.addAttribute("errorMessage", "既に登録されているメールアドレスです。");
	    return this.index(model, null);
	}
	
	/* board */
	@RequestMapping(value = "/listBoard", method = RequestMethod.GET)
	public String listBoard(Model model) throws Exception {
		List<BoardVO> boardList = boardService.selectBoardList();
		model.addAttribute("boardList", boardList);
	    return "/board/listBoard";
	}
	@RequestMapping(value = "/createBoard", method = RequestMethod.GET)
	public String createBoard(Model model) throws Exception {
	    return "/board/createBoard";
	}
	@RequestMapping(value = "/createBoard", method = RequestMethod.POST)
	public String createBoardForm(Model model, HttpServletRequest request, BoardVO boardVO) throws Exception {
		if(!request.getParameter("boardTitle").equals("") 
		&& !request.getParameter("boardWriter").equals("") 
		&& !request.getParameter("boardContent").equals("")) {
			boardVO.setBoardTitle(request.getParameter("boardTitle"));
			boardVO.setBoardWriter(request.getParameter("boardWriter"));
			boardVO.setBoardContent(request.getParameter("boardContent"));
			boardService.createBoard(boardVO);
		}else{
			return this.createBoard(model);
		};
		return this.listBoard(model);
	}
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String readBoard(Model model, HttpServletRequest request, BoardVO boardVO) throws Exception {
		boardVO.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		BoardVO readBoard = boardService.readBoard(boardVO);
		model.addAttribute("readBoard", readBoard);
		List<CommentVO> commentList = commentService.selectCommentList();
		model.addAttribute("commentList", commentList);
	    return "/board/readBoard";
	}
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public String updateBoard(Model model, HttpServletRequest request, BoardVO boardVO) throws Exception {
		boardVO.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		BoardVO updateBoard = boardService.readBoard(boardVO);
		model.addAttribute("updateBoard", updateBoard);
		return "/board/updateBoard";
	}
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public String updateBoardForm(Model model, HttpServletRequest request, BoardVO boardVO) throws Exception {
		boardVO.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		boardVO.setBoardTitle(request.getParameter("boardTitle"));
		boardVO.setBoardContent(request.getParameter("boardContent"));
		boardService.updateBoard(boardVO);
		model.addAttribute("errorMessage", "修正されました。");
		return this.listBoard(model);
	}
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoardForm(Model model, HttpServletRequest request) throws Exception {
		boardService.deleteBoard(Integer.parseInt(request.getParameter("boardNo")));
		model.addAttribute("errorMessage", "削除されました。");
		return this.listBoard(model);
	}
	
	/* comment */
	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
	public String deleteComment(Model model) throws Exception {
	    return "/board/readBoard";
	}
}