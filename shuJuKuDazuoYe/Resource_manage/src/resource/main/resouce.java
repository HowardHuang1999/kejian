package resource.main;

import java.io.IOException;

import resource.util.IuputUtil;
import resource.util.Operation;

public class resouce {

	public static void main(String[] args) {

		while(true) {
			System.out.println("��ѡ����Ҫ���еĲ���");
			System.out.println("1���Ǽ���Ƹ��λ");
			System.out.println("2���Ǽ���ְ����Ϣ");
			System.out.println("3��Ͷ�ݼ���");
			System.out.println("4���Ǽ�ǩԼ���");
			System.out.println("5���鿴��Ƹ��λ");
			System.out.println("6���鿴ǩԼ���");
			
			int num;
			try {
				num = Integer.parseInt(IuputUtil.Input().readLine());
				switch(num) {
				case 1:Operation.RecordCompany();break;
				case 2:Operation.RecordUser();break;
				case 3:Operation.Resume();break;
				case 4:Operation.Signed();break;
				case 5:Operation.SeeCompany();break;
				case 6:Operation.SeeSigned();break;
				default:break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

	
}
