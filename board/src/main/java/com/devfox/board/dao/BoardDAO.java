package com.devfox.board.dao;

import java.util.List;

import com.devfox.board.vo.BoardVO;

public interface BoardDAO {
	List<BoardVO> selectBoardList() throws Exception;
}

