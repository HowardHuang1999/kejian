package Restaurant_System;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.table.*;
import javax.swing.event.*;

public class Gui_System extends JFrame {

	private JPanel 主面板;
	private JTextField 用餐人数文本;
	private JTable table = new JTable();;
	private Timer timer;//实时更新
	int sum=0;//计算金额
	//定义菜单单选框
	JRadioButton radioButton = new JRadioButton("黄金糕 ");
	JRadioButton radioButton_1 = new JRadioButton("炒田螺");
	JRadioButton radioButton_2 = new JRadioButton("地三鲜");
	JRadioButton radioButton_3 = new JRadioButton("爆炒脆骨");
	JRadioButton radioButton_4 = new JRadioButton("铁板生肠");
	JRadioButton radioButton_5 = new JRadioButton("爆炒河蚌");
    JRadioButton radioButton_6 = new JRadioButton("香辣鱿鱼圈");
    JRadioButton radioButton_7 = new JRadioButton("铁板牛肉");
    JRadioButton radioButton_8 = new JRadioButton("铁板生肠");
    JRadioButton radioButton_9 = new JRadioButton("爆炒河蚌");
    JRadioButton radioButton_10 = new JRadioButton("炒田螺");
    JRadioButton radioButton_11 = new JRadioButton("铁板鸡杂");
    JRadioButton radioButton_12 = new JRadioButton("蒜蓉油麦");
    JRadioButton radioButton_13 = new JRadioButton("蒜蓉芥兰");
    JRadioButton radioButton_14_1 = new JRadioButton("拔丝地瓜");
    JRadioButton radioButton_15 = new JRadioButton("地三鲜");
    JRadioButton radioButton_16 = new JRadioButton("炒四季豆");
    JRadioButton radioButton_17 = new JRadioButton("拌野菜");
    JRadioButton radioButton_14 = new JRadioButton("香辣鸡扒饭");
    JRadioButton radioButton_18 = new JRadioButton("瘦肉粥");
    JRadioButton radioButton_19 = new JRadioButton("蛋蛋饭团");
    JRadioButton radioButton_20 = new JRadioButton("牛杂粥");
    JRadioButton radioButton_21 = new JRadioButton("海鲜粥");
    JRadioButton radioButton_22 = new JRadioButton("五谷鱼粉");
    JRadioButton radioButton_23 = new JRadioButton("千层榴莲");
    JRadioButton radioButton_24 = new JRadioButton("红豆冰沙");
    JRadioButton radioButton_25 = new JRadioButton("百香果西米露");
    JRadioButton radioButton_26 = new JRadioButton("芒果冰沙");
    JRadioButton radioButton_27 = new JRadioButton("养生牛奶搪胶");
    JRadioButton radioButton_28 = new JRadioButton("芋圆西米露");
    JRadioButton radioButton_29 = new JRadioButton("柠檬冰茶");
    JRadioButton radioButton_30 = new JRadioButton("王老吉");
    JRadioButton radioButton_31 = new JRadioButton("拔丝地瓜");
    JRadioButton radioButton_34 = new JRadioButton("可口可乐");
    JRadioButton radioButton_33 = new JRadioButton("百威啤酒");
    JRadioButton radioButton_32 = new JRadioButton("果粒橙");
    //定义每个菜单的数字调节控件即选择菜的数量
    JSpinner spinner = new JSpinner();
    JSpinner spinner_1 = new JSpinner();
	JSpinner spinner_2 = new JSpinner();
	JSpinner spinner_3 = new JSpinner();
	JSpinner spinner_4 = new JSpinner();
	JSpinner spinner_5 = new JSpinner();
	JSpinner spinner_6 = new JSpinner();
	JSpinner spinner_7 = new JSpinner();
	JSpinner spinner_8 = new JSpinner();
	JSpinner spinner_9 = new JSpinner();
	JSpinner spinner_10 = new JSpinner();
	JSpinner spinner_11 = new JSpinner();
	JSpinner spinner_12 = new JSpinner();
	JSpinner spinner_13 = new JSpinner();
	JSpinner spinner_14 = new JSpinner();
	JSpinner spinner_15 = new JSpinner();
	JSpinner spinner_16 = new JSpinner();
	JSpinner spinner_17 = new JSpinner();
	JSpinner spinner_18 = new JSpinner();
	JSpinner spinner_19 = new JSpinner();
	JSpinner spinner_20 = new JSpinner();
	JSpinner spinner_21 = new JSpinner();
	JSpinner spinner_22 = new JSpinner();
	JSpinner spinner_23 = new JSpinner();
	JSpinner spinner_24 = new JSpinner();
	JSpinner spinner_25 = new JSpinner();
	JSpinner spinner_26 = new JSpinner();
	JSpinner spinner_27 = new JSpinner();
	JSpinner spinner_28 = new JSpinner();
	JSpinner spinner_29 = new JSpinner();
	JSpinner spinner_30 = new JSpinner();
	JSpinner spinner_31 = new JSpinner();
	JSpinner spinner_32 = new JSpinner();
	JSpinner spinner_33 = new JSpinner();
	JSpinner spinner_34 = new JSpinner();
	JSpinner spinner_35 = new JSpinner();
	DefaultTableModel model=new DefaultTableModel();//表格模式
	JButton 加单按钮 = new JButton("加单");
	JButton 结账按钮 = new JButton("结账");
	JLabel 总额标签 = new JLabel("总额标签");
				
