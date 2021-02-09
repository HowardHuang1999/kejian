package resource.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IuputUtil {

	public static BufferedReader Input() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		return br;
	}
	
	//�жϴ����Ƿ���ǩԼ����ֹ��ְ��������λǩԼ
	public static boolean isSuccess(String Userid) throws SQLException {
		String sql = "select count(1) from qiuzhi where id=? and success=1;";
		Object[] obs = {Userid};
		ResultSet rs = DBUtil.executeQuery(sql, obs);
		if(rs.next())  {
			if(rs.getInt(1)==1) return true;
		}
		return false;
	}
}
