package resource.util;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Operation {

	public static void RecordCompany() throws IOException {
		System.out.println("�����뵥λ���");
		String id = IuputUtil.Input().readLine();
		System.out.println("�����뵥λ����");
		String name = IuputUtil.Input().readLine();
		System.out.println("��������ϵ������");
		String manageName = IuputUtil.Input().readLine();
		System.out.println("��������ϵ�˵绰");
		String managePhone = IuputUtil.Input().readLine();
		System.out.println("��������Ƹ����");
		String number = IuputUtil.Input().readLine();
		System.out.println("������ѧ��Ҫ��");
		String graduation = IuputUtil.Input().readLine();
		System.out.println("��������Ƹ��λ");
		String position = IuputUtil.Input().readLine();
		
		//����������ݷ�װ��Object���鲢������²���
		Object[] obs = {id,name,manageName,managePhone,number,graduation,position};
		String sql = "insert into cmessage values (?,?,?,?,?,?,?);";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("�Ǽ���Ƹ��λ�ɹ�");
		else System.out.println("�Ǽ���Ƹ��λʧ��");
		System.out.println();
	}
	
	public static void RecordUser() throws IOException {
		System.out.println("��������Ƹ�����֤");
		String id = IuputUtil.Input().readLine();
		System.out.println("����������");
		String name = IuputUtil.Input().readLine();
		System.out.println("�������ַ");
		String address = IuputUtil.Input().readLine();
		System.out.println("������绰");
		String phone = IuputUtil.Input().readLine();
		System.out.println("������ѧ��");
		String graduation = IuputUtil.Input().readLine();
		System.out.println("��������ְ��λ");
		String position = IuputUtil.Input().readLine();
		
		Object[] obs = {id,name,address,phone,graduation,position};
		String sql = "insert into umessage values (?,?,?,?,?,?);";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("�Ǽ���Ƹ����Ϣ�ɹ�");
		else System.out.println("�Ǽ���Ƹ����Ϣʧ��");
		System.out.println();
	}
	
	public static void Resume() throws IOException{
		System.out.println("��������ְ�����֤");
		String userId = IuputUtil.Input().readLine();
		System.out.println("����������λ���");
		String companyId = IuputUtil.Input().readLine();
		System.out.println("��������ְ��λ");
		String position = IuputUtil.Input().readLine();
		
		Object[] obs = {userId,companyId,position};
		String sql = "insert into qiuzhi(userid,companyid,position) values (?,?,?);";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("Ͷ�ݼ����ɹ�");
		else System.out.println("Ͷ�ݼ���ʧ��,ԭ������Ǹ���ְ��/��λ������");
		System.out.println();
	}
	
	public static void Signed() throws IOException, SQLException {
		System.out.println("��������ְ�����֤");
		String userId = IuputUtil.Input().readLine();
		System.out.println("��������Ƹ��λ�ı��");
		String companyId = IuputUtil.Input().readLine();
		
		//�жϴ����Ƿ���ǩԼ
		if(IuputUtil.isSuccess(userId)) {
			System.out.println("����ְ�����뵥λ�ɹ�ǩԼ��");
			return;
		}
		
		Object[] obs = {userId,companyId};
		String sql = "update qiuzhi set success=1 where userid=? and companyid=?";
		boolean result = DBUtil.executeUpdate(sql, obs);
		if(result) System.out.println("�Ǽ�ǩԼ��Ϣ�ɹ���");
		else System.out.println("�Ǽ�ǩԼ��Ϣʧ��,ԭ������Ǹ���ְ��/��λ������");
		System.out.println();
	}
	
	public static void SeeCompany() throws SQLException {
		String sql = "select * from cmessage;";
		ResultSet result = DBUtil.executeQuery(sql, null);
		System.out.println("��λ���\t��λ����\t��ϵ������\t��ϵ�˵绰\t\t��Ƹ����\tѧ��Ҫ��\t��Ƹ��λ");
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
		System.out.println("��ְ������\t��λ����\t��Ƹ��λ");
		while(result.next()) {
			System.out.print(result.getString(1)+"\t");
			System.out.print(result.getString(2)+"\t");
			System.out.print(result.getString(3));
			System.out.println();
		}
		System.out.println();
	}
}
