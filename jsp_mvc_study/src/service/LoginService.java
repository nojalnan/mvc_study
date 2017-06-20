package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import bean.User;
import common.DBConn;

public class LoginService {

	public User login(String userId, String userPwd){
		User user = null;
		try {
			Connection con = DBConn.getCon();
			String sql = "select user_name, user_pwd from user_info where user_id=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				if(userPwd.equals(rs.getString("user_pwd"))){
					user = new User();
					user.setUserId(userId);
					user.setUserName(rs.getString("user_name"));
					return user;
				}
			}
			
		}catch (Exception exception) {
			exception.printStackTrace();
		}finally{
			try {
				DBConn.closeCon();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
}
