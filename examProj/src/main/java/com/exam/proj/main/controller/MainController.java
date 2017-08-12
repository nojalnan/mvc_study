package com.exam.proj.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.proj.main.service.MainService;
import com.exam.proj.main.vo.MainVO;

@Controller
public class MainController {

	@Resource(name = "mainService")
	private MainService mainService;

	@RequestMapping(value = "/main/main.do")
	public String main(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			Model model) {

		// 현재 페이지
		// 글 갯수
		int totalCount = mainService.getTotalCount();

		int firstPage = 1, begin, end;
		int lastPage = totalCount / (10 + 1) + 1;
		int prevPage = (int) ((page - 1) / 10) * 10;
		if (prevPage < 1)
			prevPage = 1;
		int nextPage = ((int) (((page - 1) / 10) + 1) * 10 + 1);
		if (nextPage > lastPage)
			nextPage = lastPage;

		begin = (int) ((page - 1) / 10) * 10 + 1;
		end = begin + 9;
		if (end > lastPage)
			end = lastPage;

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

	@RequestMapping(value = "/main/view.do")
	public String view(@RequestParam(value = "board_num") int board_num, Model model) {
		model.addAttribute("item", mainService.getBoardView(board_num));
		return "/main/view";
	}

	@RequestMapping(value = "/main/modify.do")
	public String modify(@RequestParam(value = "board_num") int board_num, Model model) {
		model.addAttribute("item", mainService.getBoardView(board_num));
		return "/main/modify";
	}

	@RequestMapping(value = "/main/update.do")
	public String update(MainVO mainVO, Model model) {
		int result = mainService.updateBoardItem(mainVO);
		return "redirect:/main/view.do?board_num=" + mainVO.getBoard_num();
	}

	@RequestMapping(value = "/main/delete.do")
	public String delete(MainVO mainVO, Model model) {
		int result = mainService.deleteBoardItem(mainVO);
		return "redirect:/main/main.do";
	}

	@RequestMapping(value = "/main/ajax.do")
	public String ajax(Model model) {
		return "/main/ajax";
	}

	@RequestMapping(value = "/main/data/boardList.do",method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> boardList(@RequestBody int page) throws Exception {
		Thread.sleep(500);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("totalCount", mainService.getTotalCount());
		result.put("boardList", mainService.getListResult(page));
		return result;
	}

}
