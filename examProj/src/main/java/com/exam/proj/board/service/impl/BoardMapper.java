package com.exam.proj.board.service.impl;

import java.util.List;

import com.exam.proj.board.vo.BoardVO;
import com.exam.proj.util.annotation.Mapper;

@Mapper
public interface BoardMapper {

	int getTotalCount();
	
	String getResult();
	
	List<BoardVO> getListResult(int page);
}