	public static void main(String[] args) {
		//创建类时自动定义的线程。
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_System frame = new Gui_System();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public Gui_System(){
		//定义表格的首行
		Vector vrow =new Vector();
		Vector vcol =new Vector();
		vcol.add("菜式");
		vcol.add("数量");
		vcol.add("价钱");
		model=new DefaultTableModel(vrow,vcol);
		table.setModel(model);
		
		//卡片式布局，后面面板中要用到
		CardLayout c1=new CardLayout(2,4);
		
		//Jframe设置
		setResizable(false);
		setTitle("点餐系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭模式
		setBounds(100, 100, 1371, 791);
		主面板 = new JPanel();
		setContentPane(主面板);
		主面板.setLayout(null);
		
		JPanel 大面板 = new JPanel();
		大面板.setBackground(new Color(245, 245, 245));
		大面板.setBounds(20, 80, 1351, 610);
		主面板.add(大面板);
		大面板.setLayout(null);
		
		JPanel 导航面板 = new JPanel();
		导航面板.setBounds(14, 13, 118, 589);
		大面板.add(导航面板);
		导航面板.setLayout(null);
		
		
		JPanel 欢迎面板 = new JPanel();
		欢迎面板.setToolTipText("");
		欢迎面板.setBackground(new Color(255, 239, 213));
		欢迎面板.setBounds(0, 0, 1365, 67);
		主面板.add(欢迎面板);
		
		JButton 热销菜系 = new JButton("热销菜系");
		热销菜系.setFont(new Font("新宋体", Font.PLAIN, 15));//PLAIN:普通样式常量。BOLD :粗体样。ITALIC: 斜体样式
		热销菜系.setBounds(10, 60, 98, 27);
		导航面板.add(热销菜系);
		
		JButton 小炒类 = new JButton("小炒类");
		小炒类.setFont(new Font("新宋体", Font.PLAIN, 15));
		小炒类.setBounds(10, 100, 98, 27);
		导航面板.add(小炒类);
		
		JButton 蔬菜类 = new JButton("蔬菜类");
		蔬菜类.setFont(new Font("新宋体", Font.PLAIN, 15));
		蔬菜类.setBounds(10, 140, 98, 27);
		导航面板.add(蔬菜类);
		
		JButton 主食类 = new JButton("主食类");
		主食类.setFont(new Font("新宋体", Font.PLAIN, 15));
		主食类.setBounds(10, 180, 98, 27);
		导航面板.add(主食类);
		
		JMenuItem 导航菜单 = new JMenuItem("导航菜单");
		导航菜单.setBounds(0, 0, 118, 39);
		导航面板.add(导航菜单);
		导航菜单.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		导航菜单.setBackground(new Color(127, 255, 212));
		
		JButton 甜品类 = new JButton("甜品类");
		甜品类.setFont(new Font("新宋体", Font.PLAIN, 15));
		甜品类.setBounds(10, 220, 98, 27);
		导航面板.add(甜品类);
		
		JButton 饮品类 = new JButton("饮品类");
		饮品类.setFont(new Font("新宋体", Font.PLAIN, 15));
		饮品类.setBounds(10, 260, 98, 27);
		导航面板.add(饮品类);
		
		JPanel 主卡片 = new JPanel();
		主卡片.setBounds(147, 0, 885, 602);
		大面板.add(主卡片);
		主卡片.setLayout(c1);
				
		JPanel 热销面板 = new JPanel();
		主卡片.add(热销面板, "热销面板");
		热销面板.setLayout(null);
		
		//滚动面板，配合table使用
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1057, 169, 280, 374);
		大面板.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBorder(null);
		table.setRowHeight(20);//设置高度
		table.setFont(new Font("微软雅黑", Font.BOLD, 16));
		scrollPane.setViewportView(table);//将表格添加到滚动面板
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"菜式", "数量", "价钱"
			}
		));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("图片//FullSizeRender.jpg"));
		label_1.setBounds(35, 13, 225, 182);
		热销面板.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("图片//IMG_4953.JPG"));
		label.setBounds(320, 13, 225, 182);
		热销面板.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("图片//IMG_4970.JPG"));
		lblNewLabel.setBounds(596, 13, 225, 182);
		热销面板.add(lblNewLabel);
		
		JLabel 价钱1 = new JLabel("23");
		价钱1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱1.setBounds(411, 219, 18, 18);
		热销面板.add(价钱1);
		
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_1.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_1.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_1.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_1.getValue().toString())*Integer.parseInt(价钱1.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_1.setEnabled(false);
		//设置spinner的最低数量跟每次递增的大小
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		//让spinner的文本框不能编辑
		JSpinner.DefaultEditor sd_1=(JSpinner.DefaultEditor) spinner_1.getEditor();
		sd_1.getTextField().setEditable(false);
		spinner_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_1.setBounds(484, 214, 40, 27);
		热销面板.add(spinner_1);
		
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton_1.isSelected()) {
					spinner_1.setEnabled(true);//选中了才可以点击
					model.addRow(new Object[] {radioButton_1.getText(),spinner_1.getValue()
							,Integer.parseInt(spinner_1.getValue().toString())*Integer.parseInt(价钱1.getText())});
					table.setModel(model);//实现实时更新表格内容
				}
				else{
					spinner_1.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							//删除用户取消的菜系
							if(radioButton_1.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			}
		  }
		});
		radioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_1.setBounds(320, 215, 81, 27);
		热销面板.add(radioButton_1);
		
		JLabel 价钱 = new JLabel("25");
		价钱.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱.setBounds(120, 220, 18, 18);
		热销面板.add(价钱);
		
		spinner.addChangeListener(new ChangeListener() {//spinner的增加事件
			public void stateChanged(ChangeEvent arg0) {
				for(int i=table.getRowCount()-1;i>=0;i--) {
					for(int j=table.getColumnCount()-1;j>=0;j--) {
						if(radioButton.getText().equals(table.getValueAt(i, j).toString())) {
							//改变表格中菜的数量
							table.setValueAt(spinner.getValue(), i, j+1);
							//改变表格中菜的价钱
							table.setValueAt(Integer.parseInt(spinner.getValue().toString())*Integer.parseInt(价钱.getText()), i, j+2);
						}
					}
				}
			}
		});
		spinner.setEnabled(false);
		
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		//让spinner的文本框不能编辑
		JSpinner.DefaultEditor sd=(JSpinner.DefaultEditor) spinner.getEditor();
		sd.getTextField().setEditable(false);
		spinner.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner.setBounds(206, 214, 40, 27);
		热销面板.add(spinner);
		
		radioButton.addActionListener(new ActionListener() {//添加事件
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton.isSelected()) {
					spinner.setEnabled(true);
					model.addRow(new Object[] {radioButton.getText(),spinner.getValue()
							,Integer.parseInt(spinner_1.getValue().toString())*Integer.parseInt(价钱.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			}
		  }
		});
		radioButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton.setBounds(35, 215, 81, 27);
		热销面板.add(radioButton);
		
		JLabel label_2 = new JLabel("份");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_2.setBounds(249, 214, 26, 30);
		热销面板.add(label_2);
		
		JLabel label_3 = new JLabel("份");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_3.setBounds(527, 213, 26, 30);
		热销面板.add(label_3);
		
		JLabel 价钱2 = new JLabel("23");
		价钱2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱2.setBounds(699, 219, 18, 18);
		热销面板.add(价钱2);
		
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_1.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_2.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_2.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_2.getValue().toString())*Integer.parseInt(价钱2.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_2.setEnabled(false);
		spinner_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_2.setBounds(770, 212, 40, 27);
		热销面板.add(spinner_2);
		
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_2.isSelected()) {
					spinner_2.setEnabled(true);
					model.addRow(new Object[] {radioButton_2.getText(),spinner_2.getValue()
							,Integer.parseInt(spinner_2.getValue().toString())*Integer.parseInt(价钱2.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_2.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_2.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			}
			}
		});
		radioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_2.setBounds(600, 214, 94, 27);
		热销面板.add(radioButton_2);
		
		JLabel label_4 = new JLabel("份");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_4.setBounds(812, 208, 26, 30);
		热销面板.add(label_4);
		
		JLabel 价钱3 = new JLabel("25");
		价钱3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱3.setBounds(134, 523, 18, 18);
		热销面板.add(价钱3);
		
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_3.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_3.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_3.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_3.getValue().toString())*Integer.parseInt(价钱3.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_3.setEnabled(false);
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_3.setBounds(206, 517, 40, 27);
		热销面板.add(spinner_3);
		
		JLabel label_5 = new JLabel("份");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_5.setBounds(249, 514, 26, 30);
		热销面板.add(label_5);
		
		
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_3.isSelected()) {
					spinner_3.setEnabled(true);
					model.addRow(new Object[] {radioButton_3.getText(),spinner_3.getValue()
							,Integer.parseInt(spinner_3.getValue().toString())*Integer.parseInt(价钱3.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_3.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_3.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			}
			}
		});
		radioButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_3.setBounds(35, 519, 94, 27);
		热销面板.add(radioButton_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_6.setIcon(new ImageIcon("图片//IMG_4955.JPG"));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(35, 313, 225, 182);
		热销面板.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("图片//IMG_4983.JPG"));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_7.setBounds(320, 313, 225, 182);
		热销面板.add(label_7);
		
		JLabel 价钱4 = new JLabel("25");
		价钱4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱4.setBounds(419, 523, 18, 18);
		热销面板.add(价钱4);
		
		spinner_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_4.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_4.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_4.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_4.getValue().toString())*Integer.parseInt(价钱4.getText()), i, j+2);
							}
						}
					}
				}
			} 
		});
		spinner_4.setEnabled(false);
		spinner_4.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_4.setBounds(484, 517, 40, 27);
		热销面板.add(spinner_4);
		
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_4.isSelected()) {
					spinner_4.setEnabled(true);
					model.addRow(new Object[] {radioButton_4.getText(),spinner_4.getValue()
							,Integer.parseInt(spinner_4.getValue().toString())*Integer.parseInt(价钱4.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_4.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_4.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_4.setBounds(320, 519, 94, 27);
		热销面板.add(radioButton_4);
		
		JLabel label_8 = new JLabel("份");
		label_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_8.setBounds(527, 517, 26, 30);
		热销面板.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("图片//IMG_4965.JPG"));
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_9.setBounds(598, 313, 225, 182);
		热销面板.add(label_9);
		
		JLabel 价钱5 = new JLabel("28");
		价钱5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱5.setBounds(697, 520, 18, 18);
		热销面板.add(价钱5);
		
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_5.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_5.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_5.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_5.getValue().toString())*Integer.parseInt(价钱5.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_5.setEnabled(false);
		spinner_5.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_5.setBounds(769, 514, 40, 27);
		热销面板.add(spinner_5);
		
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_5.isSelected()) {
					spinner_5.setEnabled(true);
					model.addRow(new Object[] {radioButton_5.getText(),spinner_5.getValue()
							,Integer.parseInt(spinner_5.getValue().toString())*Integer.parseInt(价钱5.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_5.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_5.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_5.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_5.setBounds(598, 515, 94, 27);
		热销面板.add(radioButton_5);
		
		JLabel label_10 = new JLabel("份");
		label_10.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_10.setBounds(812, 514, 26, 30);
		热销面板.add(label_10);
		
		JLabel label_12 = new JLabel("元/份");
		label_12.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_12.setBounds(138, 219, 40, 18);
		热销面板.add(label_12);
		
		JLabel label_13 = new JLabel("元/份");
		label_13.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_13.setBounds(430, 219, 40, 18);
		热销面板.add(label_13);
		
		JLabel label_14 = new JLabel("元/份");
		label_14.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_14.setBounds(716, 219, 40, 18);
		热销面板.add(label_14);
		
		JLabel label_15 = new JLabel("元/份");
		label_15.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_15.setBounds(152, 522, 40, 18);
		热销面板.add(label_15);
		
		JLabel label_18 = new JLabel("元/份");
		label_18.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_18.setBounds(437, 522, 40, 18);
		热销面板.add(label_18);
		
		JLabel label_16 = new JLabel("元/份");
		label_16.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_16.setBounds(715, 519, 40, 18);
		热销面板.add(label_16);
		
		JPanel 小炒面板 = new JPanel();
		主卡片.add(小炒面板, "小炒面板");
		小炒面板.setLayout(null);
		
		JLabel 价钱6 = new JLabel("23");
		价钱6.setBounds(156, 207, 18, 22);
		价钱6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		小炒面板.add(价钱6);
		
		spinner_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_6.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_6.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_6.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_6.getValue().toString())*Integer.parseInt(价钱6.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_6.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_6.setBounds(218, 204, 32, 28);
		spinner_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_6.setEnabled(false);
		小炒面板.add(spinner_6);
		
		radioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_6.isSelected()) {
					spinner_6.setEnabled(true);
					model.addRow(new Object[] {radioButton_6.getText(),spinner_6.getValue()
							,Integer.parseInt(spinner_6.getValue().toString())*Integer.parseInt(价钱6.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_5.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_6.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_6.setBounds(46, 204, 109, 31);
		radioButton_6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		小炒面板.add(radioButton_6);
		
		JLabel label_17 = new JLabel("元/份");
		label_17.setBounds(177, 207, 39, 22);
		label_17.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		小炒面板.add(label_17);
		
		JLabel label_20 = new JLabel("份");
		label_20.setBounds(255, 207, 16, 22);
		label_20.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		小炒面板.add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon("图片//IMG_4956.JPG"));
		label_21.setBounds(46, 13, 225, 182);
		小炒面板.add(label_21);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("图片//IMG_4954.JPG"));
		label_11.setBounds(338, 13, 225, 182);
		小炒面板.add(label_11);
		
		JLabel 价钱7 = new JLabel("28");
		价钱7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱7.setBounds(448, 207, 18, 22);
		小炒面板.add(价钱7);
		
		spinner_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_7.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_7.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_7.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_7.getValue().toString())*Integer.parseInt(价钱7.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_7.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_7.setEnabled(false);
		spinner_7.setBounds(510, 204, 32, 28);
		小炒面板.add(spinner_7);
		
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_7.isSelected()) {
					spinner_7.setEnabled(true);
					model.addRow(new Object[] {radioButton_7.getText(),spinner_7.getValue()
							,Integer.parseInt(spinner_7.getValue().toString())*Integer.parseInt(价钱7.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_7.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_7.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_7.setBounds(348, 204, 98, 31);
		小炒面板.add(radioButton_7);
		
		JLabel label_23 = new JLabel("元/份");
		label_23.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_23.setBounds(469, 207, 39, 22);
		小炒面板.add(label_23);
		
		JLabel label_24 = new JLabel("份");
		label_24.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_24.setBounds(547, 207, 16, 22);
		小炒面板.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon("图片//IMG_4983.JPG"));
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBounds(624, 13, 225, 182);
		小炒面板.add(label_25);
		
		JLabel 价钱8 = new JLabel("25");
		价钱8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱8.setBounds(734, 207, 18, 22);
		小炒面板.add(价钱8);
		
		spinner_8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_8.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_8.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_8.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_8.getValue().toString())*Integer.parseInt(价钱8.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_8.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_8.setEnabled(false);
		spinner_8.setBounds(796, 204, 32, 28);
		小炒面板.add(spinner_8);
		
		radioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_8.isSelected()) {
					spinner_8.setEnabled(true);
					model.addRow(new Object[] {radioButton_8.getText(),spinner_8.getValue()
							,Integer.parseInt(spinner_8.getValue().toString())*Integer.parseInt(价钱8.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_8.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_8.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_8.setBounds(624, 204, 109, 31);
		小炒面板.add(radioButton_8);
		
		JLabel label_27 = new JLabel("元/份");
		label_27.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_27.setBounds(755, 207, 39, 22);
		小炒面板.add(label_27);
		
		JLabel label_28 = new JLabel("份");
		label_28.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_28.setBounds(833, 207, 16, 22);
		小炒面板.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon("图片//IMG_4965.JPG"));
		label_29.setBounds(46, 313, 225, 182);
		小炒面板.add(label_29);
		
		JLabel 价钱9 = new JLabel("28");
		价钱9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱9.setBounds(156, 507, 18, 22);
		小炒面板.add(价钱9);
		
		spinner_9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_9.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_9.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_9.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_9.getValue().toString())*Integer.parseInt(价钱9.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_9.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_9.setEnabled(false);
		spinner_9.setBounds(218, 504, 32, 28);
		小炒面板.add(spinner_9);
		
		radioButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_9.isSelected()) {
					spinner_9.setEnabled(true);
					model.addRow(new Object[] {radioButton_9.getText(),spinner_9.getValue()
							,Integer.parseInt(spinner_9.getValue().toString())*Integer.parseInt(价钱9.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_9.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_9.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_9.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_9.setBounds(46, 504, 109, 31);
		小炒面板.add(radioButton_9);
		
		JLabel label_31 = new JLabel("元/份");
		label_31.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_31.setBounds(177, 507, 39, 22);
		小炒面板.add(label_31);
		
		JLabel label_32 = new JLabel("份");
		label_32.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_32.setBounds(255, 507, 16, 22);
		小炒面板.add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon("图片//IMG_4953.JPG"));
		label_33.setBounds(338, 313, 225, 182);
		小炒面板.add(label_33);

		JLabel 价钱10 = new JLabel("23");
		价钱10.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱10.setBounds(448, 507, 18, 22);
		小炒面板.add(价钱10);
		
		spinner_10.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_10.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_10.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_10.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_10.getValue().toString())*Integer.parseInt(价钱10.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_10.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_10.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_10.setEnabled(false);
		spinner_10.setBounds(510, 504, 32, 28);
		小炒面板.add(spinner_10);
		
		radioButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_10.isSelected()) {
					spinner_10.setEnabled(true);
					model.addRow(new Object[] {radioButton_10.getText(),spinner_10.getValue()
							,Integer.parseInt(spinner_10.getValue().toString())*Integer.parseInt(价钱10.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_10.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_10.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_10.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_10.setBounds(338, 504, 109, 31);
		小炒面板.add(radioButton_10);
		
		JLabel label_35 = new JLabel("元/份");
		label_35.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_35.setBounds(469, 507, 39, 22);
		小炒面板.add(label_35);
		
		JLabel label_36 = new JLabel("份");
		label_36.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_36.setBounds(547, 507, 16, 22);
		小炒面板.add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon("图片//IMG_4982.JPG"));
		label_37.setBounds(624, 313, 225, 182);
		小炒面板.add(label_37);

		JLabel 价钱11 = new JLabel("23");
		价钱11.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱11.setBounds(734, 507, 18, 22);
		小炒面板.add(价钱11);
		
		spinner_11.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_11.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_11.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_11.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_11.getValue().toString())*Integer.parseInt(价钱11.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_11.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_11.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_11.setEnabled(false);
		spinner_11.setBounds(796, 504, 32, 28);
		小炒面板.add(spinner_11);
		
		radioButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_11.isSelected()) {
					spinner_11.setEnabled(true);
					model.addRow(new Object[] {radioButton_11.getText(),spinner_11.getValue()
							,Integer.parseInt(spinner_11.getValue().toString())*Integer.parseInt(价钱11.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_11.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_11.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_11.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_11.setBounds(624, 504, 109, 31);
		小炒面板.add(radioButton_11);
		
		JLabel label_39 = new JLabel("元/份");
		label_39.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_39.setBounds(755, 507, 39, 22);
		小炒面板.add(label_39);
		
		JLabel label_40 = new JLabel("份");
		label_40.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_40.setBounds(833, 507, 16, 22);
		小炒面板.add(label_40);
		
		JPanel 蔬菜面板 = new JPanel();
		主卡片.add(蔬菜面板, "蔬菜面板");
		蔬菜面板.setLayout(null);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon("图片//IMG_4984.JPG"));
		label_19.setBounds(42, 13, 225, 182);
		蔬菜面板.add(label_19);

		JLabel 价钱12 = new JLabel("13");
		价钱12.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱12.setBounds(152, 207, 18, 22);
		蔬菜面板.add(价钱12);
		
		spinner_12.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_12.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_12.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_12.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_12.getValue().toString())*Integer.parseInt(价钱12.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_12.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_12.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_12.setEnabled(false);
		spinner_12.setBounds(214, 204, 32, 28);
		蔬菜面板.add(spinner_12);
		
		radioButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_12.isSelected()) {
					spinner_12.setEnabled(true);
					model.addRow(new Object[] {radioButton_12.getText(),spinner_12.getValue()
							,Integer.parseInt(spinner_12.getValue().toString())*Integer.parseInt(价钱12.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_12.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_12.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_12.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_12.setBounds(42, 204, 109, 31);
		蔬菜面板.add(radioButton_12);
		
		JLabel label_26 = new JLabel("元/份");
		label_26.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_26.setBounds(173, 207, 39, 22);
		蔬菜面板.add(label_26);
		
		JLabel label_30 = new JLabel("份");
		label_30.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_30.setBounds(251, 207, 16, 22);
		蔬菜面板.add(label_30);
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon("图片//IMG_4985.JPG"));
		label_34.setBounds(331, 13, 225, 182);
		蔬菜面板.add(label_34);

		JLabel 价钱13 = new JLabel("13");
		价钱13.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱13.setBounds(441, 207, 18, 22);
		蔬菜面板.add(价钱13);
		
		spinner_13.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_13.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_13.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_13.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_13.getValue().toString())*Integer.parseInt(价钱13.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_13.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_13.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_13.setEnabled(false);
		spinner_13.setBounds(503, 204, 32, 28);
		蔬菜面板.add(spinner_13);
		
		radioButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton_13.isSelected()) {
					spinner_13.setEnabled(true);
					model.addRow(new Object[] {radioButton_13.getText(),spinner_13.getValue()
							,Integer.parseInt(spinner_13.getValue().toString())*Integer.parseInt(价钱13.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_13.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_13.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_13.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_13.setBounds(331, 204, 109, 31);
		蔬菜面板.add(radioButton_13);
		
		JLabel label_41 = new JLabel("元/份");
		label_41.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_41.setBounds(462, 207, 39, 22);
		蔬菜面板.add(label_41);
		
		JLabel label_42 = new JLabel("份");
		label_42.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_42.setBounds(540, 207, 16, 22);
		蔬菜面板.add(label_42);
		
		JLabel label_43 = new JLabel("");
		label_43.setIcon(new ImageIcon("图片//IMG_4987.JPG"));
		label_43.setBounds(615, 13, 225, 182);
		蔬菜面板.add(label_43);

		JLabel 价钱14 = new JLabel("18");
		价钱14.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱14.setBounds(725, 207, 18, 22);
		蔬菜面板.add(价钱14);
		
		spinner_14.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_14.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_14_1.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_14.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_14.getValue().toString())*Integer.parseInt(价钱14.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_14.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_14.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_14.setEnabled(false);
		spinner_14.setBounds(787, 204, 32, 28);
		蔬菜面板.add(spinner_14);
		
		radioButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_14_1.isSelected()) {
					spinner_14.setEnabled(true);
					model.addRow(new Object[] {radioButton_14_1.getText(),spinner_14.getValue()
							,Integer.parseInt(spinner_14.getValue().toString())*Integer.parseInt(价钱14.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_14.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_14_1.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_14_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_14_1.setBounds(615, 204, 109, 31);
		蔬菜面板.add(radioButton_14_1);
		
		JLabel label_45 = new JLabel("元/份");
		label_45.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_45.setBounds(746, 207, 39, 22);
		蔬菜面板.add(label_45);
		
		JLabel label_46 = new JLabel("份");
		label_46.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_46.setBounds(824, 207, 16, 22);
		蔬菜面板.add(label_46);
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon("图片//IMG_4970.JPG"));
		label_47.setBounds(42, 327, 225, 182);
		蔬菜面板.add(label_47);

		JLabel 价钱15 = new JLabel("23");
		价钱15.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱15.setBounds(152, 521, 18, 22);
		蔬菜面板.add(价钱15);
		
		spinner_15.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_15.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_15.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_15.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_15.getValue().toString())*Integer.parseInt(价钱15.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_15.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_15.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_15.setEnabled(false);
		spinner_15.setBounds(214, 518, 32, 28);
		蔬菜面板.add(spinner_15);
		
		radioButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_15.isSelected()) {
					spinner_15.setEnabled(true);
					model.addRow(new Object[] {radioButton_15.getText(),spinner_15.getValue()
							,Integer.parseInt(spinner_15.getValue().toString())*Integer.parseInt(价钱15.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_15.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_15.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_15.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_15.setBounds(42, 518, 109, 31);
		蔬菜面板.add(radioButton_15);
		
		JLabel label_49 = new JLabel("元/份");
		label_49.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_49.setBounds(173, 521, 39, 22);
		蔬菜面板.add(label_49);
		
		JLabel label_50 = new JLabel("份");
		label_50.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_50.setBounds(251, 521, 16, 22);
		蔬菜面板.add(label_50);
		
		JLabel label_51 = new JLabel("");
		label_51.setIcon(new ImageIcon("图片//IMG_5113.JPG"));
		label_51.setBounds(331, 327, 225, 182);
		蔬菜面板.add(label_51);

		JLabel 价钱16 = new JLabel("15");
		价钱16.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱16.setBounds(441, 521, 18, 22);
		蔬菜面板.add(价钱16);
		
		spinner_16.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_16.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_16.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_16.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_16.getValue().toString())*Integer.parseInt(价钱16.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_16.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_16.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_16.setEnabled(false);
		spinner_16.setBounds(503, 518, 32, 28);
		蔬菜面板.add(spinner_16);
		
		radioButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_16.isSelected()) {
					spinner_16.setEnabled(true);
					model.addRow(new Object[] {radioButton_16.getText(),spinner_16.getValue()
							,Integer.parseInt(spinner_16.getValue().toString())*Integer.parseInt(价钱16.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_16.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_16.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_16.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_16.setBounds(331, 518, 109, 31);
		蔬菜面板.add(radioButton_16);
		
		JLabel label_53 = new JLabel("元/份");
		label_53.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_53.setBounds(462, 521, 39, 22);
		蔬菜面板.add(label_53);
		
		JLabel label_54 = new JLabel("份");
		label_54.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_54.setBounds(540, 521, 16, 22);
		蔬菜面板.add(label_54);
		
		JLabel label_55 = new JLabel("");
		label_55.setIcon(new ImageIcon("图片//IMG_5114.JPG"));
		label_55.setBounds(615, 327, 225, 182);
		蔬菜面板.add(label_55);

		JLabel 价钱17 = new JLabel("15");
		价钱17.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱17.setBounds(725, 521, 18, 22);
		蔬菜面板.add(价钱17);
		
		spinner_17.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_17.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_17.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_17.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_17.getValue().toString())*Integer.parseInt(价钱17.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_17.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_17.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_17.setEnabled(false);
		spinner_17.setBounds(787, 518, 32, 28);
		蔬菜面板.add(spinner_17);
		
		radioButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_17.isSelected()) {
					spinner_17.setEnabled(true);
					model.addRow(new Object[] {radioButton_17.getText(),spinner_17.getValue()
							,Integer.parseInt(spinner_17.getValue().toString())*Integer.parseInt(价钱17.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_17.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_17.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_17.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_17.setBounds(615, 518, 109, 31);
		蔬菜面板.add(radioButton_17);
		
		JLabel label_57 = new JLabel("元/份");
		label_57.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_57.setBounds(746, 521, 39, 22);
		蔬菜面板.add(label_57);
		
		JLabel label_58 = new JLabel("份");
		label_58.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_58.setBounds(824, 521, 16, 22);
		蔬菜面板.add(label_58);
		
		JPanel 主食面板 = new JPanel();
		主卡片.add(主食面板, "主食面板");
		主食面板.setLayout(null);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon("图片//FullSizeRender(1).jpg"));
		label_22.setBounds(31, 23, 225, 182);
		主食面板.add(label_22);

		JLabel 价钱18 = new JLabel("20");
		价钱18.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱18.setBounds(141, 217, 18, 22);
		主食面板.add(价钱18);
		
		spinner_18.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_18.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_14.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_18.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_18.getValue().toString())*Integer.parseInt(价钱18.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_18.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_18.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_18.setEnabled(false);
		spinner_18.setBounds(203, 214, 32, 28);
		主食面板.add(spinner_18);
		
		radioButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_14.isSelected()) {
					spinner_18.setEnabled(true);
					model.addRow(new Object[] {radioButton_14.getText(),spinner_18.getValue()
							,Integer.parseInt(spinner_18.getValue().toString())*Integer.parseInt(价钱18.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_18.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_14.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_14.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_14.setBounds(31, 214, 109, 31);
		主食面板.add(radioButton_14);
		
		JLabel label_38 = new JLabel("元/份");
		label_38.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_38.setBounds(162, 217, 39, 22);
		主食面板.add(label_38);
		
		JLabel label_52 = new JLabel("份");
		label_52.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_52.setBounds(240, 217, 16, 22);
		主食面板.add(label_52);
		
		JLabel label_56 = new JLabel("");
		label_56.setIcon(new ImageIcon("图片//IMG_4967.JPG"));
		label_56.setBounds(320, 23, 225, 182);
		主食面板.add(label_56);

		JLabel 价钱19 = new JLabel("13");
		价钱19.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱19.setBounds(430, 217, 18, 22);
		主食面板.add(价钱19);
		
		spinner_19.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_19.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_18.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_19.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_19.getValue().toString())*Integer.parseInt(价钱19.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_19.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_19.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_19.setEnabled(false);
		spinner_19.setBounds(492, 214, 32, 28);
		主食面板.add(spinner_19);
		
		radioButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_18.isSelected()) {
					spinner_19.setEnabled(true);
					model.addRow(new Object[] {radioButton_18.getText(),spinner_19.getValue()
							,Integer.parseInt(spinner_19.getValue().toString())*Integer.parseInt(价钱19.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_19.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_18.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_18.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_18.setBounds(320, 214, 109, 31);
		主食面板.add(radioButton_18);
		
		JLabel label_59 = new JLabel("元/份");
		label_59.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_59.setBounds(451, 217, 39, 22);
		主食面板.add(label_59);
		
		JLabel label_61 = new JLabel("份");
		label_61.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_61.setBounds(529, 217, 16, 22);
		主食面板.add(label_61);
		
		JLabel label_62 = new JLabel("");
		label_62.setIcon(new ImageIcon("图片//IMG_4952.PNG"));
		label_62.setBounds(613, 23, 225, 182);
		主食面板.add(label_62);

		JLabel 价钱20 = new JLabel("18");
		价钱20.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱20.setBounds(723, 217, 18, 22);
		主食面板.add(价钱20);
		
		spinner_20.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_20.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_19.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_20.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_20.getValue().toString())*Integer.parseInt(价钱20.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_20.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_20.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_20.setEnabled(false);
		spinner_20.setBounds(785, 214, 32, 28);
		主食面板.add(spinner_20);
		
		radioButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_19.isSelected()) {
					spinner_20.setEnabled(true);
					model.addRow(new Object[] {radioButton_19.getText(),spinner_20.getValue()
							,Integer.parseInt(spinner_20.getValue().toString())*Integer.parseInt(价钱20.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_20.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_19.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_19.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_19.setBounds(613, 214, 109, 31);
		主食面板.add(radioButton_19);
		
		JLabel label_63 = new JLabel("元/份");
		label_63.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_63.setBounds(744, 217, 39, 22);
		主食面板.add(label_63);
		
		JLabel label_65 = new JLabel("份");
		label_65.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_65.setBounds(822, 217, 16, 22);
		主食面板.add(label_65);
		
		JLabel label_66 = new JLabel("");
		label_66.setIcon(new ImageIcon("图片//IMG_4968.JPG"));
		label_66.setBounds(31, 306, 225, 182);
		主食面板.add(label_66);

		JLabel 价钱21 = new JLabel("25");
		价钱21.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱21.setBounds(141, 500, 18, 22);
		主食面板.add(价钱21);
		
		spinner_21.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_21.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_20.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_21.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_21.getValue().toString())*Integer.parseInt(价钱21.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_21.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_21.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_21.setEnabled(false);
		spinner_21.setBounds(203, 497, 32, 28);
		主食面板.add(spinner_21);
		
		radioButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_20.isSelected()) {
					spinner_21.setEnabled(true);
					model.addRow(new Object[] {radioButton_20.getText(),spinner_21.getValue()
							,Integer.parseInt(spinner_21.getValue().toString())*Integer.parseInt(价钱21.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_21.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_20.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_20.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_20.setBounds(31, 497, 109, 31);
		主食面板.add(radioButton_20);
		
		JLabel label_67 = new JLabel("元/份");
		label_67.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_67.setBounds(162, 500, 39, 22);
		主食面板.add(label_67);
		
		JLabel label_69 = new JLabel("份");
		label_69.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_69.setBounds(240, 500, 16, 22);
		主食面板.add(label_69);
		
		JLabel label_70 = new JLabel("");
		label_70.setIcon(new ImageIcon("图片//IMG_4969.JPG"));
		label_70.setBounds(320, 306, 225, 182);
		主食面板.add(label_70);

		JLabel 价钱22 = new JLabel("28");
		价钱22.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱22.setBounds(430, 500, 18, 22);
		主食面板.add(价钱22);
		
		spinner_22.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_22.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_21.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_22.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_22.getValue().toString())*Integer.parseInt(价钱22.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_22.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_22.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_22.setEnabled(false);
		spinner_22.setBounds(492, 497, 32, 28);
		主食面板.add(spinner_22);
		
		radioButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_21.isSelected()) {
					spinner_22.setEnabled(true);
					model.addRow(new Object[] {radioButton_21.getText(),spinner_22.getValue()
							,Integer.parseInt(spinner_22.getValue().toString())*Integer.parseInt(价钱22.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_22.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_21.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_21.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_21.setBounds(320, 497, 109, 31);
		主食面板.add(radioButton_21);
		
		JLabel label_71 = new JLabel("元/份");
		label_71.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_71.setBounds(451, 500, 39, 22);
		主食面板.add(label_71);
		
		JLabel label_73 = new JLabel("份");
		label_73.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_73.setBounds(529, 500, 16, 22);
		主食面板.add(label_73);
		
		JLabel label_74 = new JLabel("");
		label_74.setIcon(new ImageIcon("图片//IMG_4963.JPG"));
		label_74.setBounds(613, 306, 225, 182);
		主食面板.add(label_74);

		JLabel 价钱23 = new JLabel("18");
		价钱23.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱23.setBounds(723, 500, 18, 22);
		主食面板.add(价钱23);
		
		spinner_23.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_23.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_22.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_23.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_23.getValue().toString())*Integer.parseInt(价钱23.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_23.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_23.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_23.setEnabled(false);
		spinner_23.setBounds(785, 497, 32, 28);
		主食面板.add(spinner_23);
		
		radioButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_22.isSelected()) {
					spinner_23.setEnabled(true);
					model.addRow(new Object[] {radioButton_22.getText(),spinner_23.getValue()
							,Integer.parseInt(spinner_23.getValue().toString())*Integer.parseInt(价钱23.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_23.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_22.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_22.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_22.setBounds(613, 497, 109, 31);
		主食面板.add(radioButton_22);
		
		JLabel label_75 = new JLabel("元/份");
		label_75.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_75.setBounds(744, 500, 39, 22);
		主食面板.add(label_75);
		
		JLabel label_77 = new JLabel("份");
		label_77.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_77.setBounds(822, 500, 16, 22);
		主食面板.add(label_77);
		
		JPanel 甜品面板 = new JPanel();
		主卡片.add(甜品面板, "甜品面板");
		甜品面板.setLayout(null);
		
		JLabel label_78 = new JLabel("");
		label_78.setIcon(new ImageIcon("图片//IMG_4989.JPG"));
		label_78.setBounds(31, 25, 225, 182);
		甜品面板.add(label_78);

		JLabel 价钱24 = new JLabel("15");
		价钱24.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱24.setBounds(141, 219, 18, 22);
		甜品面板.add(价钱24);
		
		spinner_24.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_24.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_23.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_24.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_24.getValue().toString())*Integer.parseInt(价钱24.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_24.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_24.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_24.setEnabled(false);
		spinner_24.setBounds(203, 216, 32, 28);
		甜品面板.add(spinner_24);
		
		radioButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_23.isSelected()) {
					spinner_24.setEnabled(true);
					model.addRow(new Object[] {radioButton_23.getText(),spinner_24.getValue()
							,Integer.parseInt(spinner_24.getValue().toString())*Integer.parseInt(价钱24.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_24.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_23.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_23.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_23.setBounds(31, 216, 109, 31);
		甜品面板.add(radioButton_23);
		
		JLabel label_79 = new JLabel("元/份");
		label_79.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_79.setBounds(162, 219, 39, 22);
		甜品面板.add(label_79);
		
		JLabel label_81 = new JLabel("份");
		label_81.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_81.setBounds(240, 219, 16, 22);
		甜品面板.add(label_81);
		
		JLabel label_82 = new JLabel("");
		label_82.setIcon(new ImageIcon("图片//IMG_4990.JPG"));
		label_82.setBounds(317, 25, 225, 182);
		甜品面板.add(label_82);

		JLabel 价钱25 = new JLabel("13");
		价钱25.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱25.setBounds(427, 219, 18, 22);
		甜品面板.add(价钱25);
		
		spinner_25.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_25.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_24.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_25.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_25.getValue().toString())*Integer.parseInt(价钱25.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_25.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_25.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_25.setEnabled(false);
		spinner_25.setBounds(489, 216, 32, 28);
		甜品面板.add(spinner_25);
		
		radioButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_24.isSelected()) {
					spinner_25.setEnabled(true);
					model.addRow(new Object[] {radioButton_24.getText(),spinner_25.getValue()
							,Integer.parseInt(spinner_25.getValue().toString())*Integer.parseInt(价钱25.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_25.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_24.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_24.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_24.setBounds(317, 216, 109, 31);
		甜品面板.add(radioButton_24);
		
		JLabel label_83 = new JLabel("元/份");
		label_83.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_83.setBounds(448, 219, 39, 22);
		甜品面板.add(label_83);
		
		JLabel label_85 = new JLabel("份");
		label_85.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_85.setBounds(526, 219, 16, 22);
		甜品面板.add(label_85);
		
		JLabel label_86 = new JLabel("");
		label_86.setIcon(new ImageIcon("图片//IMG_4991.JPG"));
		label_86.setBounds(598, 25, 225, 182);
		甜品面板.add(label_86);

		JLabel 价钱26 = new JLabel("18");
		价钱26.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱26.setBounds(720, 222, 18, 22);
		甜品面板.add(价钱26);
		
		spinner_26.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_26.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_25.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_26.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_26.getValue().toString())*Integer.parseInt(价钱26.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_26.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_26.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_26.setEnabled(false);
		spinner_26.setBounds(782, 219, 32, 28);
		甜品面板.add(spinner_26);
		
		radioButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_25.isSelected()) {
					spinner_26.setEnabled(true);
					model.addRow(new Object[] {radioButton_25.getText(),spinner_26.getValue()
							,Integer.parseInt(spinner_26.getValue().toString())*Integer.parseInt(价钱26.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_26.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_25.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_25.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_25.setBounds(587, 216, 131, 31);
		甜品面板.add(radioButton_25);
		
		JLabel label_87 = new JLabel("元/份");
		label_87.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_87.setBounds(741, 222, 39, 22);
		甜品面板.add(label_87);
		
		JLabel label_89 = new JLabel("份");
		label_89.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_89.setBounds(819, 222, 16, 22);
		甜品面板.add(label_89);
		
		JLabel label_90 = new JLabel("");
		label_90.setIcon(new ImageIcon("图片//IMG_4992.JPG"));
		label_90.setBounds(31, 329, 225, 182);
		甜品面板.add(label_90);

		JLabel 价钱27 = new JLabel("18");
		价钱27.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱27.setBounds(141, 523, 18, 22);
		甜品面板.add(价钱27);
		
		spinner_27.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_27.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_26.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_27.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_27.getValue().toString())*Integer.parseInt(价钱27.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_27.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_27.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_27.setEnabled(false);
		spinner_27.setBounds(203, 520, 32, 28);
		甜品面板.add(spinner_27);
		
		radioButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_26.isSelected()) {
					spinner_27.setEnabled(true);
					model.addRow(new Object[] {radioButton_26.getText(),spinner_27.getValue()
							,Integer.parseInt(spinner_27.getValue().toString())*Integer.parseInt(价钱27.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_27.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_26.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_26.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_26.setBounds(31, 520, 109, 31);
		甜品面板.add(radioButton_26);
		
		JLabel label_91 = new JLabel("元/份");
		label_91.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_91.setBounds(162, 523, 39, 22);
		甜品面板.add(label_91);
		
		JLabel label_93 = new JLabel("份");
		label_93.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_93.setBounds(240, 523, 16, 22);
		甜品面板.add(label_93);
		
		JLabel label_94 = new JLabel("");
		label_94.setIcon(new ImageIcon("图片//IMG_4993.JPG"));
		label_94.setBounds(317, 329, 225, 182);
		甜品面板.add(label_94);

		JLabel 价钱28 = new JLabel("18");
		价钱28.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱28.setBounds(442, 526, 18, 22);
		甜品面板.add(价钱28);
		
		spinner_28.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_28.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_27.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_28.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_28.getValue().toString())*Integer.parseInt(价钱28.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_28.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_28.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_28.setEnabled(false);
		spinner_28.setBounds(504, 523, 32, 28);
		甜品面板.add(spinner_28);
		
		radioButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_27.isSelected()) {
					spinner_28.setEnabled(true);
					model.addRow(new Object[] {radioButton_27.getText(),spinner_28.getValue()
							,Integer.parseInt(spinner_28.getValue().toString())*Integer.parseInt(价钱28.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_28.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_27.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_27.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_27.setBounds(305, 520, 128, 31);
		甜品面板.add(radioButton_27);
		
		JLabel label_95 = new JLabel("元/份");
		label_95.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_95.setBounds(463, 526, 39, 22);
		甜品面板.add(label_95);
		
		JLabel label_97 = new JLabel("份");
		label_97.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_97.setBounds(541, 526, 16, 22);
		甜品面板.add(label_97);
		
		JLabel label_98 = new JLabel("");
		label_98.setIcon(new ImageIcon("图片//IMG_4994.JPG"));
		label_98.setBounds(598, 329, 225, 182);
		甜品面板.add(label_98);

		JLabel 价钱29 = new JLabel("18");
		价钱29.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱29.setBounds(708, 523, 18, 22);
		甜品面板.add(价钱29);
		
		spinner_29.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_29.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_28.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_29.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_29.getValue().toString())*Integer.parseInt(价钱29.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_29.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_29.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_29.setEnabled(false);
		spinner_29.setBounds(770, 520, 32, 28);
		甜品面板.add(spinner_29);
		
		radioButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_28.isSelected()) {
					spinner_29.setEnabled(true);
					model.addRow(new Object[] {radioButton_28.getText(),spinner_29.getValue()
							,Integer.parseInt(spinner_29.getValue().toString())*Integer.parseInt(价钱29.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_29.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_28.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_28.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_28.setBounds(598, 520, 109, 31);
		甜品面板.add(radioButton_28);
		
		JLabel label_99 = new JLabel("元/份");
		label_99.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_99.setBounds(729, 523, 39, 22);
		甜品面板.add(label_99);
		
		JLabel label_101 = new JLabel("份");
		label_101.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_101.setBounds(807, 523, 16, 22);
		甜品面板.add(label_101);
		
		JPanel 饮品面板 = new JPanel();
		主卡片.add(饮品面板, "饮品面板");
		饮品面板.setLayout(null);
		
		JLabel label_102 = new JLabel("");
		label_102.setIcon(new ImageIcon("图片//FullSizeRender(2).jpg"));
		label_102.setBounds(35, 28, 225, 182);
		饮品面板.add(label_102);

		JLabel 价钱30 = new JLabel("6");
		价钱30.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱30.setBounds(145, 222, 18, 22);
		饮品面板.add(价钱30);
		
		spinner_30.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_30.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_30.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_29.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_30.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_30.getValue().toString())*Integer.parseInt(价钱30.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_30.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_30.setEnabled(false);
		spinner_30.setBounds(207, 219, 32, 28);
		饮品面板.add(spinner_30);
		
		radioButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_29.isSelected()) {
					spinner_30.setEnabled(true);
					model.addRow(new Object[] {radioButton_29.getText(),spinner_30.getValue()
							,Integer.parseInt(spinner_30.getValue().toString())*Integer.parseInt(价钱30.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_30.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_29.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_29.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_29.setBounds(35, 219, 109, 31);
		饮品面板.add(radioButton_29);
		
		JLabel label_103 = new JLabel("元/份");
		label_103.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_103.setBounds(166, 222, 39, 22);
		饮品面板.add(label_103);
		
		JLabel label_105 = new JLabel("份");
		label_105.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_105.setBounds(244, 222, 16, 22);
		饮品面板.add(label_105);
		
		JLabel label_106 = new JLabel("");
		label_106.setIcon(new ImageIcon("图片//IMG_4975.JPG"));
		label_106.setBounds(321, 28, 225, 182);
		饮品面板.add(label_106);

		JLabel 价钱31 = new JLabel("6");
		价钱31.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱31.setBounds(431, 222, 18, 22);
		饮品面板.add(价钱31);
		
		spinner_31.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_31.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_30.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_31.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_31.getValue().toString())*Integer.parseInt(价钱31.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_31.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_31.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_31.setEnabled(false);
		spinner_31.setBounds(493, 219, 32, 28);
		饮品面板.add(spinner_31);
		
		radioButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_30.isSelected()) {
					spinner_31.setEnabled(true);
					model.addRow(new Object[] {radioButton_30.getText(),spinner_31.getValue()
							,Integer.parseInt(spinner_31.getValue().toString())*Integer.parseInt(价钱31.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_31.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_30.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_30.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_30.setBounds(321, 219, 109, 31);
		饮品面板.add(radioButton_30);
		
		JLabel label_107 = new JLabel("元/份");
		label_107.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_107.setBounds(452, 222, 39, 22);
		饮品面板.add(label_107);
		
		JLabel label_109 = new JLabel("份");
		label_109.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_109.setBounds(530, 222, 16, 22);
		饮品面板.add(label_109);
		
		JLabel label_110 = new JLabel("");
		label_110.setIcon(new ImageIcon("图片//IMG_4960.JPG"));
		label_110.setBounds(607, 28, 225, 182);
		饮品面板.add(label_110);

		JLabel 价钱32 = new JLabel("45");
		价钱32.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱32.setBounds(717, 222, 18, 22);
		饮品面板.add(价钱32);
		
		spinner_32.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_32.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_31.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_32.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_32.getValue().toString())*Integer.parseInt(价钱32.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_32.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_32.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_32.setEnabled(false);
		spinner_32.setBounds(779, 219, 32, 28);
		饮品面板.add(spinner_32);
		
		radioButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_31.isSelected()) {
					spinner_32.setEnabled(true);
					model.addRow(new Object[] {radioButton_31.getText(),spinner_32.getValue()
							,Integer.parseInt(spinner_32.getValue().toString())*Integer.parseInt(价钱32.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_32.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_31.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_31.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_31.setBounds(607, 219, 109, 31);
		饮品面板.add(radioButton_31);
		
		JLabel label_111 = new JLabel("元/份");
		label_111.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_111.setBounds(738, 222, 39, 22);
		饮品面板.add(label_111);
		
		JLabel label_113 = new JLabel("份");
		label_113.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_113.setBounds(816, 222, 16, 22);
		饮品面板.add(label_113);
		
		JLabel label_114 = new JLabel("");
		label_114.setIcon(new ImageIcon("图片//IMG_4973.JPG"));
		label_114.setBounds(607, 328, 225, 182);
		饮品面板.add(label_114);

		JLabel 价钱33 = new JLabel("8");
		价钱33.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱33.setBounds(717, 522, 18, 22);
		饮品面板.add(价钱33);
		
		spinner_33.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_33.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_32.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_33.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_33.getValue().toString())*Integer.parseInt(价钱33.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_33.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_33.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_33.setEnabled(false);
		spinner_33.setBounds(779, 519, 32, 28);
		饮品面板.add(spinner_33);
		
		radioButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_32.isSelected()) {
					spinner_33.setEnabled(true);
					model.addRow(new Object[] {radioButton_32.getText(),spinner_33.getValue()
							,Integer.parseInt(spinner_33.getValue().toString())*Integer.parseInt(价钱33.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_33.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_32.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_32.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_32.setBounds(607, 519, 109, 31);
		饮品面板.add(radioButton_32);
		
		JLabel label_115 = new JLabel("元/份");
		label_115.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_115.setBounds(738, 522, 39, 22);
		饮品面板.add(label_115);
		
		JLabel label_117 = new JLabel("份");
		label_117.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_117.setBounds(816, 522, 16, 22);
		饮品面板.add(label_117);
		
		JLabel label_118 = new JLabel("");
		label_118.setIcon(new ImageIcon("图片//IMG_4972.JPG"));
		label_118.setBounds(321, 328, 225, 182);
		饮品面板.add(label_118);

		JLabel 价钱34 = new JLabel("5");
		价钱34.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱34.setBounds(431, 522, 18, 22);
		饮品面板.add(价钱34);
		
		spinner_34.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_34.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_33.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_34.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_34.getValue().toString())*Integer.parseInt(价钱34.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_34.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_34.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_34.setEnabled(false);
		spinner_34.setBounds(493, 519, 32, 28);
		饮品面板.add(spinner_34);
		
		radioButton_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_33.isSelected()) {
					spinner_34.setEnabled(true);
					model.addRow(new Object[] {radioButton_33.getText(),spinner_34.getValue()
							,Integer.parseInt(spinner_34.getValue().toString())*Integer.parseInt(价钱34.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_34.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_33.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_33.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_33.setBounds(321, 519, 109, 31);
		饮品面板.add(radioButton_33);
		
		JLabel label_119 = new JLabel("元/份");
		label_119.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_119.setBounds(452, 522, 39, 22);
		饮品面板.add(label_119);
		
		JLabel label_121 = new JLabel("份");
		label_121.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_121.setBounds(530, 522, 16, 22);
		饮品面板.add(label_121);
		
		JLabel label_122 = new JLabel("");
		label_122.setIcon(new ImageIcon("图片//IMG_4976.JPG"));
		label_122.setBounds(35, 328, 225, 182);
		饮品面板.add(label_122);

		JLabel 价钱35 = new JLabel("4");
		价钱35.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		价钱35.setBounds(145, 522, 18, 22);
		饮品面板.add(价钱35);
		
		spinner_35.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_35.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_34.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_35.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_35.getValue().toString())*Integer.parseInt(价钱35.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_35.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_35.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		spinner_35.setEnabled(false);
		spinner_35.setBounds(207, 519, 32, 28);
		饮品面板.add(spinner_35);
		
		radioButton_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_34.isSelected()) {
					spinner_35.setEnabled(true);
					model.addRow(new Object[] {radioButton_34.getText(),spinner_35.getValue()
							,Integer.parseInt(spinner_35.getValue().toString())*Integer.parseInt(价钱35.getText())});
					table.setModel(model);//实现实时更新
				}
				else{
					spinner_35.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_34.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			 }
			}
		});
		radioButton_34.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		radioButton_34.setBounds(35, 519, 109, 31);
		饮品面板.add(radioButton_34);
		
		JLabel label_123 = new JLabel("元/份");
		label_123.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_123.setBounds(166, 522, 39, 22);
		饮品面板.add(label_123);
		
		JLabel label_125 = new JLabel("份");
		label_125.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_125.setBounds(244, 522, 16, 22);
		饮品面板.add(label_125);
		
		JLabel 桌号标签 = new JLabel("请选择桌号:");
		桌号标签.setFont(new Font("微软雅黑", Font.BOLD, 16));
		桌号标签.setBounds(1057, 0, 251, 24);
		大面板.add(桌号标签);
		
		String desk[]= {"1号桌","2号桌","3号桌","4号桌","5号桌","6号桌"};
		JComboBox 桌号复选框 = new JComboBox(desk);
		桌号复选框.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		桌号复选框.setBounds(1056, 25, 189, 24);
		大面板.add(桌号复选框);
		
		JLabel 用餐人数 = new JLabel("请输入用餐人数:(茶水费10元/人)");
		用餐人数.setFont(new Font("微软雅黑", Font.BOLD, 16));
		用餐人数.setBounds(1057, 62, 251, 18);
		大面板.add(用餐人数);
		
		用餐人数文本 = new JTextField();
		用餐人数文本.setText("0");
		用餐人数文本.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		用餐人数文本.setBounds(1057, 82, 188, 24);
		大面板.add(用餐人数文本);
		
		JLabel 菜式列表标签 = new JLabel("已点菜式列表：");
		菜式列表标签.setFont(new Font("微软雅黑", Font.BOLD, 16));
		菜式列表标签.setBounds(1057, 138, 188, 18);
		大面板.add(菜式列表标签);

		总额标签.setFont(new Font("微软雅黑", Font.BOLD, 16));
		总额标签.setBounds(1057, 564, 280, 18);
		大面板.add(总额标签);
		欢迎面板.setLayout(null);
		
		JLabel 欢迎标签 = new JLabel("欢迎来到华哥餐厅");
		欢迎标签.setBounds(509, 13, 355, 30);
		欢迎标签.setFont(new Font("宋体", Font.PLAIN, 25));
		欢迎标签.setHorizontalAlignment(SwingConstants.CENTER);
		欢迎面板.add(欢迎标签);
		
		JButton 取消按钮 = new JButton("取消");
		取消按钮.addActionListener(new ActionListener() {//添加事件
			public void actionPerformed(ActionEvent a) {
				//设置所有的单选框和数字调节控件不可操作
				radioButton.setSelected(false);
				spinner.setEnabled(false);
				radioButton_1.setSelected(false);
				spinner_1.setEnabled(false);
				radioButton_2.setSelected(false);
				spinner_2.setEnabled(false);
				radioButton_3.setSelected(false);
				spinner_3.setEnabled(false);
				radioButton_4.setSelected(false);
				spinner_4.setEnabled(false);
				radioButton_5.setSelected(false);
				spinner_5.setEnabled(false);
				radioButton_6.setSelected(false);
				spinner_6.setEnabled(false);
				radioButton_7.setSelected(false);
				spinner_7.setEnabled(false);
				radioButton_8.setSelected(false);
				spinner_8.setEnabled(false);
				radioButton_9.setSelected(false);
				spinner_9.setEnabled(false);
				radioButton_10.setSelected(false);
				spinner_10.setEnabled(false);
				radioButton_11.setSelected(false);
				spinner_11.setEnabled(false);
				radioButton_12.setSelected(false);
				spinner_12.setEnabled(false);
				radioButton_13.setSelected(false);
				spinner_13.setEnabled(false);
				radioButton_14.setSelected(false);
				radioButton_14_1.setSelected(false);
				spinner_14.setEnabled(false);
				radioButton_15.setSelected(false);
				spinner_15.setEnabled(false);
				radioButton_16.setSelected(false);
				spinner_16.setEnabled(false);
				radioButton_17.setSelected(false);
				spinner_17.setEnabled(false);
				radioButton_18.setSelected(false);
				spinner_18.setEnabled(false);
				radioButton_19.setSelected(false);
				spinner_19.setEnabled(false);
				radioButton_20.setSelected(false);
				spinner_20.setEnabled(false);
				radioButton_21.setSelected(false);
				spinner_21.setEnabled(false);
				radioButton_22.setSelected(false);
				spinner_22.setEnabled(false);
				radioButton_23.setSelected(false);
				spinner_23.setEnabled(false);
				radioButton_24.setSelected(false);
				spinner_24.setEnabled(false);
				radioButton_25.setSelected(false);
				spinner_25.setEnabled(false);
				radioButton_26.setSelected(false);
				spinner_26.setEnabled(false);
				radioButton_27.setSelected(false);
				spinner_27.setEnabled(false);
				radioButton_28.setSelected(false);
				spinner_28.setEnabled(false);
				radioButton_29.setSelected(false);
				spinner_29.setEnabled(false);
				radioButton_30.setSelected(false);
				spinner_30.setEnabled(false);
				radioButton_31.setSelected(false);
				spinner_31.setEnabled(false);
				radioButton_32.setSelected(false);
				spinner_32.setEnabled(false);
				radioButton_33.setSelected(false);
				spinner_33.setEnabled(false);
				radioButton_34.setSelected(false);
				spinner_34.setEnabled(false);
				spinner_35.setEnabled(false);
				spinner.setValue(1);//把数字调节控件的数字调回1
				spinner_1.setValue(1);
				spinner_2.setValue(1);
				spinner_3.setValue(1);
				spinner_4.setValue(1);
				spinner_5.setValue(1);
				spinner_6.setValue(1);
				spinner_7.setValue(1);
				spinner_8.setValue(1);
				spinner_9.setValue(1);
				spinner_10.setValue(1);
				spinner_11.setValue(1);
				spinner_12.setValue(1);
				spinner_13.setValue(1);
				spinner_14.setValue(1);
				spinner_15.setValue(1);
				spinner_16.setValue(1);
				spinner_17.setValue(1);
				spinner_18.setValue(1);
				spinner_19.setValue(1);
				spinner_20.setValue(1);
				spinner_21.setValue(1);
				spinner_22.setValue(1);
				spinner_23.setValue(1);
				spinner_24.setValue(1);
				spinner_25.setValue(1);
				spinner_26.setValue(1);
				spinner_27.setValue(1);
				spinner_28.setValue(1);
				spinner_29.setValue(1);
				spinner_30.setValue(1);
				spinner_31.setValue(1);
				spinner_32.setValue(1);
				spinner_33.setValue(1);
				spinner_34.setValue(1);
				model.setRowCount(0);
				table.setModel(model);
			}
		});
		取消按钮.setBounds(448, 703, 113, 27);
		主面板.add(取消按钮);
		
		JButton 下单按钮 = new JButton("下单");
		下单按钮.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(用餐人数文本.getText())==0||table.getRowCount()==0) {
					dialog d=new dialog(1);//谈出下单成功对话框
				}
				else {
					dialog d=new dialog(0);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						sum +=Integer.parseInt(table.getValueAt(i, 2).toString());
					}
					sum +=Integer.parseInt(用餐人数文本.getText())*10;
					总额标签.setText("账单总额："+sum+"元");
					下单按钮.setEnabled(false);//设置下了单之后不可以再按下单按钮
					加单按钮.setEnabled(true);
					结账按钮.setEnabled(true);
					
					File_operate fo=new File_operate();//下单之后将数据写入文件
					fo.write(table, 桌号复选框,用餐人数文本);
					
					radioButton.setSelected(false);
					spinner.setEnabled(false);
					radioButton_1.setSelected(false);
					spinner_1.setEnabled(false);
					radioButton_2.setSelected(false);
					spinner_2.setEnabled(false);
					radioButton_3.setSelected(false);
					spinner_3.setEnabled(false);
					radioButton_4.setSelected(false);
					spinner_4.setEnabled(false);
					radioButton_5.setSelected(false);
					spinner_5.setEnabled(false);
					radioButton_6.setSelected(false);
					spinner_6.setEnabled(false);
					radioButton_7.setSelected(false);
					spinner_7.setEnabled(false);
					radioButton_8.setSelected(false);
					spinner_8.setEnabled(false);
					radioButton_9.setSelected(false);
					spinner_9.setEnabled(false);
					radioButton_10.setSelected(false);
					spinner_10.setEnabled(false);
					radioButton_11.setSelected(false);
					spinner_11.setEnabled(false);
					radioButton_12.setSelected(false);
					spinner_12.setEnabled(false);
					radioButton_13.setSelected(false);
					spinner_13.setEnabled(false);
					radioButton_14.setSelected(false);
					radioButton_14_1.setSelected(false);
					spinner_14.setEnabled(false);
					radioButton_15.setSelected(false);
					spinner_15.setEnabled(false);
					radioButton_16.setSelected(false);
					spinner_16.setEnabled(false);
					radioButton_17.setSelected(false);
					spinner_17.setEnabled(false);
					radioButton_18.setSelected(false);
					spinner_18.setEnabled(false);
					radioButton_19.setSelected(false);
					spinner_19.setEnabled(false);
					radioButton_20.setSelected(false);
					spinner_20.setEnabled(false);
					radioButton_21.setSelected(false);
					spinner_21.setEnabled(false);
					radioButton_22.setSelected(false);
					spinner_22.setEnabled(false);
					radioButton_23.setSelected(false);
					spinner_23.setEnabled(false);
					radioButton_24.setSelected(false);
					spinner_24.setEnabled(false);
					radioButton_25.setSelected(false);
					spinner_25.setEnabled(false);
					radioButton_26.setSelected(false);
					spinner_26.setEnabled(false);
					radioButton_27.setSelected(false);
					spinner_27.setEnabled(false);
					radioButton_28.setSelected(false);
					spinner_28.setEnabled(false);
					radioButton_29.setSelected(false);
					spinner_29.setEnabled(false);
					radioButton_30.setSelected(false);
					spinner_30.setEnabled(false);
					radioButton_31.setSelected(false);
					spinner_31.setEnabled(false);
					radioButton_32.setSelected(false);
					spinner_32.setEnabled(false);
					radioButton_33.setSelected(false);
					spinner_33.setEnabled(false);
					radioButton_34.setSelected(false);
					spinner_34.setEnabled(false);
					spinner.setValue(1);
					spinner_1.setValue(1);
					spinner_2.setValue(1);
					spinner_3.setValue(1);
					spinner_4.setValue(1);
					spinner_5.setValue(1);
					spinner_6.setValue(1);
					spinner_7.setValue(1);
					spinner_8.setValue(1);
					spinner_9.setValue(1);
					spinner_10.setValue(1);
					spinner_11.setValue(1);
					spinner_12.setValue(1);
					spinner_13.setValue(1);
					spinner_14.setValue(1);
					spinner_15.setValue(1);
					spinner_16.setValue(1);
					spinner_17.setValue(1);
					spinner_18.setValue(1);
					spinner_19.setValue(1);
					spinner_20.setValue(1);
					spinner_21.setValue(1);
					spinner_22.setValue(1);
					spinner_23.setValue(1);
					spinner_24.setValue(1);
					spinner_25.setValue(1);
					spinner_26.setValue(1);
					spinner_27.setValue(1);
					spinner_28.setValue(1);
					spinner_29.setValue(1);
					spinner_30.setValue(1);
					spinner_31.setValue(1);
					spinner_32.setValue(1);
					spinner_33.setValue(1);
					spinner_34.setValue(1);
					model.setRowCount(0);
					table.setModel(model);
				}
			}
		});
		下单按钮.setBounds(587, 704, 113, 27);
		主面板.add(下单按钮);
		
		加单按钮.setEnabled(false);
		加单按钮.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) {
					dialog d=new dialog(3);//弹出加单成功对话框
				}
				else {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						sum +=Integer.parseInt(table.getValueAt(i, 2).toString());
					}
					总额标签.setText("账单总额："+sum+"元");
					下单按钮.setEnabled(false);
					
					File_operate fo=new File_operate();
					fo.writeadd(table, 桌号复选框);
					
					dialog d=new dialog(2);//弹出加单成功对话框
					
					radioButton.setSelected(false);
					spinner.setEnabled(false);
					radioButton_1.setSelected(false);
					spinner_1.setEnabled(false);
					radioButton_2.setSelected(false);
					spinner_2.setEnabled(false);
					radioButton_3.setSelected(false);
					spinner_3.setEnabled(false);
					radioButton_4.setSelected(false);
					spinner_4.setEnabled(false);
					radioButton_5.setSelected(false);
					spinner_5.setEnabled(false);
					radioButton_6.setSelected(false);
					spinner_6.setEnabled(false);
					radioButton_7.setSelected(false);
					spinner_7.setEnabled(false);
					radioButton_8.setSelected(false);
					spinner_8.setEnabled(false);
					radioButton_9.setSelected(false);
					spinner_9.setEnabled(false);
					radioButton_10.setSelected(false);
					spinner_10.setEnabled(false);
					radioButton_11.setSelected(false);
					spinner_11.setEnabled(false);
					radioButton_12.setSelected(false);
					spinner_12.setEnabled(false);
					radioButton_13.setSelected(false);
					spinner_13.setEnabled(false);
					radioButton_14.setSelected(false);
					
					radioButton_14_1.setSelected(false);
					spinner_14.setEnabled(false);
					radioButton_15.setSelected(false);
					spinner_15.setEnabled(false);
					radioButton_16.setSelected(false);
					spinner_16.setEnabled(false);
					radioButton_17.setSelected(false);
					spinner_17.setEnabled(false);
					radioButton_18.setSelected(false);
					spinner_18.setEnabled(false);
					radioButton_19.setSelected(false);
					spinner_19.setEnabled(false);
					radioButton_20.setSelected(false);
					spinner_20.setEnabled(false);
					radioButton_21.setSelected(false);
					spinner_21.setEnabled(false);
					radioButton_22.setSelected(false);
					spinner_22.setEnabled(false);
					radioButton_23.setSelected(false);
					spinner_23.setEnabled(false);
					radioButton_24.setSelected(false);
					spinner_24.setEnabled(false);
					radioButton_25.setSelected(false);
					spinner_25.setEnabled(false);
					radioButton_26.setSelected(false);
					spinner_26.setEnabled(false);
					radioButton_27.setSelected(false);
					spinner_27.setEnabled(false);
					radioButton_28.setSelected(false);
					spinner_28.setEnabled(false);
					radioButton_29.setSelected(false);
					spinner_29.setEnabled(false);
					radioButton_30.setSelected(false);
					spinner_30.setEnabled(false);
					radioButton_31.setSelected(false);
					spinner_31.setEnabled(false);
					radioButton_32.setSelected(false);
					spinner_32.setEnabled(false);
					radioButton_33.setSelected(false);
					spinner_33.setEnabled(false);
					radioButton_34.setSelected(false);
					spinner_34.setEnabled(false);
					spinner.setValue(1);
					spinner_1.setValue(1);
					spinner_2.setValue(1);
					spinner_3.setValue(1);
					spinner_4.setValue(1);
					spinner_5.setValue(1);
					spinner_6.setValue(1);
					spinner_7.setValue(1);
					spinner_8.setValue(1);
					spinner_9.setValue(1);
					spinner_10.setValue(1);
					spinner_11.setValue(1);
					spinner_12.setValue(1);
					spinner_13.setValue(1);
					spinner_14.setValue(1);
					spinner_15.setValue(1);
					spinner_16.setValue(1);
					spinner_17.setValue(1);
					spinner_18.setValue(1);
					spinner_19.setValue(1);
					spinner_20.setValue(1);
					spinner_21.setValue(1);
					spinner_22.setValue(1);
					spinner_23.setValue(1);
					spinner_24.setValue(1);
					spinner_25.setValue(1);
					spinner_26.setValue(1);
					spinner_27.setValue(1);
					spinner_28.setValue(1);
					spinner_29.setValue(1);
					spinner_30.setValue(1);
					spinner_31.setValue(1);
					spinner_32.setValue(1);
					spinner_33.setValue(1);
					spinner_34.setValue(1);
					model.setRowCount(0);
					table.setModel(model);
				}
			}
		});
		加单按钮.setBounds(725, 705, 113, 27);
		主面板.add(加单按钮);
		
		
		结账按钮.setEnabled(false);
		结账按钮.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//创建结账窗口
				JDialog dialog = new JDialog();
		        try {
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception w) {
					w.printStackTrace();
				}
		        dialog.setFont(new Font("微软雅黑", Font.BOLD, 14));
		        dialog.setBounds(200,300,500,600);
		        dialog.setTitle("温馨提示\r\n");
		       
				JButton btnOk = new JButton("OK");
				btnOk.setBackground(new Color(204, 255, 0));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				dialog.getContentPane().setLayout(null);
				btnOk.setFont(new Font("微软雅黑", Font.BOLD, 17));
				btnOk.setBounds(201, 279, 113, 27);
				dialog.getContentPane().add(btnOk);
				JLabel conmune = new JLabel(桌号复选框.getSelectedItem()+"一共消费了"+总额标签.getText());
				conmune.setFont(new Font("微软雅黑", Font.BOLD, 18));
				conmune.setBounds(66, 13, 383, 27);
				JLabel lblNewLabel2 = new JLabel("请到前台结账");
				lblNewLabel2.setFont(new Font("微软雅黑", Font.BOLD, 18));
				lblNewLabel2.setBounds(99, 41, 318, 34);
				dialog.getContentPane().add(lblNewLabel2);
				dialog.getContentPane().add(conmune);
				
				总额标签.setText("账单总额：");
			}
		});
		结账按钮.setBounds(853, 704, 113, 27);
		主面板.add(结账按钮);
		
		//显示动态时间
		JLabel 时间标签 = new JLabel("");
		timer=new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				SimpleDateFormat time=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss"); 
				时间标签.setText(time.format(date.getTime()));
			}
		});
		timer.start();
		时间标签.setFont(new Font("微软雅黑", Font.BOLD, 16));
		时间标签.setBounds(1141, 723, 210, 20);
		主面板.add(时间标签);
		
		热销菜系.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(主卡片, "热销面板");
			}
		});
		小炒类.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(主卡片, "小炒面板");
			}
		});
		蔬菜类.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(主卡片, "蔬菜面板");
			}
		});
		主食类.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(主卡片, "主食面板");
			}
		});
		甜品类.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(主卡片, "甜品面板");
			}
		});
		饮品类.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(主卡片, "饮品面板");
			}
		});
	}
}

