package Restaurant_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class dialog {
	public dialog(int i) {
		JDialog dialog = new JDialog();
        try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//设置关闭方式
			dialog.setVisible(true);
		} catch (Exception w) {
			w.printStackTrace();
		}
        dialog.setFont(new Font("微软雅黑", Font.BOLD, 14));
        dialog.setTitle("温馨提示\r\n");
        
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(204, 255, 0));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
		btnOk.setFont(new Font("微软雅黑", Font.BOLD, 17));
		btnOk.setBounds(186, 206, 113, 27);
		dialog.getContentPane().add(btnOk);
		switch(i) {
		case 0:
			JLabel lblNewLabel = new JLabel("店家已以收到订单，请稍等！");
			lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(108, 94, 311, 64);
			dialog.getContentPane().add(lblNewLabel);
			dialog.setBounds(200,300,500,600);
			break;
		case 1:
			JLabel lblNewLabel1 = new JLabel("请输入本次用餐的人数");
			lblNewLabel1.setFont(new Font("微软雅黑", Font.BOLD, 18));
			lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel1.setBounds(108, 94, 311, 64);
			dialog.getContentPane().add(lblNewLabel1);
			dialog.setBounds(200,300,500,600);
			
			JLabel label = new JLabel("以及选择需要下单的菜系哦");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("微软雅黑", Font.BOLD, 18));
			label.setBounds(108, 58, 311, 64);
			dialog.getContentPane().add(label);
			break;
		case 2:
			JLabel lblNewL = new JLabel("店家已收到加单，请稍等！");
			lblNewL.setFont(new Font("微软雅黑", Font.BOLD, 18));
			lblNewL.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewL.setBounds(108, 94, 311, 64);
			dialog.getContentPane().add(lblNewL);
			dialog.setBounds(200,300,500,600);
			break;
		case 3:
			JLabel lblNewL3 = new JLabel("请选择要加单的菜系");
			lblNewL3.setFont(new Font("微软雅黑", Font.BOLD, 18));
			lblNewL3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewL3.setBounds(108, 94, 311, 64);
			dialog.getContentPane().add(lblNewL3);
			dialog.setBounds(200,300,500,600);
			break;
		}
	}
}
