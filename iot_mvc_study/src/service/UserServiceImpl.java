package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import bean.User;
import common.DBConn;

public class UserServiceImpl implements UserServiceIn {
	Scanner scan = new Scanner(System.in);
	Connection con;
	PreparedStatement ps;
	
	UserServiceImpl(){
		try {
			con = DBConn.getCon();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void selectUser() throws SQLException {
		String sql = "select user_num, user_id, user_name, user_pwd, class_num, age from user_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		rs.next();
//		getMetaData
//		getColumnCount
	}
	
	public void insertUserInfo(User user){
		
	}

	@Override
	public void insertUser() {
		String sql = "insert into user_info(user_id, user_name, user_pwd, class_num, age)";
		sql += "values(?,?,?,?,?)";
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}
	

}
