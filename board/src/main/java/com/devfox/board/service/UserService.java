package com.devfox.board.service;

import java.util.List;

import com.devfox.board.vo.UserVO;

public interface UserService {
	List<UserVO> selectUserList() throws Exception;
	int selectUserNo(UserVO userVO) throws Exception;
	void insertUser(UserVO userVO);
}

