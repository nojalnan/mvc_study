package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection con;
	
	public static Connection getCon() throws ClassNotFoundException, SQLException{
		if(con==null){
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iot_test", "root", "1234");
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
