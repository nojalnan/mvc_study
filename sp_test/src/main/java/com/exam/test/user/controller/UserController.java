package com.exam.test.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.test.user.dto.User;
import com.exam.test.user.service.UserService;

@Controller
public class UserController { 

	@Autowired
	private UserService us; 
	
	@RequestMapping("/user/main")
	public String init(HttpServletRequest request, ModelMap model, HttpSession hs) {
		String id = (String)hs.getAttribute("ID");
		if(id!=null){
			model.addAttribute("userid", id);
			return "/user/main";
		}else{
			return "/user/login";
		}
	}
	
	@RequestMapping(value="/user/loginaction", method=RequestMethod.POST)
	public @ResponseBody Map login(HttpServletRequest request, @RequestBody Map pm,ModelMap model,HttpSession hs) {
		User user = us.getUserPwd(pm);
		String url = "";
		if(user==null){
			model.put("data", "F");
			model.put("url", "/user/login");
			model.put("msg", "Login Fail");
		}else{
			hs.setAttribute("ID", user.getUserid());
			model.put("data", "S");
			model.put("url", "/user/main");
			model.put("msg", "Login Success");
		}
		return model;
	}
	
	@RequestMapping(value="/user/logoutaction", method=RequestMethod.GET)
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "/user/login";
	}
	
	@RequestMapping(value="/user/userlistaction", method=RequestMethod.POST)
	public @ResponseBody Map userlistaction(@RequestBody Map pm,ModelMap model,HttpSession hs) {
		String mode = (String)pm.get("mode");
		String userid = (String)pm.get("userid");
		if(mode.equals("del")){
			int memdel = us.memdel(pm);
			System.out.println("����� : "+memdel);
			if(memdel > 0){
				model.put("msg", userid+"���̵� �����Ǿ����ϴ�.");
				model.put("url", "/user/userlist");
			}else{
				model.put("url", "/user/userlist");
				model.put("msg", "������ �����Ͽ����ϴ�.");
			}
		}else{
			List memlist = us.memlist();
			List memrole = us.memrole();
			model.put("data", memlist);
			model.put("role", memrole);
			model.put("url", "/user/userlist");
			model.put("msg", "list call");
		}
		return model;
	}

	@RequestMapping(value="/user/sessionRegi")
	public @ResponseBody Map sessionRegi(@RequestBody Map pm,ModelMap model,HttpSession hs) {
		hs.setAttribute("role", (String)pm.get("role"));
		
		model.put("url", "/user/main");
		
		return model;
	}
	

}
