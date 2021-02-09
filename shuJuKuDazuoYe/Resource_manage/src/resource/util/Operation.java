package resource.util;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operation {

	public static void RecordCompany() throws IOException {
		System.out.println("请输入单位编号");
		String id = IuputUtil.Input().readLine();
		System.out.println("请输入单位名称");
		String name = IuputUtil.Input().readLine();
		System.out.println("请输入联系人姓名");
		String manageName = IuputUtil.Input().readLine();
		System.out.println("请输入联系人电话");
		String managePhone = IuputUtil.Input().readLine();
		System.out.println("请输入招聘人数");
		String number = IuputUtil.Input().readLine();
		System.out.println("请输入学历要求");
		String graduation = IuputUtil.Input().readLine();
		System.out.println("请输入招聘岗位");
		String position = IuputUtil.Input().readLine();
		
		//将输入的数据封装成Object数组并传入更新操作
		Object[] obs = {id,name,manageName,managePhone,number,graduation,position};
		String sql = "insert into cmessage values (?,?,?,?,?,?,?);";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("登记招聘单位成功");
		else System.out.println("登记招聘单位失败");
		System.out.println();
	}
	
	public static void RecordUser() throws IOException {
		System.out.println("请输入招聘者身份证");
		String id = IuputUtil.Input().readLine();
		System.out.println("请输入姓名");
		String name = IuputUtil.Input().readLine();
		System.out.println("请输入地址");
		String address = IuputUtil.Input().readLine();
		System.out.println("请输入电话");
		String phone = IuputUtil.Input().readLine();
		System.out.println("请输入学历");
		String graduation = IuputUtil.Input().readLine();
		System.out.println("请输入求职岗位");
		String position = IuputUtil.Input().readLine();
		
		Object[] obs = {id,name,address,phone,graduation,position};
		String sql = "insert into umessage values (?,?,?,?,?,?);";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("登记招聘者信息成功");
		else System.out.println("登记招聘者信息失败");
		System.out.println();
	}
	
	public static void Resume() throws IOException{
		System.out.println("请输入求职者身份证");
		String userId = IuputUtil.Input().readLine();
		System.out.println("请输入意向单位编号");
		String companyId = IuputUtil.Input().readLine();
		System.out.println("请输入求职岗位");
		String position = IuputUtil.Input().readLine();
		
		Object[] obs = {userId,companyId,position};
		String sql = "insert into qiuzhi(userid,companyid,position) values (?,?,?);";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("投递简历成功");
		else System.out.println("投递简历失败,原因可能是该求职者/单位不存在");
		System.out.println();
	}
	
	public static void Signed() throws IOException, SQLException {
		System.out.println("请输入求职者身份证");
		String userId = IuputUtil.Input().readLine();
		System.out.println("请输入招聘单位的编号");
		String companyId = IuputUtil.Input().readLine();
		
		//判断此人是否已签约
		if(IuputUtil.isSuccess(userId)) {
			System.out.println("该求职者已与单位成功签约！");
			return;
		}
		
		Object[] obs = {userId,companyId};
		String sql = "update qiuzhi set success=1 where userid=? and companyid=?";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("登记签约信息成功！");
		else System.out.println("登记签约信息失败,原因可能是该求职者/单位不存在");
		System.out.println();
	}
	
	public static void SeeCompany() throws SQLException {
		String sql = "select * from cmessage;";
		ResultSet result = DBUtil.executeQuery(sql, null);
		System.out.println("单位编号\t单位名称\t联系人姓名\t联系人电话\t\t招聘人数\t学历要求\t招聘岗位");
		while(result.next()) {
			System.out.print(result.getString(1)+"\t");
			System.out.print(result.getString(2)+"\t");
			System.out.print(result.getString(3)+"\t");
			System.out.print(result.getString(4)+"\t");
			System.out.print(result.getString(5)+"\t");
			System.out.print(result.getString(6)+"\t");
			System.out.print(result.getString(7));
			System.out.println();
		}
		System.out.println();
	}
	
	public static void SeeSigned() throws SQLException {
		String sql = "select * from success_table;";
		ResultSet result = DBUtil.executeQuery(sql, null);
		System.out.println("求职者姓名\t单位名称\t招聘岗位");
		while(result.next()) {
			System.out.print(result.getString(1)+"\t");
			System.out.print(result.getString(2)+"\t");
			System.out.print(result.getString(3));
			System.out.println();
		}
		System.out.println();
	}
}
