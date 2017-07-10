package com.exam.test.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {
	
	@RequestMapping(value="/*")
	public String init(HttpServletRequest request, HttpSession hs, ModelMap model) {
		String id = (String)hs.getAttribute("ID");
		if(id==null) return "/user/login";
		ParamMap pm = new ParamMap(request);
		model.addAttribute("userid", id);
		String url = (String)pm.get("urlStr");
		if(url==null||url.equals("")){
			return "/user/main";
		}else if(url.equals("board")){
			System.out.println("123123123");
			return "/board/list";
		}
		return url;
	}
}
