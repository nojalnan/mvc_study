package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection con;
	
	public static Connection getCon() throws SQLException{
		if(con==null){
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study_jsp", "root", "1234");
		}
		return con;
	}
	
	public static void closeCon() throws SQLException{
		if(con!=null){
			con.close();
			con = null;
		}
	}
}
