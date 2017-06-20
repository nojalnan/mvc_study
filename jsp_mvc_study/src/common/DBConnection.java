package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;


public class DBConnection {

    public DataSource getDataSource(){
        FileInputStream fis = null;
        try {
        	//파일인풋스트림으로 읽어들일 파일을 지정해줍니다.
			fis = new FileInputStream("C:\\SpringTest\\workspace\\webTest\\src\\database.property");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

    	//프로퍼티 텍스트를 읽어올 프로퍼티변수를 선언해줍니다.
        Properties prps = new Properties();
        try {
        	//텍스트를 읽어들인 파일잇풉스트립을 prps에 로딩시킵니다.
			prps.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
        OracleDataSource oDS = null;
		try {
			oDS = new OracleDataSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        oDS.setURL(prps.getProperty("DB_URL"));
        oDS.setUser(prps.getProperty("DB_USERNAME"));
        oDS.setPassword(prps.getProperty("DB_PASSWORD"));
        return oDS;
    }
    
    public Connection getConnection() {
    	Connection con = null;
    	try {
        	DataSource ods = getDataSource();
			con = ods.getConnection();
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return con;
    }
    
    public void closeAll(Connection conn, Statement stms, ResultSet rs){
    	closeConn(conn);
    	closeStms(stms);
    	closeRs(rs);
    }
    
    
    public void closeConn(Connection conn){
    	try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void closeStms(Statement stms){
    	try {
    		stms.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void closeRs(ResultSet rs){
    	try {
    		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void main(String[] args){
    	DBConnection dbcon = new DBConnection();
    	Connection con = dbcon.getConnection();
    	PreparedStatement pstmt;
    	String rownum = "2";
    	String userId ="TEST";
    	try {
    		String sql="Select USERID, USERPWD from tuser2 where rownum=? and userid=?";
    		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, rownum);			
			pstmt.setString(2, userId);
			
			ResultSet rs = pstmt.executeQuery();
	    	while(rs.next()){
	    		System.out.print("userid : " + rs.getString(1));
	    		System.out.println(", userpwd : " + rs.getString(2));
	    	}
	    	dbcon.closeAll(con, pstmt, rs);
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }    
}
