package com.devfox.board.dao;

import java.util.List;

import com.devfox.board.vo.UserVO;

public interface UserDAO {
	List<UserVO> selectUserList() throws Exception;
	int selectUserNo(UserVO userVO);
	void joinUser(UserVO userVO);
	UserVO loginUser(UserVO userVO);
}

