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

	private JPanel �����;
	private JTextField �ò������ı�;
	private JTable table = new JTable();;
	private Timer timer;//ʵʱ����
	int sum=0;//������
	//����˵���ѡ��
	JRadioButton radioButton = new JRadioButton("�ƽ�� ");
	JRadioButton radioButton_1 = new JRadioButton("������");
	JRadioButton radioButton_2 = new JRadioButton("������");
	JRadioButton radioButton_3 = new JRadioButton("�������");
	JRadioButton radioButton_4 = new JRadioButton("��������");
	JRadioButton radioButton_5 = new JRadioButton("�����Ӱ�");
    JRadioButton radioButton_6 = new JRadioButton("��������Ȧ");
    JRadioButton radioButton_7 = new JRadioButton("����ţ��");
    JRadioButton radioButton_8 = new JRadioButton("��������");
    JRadioButton radioButton_9 = new JRadioButton("�����Ӱ�");
    JRadioButton radioButton_10 = new JRadioButton("������");
    JRadioButton radioButton_11 = new JRadioButton("���弦��");
    JRadioButton radioButton_12 = new JRadioButton("��������");
    JRadioButton radioButton_13 = new JRadioButton("���ؽ���");
    JRadioButton radioButton_14_1 = new JRadioButton("��˿�ع�");
    JRadioButton radioButton_15 = new JRadioButton("������");
    JRadioButton radioButton_16 = new JRadioButton("���ļ���");
    JRadioButton radioButton_17 = new JRadioButton("��Ұ��");
    JRadioButton radioButton_14 = new JRadioButton("�������Ƿ�");
    JRadioButton radioButton_18 = new JRadioButton("������");
    JRadioButton radioButton_19 = new JRadioButton("��������");
    JRadioButton radioButton_20 = new JRadioButton("ţ����");
    JRadioButton radioButton_21 = new JRadioButton("������");
    JRadioButton radioButton_22 = new JRadioButton("������");
    JRadioButton radioButton_23 = new JRadioButton("ǧ������");
    JRadioButton radioButton_24 = new JRadioButton("�춹��ɳ");
    JRadioButton radioButton_25 = new JRadioButton("���������¶");
    JRadioButton radioButton_26 = new JRadioButton("â����ɳ");
    JRadioButton radioButton_27 = new JRadioButton("����ţ���½�");
    JRadioButton radioButton_28 = new JRadioButton("��Բ����¶");
    JRadioButton radioButton_29 = new JRadioButton("���ʱ���");
    JRadioButton radioButton_30 = new JRadioButton("���ϼ�");
    JRadioButton radioButton_31 = new JRadioButton("��˿�ع�");
    JRadioButton radioButton_34 = new JRadioButton("�ɿڿ���");
    JRadioButton radioButton_33 = new JRadioButton("����ơ��");
    JRadioButton radioButton_32 = new JRadioButton("������");
    //����ÿ���˵������ֵ��ڿؼ���ѡ��˵�����
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
	DefaultTableModel model=new DefaultTableModel();//���ģʽ
	JButton �ӵ���ť = new JButton("�ӵ�");
	JButton ���˰�ť = new JButton("����");
	JLabel �ܶ��ǩ = new JLabel("�ܶ��ǩ");
				
	public static void main(String[] args) {
		//������ʱ�Զ�������̡߳�
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
		//�����������
		Vector vrow =new Vector();
		Vector vcol =new Vector();
		vcol.add("��ʽ");
		vcol.add("����");
		vcol.add("��Ǯ");
		model=new DefaultTableModel(vrow,vcol);
		table.setModel(model);
		
		//��Ƭʽ���֣����������Ҫ�õ�
		CardLayout c1=new CardLayout(2,4);
		
		//Jframe����
		setResizable(false);
		setTitle("���ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڹر�ģʽ
		setBounds(100, 100, 1371, 791);
		����� = new JPanel();
		setContentPane(�����);
		�����.setLayout(null);
		
		JPanel ����� = new JPanel();
		�����.setBackground(new Color(245, 245, 245));
		�����.setBounds(20, 80, 1351, 610);
		�����.add(�����);
		�����.setLayout(null);
		
		JPanel ������� = new JPanel();
		�������.setBounds(14, 13, 118, 589);
		�����.add(�������);
		�������.setLayout(null);
		
		
		JPanel ��ӭ��� = new JPanel();
		��ӭ���.setToolTipText("");
		��ӭ���.setBackground(new Color(255, 239, 213));
		��ӭ���.setBounds(0, 0, 1365, 67);
		�����.add(��ӭ���);
		
		JButton ������ϵ = new JButton("������ϵ");
		������ϵ.setFont(new Font("������", Font.PLAIN, 15));//PLAIN:��ͨ��ʽ������BOLD :��������ITALIC: б����ʽ
		������ϵ.setBounds(10, 60, 98, 27);
		�������.add(������ϵ);
		
		JButton С���� = new JButton("С����");
		С����.setFont(new Font("������", Font.PLAIN, 15));
		С����.setBounds(10, 100, 98, 27);
		�������.add(С����);
		
		JButton �߲��� = new JButton("�߲���");
		�߲���.setFont(new Font("������", Font.PLAIN, 15));
		�߲���.setBounds(10, 140, 98, 27);
		�������.add(�߲���);
		
		JButton ��ʳ�� = new JButton("��ʳ��");
		��ʳ��.setFont(new Font("������", Font.PLAIN, 15));
		��ʳ��.setBounds(10, 180, 98, 27);
		�������.add(��ʳ��);
		
		JMenuItem �����˵� = new JMenuItem("�����˵�");
		�����˵�.setBounds(0, 0, 118, 39);
		�������.add(�����˵�);
		�����˵�.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		�����˵�.setBackground(new Color(127, 255, 212));
		
		JButton ��Ʒ�� = new JButton("��Ʒ��");
		��Ʒ��.setFont(new Font("������", Font.PLAIN, 15));
		��Ʒ��.setBounds(10, 220, 98, 27);
		�������.add(��Ʒ��);
		
		JButton ��Ʒ�� = new JButton("��Ʒ��");
		��Ʒ��.setFont(new Font("������", Font.PLAIN, 15));
		��Ʒ��.setBounds(10, 260, 98, 27);
		�������.add(��Ʒ��);
		
		JPanel ����Ƭ = new JPanel();
		����Ƭ.setBounds(147, 0, 885, 602);
		�����.add(����Ƭ);
		����Ƭ.setLayout(c1);
				
		JPanel ������� = new JPanel();
		����Ƭ.add(�������, "�������");
		�������.setLayout(null);
		
		//������壬���tableʹ��
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1057, 169, 280, 374);
		�����.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBorder(null);
		table.setRowHeight(20);//���ø߶�
		table.setFont(new Font("΢���ź�", Font.BOLD, 16));
		scrollPane.setViewportView(table);//�������ӵ��������
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"��ʽ", "����", "��Ǯ"
			}
		));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("ͼƬ//FullSizeRender.jpg"));
		label_1.setBounds(35, 13, 225, 182);
		�������.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("ͼƬ//IMG_4953.JPG"));
		label.setBounds(320, 13, 225, 182);
		�������.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("ͼƬ//IMG_4970.JPG"));
		lblNewLabel.setBounds(596, 13, 225, 182);
		�������.add(lblNewLabel);
		
		JLabel ��Ǯ1 = new JLabel("23");
		��Ǯ1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ1.setBounds(411, 219, 18, 18);
		�������.add(��Ǯ1);
		
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_1.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_1.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_1.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_1.getValue().toString())*Integer.parseInt(��Ǯ1.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_1.setEnabled(false);
		//����spinner�����������ÿ�ε����Ĵ�С
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		//��spinner���ı����ܱ༭
		JSpinner.DefaultEditor sd_1=(JSpinner.DefaultEditor) spinner_1.getEditor();
		sd_1.getTextField().setEditable(false);
		spinner_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_1.setBounds(484, 214, 40, 27);
		�������.add(spinner_1);
		
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton_1.isSelected()) {
					spinner_1.setEnabled(true);//ѡ���˲ſ��Ե��
					model.addRow(new Object[] {radioButton_1.getText(),spinner_1.getValue()
							,Integer.parseInt(spinner_1.getValue().toString())*Integer.parseInt(��Ǯ1.getText())});
					table.setModel(model);//ʵ��ʵʱ���±������
				}
				else{
					spinner_1.setEnabled(false);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							//ɾ���û�ȡ���Ĳ�ϵ
							if(radioButton_1.getText().equals(table.getValueAt(i, j).toString())) {
								model.removeRow(i);
						}
					}
				}
			}
		  }
		});
		radioButton_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_1.setBounds(320, 215, 81, 27);
		�������.add(radioButton_1);
		
		JLabel ��Ǯ = new JLabel("25");
		��Ǯ.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ.setBounds(120, 220, 18, 18);
		�������.add(��Ǯ);
		
		spinner.addChangeListener(new ChangeListener() {//spinner�������¼�
			public void stateChanged(ChangeEvent arg0) {
				for(int i=table.getRowCount()-1;i>=0;i--) {
					for(int j=table.getColumnCount()-1;j>=0;j--) {
						if(radioButton.getText().equals(table.getValueAt(i, j).toString())) {
							//�ı����в˵�����
							table.setValueAt(spinner.getValue(), i, j+1);
							//�ı����в˵ļ�Ǯ
							table.setValueAt(Integer.parseInt(spinner.getValue().toString())*Integer.parseInt(��Ǯ.getText()), i, j+2);
						}
					}
				}
			}
		});
		spinner.setEnabled(false);
		
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		//��spinner���ı����ܱ༭
		JSpinner.DefaultEditor sd=(JSpinner.DefaultEditor) spinner.getEditor();
		sd.getTextField().setEditable(false);
		spinner.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner.setBounds(206, 214, 40, 27);
		�������.add(spinner);
		
		radioButton.addActionListener(new ActionListener() {//����¼�
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton.isSelected()) {
					spinner.setEnabled(true);
					model.addRow(new Object[] {radioButton.getText(),spinner.getValue()
							,Integer.parseInt(spinner_1.getValue().toString())*Integer.parseInt(��Ǯ.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton.setBounds(35, 215, 81, 27);
		�������.add(radioButton);
		
		JLabel label_2 = new JLabel("��");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_2.setBounds(249, 214, 26, 30);
		�������.add(label_2);
		
		JLabel label_3 = new JLabel("��");
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_3.setBounds(527, 213, 26, 30);
		�������.add(label_3);
		
		JLabel ��Ǯ2 = new JLabel("23");
		��Ǯ2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ2.setBounds(699, 219, 18, 18);
		�������.add(��Ǯ2);
		
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_1.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_2.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_2.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_2.getValue().toString())*Integer.parseInt(��Ǯ2.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_2.setEnabled(false);
		spinner_2.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_2.setBounds(770, 212, 40, 27);
		�������.add(spinner_2);
		
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_2.isSelected()) {
					spinner_2.setEnabled(true);
					model.addRow(new Object[] {radioButton_2.getText(),spinner_2.getValue()
							,Integer.parseInt(spinner_2.getValue().toString())*Integer.parseInt(��Ǯ2.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_2.setBounds(600, 214, 94, 27);
		�������.add(radioButton_2);
		
		JLabel label_4 = new JLabel("��");
		label_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_4.setBounds(812, 208, 26, 30);
		�������.add(label_4);
		
		JLabel ��Ǯ3 = new JLabel("25");
		��Ǯ3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ3.setBounds(134, 523, 18, 18);
		�������.add(��Ǯ3);
		
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_3.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_3.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_3.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_3.getValue().toString())*Integer.parseInt(��Ǯ3.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_3.setEnabled(false);
		spinner_3.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_3.setBounds(206, 517, 40, 27);
		�������.add(spinner_3);
		
		JLabel label_5 = new JLabel("��");
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_5.setBounds(249, 514, 26, 30);
		�������.add(label_5);
		
		
		radioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_3.isSelected()) {
					spinner_3.setEnabled(true);
					model.addRow(new Object[] {radioButton_3.getText(),spinner_3.getValue()
							,Integer.parseInt(spinner_3.getValue().toString())*Integer.parseInt(��Ǯ3.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_3.setBounds(35, 519, 94, 27);
		�������.add(radioButton_3);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_6.setIcon(new ImageIcon("ͼƬ//IMG_4955.JPG"));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(35, 313, 225, 182);
		�������.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("ͼƬ//IMG_4983.JPG"));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_7.setBounds(320, 313, 225, 182);
		�������.add(label_7);
		
		JLabel ��Ǯ4 = new JLabel("25");
		��Ǯ4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ4.setBounds(419, 523, 18, 18);
		�������.add(��Ǯ4);
		
		spinner_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_4.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_4.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_4.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_4.getValue().toString())*Integer.parseInt(��Ǯ4.getText()), i, j+2);
							}
						}
					}
				}
			} 
		});
		spinner_4.setEnabled(false);
		spinner_4.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_4.setBounds(484, 517, 40, 27);
		�������.add(spinner_4);
		
		radioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_4.isSelected()) {
					spinner_4.setEnabled(true);
					model.addRow(new Object[] {radioButton_4.getText(),spinner_4.getValue()
							,Integer.parseInt(spinner_4.getValue().toString())*Integer.parseInt(��Ǯ4.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_4.setBounds(320, 519, 94, 27);
		�������.add(radioButton_4);
		
		JLabel label_8 = new JLabel("��");
		label_8.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_8.setBounds(527, 517, 26, 30);
		�������.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("ͼƬ//IMG_4965.JPG"));
		label_9.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_9.setBounds(598, 313, 225, 182);
		�������.add(label_9);
		
		JLabel ��Ǯ5 = new JLabel("28");
		��Ǯ5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ5.setBounds(697, 520, 18, 18);
		�������.add(��Ǯ5);
		
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_5.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_5.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_5.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_5.getValue().toString())*Integer.parseInt(��Ǯ5.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_5.setEnabled(false);
		spinner_5.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_5.setBounds(769, 514, 40, 27);
		�������.add(spinner_5);
		
		radioButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_5.isSelected()) {
					spinner_5.setEnabled(true);
					model.addRow(new Object[] {radioButton_5.getText(),spinner_5.getValue()
							,Integer.parseInt(spinner_5.getValue().toString())*Integer.parseInt(��Ǯ5.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_5.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_5.setBounds(598, 515, 94, 27);
		�������.add(radioButton_5);
		
		JLabel label_10 = new JLabel("��");
		label_10.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_10.setBounds(812, 514, 26, 30);
		�������.add(label_10);
		
		JLabel label_12 = new JLabel("Ԫ/��");
		label_12.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_12.setBounds(138, 219, 40, 18);
		�������.add(label_12);
		
		JLabel label_13 = new JLabel("Ԫ/��");
		label_13.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_13.setBounds(430, 219, 40, 18);
		�������.add(label_13);
		
		JLabel label_14 = new JLabel("Ԫ/��");
		label_14.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_14.setBounds(716, 219, 40, 18);
		�������.add(label_14);
		
		JLabel label_15 = new JLabel("Ԫ/��");
		label_15.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_15.setBounds(152, 522, 40, 18);
		�������.add(label_15);
		
		JLabel label_18 = new JLabel("Ԫ/��");
		label_18.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_18.setBounds(437, 522, 40, 18);
		�������.add(label_18);
		
		JLabel label_16 = new JLabel("Ԫ/��");
		label_16.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_16.setBounds(715, 519, 40, 18);
		�������.add(label_16);
		
		JPanel С����� = new JPanel();
		����Ƭ.add(С�����, "С�����");
		С�����.setLayout(null);
		
		JLabel ��Ǯ6 = new JLabel("23");
		��Ǯ6.setBounds(156, 207, 18, 22);
		��Ǯ6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		С�����.add(��Ǯ6);
		
		spinner_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_6.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_6.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_6.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_6.getValue().toString())*Integer.parseInt(��Ǯ6.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_6.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_6.setBounds(218, 204, 32, 28);
		spinner_6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_6.setEnabled(false);
		С�����.add(spinner_6);
		
		radioButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_6.isSelected()) {
					spinner_6.setEnabled(true);
					model.addRow(new Object[] {radioButton_6.getText(),spinner_6.getValue()
							,Integer.parseInt(spinner_6.getValue().toString())*Integer.parseInt(��Ǯ6.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_6.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		С�����.add(radioButton_6);
		
		JLabel label_17 = new JLabel("Ԫ/��");
		label_17.setBounds(177, 207, 39, 22);
		label_17.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		С�����.add(label_17);
		
		JLabel label_20 = new JLabel("��");
		label_20.setBounds(255, 207, 16, 22);
		label_20.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		С�����.add(label_20);
		
		JLabel label_21 = new JLabel("");
		label_21.setIcon(new ImageIcon("ͼƬ//IMG_4956.JPG"));
		label_21.setBounds(46, 13, 225, 182);
		С�����.add(label_21);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("ͼƬ//IMG_4954.JPG"));
		label_11.setBounds(338, 13, 225, 182);
		С�����.add(label_11);
		
		JLabel ��Ǯ7 = new JLabel("28");
		��Ǯ7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ7.setBounds(448, 207, 18, 22);
		С�����.add(��Ǯ7);
		
		spinner_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_7.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_7.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_7.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_7.getValue().toString())*Integer.parseInt(��Ǯ7.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_7.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_7.setEnabled(false);
		spinner_7.setBounds(510, 204, 32, 28);
		С�����.add(spinner_7);
		
		radioButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_7.isSelected()) {
					spinner_7.setEnabled(true);
					model.addRow(new Object[] {radioButton_7.getText(),spinner_7.getValue()
							,Integer.parseInt(spinner_7.getValue().toString())*Integer.parseInt(��Ǯ7.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_7.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_7.setBounds(348, 204, 98, 31);
		С�����.add(radioButton_7);
		
		JLabel label_23 = new JLabel("Ԫ/��");
		label_23.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_23.setBounds(469, 207, 39, 22);
		С�����.add(label_23);
		
		JLabel label_24 = new JLabel("��");
		label_24.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_24.setBounds(547, 207, 16, 22);
		С�����.add(label_24);
		
		JLabel label_25 = new JLabel("");
		label_25.setIcon(new ImageIcon("ͼƬ//IMG_4983.JPG"));
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setBounds(624, 13, 225, 182);
		С�����.add(label_25);
		
		JLabel ��Ǯ8 = new JLabel("25");
		��Ǯ8.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ8.setBounds(734, 207, 18, 22);
		С�����.add(��Ǯ8);
		
		spinner_8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_8.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_8.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_8.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_8.getValue().toString())*Integer.parseInt(��Ǯ8.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_8.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_8.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_8.setEnabled(false);
		spinner_8.setBounds(796, 204, 32, 28);
		С�����.add(spinner_8);
		
		radioButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_8.isSelected()) {
					spinner_8.setEnabled(true);
					model.addRow(new Object[] {radioButton_8.getText(),spinner_8.getValue()
							,Integer.parseInt(spinner_8.getValue().toString())*Integer.parseInt(��Ǯ8.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_8.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_8.setBounds(624, 204, 109, 31);
		С�����.add(radioButton_8);
		
		JLabel label_27 = new JLabel("Ԫ/��");
		label_27.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_27.setBounds(755, 207, 39, 22);
		С�����.add(label_27);
		
		JLabel label_28 = new JLabel("��");
		label_28.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_28.setBounds(833, 207, 16, 22);
		С�����.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.setIcon(new ImageIcon("ͼƬ//IMG_4965.JPG"));
		label_29.setBounds(46, 313, 225, 182);
		С�����.add(label_29);
		
		JLabel ��Ǯ9 = new JLabel("28");
		��Ǯ9.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ9.setBounds(156, 507, 18, 22);
		С�����.add(��Ǯ9);
		
		spinner_9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_9.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_9.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_9.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_9.getValue().toString())*Integer.parseInt(��Ǯ9.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_9.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_9.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_9.setEnabled(false);
		spinner_9.setBounds(218, 504, 32, 28);
		С�����.add(spinner_9);
		
		radioButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_9.isSelected()) {
					spinner_9.setEnabled(true);
					model.addRow(new Object[] {radioButton_9.getText(),spinner_9.getValue()
							,Integer.parseInt(spinner_9.getValue().toString())*Integer.parseInt(��Ǯ9.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_9.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_9.setBounds(46, 504, 109, 31);
		С�����.add(radioButton_9);
		
		JLabel label_31 = new JLabel("Ԫ/��");
		label_31.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_31.setBounds(177, 507, 39, 22);
		С�����.add(label_31);
		
		JLabel label_32 = new JLabel("��");
		label_32.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_32.setBounds(255, 507, 16, 22);
		С�����.add(label_32);
		
		JLabel label_33 = new JLabel("");
		label_33.setIcon(new ImageIcon("ͼƬ//IMG_4953.JPG"));
		label_33.setBounds(338, 313, 225, 182);
		С�����.add(label_33);

		JLabel ��Ǯ10 = new JLabel("23");
		��Ǯ10.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ10.setBounds(448, 507, 18, 22);
		С�����.add(��Ǯ10);
		
		spinner_10.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_10.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_10.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_10.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_10.getValue().toString())*Integer.parseInt(��Ǯ10.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_10.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_10.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_10.setEnabled(false);
		spinner_10.setBounds(510, 504, 32, 28);
		С�����.add(spinner_10);
		
		radioButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_10.isSelected()) {
					spinner_10.setEnabled(true);
					model.addRow(new Object[] {radioButton_10.getText(),spinner_10.getValue()
							,Integer.parseInt(spinner_10.getValue().toString())*Integer.parseInt(��Ǯ10.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_10.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_10.setBounds(338, 504, 109, 31);
		С�����.add(radioButton_10);
		
		JLabel label_35 = new JLabel("Ԫ/��");
		label_35.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_35.setBounds(469, 507, 39, 22);
		С�����.add(label_35);
		
		JLabel label_36 = new JLabel("��");
		label_36.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_36.setBounds(547, 507, 16, 22);
		С�����.add(label_36);
		
		JLabel label_37 = new JLabel("");
		label_37.setIcon(new ImageIcon("ͼƬ//IMG_4982.JPG"));
		label_37.setBounds(624, 313, 225, 182);
		С�����.add(label_37);

		JLabel ��Ǯ11 = new JLabel("23");
		��Ǯ11.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ11.setBounds(734, 507, 18, 22);
		С�����.add(��Ǯ11);
		
		spinner_11.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_11.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_11.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_11.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_11.getValue().toString())*Integer.parseInt(��Ǯ11.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_11.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_11.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_11.setEnabled(false);
		spinner_11.setBounds(796, 504, 32, 28);
		С�����.add(spinner_11);
		
		radioButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_11.isSelected()) {
					spinner_11.setEnabled(true);
					model.addRow(new Object[] {radioButton_11.getText(),spinner_11.getValue()
							,Integer.parseInt(spinner_11.getValue().toString())*Integer.parseInt(��Ǯ11.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_11.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_11.setBounds(624, 504, 109, 31);
		С�����.add(radioButton_11);
		
		JLabel label_39 = new JLabel("Ԫ/��");
		label_39.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_39.setBounds(755, 507, 39, 22);
		С�����.add(label_39);
		
		JLabel label_40 = new JLabel("��");
		label_40.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_40.setBounds(833, 507, 16, 22);
		С�����.add(label_40);
		
		JPanel �߲���� = new JPanel();
		����Ƭ.add(�߲����, "�߲����");
		�߲����.setLayout(null);
		
		JLabel label_19 = new JLabel("");
		label_19.setIcon(new ImageIcon("ͼƬ//IMG_4984.JPG"));
		label_19.setBounds(42, 13, 225, 182);
		�߲����.add(label_19);

		JLabel ��Ǯ12 = new JLabel("13");
		��Ǯ12.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ12.setBounds(152, 207, 18, 22);
		�߲����.add(��Ǯ12);
		
		spinner_12.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_12.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_12.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_12.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_12.getValue().toString())*Integer.parseInt(��Ǯ12.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_12.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_12.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_12.setEnabled(false);
		spinner_12.setBounds(214, 204, 32, 28);
		�߲����.add(spinner_12);
		
		radioButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_12.isSelected()) {
					spinner_12.setEnabled(true);
					model.addRow(new Object[] {radioButton_12.getText(),spinner_12.getValue()
							,Integer.parseInt(spinner_12.getValue().toString())*Integer.parseInt(��Ǯ12.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_12.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_12.setBounds(42, 204, 109, 31);
		�߲����.add(radioButton_12);
		
		JLabel label_26 = new JLabel("Ԫ/��");
		label_26.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_26.setBounds(173, 207, 39, 22);
		�߲����.add(label_26);
		
		JLabel label_30 = new JLabel("��");
		label_30.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_30.setBounds(251, 207, 16, 22);
		�߲����.add(label_30);
		
		JLabel label_34 = new JLabel("");
		label_34.setIcon(new ImageIcon("ͼƬ//IMG_4985.JPG"));
		label_34.setBounds(331, 13, 225, 182);
		�߲����.add(label_34);

		JLabel ��Ǯ13 = new JLabel("13");
		��Ǯ13.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ13.setBounds(441, 207, 18, 22);
		�߲����.add(��Ǯ13);
		
		spinner_13.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_13.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_13.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_13.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_13.getValue().toString())*Integer.parseInt(��Ǯ13.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_13.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_13.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_13.setEnabled(false);
		spinner_13.setBounds(503, 204, 32, 28);
		�߲����.add(spinner_13);
		
		radioButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(radioButton_13.isSelected()) {
					spinner_13.setEnabled(true);
					model.addRow(new Object[] {radioButton_13.getText(),spinner_13.getValue()
							,Integer.parseInt(spinner_13.getValue().toString())*Integer.parseInt(��Ǯ13.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_13.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_13.setBounds(331, 204, 109, 31);
		�߲����.add(radioButton_13);
		
		JLabel label_41 = new JLabel("Ԫ/��");
		label_41.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_41.setBounds(462, 207, 39, 22);
		�߲����.add(label_41);
		
		JLabel label_42 = new JLabel("��");
		label_42.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_42.setBounds(540, 207, 16, 22);
		�߲����.add(label_42);
		
		JLabel label_43 = new JLabel("");
		label_43.setIcon(new ImageIcon("ͼƬ//IMG_4987.JPG"));
		label_43.setBounds(615, 13, 225, 182);
		�߲����.add(label_43);

		JLabel ��Ǯ14 = new JLabel("18");
		��Ǯ14.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ14.setBounds(725, 207, 18, 22);
		�߲����.add(��Ǯ14);
		
		spinner_14.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if(Integer.parseInt(spinner_14.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_14_1.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_14.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_14.getValue().toString())*Integer.parseInt(��Ǯ14.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_14.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_14.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_14.setEnabled(false);
		spinner_14.setBounds(787, 204, 32, 28);
		�߲����.add(spinner_14);
		
		radioButton_14_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_14_1.isSelected()) {
					spinner_14.setEnabled(true);
					model.addRow(new Object[] {radioButton_14_1.getText(),spinner_14.getValue()
							,Integer.parseInt(spinner_14.getValue().toString())*Integer.parseInt(��Ǯ14.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_14_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_14_1.setBounds(615, 204, 109, 31);
		�߲����.add(radioButton_14_1);
		
		JLabel label_45 = new JLabel("Ԫ/��");
		label_45.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_45.setBounds(746, 207, 39, 22);
		�߲����.add(label_45);
		
		JLabel label_46 = new JLabel("��");
		label_46.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_46.setBounds(824, 207, 16, 22);
		�߲����.add(label_46);
		
		JLabel label_47 = new JLabel("");
		label_47.setIcon(new ImageIcon("ͼƬ//IMG_4970.JPG"));
		label_47.setBounds(42, 327, 225, 182);
		�߲����.add(label_47);

		JLabel ��Ǯ15 = new JLabel("23");
		��Ǯ15.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ15.setBounds(152, 521, 18, 22);
		�߲����.add(��Ǯ15);
		
		spinner_15.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_15.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_15.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_15.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_15.getValue().toString())*Integer.parseInt(��Ǯ15.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_15.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_15.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_15.setEnabled(false);
		spinner_15.setBounds(214, 518, 32, 28);
		�߲����.add(spinner_15);
		
		radioButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_15.isSelected()) {
					spinner_15.setEnabled(true);
					model.addRow(new Object[] {radioButton_15.getText(),spinner_15.getValue()
							,Integer.parseInt(spinner_15.getValue().toString())*Integer.parseInt(��Ǯ15.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_15.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_15.setBounds(42, 518, 109, 31);
		�߲����.add(radioButton_15);
		
		JLabel label_49 = new JLabel("Ԫ/��");
		label_49.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_49.setBounds(173, 521, 39, 22);
		�߲����.add(label_49);
		
		JLabel label_50 = new JLabel("��");
		label_50.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_50.setBounds(251, 521, 16, 22);
		�߲����.add(label_50);
		
		JLabel label_51 = new JLabel("");
		label_51.setIcon(new ImageIcon("ͼƬ//IMG_5113.JPG"));
		label_51.setBounds(331, 327, 225, 182);
		�߲����.add(label_51);

		JLabel ��Ǯ16 = new JLabel("15");
		��Ǯ16.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ16.setBounds(441, 521, 18, 22);
		�߲����.add(��Ǯ16);
		
		spinner_16.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_16.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_16.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_16.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_16.getValue().toString())*Integer.parseInt(��Ǯ16.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_16.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_16.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_16.setEnabled(false);
		spinner_16.setBounds(503, 518, 32, 28);
		�߲����.add(spinner_16);
		
		radioButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_16.isSelected()) {
					spinner_16.setEnabled(true);
					model.addRow(new Object[] {radioButton_16.getText(),spinner_16.getValue()
							,Integer.parseInt(spinner_16.getValue().toString())*Integer.parseInt(��Ǯ16.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_16.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_16.setBounds(331, 518, 109, 31);
		�߲����.add(radioButton_16);
		
		JLabel label_53 = new JLabel("Ԫ/��");
		label_53.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_53.setBounds(462, 521, 39, 22);
		�߲����.add(label_53);
		
		JLabel label_54 = new JLabel("��");
		label_54.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_54.setBounds(540, 521, 16, 22);
		�߲����.add(label_54);
		
		JLabel label_55 = new JLabel("");
		label_55.setIcon(new ImageIcon("ͼƬ//IMG_5114.JPG"));
		label_55.setBounds(615, 327, 225, 182);
		�߲����.add(label_55);

		JLabel ��Ǯ17 = new JLabel("15");
		��Ǯ17.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ17.setBounds(725, 521, 18, 22);
		�߲����.add(��Ǯ17);
		
		spinner_17.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_17.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_17.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_17.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_17.getValue().toString())*Integer.parseInt(��Ǯ17.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_17.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_17.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_17.setEnabled(false);
		spinner_17.setBounds(787, 518, 32, 28);
		�߲����.add(spinner_17);
		
		radioButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_17.isSelected()) {
					spinner_17.setEnabled(true);
					model.addRow(new Object[] {radioButton_17.getText(),spinner_17.getValue()
							,Integer.parseInt(spinner_17.getValue().toString())*Integer.parseInt(��Ǯ17.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_17.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_17.setBounds(615, 518, 109, 31);
		�߲����.add(radioButton_17);
		
		JLabel label_57 = new JLabel("Ԫ/��");
		label_57.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_57.setBounds(746, 521, 39, 22);
		�߲����.add(label_57);
		
		JLabel label_58 = new JLabel("��");
		label_58.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_58.setBounds(824, 521, 16, 22);
		�߲����.add(label_58);
		
		JPanel ��ʳ��� = new JPanel();
		����Ƭ.add(��ʳ���, "��ʳ���");
		��ʳ���.setLayout(null);
		
		JLabel label_22 = new JLabel("");
		label_22.setIcon(new ImageIcon("ͼƬ//FullSizeRender(1).jpg"));
		label_22.setBounds(31, 23, 225, 182);
		��ʳ���.add(label_22);

		JLabel ��Ǯ18 = new JLabel("20");
		��Ǯ18.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ18.setBounds(141, 217, 18, 22);
		��ʳ���.add(��Ǯ18);
		
		spinner_18.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_18.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_14.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_18.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_18.getValue().toString())*Integer.parseInt(��Ǯ18.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_18.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_18.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_18.setEnabled(false);
		spinner_18.setBounds(203, 214, 32, 28);
		��ʳ���.add(spinner_18);
		
		radioButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_14.isSelected()) {
					spinner_18.setEnabled(true);
					model.addRow(new Object[] {radioButton_14.getText(),spinner_18.getValue()
							,Integer.parseInt(spinner_18.getValue().toString())*Integer.parseInt(��Ǯ18.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_14.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_14.setBounds(31, 214, 109, 31);
		��ʳ���.add(radioButton_14);
		
		JLabel label_38 = new JLabel("Ԫ/��");
		label_38.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_38.setBounds(162, 217, 39, 22);
		��ʳ���.add(label_38);
		
		JLabel label_52 = new JLabel("��");
		label_52.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_52.setBounds(240, 217, 16, 22);
		��ʳ���.add(label_52);
		
		JLabel label_56 = new JLabel("");
		label_56.setIcon(new ImageIcon("ͼƬ//IMG_4967.JPG"));
		label_56.setBounds(320, 23, 225, 182);
		��ʳ���.add(label_56);

		JLabel ��Ǯ19 = new JLabel("13");
		��Ǯ19.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ19.setBounds(430, 217, 18, 22);
		��ʳ���.add(��Ǯ19);
		
		spinner_19.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_19.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_18.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_19.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_19.getValue().toString())*Integer.parseInt(��Ǯ19.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_19.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_19.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_19.setEnabled(false);
		spinner_19.setBounds(492, 214, 32, 28);
		��ʳ���.add(spinner_19);
		
		radioButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_18.isSelected()) {
					spinner_19.setEnabled(true);
					model.addRow(new Object[] {radioButton_18.getText(),spinner_19.getValue()
							,Integer.parseInt(spinner_19.getValue().toString())*Integer.parseInt(��Ǯ19.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_18.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_18.setBounds(320, 214, 109, 31);
		��ʳ���.add(radioButton_18);
		
		JLabel label_59 = new JLabel("Ԫ/��");
		label_59.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_59.setBounds(451, 217, 39, 22);
		��ʳ���.add(label_59);
		
		JLabel label_61 = new JLabel("��");
		label_61.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_61.setBounds(529, 217, 16, 22);
		��ʳ���.add(label_61);
		
		JLabel label_62 = new JLabel("");
		label_62.setIcon(new ImageIcon("ͼƬ//IMG_4952.PNG"));
		label_62.setBounds(613, 23, 225, 182);
		��ʳ���.add(label_62);

		JLabel ��Ǯ20 = new JLabel("18");
		��Ǯ20.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ20.setBounds(723, 217, 18, 22);
		��ʳ���.add(��Ǯ20);
		
		spinner_20.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_20.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_19.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_20.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_20.getValue().toString())*Integer.parseInt(��Ǯ20.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_20.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_20.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_20.setEnabled(false);
		spinner_20.setBounds(785, 214, 32, 28);
		��ʳ���.add(spinner_20);
		
		radioButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_19.isSelected()) {
					spinner_20.setEnabled(true);
					model.addRow(new Object[] {radioButton_19.getText(),spinner_20.getValue()
							,Integer.parseInt(spinner_20.getValue().toString())*Integer.parseInt(��Ǯ20.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_19.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_19.setBounds(613, 214, 109, 31);
		��ʳ���.add(radioButton_19);
		
		JLabel label_63 = new JLabel("Ԫ/��");
		label_63.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_63.setBounds(744, 217, 39, 22);
		��ʳ���.add(label_63);
		
		JLabel label_65 = new JLabel("��");
		label_65.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_65.setBounds(822, 217, 16, 22);
		��ʳ���.add(label_65);
		
		JLabel label_66 = new JLabel("");
		label_66.setIcon(new ImageIcon("ͼƬ//IMG_4968.JPG"));
		label_66.setBounds(31, 306, 225, 182);
		��ʳ���.add(label_66);

		JLabel ��Ǯ21 = new JLabel("25");
		��Ǯ21.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ21.setBounds(141, 500, 18, 22);
		��ʳ���.add(��Ǯ21);
		
		spinner_21.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_21.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_20.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_21.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_21.getValue().toString())*Integer.parseInt(��Ǯ21.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_21.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_21.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_21.setEnabled(false);
		spinner_21.setBounds(203, 497, 32, 28);
		��ʳ���.add(spinner_21);
		
		radioButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_20.isSelected()) {
					spinner_21.setEnabled(true);
					model.addRow(new Object[] {radioButton_20.getText(),spinner_21.getValue()
							,Integer.parseInt(spinner_21.getValue().toString())*Integer.parseInt(��Ǯ21.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_20.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_20.setBounds(31, 497, 109, 31);
		��ʳ���.add(radioButton_20);
		
		JLabel label_67 = new JLabel("Ԫ/��");
		label_67.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_67.setBounds(162, 500, 39, 22);
		��ʳ���.add(label_67);
		
		JLabel label_69 = new JLabel("��");
		label_69.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_69.setBounds(240, 500, 16, 22);
		��ʳ���.add(label_69);
		
		JLabel label_70 = new JLabel("");
		label_70.setIcon(new ImageIcon("ͼƬ//IMG_4969.JPG"));
		label_70.setBounds(320, 306, 225, 182);
		��ʳ���.add(label_70);

		JLabel ��Ǯ22 = new JLabel("28");
		��Ǯ22.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ22.setBounds(430, 500, 18, 22);
		��ʳ���.add(��Ǯ22);
		
		spinner_22.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_22.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_21.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_22.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_22.getValue().toString())*Integer.parseInt(��Ǯ22.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_22.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_22.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_22.setEnabled(false);
		spinner_22.setBounds(492, 497, 32, 28);
		��ʳ���.add(spinner_22);
		
		radioButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_21.isSelected()) {
					spinner_22.setEnabled(true);
					model.addRow(new Object[] {radioButton_21.getText(),spinner_22.getValue()
							,Integer.parseInt(spinner_22.getValue().toString())*Integer.parseInt(��Ǯ22.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_21.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_21.setBounds(320, 497, 109, 31);
		��ʳ���.add(radioButton_21);
		
		JLabel label_71 = new JLabel("Ԫ/��");
		label_71.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_71.setBounds(451, 500, 39, 22);
		��ʳ���.add(label_71);
		
		JLabel label_73 = new JLabel("��");
		label_73.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_73.setBounds(529, 500, 16, 22);
		��ʳ���.add(label_73);
		
		JLabel label_74 = new JLabel("");
		label_74.setIcon(new ImageIcon("ͼƬ//IMG_4963.JPG"));
		label_74.setBounds(613, 306, 225, 182);
		��ʳ���.add(label_74);

		JLabel ��Ǯ23 = new JLabel("18");
		��Ǯ23.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ23.setBounds(723, 500, 18, 22);
		��ʳ���.add(��Ǯ23);
		
		spinner_23.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_23.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_22.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_23.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_23.getValue().toString())*Integer.parseInt(��Ǯ23.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_23.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_23.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_23.setEnabled(false);
		spinner_23.setBounds(785, 497, 32, 28);
		��ʳ���.add(spinner_23);
		
		radioButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_22.isSelected()) {
					spinner_23.setEnabled(true);
					model.addRow(new Object[] {radioButton_22.getText(),spinner_23.getValue()
							,Integer.parseInt(spinner_23.getValue().toString())*Integer.parseInt(��Ǯ23.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_22.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_22.setBounds(613, 497, 109, 31);
		��ʳ���.add(radioButton_22);
		
		JLabel label_75 = new JLabel("Ԫ/��");
		label_75.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_75.setBounds(744, 500, 39, 22);
		��ʳ���.add(label_75);
		
		JLabel label_77 = new JLabel("��");
		label_77.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_77.setBounds(822, 500, 16, 22);
		��ʳ���.add(label_77);
		
		JPanel ��Ʒ��� = new JPanel();
		����Ƭ.add(��Ʒ���, "��Ʒ���");
		��Ʒ���.setLayout(null);
		
		JLabel label_78 = new JLabel("");
		label_78.setIcon(new ImageIcon("ͼƬ//IMG_4989.JPG"));
		label_78.setBounds(31, 25, 225, 182);
		��Ʒ���.add(label_78);

		JLabel ��Ǯ24 = new JLabel("15");
		��Ǯ24.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ24.setBounds(141, 219, 18, 22);
		��Ʒ���.add(��Ǯ24);
		
		spinner_24.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_24.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_23.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_24.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_24.getValue().toString())*Integer.parseInt(��Ǯ24.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_24.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_24.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_24.setEnabled(false);
		spinner_24.setBounds(203, 216, 32, 28);
		��Ʒ���.add(spinner_24);
		
		radioButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_23.isSelected()) {
					spinner_24.setEnabled(true);
					model.addRow(new Object[] {radioButton_23.getText(),spinner_24.getValue()
							,Integer.parseInt(spinner_24.getValue().toString())*Integer.parseInt(��Ǯ24.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_23.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_23.setBounds(31, 216, 109, 31);
		��Ʒ���.add(radioButton_23);
		
		JLabel label_79 = new JLabel("Ԫ/��");
		label_79.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_79.setBounds(162, 219, 39, 22);
		��Ʒ���.add(label_79);
		
		JLabel label_81 = new JLabel("��");
		label_81.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_81.setBounds(240, 219, 16, 22);
		��Ʒ���.add(label_81);
		
		JLabel label_82 = new JLabel("");
		label_82.setIcon(new ImageIcon("ͼƬ//IMG_4990.JPG"));
		label_82.setBounds(317, 25, 225, 182);
		��Ʒ���.add(label_82);

		JLabel ��Ǯ25 = new JLabel("13");
		��Ǯ25.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ25.setBounds(427, 219, 18, 22);
		��Ʒ���.add(��Ǯ25);
		
		spinner_25.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_25.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_24.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_25.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_25.getValue().toString())*Integer.parseInt(��Ǯ25.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_25.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_25.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_25.setEnabled(false);
		spinner_25.setBounds(489, 216, 32, 28);
		��Ʒ���.add(spinner_25);
		
		radioButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_24.isSelected()) {
					spinner_25.setEnabled(true);
					model.addRow(new Object[] {radioButton_24.getText(),spinner_25.getValue()
							,Integer.parseInt(spinner_25.getValue().toString())*Integer.parseInt(��Ǯ25.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_24.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_24.setBounds(317, 216, 109, 31);
		��Ʒ���.add(radioButton_24);
		
		JLabel label_83 = new JLabel("Ԫ/��");
		label_83.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_83.setBounds(448, 219, 39, 22);
		��Ʒ���.add(label_83);
		
		JLabel label_85 = new JLabel("��");
		label_85.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_85.setBounds(526, 219, 16, 22);
		��Ʒ���.add(label_85);
		
		JLabel label_86 = new JLabel("");
		label_86.setIcon(new ImageIcon("ͼƬ//IMG_4991.JPG"));
		label_86.setBounds(598, 25, 225, 182);
		��Ʒ���.add(label_86);

		JLabel ��Ǯ26 = new JLabel("18");
		��Ǯ26.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ26.setBounds(720, 222, 18, 22);
		��Ʒ���.add(��Ǯ26);
		
		spinner_26.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_26.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_25.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_26.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_26.getValue().toString())*Integer.parseInt(��Ǯ26.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_26.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_26.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_26.setEnabled(false);
		spinner_26.setBounds(782, 219, 32, 28);
		��Ʒ���.add(spinner_26);
		
		radioButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_25.isSelected()) {
					spinner_26.setEnabled(true);
					model.addRow(new Object[] {radioButton_25.getText(),spinner_26.getValue()
							,Integer.parseInt(spinner_26.getValue().toString())*Integer.parseInt(��Ǯ26.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_25.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_25.setBounds(587, 216, 131, 31);
		��Ʒ���.add(radioButton_25);
		
		JLabel label_87 = new JLabel("Ԫ/��");
		label_87.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_87.setBounds(741, 222, 39, 22);
		��Ʒ���.add(label_87);
		
		JLabel label_89 = new JLabel("��");
		label_89.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_89.setBounds(819, 222, 16, 22);
		��Ʒ���.add(label_89);
		
		JLabel label_90 = new JLabel("");
		label_90.setIcon(new ImageIcon("ͼƬ//IMG_4992.JPG"));
		label_90.setBounds(31, 329, 225, 182);
		��Ʒ���.add(label_90);

		JLabel ��Ǯ27 = new JLabel("18");
		��Ǯ27.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ27.setBounds(141, 523, 18, 22);
		��Ʒ���.add(��Ǯ27);
		
		spinner_27.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_27.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_26.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_27.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_27.getValue().toString())*Integer.parseInt(��Ǯ27.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_27.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_27.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_27.setEnabled(false);
		spinner_27.setBounds(203, 520, 32, 28);
		��Ʒ���.add(spinner_27);
		
		radioButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_26.isSelected()) {
					spinner_27.setEnabled(true);
					model.addRow(new Object[] {radioButton_26.getText(),spinner_27.getValue()
							,Integer.parseInt(spinner_27.getValue().toString())*Integer.parseInt(��Ǯ27.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_26.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_26.setBounds(31, 520, 109, 31);
		��Ʒ���.add(radioButton_26);
		
		JLabel label_91 = new JLabel("Ԫ/��");
		label_91.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_91.setBounds(162, 523, 39, 22);
		��Ʒ���.add(label_91);
		
		JLabel label_93 = new JLabel("��");
		label_93.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_93.setBounds(240, 523, 16, 22);
		��Ʒ���.add(label_93);
		
		JLabel label_94 = new JLabel("");
		label_94.setIcon(new ImageIcon("ͼƬ//IMG_4993.JPG"));
		label_94.setBounds(317, 329, 225, 182);
		��Ʒ���.add(label_94);

		JLabel ��Ǯ28 = new JLabel("18");
		��Ǯ28.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ28.setBounds(442, 526, 18, 22);
		��Ʒ���.add(��Ǯ28);
		
		spinner_28.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_28.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_27.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_28.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_28.getValue().toString())*Integer.parseInt(��Ǯ28.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_28.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_28.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_28.setEnabled(false);
		spinner_28.setBounds(504, 523, 32, 28);
		��Ʒ���.add(spinner_28);
		
		radioButton_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_27.isSelected()) {
					spinner_28.setEnabled(true);
					model.addRow(new Object[] {radioButton_27.getText(),spinner_28.getValue()
							,Integer.parseInt(spinner_28.getValue().toString())*Integer.parseInt(��Ǯ28.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_27.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_27.setBounds(305, 520, 128, 31);
		��Ʒ���.add(radioButton_27);
		
		JLabel label_95 = new JLabel("Ԫ/��");
		label_95.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_95.setBounds(463, 526, 39, 22);
		��Ʒ���.add(label_95);
		
		JLabel label_97 = new JLabel("��");
		label_97.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_97.setBounds(541, 526, 16, 22);
		��Ʒ���.add(label_97);
		
		JLabel label_98 = new JLabel("");
		label_98.setIcon(new ImageIcon("ͼƬ//IMG_4994.JPG"));
		label_98.setBounds(598, 329, 225, 182);
		��Ʒ���.add(label_98);

		JLabel ��Ǯ29 = new JLabel("18");
		��Ǯ29.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ29.setBounds(708, 523, 18, 22);
		��Ʒ���.add(��Ǯ29);
		
		spinner_29.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_29.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_28.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_29.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_29.getValue().toString())*Integer.parseInt(��Ǯ29.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_29.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_29.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_29.setEnabled(false);
		spinner_29.setBounds(770, 520, 32, 28);
		��Ʒ���.add(spinner_29);
		
		radioButton_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_28.isSelected()) {
					spinner_29.setEnabled(true);
					model.addRow(new Object[] {radioButton_28.getText(),spinner_29.getValue()
							,Integer.parseInt(spinner_29.getValue().toString())*Integer.parseInt(��Ǯ29.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_28.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_28.setBounds(598, 520, 109, 31);
		��Ʒ���.add(radioButton_28);
		
		JLabel label_99 = new JLabel("Ԫ/��");
		label_99.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_99.setBounds(729, 523, 39, 22);
		��Ʒ���.add(label_99);
		
		JLabel label_101 = new JLabel("��");
		label_101.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_101.setBounds(807, 523, 16, 22);
		��Ʒ���.add(label_101);
		
		JPanel ��Ʒ��� = new JPanel();
		����Ƭ.add(��Ʒ���, "��Ʒ���");
		��Ʒ���.setLayout(null);
		
		JLabel label_102 = new JLabel("");
		label_102.setIcon(new ImageIcon("ͼƬ//FullSizeRender(2).jpg"));
		label_102.setBounds(35, 28, 225, 182);
		��Ʒ���.add(label_102);

		JLabel ��Ǯ30 = new JLabel("6");
		��Ǯ30.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ30.setBounds(145, 222, 18, 22);
		��Ʒ���.add(��Ǯ30);
		
		spinner_30.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_30.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_30.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_29.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_30.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_30.getValue().toString())*Integer.parseInt(��Ǯ30.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_30.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_30.setEnabled(false);
		spinner_30.setBounds(207, 219, 32, 28);
		��Ʒ���.add(spinner_30);
		
		radioButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_29.isSelected()) {
					spinner_30.setEnabled(true);
					model.addRow(new Object[] {radioButton_29.getText(),spinner_30.getValue()
							,Integer.parseInt(spinner_30.getValue().toString())*Integer.parseInt(��Ǯ30.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_29.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_29.setBounds(35, 219, 109, 31);
		��Ʒ���.add(radioButton_29);
		
		JLabel label_103 = new JLabel("Ԫ/��");
		label_103.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_103.setBounds(166, 222, 39, 22);
		��Ʒ���.add(label_103);
		
		JLabel label_105 = new JLabel("��");
		label_105.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_105.setBounds(244, 222, 16, 22);
		��Ʒ���.add(label_105);
		
		JLabel label_106 = new JLabel("");
		label_106.setIcon(new ImageIcon("ͼƬ//IMG_4975.JPG"));
		label_106.setBounds(321, 28, 225, 182);
		��Ʒ���.add(label_106);

		JLabel ��Ǯ31 = new JLabel("6");
		��Ǯ31.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ31.setBounds(431, 222, 18, 22);
		��Ʒ���.add(��Ǯ31);
		
		spinner_31.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_31.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_30.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_31.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_31.getValue().toString())*Integer.parseInt(��Ǯ31.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_31.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_31.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_31.setEnabled(false);
		spinner_31.setBounds(493, 219, 32, 28);
		��Ʒ���.add(spinner_31);
		
		radioButton_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_30.isSelected()) {
					spinner_31.setEnabled(true);
					model.addRow(new Object[] {radioButton_30.getText(),spinner_31.getValue()
							,Integer.parseInt(spinner_31.getValue().toString())*Integer.parseInt(��Ǯ31.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_30.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_30.setBounds(321, 219, 109, 31);
		��Ʒ���.add(radioButton_30);
		
		JLabel label_107 = new JLabel("Ԫ/��");
		label_107.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_107.setBounds(452, 222, 39, 22);
		��Ʒ���.add(label_107);
		
		JLabel label_109 = new JLabel("��");
		label_109.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_109.setBounds(530, 222, 16, 22);
		��Ʒ���.add(label_109);
		
		JLabel label_110 = new JLabel("");
		label_110.setIcon(new ImageIcon("ͼƬ//IMG_4960.JPG"));
		label_110.setBounds(607, 28, 225, 182);
		��Ʒ���.add(label_110);

		JLabel ��Ǯ32 = new JLabel("45");
		��Ǯ32.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ32.setBounds(717, 222, 18, 22);
		��Ʒ���.add(��Ǯ32);
		
		spinner_32.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_32.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_31.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_32.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_32.getValue().toString())*Integer.parseInt(��Ǯ32.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_32.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_32.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_32.setEnabled(false);
		spinner_32.setBounds(779, 219, 32, 28);
		��Ʒ���.add(spinner_32);
		
		radioButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_31.isSelected()) {
					spinner_32.setEnabled(true);
					model.addRow(new Object[] {radioButton_31.getText(),spinner_32.getValue()
							,Integer.parseInt(spinner_32.getValue().toString())*Integer.parseInt(��Ǯ32.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_31.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_31.setBounds(607, 219, 109, 31);
		��Ʒ���.add(radioButton_31);
		
		JLabel label_111 = new JLabel("Ԫ/��");
		label_111.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_111.setBounds(738, 222, 39, 22);
		��Ʒ���.add(label_111);
		
		JLabel label_113 = new JLabel("��");
		label_113.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_113.setBounds(816, 222, 16, 22);
		��Ʒ���.add(label_113);
		
		JLabel label_114 = new JLabel("");
		label_114.setIcon(new ImageIcon("ͼƬ//IMG_4973.JPG"));
		label_114.setBounds(607, 328, 225, 182);
		��Ʒ���.add(label_114);

		JLabel ��Ǯ33 = new JLabel("8");
		��Ǯ33.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ33.setBounds(717, 522, 18, 22);
		��Ʒ���.add(��Ǯ33);
		
		spinner_33.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_33.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_32.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_33.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_33.getValue().toString())*Integer.parseInt(��Ǯ33.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_33.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_33.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_33.setEnabled(false);
		spinner_33.setBounds(779, 519, 32, 28);
		��Ʒ���.add(spinner_33);
		
		radioButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_32.isSelected()) {
					spinner_33.setEnabled(true);
					model.addRow(new Object[] {radioButton_32.getText(),spinner_33.getValue()
							,Integer.parseInt(spinner_33.getValue().toString())*Integer.parseInt(��Ǯ33.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_32.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_32.setBounds(607, 519, 109, 31);
		��Ʒ���.add(radioButton_32);
		
		JLabel label_115 = new JLabel("Ԫ/��");
		label_115.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_115.setBounds(738, 522, 39, 22);
		��Ʒ���.add(label_115);
		
		JLabel label_117 = new JLabel("��");
		label_117.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_117.setBounds(816, 522, 16, 22);
		��Ʒ���.add(label_117);
		
		JLabel label_118 = new JLabel("");
		label_118.setIcon(new ImageIcon("ͼƬ//IMG_4972.JPG"));
		label_118.setBounds(321, 328, 225, 182);
		��Ʒ���.add(label_118);

		JLabel ��Ǯ34 = new JLabel("5");
		��Ǯ34.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ34.setBounds(431, 522, 18, 22);
		��Ʒ���.add(��Ǯ34);
		
		spinner_34.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_34.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_33.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_34.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_34.getValue().toString())*Integer.parseInt(��Ǯ34.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_34.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_34.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_34.setEnabled(false);
		spinner_34.setBounds(493, 519, 32, 28);
		��Ʒ���.add(spinner_34);
		
		radioButton_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_33.isSelected()) {
					spinner_34.setEnabled(true);
					model.addRow(new Object[] {radioButton_33.getText(),spinner_34.getValue()
							,Integer.parseInt(spinner_34.getValue().toString())*Integer.parseInt(��Ǯ34.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_33.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_33.setBounds(321, 519, 109, 31);
		��Ʒ���.add(radioButton_33);
		
		JLabel label_119 = new JLabel("Ԫ/��");
		label_119.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_119.setBounds(452, 522, 39, 22);
		��Ʒ���.add(label_119);
		
		JLabel label_121 = new JLabel("��");
		label_121.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_121.setBounds(530, 522, 16, 22);
		��Ʒ���.add(label_121);
		
		JLabel label_122 = new JLabel("");
		label_122.setIcon(new ImageIcon("ͼƬ//IMG_4976.JPG"));
		label_122.setBounds(35, 328, 225, 182);
		��Ʒ���.add(label_122);

		JLabel ��Ǯ35 = new JLabel("4");
		��Ǯ35.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		��Ǯ35.setBounds(145, 522, 18, 22);
		��Ʒ���.add(��Ǯ35);
		
		spinner_35.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(Integer.parseInt(spinner_35.getValue().toString())>0) {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						for(int j=table.getColumnCount()-1;j>=0;j--) {
							if(radioButton_34.getText().equals(table.getValueAt(i, j).toString())) {
								table.setValueAt(spinner_35.getValue(), i, j+1);
								table.setValueAt(Integer.parseInt(spinner_35.getValue().toString())*Integer.parseInt(��Ǯ35.getText()), i, j+2);
							}
						}
					}
				}
			}
		});
		spinner_35.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner_35.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		spinner_35.setEnabled(false);
		spinner_35.setBounds(207, 519, 32, 28);
		��Ʒ���.add(spinner_35);
		
		radioButton_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_34.isSelected()) {
					spinner_35.setEnabled(true);
					model.addRow(new Object[] {radioButton_34.getText(),spinner_35.getValue()
							,Integer.parseInt(spinner_35.getValue().toString())*Integer.parseInt(��Ǯ35.getText())});
					table.setModel(model);//ʵ��ʵʱ����
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
		radioButton_34.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		radioButton_34.setBounds(35, 519, 109, 31);
		��Ʒ���.add(radioButton_34);
		
		JLabel label_123 = new JLabel("Ԫ/��");
		label_123.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_123.setBounds(166, 522, 39, 22);
		��Ʒ���.add(label_123);
		
		JLabel label_125 = new JLabel("��");
		label_125.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_125.setBounds(244, 522, 16, 22);
		��Ʒ���.add(label_125);
		
		JLabel ���ű�ǩ = new JLabel("��ѡ������:");
		���ű�ǩ.setFont(new Font("΢���ź�", Font.BOLD, 16));
		���ű�ǩ.setBounds(1057, 0, 251, 24);
		�����.add(���ű�ǩ);
		
		String desk[]= {"1����","2����","3����","4����","5����","6����"};
		JComboBox ���Ÿ�ѡ�� = new JComboBox(desk);
		���Ÿ�ѡ��.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		���Ÿ�ѡ��.setBounds(1056, 25, 189, 24);
		�����.add(���Ÿ�ѡ��);
		
		JLabel �ò����� = new JLabel("�������ò�����:(��ˮ��10Ԫ/��)");
		�ò�����.setFont(new Font("΢���ź�", Font.BOLD, 16));
		�ò�����.setBounds(1057, 62, 251, 18);
		�����.add(�ò�����);
		
		�ò������ı� = new JTextField();
		�ò������ı�.setText("0");
		�ò������ı�.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		�ò������ı�.setBounds(1057, 82, 188, 24);
		�����.add(�ò������ı�);
		
		JLabel ��ʽ�б��ǩ = new JLabel("�ѵ��ʽ�б�");
		��ʽ�б��ǩ.setFont(new Font("΢���ź�", Font.BOLD, 16));
		��ʽ�б��ǩ.setBounds(1057, 138, 188, 18);
		�����.add(��ʽ�б��ǩ);

		�ܶ��ǩ.setFont(new Font("΢���ź�", Font.BOLD, 16));
		�ܶ��ǩ.setBounds(1057, 564, 280, 18);
		�����.add(�ܶ��ǩ);
		��ӭ���.setLayout(null);
		
		JLabel ��ӭ��ǩ = new JLabel("��ӭ�����������");
		��ӭ��ǩ.setBounds(509, 13, 355, 30);
		��ӭ��ǩ.setFont(new Font("����", Font.PLAIN, 25));
		��ӭ��ǩ.setHorizontalAlignment(SwingConstants.CENTER);
		��ӭ���.add(��ӭ��ǩ);
		
		JButton ȡ����ť = new JButton("ȡ��");
		ȡ����ť.addActionListener(new ActionListener() {//����¼�
			public void actionPerformed(ActionEvent a) {
				//�������еĵ�ѡ������ֵ��ڿؼ����ɲ���
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
				spinner.setValue(1);//�����ֵ��ڿؼ������ֵ���1
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
		ȡ����ť.setBounds(448, 703, 113, 27);
		�����.add(ȡ����ť);
		
		JButton �µ���ť = new JButton("�µ�");
		�µ���ť.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.parseInt(�ò������ı�.getText())==0||table.getRowCount()==0) {
					dialog d=new dialog(1);//̸���µ��ɹ��Ի���
				}
				else {
					dialog d=new dialog(0);
					for(int i=table.getRowCount()-1;i>=0;i--) {
						sum +=Integer.parseInt(table.getValueAt(i, 2).toString());
					}
					sum +=Integer.parseInt(�ò������ı�.getText())*10;
					�ܶ��ǩ.setText("�˵��ܶ"+sum+"Ԫ");
					�µ���ť.setEnabled(false);//�������˵�֮�󲻿����ٰ��µ���ť
					�ӵ���ť.setEnabled(true);
					���˰�ť.setEnabled(true);
					
					File_operate fo=new File_operate();//�µ�֮������д���ļ�
					fo.write(table, ���Ÿ�ѡ��,�ò������ı�);
					
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
		�µ���ť.setBounds(587, 704, 113, 27);
		�����.add(�µ���ť);
		
		�ӵ���ť.setEnabled(false);
		�ӵ���ť.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) {
					dialog d=new dialog(3);//�����ӵ��ɹ��Ի���
				}
				else {
					for(int i=table.getRowCount()-1;i>=0;i--) {
						sum +=Integer.parseInt(table.getValueAt(i, 2).toString());
					}
					�ܶ��ǩ.setText("�˵��ܶ"+sum+"Ԫ");
					�µ���ť.setEnabled(false);
					
					File_operate fo=new File_operate();
					fo.writeadd(table, ���Ÿ�ѡ��);
					
					dialog d=new dialog(2);//�����ӵ��ɹ��Ի���
					
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
		�ӵ���ť.setBounds(725, 705, 113, 27);
		�����.add(�ӵ���ť);
		
		
		���˰�ť.setEnabled(false);
		���˰�ť.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�������˴���
				JDialog dialog = new JDialog();
		        try {
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception w) {
					w.printStackTrace();
				}
		        dialog.setFont(new Font("΢���ź�", Font.BOLD, 14));
		        dialog.setBounds(200,300,500,600);
		        dialog.setTitle("��ܰ��ʾ\r\n");
		       
				JButton btnOk = new JButton("OK");
				btnOk.setBackground(new Color(204, 255, 0));
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				dialog.getContentPane().setLayout(null);
				btnOk.setFont(new Font("΢���ź�", Font.BOLD, 17));
				btnOk.setBounds(201, 279, 113, 27);
				dialog.getContentPane().add(btnOk);
				JLabel conmune = new JLabel(���Ÿ�ѡ��.getSelectedItem()+"һ��������"+�ܶ��ǩ.getText());
				conmune.setFont(new Font("΢���ź�", Font.BOLD, 18));
				conmune.setBounds(66, 13, 383, 27);
				JLabel lblNewLabel2 = new JLabel("�뵽ǰ̨����");
				lblNewLabel2.setFont(new Font("΢���ź�", Font.BOLD, 18));
				lblNewLabel2.setBounds(99, 41, 318, 34);
				dialog.getContentPane().add(lblNewLabel2);
				dialog.getContentPane().add(conmune);
				
				�ܶ��ǩ.setText("�˵��ܶ");
			}
		});
		���˰�ť.setBounds(853, 704, 113, 27);
		�����.add(���˰�ť);
		
		//��ʾ��̬ʱ��
		JLabel ʱ���ǩ = new JLabel("");
		timer=new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date=new Date();
				SimpleDateFormat time=new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss"); 
				ʱ���ǩ.setText(time.format(date.getTime()));
			}
		});
		timer.start();
		ʱ���ǩ.setFont(new Font("΢���ź�", Font.BOLD, 16));
		ʱ���ǩ.setBounds(1141, 723, 210, 20);
		�����.add(ʱ���ǩ);
		
		������ϵ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(����Ƭ, "�������");
			}
		});
		С����.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(����Ƭ, "С�����");
			}
		});
		�߲���.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(����Ƭ, "�߲����");
			}
		});
		��ʳ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(����Ƭ, "��ʳ���");
			}
		});
		��Ʒ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(����Ƭ, "��Ʒ���");
			}
		});
		��Ʒ��.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(����Ƭ, "��Ʒ���");
			}
		});
	}
}

