package com.exam.proj.board.service;

import java.util.List;

import com.exam.proj.board.vo.BoardVO;

public interface BoardService {
	

	int getTotalCount();
	
	String getResult();
	
	List<BoardVO> getListResult(int page);

}
