package com.exam.proj.main.service.impl;

import java.util.List;

import com.exam.proj.main.vo.MainVO;
import com.exam.proj.util.annotation.Mapper;

@Mapper
public interface MainMapper {

	int getTotalCount();
	
	String getResult();
	
	List<MainVO> getListResult(int page);
	
	MainVO getBoardView(int board_num);
	
	int insertBoardItem(MainVO mainVO);
	
	int updateBoardItem(MainVO mainVO);
	
	int deleteBoardItem(MainVO mainVO);
	
}
