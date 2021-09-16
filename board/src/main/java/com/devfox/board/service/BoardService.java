package com.devfox.board.service;

import java.util.List;

import com.devfox.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> selectBoardList() throws Exception;
}

