package com.sp.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.sb.model.User;
import com.sp.sb.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService us;
	@RequestMapping(value="/user", method=RequestMethod.POST)
	public void getEmployees(@RequestBody User hm) {
		us.save(hm);
	}
	
	@RequestMapping(value="/user/{user_num}",method=RequestMethod.GET)
	public User getUser(@PathVariable("user_num")long userNum){
		return us.findOne(userNum);
	}
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
		public List<User>getUserList(){
			return us.findAll();		
	}

}
