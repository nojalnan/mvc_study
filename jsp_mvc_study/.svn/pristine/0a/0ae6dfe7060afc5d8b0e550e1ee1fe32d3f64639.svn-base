package controller;

import javax.servlet.http.HttpServletRequest;

import bean.TUser;
import service.UserLoginService;

public class UserController extends BasicController{
	private String action;
	private TUser user;
	
	public UserController(HttpServletRequest req) {
		super(req);
	}
	
	public String doAction(){
		String writeStr = null;
		String action = this.paramMap.get("action").toString();
		
		if("LOGIN".equals(action)){
			UserLoginService uls = new UserLoginService();
			uls.login(this.paramMap);
		}
		return writeStr;
	}
}
