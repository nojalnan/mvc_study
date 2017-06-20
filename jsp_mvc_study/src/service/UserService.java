package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import bean.User;

public interface UserService {
	public User login(String userId, String userPwd);
	public boolean signup(User user);
	public boolean logout(HttpSession session);
	public boolean signout(User user);
	public List<User> getUserList();
}
