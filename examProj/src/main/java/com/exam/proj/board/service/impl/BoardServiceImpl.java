package com.exam.proj.board.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.proj.board.service.BoardService;
import com.exam.proj.board.vo.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardMapper")
	BoardMapper boardMapper;

	@Override
	public int getTotalCount() {
		return boardMapper.getTotalCount();
	}
	
	@Override
	public String getResult() {
		return boardMapper.getResult();
	}

	@Override
	public List<BoardVO> getListResult(int page) {
		System.out.println("page : " + page);
		return boardMapper.getListResult(page);
	}

}
