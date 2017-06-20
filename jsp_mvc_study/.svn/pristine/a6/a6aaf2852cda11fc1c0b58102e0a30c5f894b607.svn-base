package service;
import java.sql.SQLException;
import java.util.Map;

import bean.TUser;
import dao.UserDAO;;

public class UserLoginService {

	public TUser login(Map paramMap) {
		String sql="Select user_id,user_pwd from user_info where user_id=:userid and user_pwd=:userpwd";
		UserDAO udao = new UserDAO();
		TUser tu = udao.getUser(sql, paramMap);
		return tu;
	}
}
