package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.LoginService;

public class ServletLogin2 extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse resp) 
			throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
    }	
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    }
    
}
