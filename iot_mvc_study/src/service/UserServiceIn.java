package service;

import java.sql.SQLException;

import bean.User;

public interface UserServiceIn {
	public void selectUser() throws SQLException;
	public void insertUser(User user) throws SQLException;
	public void deleteUser() throws SQLException;
	public User insertUserInfo(User user);
}
