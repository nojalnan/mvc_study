package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConn;

public class UserServiceImpl implements UserServiceIn {
	
	Connection con;
	PreparedStatement ps;
	
	UserServiceImpl(){
		try {
			con = DBConn.getCon();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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

	@Override
	public void insertUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}
	

}
