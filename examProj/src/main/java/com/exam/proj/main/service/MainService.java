package com.exam.proj.main.service;

import java.util.List;

import com.exam.proj.main.vo.MainVO;

public interface MainService {

	int getTotalCount();
	
	String getResult();
	
	List<MainVO> getListResult(int page);
	
	MainVO getBoardView(int binum);
	
	int insertBoardItem(MainVO mainVO);
	
	int updateBoardItem(MainVO mainVO);
	
	int deleteBoardItem(MainVO mainVO);

}
