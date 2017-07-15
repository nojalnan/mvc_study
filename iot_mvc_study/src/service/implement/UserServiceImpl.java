package service.implement;

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
import service.UserService;

public class UserServiceImpl implements UserService {
	Scanner scan = new Scanner(System.in);
	PreparedStatement ps;

	public void connDb(String sql) {
		try {
			Connection con = DBConn.getCon();
			ps = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<HashMap> selectUser() throws SQLException {
		// getMetaData
		// getColumnCount
		// getColumnLabel
		String sql = "select user_num, user_id, user_name, user_pwd, class_num, age from user_info";
		UserServiceImpl us = new UserServiceImpl();
		us.connDb(sql);
		ResultSet rs = us.ps.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCnt = rsmd.getColumnCount();
		ArrayList<HashMap> userInfoList = new ArrayList<HashMap>();
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

	@Override
	public void insertUser(User user) throws SQLException {
		String sql = "insert into user_info(user_id, user_name, user_pwd, class_num, age)";
		UserServiceImpl us = new UserServiceImpl();
		sql += "values(?,?,?,?,?)";
		us.connDb(sql);
		us.insertUserInfo(user);
		us.ps.setString(1, user.getUserId());
		us.ps.setString(2, user.getUserPwd());
		us.ps.setString(3, user.getUserName());
		us.ps.setInt(4, user.getClassNum());
		us.ps.setInt(5, user.getAge());
		int result = us.ps.executeUpdate();
		System.out.println(result + "개의 행이 추가되었습니다.");
	}

	@Override
	public void deleteUser(User user) throws SQLException {
		String sql = "delete from user_info where user_num=?";
		UserServiceImpl us = new UserServiceImpl();
		us.connDb(sql);
		us.insertUserInfo(user);
		us.ps.setInt(1, user.getUserNum());
		int result = us.ps.executeUpdate();
		System.out.println(result + "개의 행이 삭제되었습니다.");
	}

	@Override
	public void insertUserInfo(User user) {
		if (user.getCommand() == 2) {
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
		} else if (user.getCommand() == 3) {
			System.out.println("삭제하려는 유저의 번호를 입력해주세요.");
			user.setUserNum(Integer.parseInt(scan.nextLine()));
		} else {
			System.out.println("서비스번호를 잘못 입력하셨습니다.");
		}

	}

}
