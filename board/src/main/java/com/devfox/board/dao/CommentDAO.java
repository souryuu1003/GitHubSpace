package com.devfox.board.dao;

import java.util.List;

import com.devfox.board.vo.CommentVO;

public interface CommentDAO {
	List<CommentVO> selectCommentList(int boardNo) throws Exception;
}

