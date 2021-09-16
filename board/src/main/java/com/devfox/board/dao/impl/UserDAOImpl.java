package com.devfox.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devfox.board.dao.UserDAO;
import com.devfox.board.vo.UserVO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserVO> selectUserList() throws Exception {
		return sqlSession.selectList("selectUserList");
	}
}

