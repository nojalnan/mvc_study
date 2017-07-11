package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import bean.User;

public interface UserServiceIn {
	public ArrayList<HashMap> selectUser() throws SQLException;
	public void insertUser(User user) throws SQLException;
	public void deleteUser() throws SQLException;
	public void insertUserInfo(User user);
}