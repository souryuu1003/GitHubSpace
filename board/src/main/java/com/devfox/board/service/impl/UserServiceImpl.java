package com.devfox.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devfox.board.dao.UserDAO;
import com.devfox.board.service.UserService;
import com.devfox.board.vo.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDAO userMapper;
	
	@Override
	public List<UserVO> selectUserList() throws Exception {
		return userMapper.selectUserList();
	}
	
	@Override
	public int selectUserNo(UserVO userVO) throws Exception{
		return userMapper.selectUserNo(userVO);
	}
	
	@Override
	public void insertUser(UserVO userVO){
		userMapper.insertUser(userVO);
	}
}
