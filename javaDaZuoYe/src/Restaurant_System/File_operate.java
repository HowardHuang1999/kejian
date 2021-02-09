package Restaurant_System;

import java.io.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class File_operate {
	String filename="已点菜单.txt";
	public void read(JTextArea textArea) {
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			String n;
			while((n=br.readLine())!=null) {
				textArea.append(n+"\n");
			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    @SuppressWarnings({"unused", "rawtypes" })
	public void write(JTable jt,JComboBox jc,JTextField jf) {
		try {
			FileWriter fw=new FileWriter(filename,true);
			BufferedWriter bw=new BufferedWriter(fw);
			
			fw.write("价钱"+"\t"+"数量"+"\t"+"菜系"+"\t"+"桌号"+"\t"+"用餐人数"+"\r\n");
			
			for(int i=jt.getRowCount()-1;i>=0;i--) {
				for(int j=2;j>=0;j--) {
					fw.write(jt.getValueAt(i, j).toString()+"\t");
				}
				
				fw.write(jc.getSelectedItem().toString()+"\t");//写入桌号
				if(i==jt.getRowCount()-1) {
					fw.write(Integer.parseInt(jf.getText())+"人");
				}
				fw.write("\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			System.out.println("输入文件出错!!!");
			e.printStackTrace();
		}
	}
    @SuppressWarnings({"unused", "rawtypes" })
   	public void writeadd(JTable jt,JComboBox jc) {
    	//加单时进行写入文件
   		try {
   			FileWriter fw=new FileWriter(filename,true);
   			BufferedWriter bw=new BufferedWriter(fw);
   			
   			for(int i=jt.getRowCount()-1;i>=0;i--) {
   				for(int j=2;j>=0;j--) {
   					fw.write(jt.getValueAt(i, j).toString()+"\t");
   				}
   				fw.write(jc.getSelectedItem().toString()+"\t"+" "+"\r\n");//写入桌号
   			}
   			
   			fw.close();
   		} catch (IOException e) {
   			System.out.println("输入文件出错!!!");
   			e.printStackTrace();
   		}
   	}
}
