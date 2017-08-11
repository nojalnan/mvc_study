package com.exam.proj.main.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.proj.main.service.MainService;

@Controller
public class MainController {

	@Resource(name = "mainService")
	private MainService mainService;
	
	@RequestMapping(value = "/main/main.do")
	public String main(@RequestParam(value="page",required=false,defaultValue="1") int page, Model model) {
		
		int totalCount = mainService.getTotalCount();
		
		int firstPage = 1, begin, end;
		int lastPage = totalCount/(10+1)+1;
		int prevPage = (int)((page-1)/10)*10;
		if( prevPage < 1 ) prevPage = 1;
		int nextPage = ((int)(((page-1)/10)+1)*10+1);
		if( nextPage > lastPage ) nextPage = lastPage;

		begin = (int)((page-1)/10)*10+1;
		end = begin+9;
		if( end > lastPage ) end = lastPage;
		
		model.addAttribute("result", mainService.getResult());
		
		model.addAttribute("list", mainService.getListResult(page));
		model.addAttribute("firstPage", firstPage);
		model.addAttribute("prevPage", prevPage);
		model.addAttribute("nextPage", nextPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("begin", begin);
		model.addAttribute("end", end);
		model.addAttribute("totalCount", totalCount);
		
		return "/main/main";
		
	}
	
}
