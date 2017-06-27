package com.exam.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */	

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("test", "모델에 테스트라고 넣으셨군요.");
		return "main";
	}
	
	@RequestMapping(value = "/board/list", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		logger.info("Welcome board! The client locale is {}.", locale);
		model.addAttribute("test", "모델에 테스트라고 넣으셨군요.");
		return "/board/board";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String user(Locale locale, Model model) {
		logger.info("Welcome user! The client locale is {}.", locale);
		model.addAttribute("test", "모델에 테스트라고 넣으셨군요.");
		return "/user/login";
	}
	
}
