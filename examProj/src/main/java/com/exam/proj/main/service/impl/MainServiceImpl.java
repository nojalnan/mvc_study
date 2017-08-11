package com.exam.proj.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.proj.main.service.MainService;
import com.exam.proj.main.vo.MainVO;

@Service("mainService")
public class MainServiceImpl implements MainService {

	@Resource(name = "mainMapper")
	MainMapper mainMapper;

	@Override
	public int getTotalCount() {
		return mainMapper.getTotalCount();
	}
	
	@Override
	public String getResult() {
		return mainMapper.getResult();
	}

	@Override
	public List<MainVO> getListResult(int page) {
		System.out.println("page : " + page);
		return mainMapper.getListResult(page);
	}

}
