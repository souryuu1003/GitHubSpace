package com.devfox.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devfox.board.dao.BoardDAO;
import com.devfox.board.service.BoardService;
import com.devfox.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Resource
	private BoardDAO boardMapper;
	
	@Override
	public List<BoardVO> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
}
