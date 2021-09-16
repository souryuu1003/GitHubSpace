package com.devfox.board.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devfox.board.dao.CommentDAO;
import com.devfox.board.vo.CommentVO;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<CommentVO> selectCommentList() throws Exception {
		return sqlSession.selectList("selectCommentList");
	}
}

