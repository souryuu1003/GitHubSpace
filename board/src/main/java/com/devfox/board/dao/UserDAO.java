package com.devfox.board.dao;

import java.util.List;

import com.devfox.board.vo.UserVO;

public interface UserDAO {
	List<UserVO> selectUserList() throws Exception;
	int selectUserNo(UserVO userVO) throws Exception;
	void joinUser(UserVO userVO) throws Exception;
	UserVO loginUser(UserVO userVO) throws Exception;
}

