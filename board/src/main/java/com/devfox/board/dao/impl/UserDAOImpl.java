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
	
	@Override
	public int selectUserNo(UserVO userVO) throws Exception {
		int selectUserNo = -1;
		if(sqlSession.selectOne("checkUserNo", userVO) != null) {
			selectUserNo = sqlSession.selectOne("checkUserNo", userVO);
		}
		return selectUserNo;
	}
	
	@Override
	public void joinUser(UserVO userVO) throws Exception {
		sqlSession.insert("joinUser", userVO);
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		sqlSession.update("updateUser", userVO);
	}
	
	@Override
	public UserVO loginUser(UserVO userVO) throws Exception {
		return sqlSession.selectOne("loginUser", userVO);
	}
}
