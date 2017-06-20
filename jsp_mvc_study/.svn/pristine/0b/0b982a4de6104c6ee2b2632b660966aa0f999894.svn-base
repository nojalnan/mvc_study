package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.DBConn;

public class ServletExam extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		try{
			Connection con = DBConn.getCon();
			Statement stmt = con.createStatement();
			String sql = "select user_name, user_pwd from user_info where user_id='" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);

			String result = "로그인 실패";
			while(rs.next()){
				if(pwd.equals(rs.getString("user_pwd"))){
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("pwd", pwd);
					session.setAttribute("name", rs.getString("user_name"));
					result = "로그인 성공";
				}
			}
			
			

	    	resp.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = resp.getWriter();
	        out.println(result); 
		}catch(Exception e){
			e.printStackTrace();
		}
    }
}
