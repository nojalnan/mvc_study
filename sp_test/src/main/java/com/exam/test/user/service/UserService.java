package com.exam.test.user.service;

import java.util.List;
import java.util.Map;

import com.exam.test.user.dto.User;

public interface UserService {

	public User getUserPwd(Map paramMap);

	public List memlist();
	
	public List memrole();	
	
	public int memdel(Map paramMap);
}
