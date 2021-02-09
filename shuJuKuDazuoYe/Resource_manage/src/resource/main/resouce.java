package resource.main;

import java.io.IOException;

import resource.util.IuputUtil;
import resource.util.Operation;

public class resouce {

	public static void main(String[] args) {

		while(true) {
			System.out.println("请选择需要进行的操作");
			System.out.println("1、登记招聘单位");
			System.out.println("2、登记求职者信息");
			System.out.println("3、投递简历");
			System.out.println("4、登记签约情况");
			System.out.println("5、查看招聘单位");
			System.out.println("6、查看签约情况");
			
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
