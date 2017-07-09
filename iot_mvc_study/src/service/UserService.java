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


public class UserService {
	Scanner scan = new Scanner(System.in);
	Connection con;
	PreparedStatement ps;
	UserService(){
		try{
			con = DBConn.getCon();
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public ArrayList<HashMap> selectUser() throws SQLException{
		ArrayList<HashMap> userInfoList = new ArrayList<HashMap>();
		String sql = "select user_num, user_id, user_pwd, user_name, class_num, age from user_info";
		ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCnt = rsmd.getColumnCount();
		while (rs.next()) {
			HashMap hm = new HashMap();
			for (int i = 1; i <= colCnt; i++) {
				String name = rsmd.getColumnLabel(i);
				hm.put(name, rs.getString(name));
			}
			userInfoList.add(hm);
		}
		return userInfoList;
	}
	
	public User inputUserInfo(User user){
		System.out.println("아이디를 입력해주세요 .");
		String id = scan.nextLine();
		user.setUserId(id);
		System.out.println("비밀번호를 입력해주세요 .");
		String pwd = scan.nextLine();
		user.setUserPwd(pwd);		
		System.out.println("이름를 입력해주세요 .");
		String name = scan.nextLine();
		user.setUserName(name);	
		System.out.println("클래스를 입력해주세요 .");
		int classNum = Integer.parseInt(scan.nextLine());
		user.setClassNum(classNum);		
		System.out.println("나이를 입력해주세요 .");
		int age = Integer.parseInt(scan.nextLine());
		user.setAge(age);
		return user;
		
	}
	
	public void insertUser(User user) throws SQLException{
		UserService us = new UserService();
		String sql = "insert into user_info(user_id, user_pwd, user_name, class_num, age)";
		sql += " values(?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		us.inputUserInfo(user);
		ps.setString(1,user.getUserId());
		ps.setString(2,user.getUserPwd());
		ps.setString(3,user.getUserName());
		ps.setInt(4,user.getClassNum());
		ps.setInt(5, user.getAge());
		
		int result = ps.executeUpdate();
		System.out.println(result + "갯수 만큼 추가 되었습니다.");
	}
	
	public void deleteUser(){
		
	}
	
}
