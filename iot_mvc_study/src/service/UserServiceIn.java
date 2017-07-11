package service;

import java.sql.SQLException;

public interface UserServiceIn {
	public void selectUser() throws SQLException;
	public void insertUser() throws SQLException;
	public void deleteUser() throws SQLException;

}
