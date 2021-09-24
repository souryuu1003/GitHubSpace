package com.devfox.board.service;

import java.util.List;

import com.devfox.board.vo.CommentVO;

public interface CommentService {
	List<CommentVO> selectCommentList(int boardNo) throws Exception;
}

