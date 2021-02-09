package Restaurant_System;

import java.io.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class File_operate {
	String filename="�ѵ�˵�.txt";
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
			
			fw.write("��Ǯ"+"\t"+"����"+"\t"+"��ϵ"+"\t"+"����"+"\t"+"�ò�����"+"\r\n");
			
			for(int i=jt.getRowCount()-1;i>=0;i--) {
				for(int j=2;j>=0;j--) {
					fw.write(jt.getValueAt(i, j).toString()+"\t");
				}
				
				fw.write(jc.getSelectedItem().toString()+"\t");//д������
				if(i==jt.getRowCount()-1) {
					fw.write(Integer.parseInt(jf.getText())+"��");
				}
				fw.write("\r\n");
			}
			fw.close();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			System.out.println("�����ļ�����!!!");
			e.printStackTrace();
		}
	}
    @SuppressWarnings({"unused", "rawtypes" })
   	public void writeadd(JTable jt,JComboBox jc) {
    	//�ӵ�ʱ����д���ļ�
   		try {
   			FileWriter fw=new FileWriter(filename,true);
   			BufferedWriter bw=new BufferedWriter(fw);
   			
   			for(int i=jt.getRowCount()-1;i>=0;i--) {
   				for(int j=2;j>=0;j--) {
   					fw.write(jt.getValueAt(i, j).toString()+"\t");
   				}
   				fw.write(jc.getSelectedItem().toString()+"\t"+" "+"\r\n");//д������
   			}
   			
   			fw.close();
   		} catch (IOException e) {
   			System.out.println("�����ļ�����!!!");
   			e.printStackTrace();
   		}
   	}
}
