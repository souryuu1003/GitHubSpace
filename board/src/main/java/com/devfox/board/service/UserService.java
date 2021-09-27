package com.devfox.board.service;

import java.util.List;

import com.devfox.board.vo.UserVO;

public interface UserService {
	List<UserVO> selectUserList() throws Exception;
	int selectUserNo(UserVO userVO) throws Exception;
	void joinUser(UserVO userVO) throws Exception;
	void updateUser(UserVO userVO) throws Exception;
	UserVO loginUser(UserVO userVO) throws Exception;
}

