package controller.EmployeesWork;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.wmsEmployeesDaoImpl;
import model.wmsemployees;
import util.ClockRun;
import util.calendarSelect;
import util.employeesChangeUI;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
@SuppressWarnings("all")
public class addEmployeesUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField eName;
	private JTextField eUsername;
	private JTextField ePassword;
	private JTextField dateOfBirth;
	private JTextField ePhoneNumber;
	private JTextField eAddress;
	private JTextField eEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ecNumber;
	private JTextField ecName;
	private String gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmployeesUI frame = new addEmployeesUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addEmployeesUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
	    int y = (screenSize.height - getHeight()) / 2;
	    setLocation(x,y);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(164, 209, 255));
		panel.setBounds(0, 0, 816, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("新增員工資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2.setBounds(286, 25, 244, 40);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("員工姓名：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(131, 103, 100, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(138, 214, 88, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(442, 214, 88, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("手機號碼：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(434, 162, 100, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("出生日期：");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_1.setBounds(134, 162, 92, 30);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("居住地址：");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_1_1.setBounds(131, 332, 100, 30);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("電子郵件：");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_1_1_1.setBounds(131, 391, 100, 30);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		eName = new JTextField();
		eName.setColumns(10);
		eName.setBounds(250, 101, 134, 35);
		panel.add(eName);
		
		eUsername = new JTextField();
		eUsername.setColumns(10);
		eUsername.setBounds(250, 212, 134, 35);
		panel.add(eUsername);
		
		ePassword = new JTextField();
		ePassword.setColumns(10);
		ePassword.setBounds(530, 217, 134, 35);
		panel.add(ePassword);
		
		dateOfBirth = new JTextField();
		dateOfBirth.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				calendarSelect cs=new calendarSelect(dateOfBirth);
				cs.showDialog();
			}
		});
		dateOfBirth.setColumns(10);
		dateOfBirth.setBounds(250, 160, 134, 35);
		panel.add(dateOfBirth);
		
		ePhoneNumber = new JTextField();
		ePhoneNumber.setColumns(10);
		ePhoneNumber.setBounds(530, 160, 134, 35);
		panel.add(ePhoneNumber);
		
		eAddress = new JTextField();
		eAddress.setColumns(10);
		eAddress.setBounds(250, 330, 414, 35);
		panel.add(eAddress);
		
		eEmail = new JTextField();
		eEmail.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		eEmail.setColumns(10);
		eEmail.setBounds(250, 389, 414, 35);
		panel.add(eEmail);
		
		JRadioButton M = new JRadioButton("男");
		M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{gender="男";}
		});
		buttonGroup.add(M);
		M.setBackground(new Color(164, 209, 255));
		M.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		M.setBounds(534, 104, 54, 30);
		panel.add(M);
		
		JRadioButton F = new JRadioButton("女");
		F.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{gender="女";}
		});
		buttonGroup.add(F);
		F.setBackground(new Color(164, 209, 255));
		F.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		F.setBounds(608, 103, 56, 30);
		panel.add(F);
		
		JLabel lblNewLabel_1_3 = new JLabel("性別：");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(440, 103, 88, 30);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("緊急聯絡人：");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_1_2.setBounds(106, 275, 122, 30);
		panel.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("聯絡人電話：");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_2.setBounds(412, 275, 122, 30);
		panel.add(lblNewLabel_1_2_2);
		
		ecNumber = new JTextField();
		ecNumber.setColumns(10);
		ecNumber.setBounds(530, 273, 134, 35);
		panel.add(ecNumber);
		
		ecName = new JTextField();
		ecName.setColumns(10);
		ecName.setBounds(250, 273, 134, 35);
		panel.add(ecName);
		
		JButton btnNewButton = new JButton("確定新增");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ButtonModel radioBUtton=buttonGroup.getSelection();
				
				wmsemployees wey=new wmsemployees(
						eName.getText(),
						gender,dateOfBirth.getText(),ePhoneNumber.getText(),
						eAddress.getText(),eEmail.getText(),ecName.getText(),
						ecNumber.getText(),eUsername.getText(),ePassword.getText());
				new wmsEmployeesDaoImpl().add(wey);
				JOptionPane.showMessageDialog(null, "新增成功");
				
				eName.setText("");
				eUsername.setText("");
				ePassword.setText("");
				dateOfBirth.setText("");
				ePhoneNumber.setText("");
				eAddress.setText("");
				eEmail.setText("");
				ecNumber.setText("");
				ecName.setText("");
				buttonGroup.clearSelection();
			}
		});
		btnNewButton.setBounds(131, 470, 115, 37);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除重填");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				eName.setText("");
				eUsername.setText("");
				ePassword.setText("");
				dateOfBirth.setText("");
				ePhoneNumber.setText("");
				eAddress.setText("");
				eEmail.setText("");
				ecNumber.setText("");
				ecName.setText("");
				buttonGroup.clearSelection();
				
			}
		});
		btnNewButton_1.setBounds(351, 470, 115, 37);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("回員工管理");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				employeesChangeUI.EmployeesManager();
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(560, 469, 134, 39);
		panel.add(btnNewButton_2_1);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(566, 30, 228, 30);
		panel.add(showDate);
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowActivated(WindowEvent e)
			{
				ClockRun cr=new ClockRun(showDate);
				new Thread(cr).start();
			}
		});
		
	}
}
