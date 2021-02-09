package resource.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/Resource_manage?useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PWD = "201810098126";
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static PreparedStatement getPstmt(String sql,Object[] obs) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, USERNAME, PWD);
		
		pstmt = conn.prepareStatement(sql);
		if(obs != null) {
			for(int i=0;i<obs.length;i++) {
				pstmt.setObject(i+1, obs[i]);
			}
		}
		return pstmt;
	}
	
	// ‘ˆ…æ∏ƒ
	public static boolean executeUpdate(String sql,Object[] obs) {
		int count;
		try {
			count = getPstmt(sql,obs).executeUpdate();
			return count>0 ? true : false;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
		} finally {
			CloseAll(null,pstmt,conn);
		}
		
		return false;
	}
	
	// ≤È—Ø
	public static ResultSet executeQuery(String sql,Object[] obs){
		try {
			rs = getPstmt(sql,obs).executeQuery();
			return rs;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void CloseAll(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
