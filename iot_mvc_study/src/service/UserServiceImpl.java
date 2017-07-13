package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
	public  ArrayList<HashMap> selectUser() throws SQLException {
//		getMetaData
//		getColumnCount
//		getColumnLabel
		String sql = "select user_num, user_id, user_name, user_pwd, class_num, age from user_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCnt = rsmd.getColumnCount();		
		ArrayList<HashMap> userInfoList = new ArrayList<HashMap>();
		while(rs.next()){
			HashMap hm = new HashMap();
			for(int i=1;i<=colCnt;i++){
				String name = rsmd.getColumnLabel(i);
				hm.put(name, rs.getString(name));
			}
			userInfoList.add(hm);
		}
		return userInfoList;
	}
	
	@Override
	public void insertUser(User user) throws SQLException {
		UserServiceIn us = new UserServiceImpl();
		String sql = "insert into user_info(user_id, user_name, user_pwd, class_num, age)";
		sql += "values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		us.insertUserInfo(user);
		ps.setString(1, user.getUserId());
		ps.setString(2, user.getUserPwd());
		ps.setString(3, user.getUserName());
		ps.setInt(4, user.getClassNum());
		ps.setInt(5, user.getAge());
		int result = ps.executeUpdate();
		System.out.println(result + "개의 행이 추가되었습니다.");
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertUserInfo(User user) {
		System.out.println("아이디를 입력해주세요.");
		user.setUserId(scan.nextLine());
		System.out.println("비밀번호를 입력해주세요.");
		user.setUserPwd(scan.nextLine());
		System.out.println("이름를 입력해주세요.");
		user.setUserName(scan.nextLine());
		System.out.println("클래스를 입력해주세요.");
		user.setClassNum(Integer.parseInt(scan.nextLine()));
		System.out.println("나이를 입력해주세요.");
		user.setAge(Integer.parseInt(scan.nextLine()));
		
	}
	

}
