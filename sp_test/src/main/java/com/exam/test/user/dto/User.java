package com.exam.test.user.dto;

import com.exam.test.common.CommonDTO;

public class User extends CommonDTO{
	
	private String userid;
	private String userpwd;
	private String usernm;
	private String userrol;

	public String getUserid() {
		return userid;
	}

	public String getUsernm() {
		return usernm;
	}

	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	public String getUserrol() {
		return userrol;
	}

	public void setUserrol(String userrol) {
		this.userrol = userrol;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	

}
