package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import bean.User;
import common.DBConn;

public class SignupService {

	public boolean signup(User user){
		try {
			Connection con = DBConn.getCon();
			String sql = "insert into user_info(user_name, user_id,user_pwd, age)";
			sql+=" values(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserPwd());
			pstmt.setInt(4, user.getAge());
			
			int resultNum = pstmt.executeUpdate();
			if(resultNum==1){
				return true;
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
		return false;
	}
}
