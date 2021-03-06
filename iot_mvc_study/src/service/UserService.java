package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import bean.User;

public interface UserService {
	public ArrayList<HashMap> selectUser() throws SQLException;

	public void insertUser(User user) throws SQLException;

	public int deleteUser(User user) throws SQLException;

	public void inputUserInfo(User user);
	
	public int getClassNumber(User user);
	
}
