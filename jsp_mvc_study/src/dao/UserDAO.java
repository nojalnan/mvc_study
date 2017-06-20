package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.TUser;
import common.NamedParameterStatement;

public class UserDAO extends BasicDAO{
	
	public List<TUser> getUserList(String sql){
		List<TUser> tuList = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = this.con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			tuList = new ArrayList<TUser>();
			while(rs.next()){
				TUser tu = new TUser();
				tu.setUserId(rs.getString("WKONUM"));
				tu.setUserPwd(rs.getString("ASSYCD"));
				tuList.add(tu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tuList;
	}

	public List<TUser> getUserList(String sql, Map paramMap){
		List<TUser> tuList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = this.con.prepareStatement(sql);
			pstmt.setString(0, paramMap.get("rownum").toString());
			rs = pstmt.executeQuery();
			
			tuList = new ArrayList<TUser>();
			while(rs.next()){
				TUser tu = new TUser();
				tu.setUserId(rs.getString("WKONUM"));
				tu.setUserPwd(rs.getString("ASSYCD"));
				tuList.add(tu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tuList;
	}
	
	public TUser getUser(String sql, Map paramMap){
		TUser tu = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			NamedParameterStatement  nps = new NamedParameterStatement (this.con, sql);
			Iterator it = paramMap.keySet().iterator();
			while(it.hasNext()){
				String key = it.next().toString();
				String value = paramMap.get(key).toString();
				nps.setString(key, value);
			}
			rs=nps.executeQuery();
			tu = (TUser)mapRersultSetToObject(rs, TUser.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.dbCon.closeAll(this.con, pstmt, rs);
		}
		return tu;
	}
	
}
