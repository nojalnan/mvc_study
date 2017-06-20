package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.UserService;
import service.implement.UserServiceImpl;

public class ServletUser extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String action = request.getParameter("action");
		String result = "";
		HttpSession session = request.getSession();
		if(action.equals("LOGIN")){
			User user = us.login(id, pwd);
			if(user!=null){
				session.setAttribute("id", id);
				session.setAttribute("pwd", pwd);
				session.setAttribute("name", user.getUserName());
				session.setAttribute("admin", user.getAdmin());
				session.setAttribute("board_admin", user.getBoardAdmin());
				result += id + "님 로그인에 성공 하셨습니다.<input type='button' value='logout'onclick='doLogout()'/>";
				if(user.getAdmin()==1){
					result += "<br/><input type='button' value='유저리스트불러오기' onclick='doGetUserList()'/>";
				}
				if(user.getBoardAdmin()==1){
					result += "<br/><input type='button' value='게시판 불러오기' onclick='doGetBoardList()'/>";
				}
				
			}else{
				result += id + "님 로그인에 실패 하셨습니다.";
			}
		}else if(action.equals("LOGOUT")){
			id = (String) session.getAttribute("id");
			us.logout(session);
			result = id + "님 로그아웃 하셨습니다.";
		}else if(action.equals("SIGNUP")){
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			User user = new User();
			user.setUserName(name);
			user.setUserId(id);
			user.setUserPwd(pwd);
			user.setAge(Integer.parseInt(age));
			boolean isInsert = us.signup(user);
			if(isInsert){
				result = id + "님의 회원가입이 성공하셨습니다.";
			}else{
				result = id + "님의 회원가입이 실패하셨습니다.";
			}
		}else if(action.equals("USERLIST")){
			int admin = (int)session.getAttribute("admin");
			if(admin==1){
				List<User> userList = us.getUserList();
				result += "<table border='1'>";
				result += "<tr>";
				result += "<td>유저번호</td>";
				result += "<td>유저아이디</td>";
				result += "<td>유저이름</td>";
				result += "<td>유저나이</td>";
				result += "<td>삭제버튼</td>";
				result += "</tr>";
				for(User u : userList){
					result += "<tr>";
					result += "<td>" + u.getUserNum() +"</td>";
					result += "<td>" + u.getUserId() +"</td>";
					result += "<td>" + u.getUserName() +"</td>";
					result += "<td>" + u.getAge() +"</td>";
					result += "<td><input type='button' value='삭제' onclick='doDelete(" + u.getUserNum() + ")'/></td>";
					result += "</tr>";
				}
				result += "</table border>";
			}else{
				result = "관리자가 아니시네요. 꺼지세요!";
			}
		}else if(action.equals("SIGNOUT")){
			int admin = (int)session.getAttribute("admin");
			if(admin==1){
				String userNum = request.getParameter("user_num");
				User user = new User();
				user.setUserNum(Integer.parseInt(userNum));
				us.signout(user);
			}else{
				result = "관리자가 아니시네요. 꺼지세요!";
			}
		}
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println(result);
    }	
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    
}
