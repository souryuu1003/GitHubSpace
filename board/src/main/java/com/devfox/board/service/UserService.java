package com.devfox.board.service;

import java.util.List;

import com.devfox.board.vo.UserVO;

public interface UserService {
	List<UserVO> selectUserList() throws Exception;
}

