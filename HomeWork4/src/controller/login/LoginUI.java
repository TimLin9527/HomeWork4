package controller.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.wmsMemberDaoImpl;
import model.wmsmember;
import util.ChangeUI;
import util.ClockRun;
import util.commodityChangeUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.JButton;

import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	public static String USERNAME;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
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
		panel.setBackground(new Color(159, 207, 255));
		panel.setBounds(0, 0, 816, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(285, 280, 65, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(285, 335, 65, 28);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		username.setBounds(360, 280, 120, 30);
		panel.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		password.setBounds(360, 335, 120, 30);
		panel.add(password);
		
		JButton btnNewButton_1 = new JButton("登入");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				USERNAME=username.getText();
				String PASSWORD=password.getText();
				
				wmsmember wm=new wmsMemberDaoImpl().queryMember(USERNAME, PASSWORD);
				if(wm!=null && USERNAME.equals(wm.getMusername()) && PASSWORD.equals(wm.getMpassword())) 
				{
					if("admin".equals(USERNAME))
					{	
						JOptionPane.showMessageDialog(null, "管理員您好，登入成功");
						ChangeUI.MenuManage();
						dispose();
					}
					else if("abc".equals(USERNAME))
					{	
						JOptionPane.showMessageDialog(null, "職員您好，登入成功");
						ChangeUI.MenuManage();
						dispose();
					}
					else if("zxc".equals(USERNAME)) 
					{	
						JOptionPane.showMessageDialog(null, "客人您好，登入成功");
						commodityChangeUI.commodityManager();
						dispose();
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重新輸入");
				}
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(250, 420, 110, 42);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("忘記密碼");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				LoginRepasswordUI lru=new LoginRepasswordUI();
				lru.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(432, 420, 133, 42);
		panel.add(btnNewButton_1_1);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(578, 53, 228, 30);
		panel.add(showDate);
		
		JCheckBox showKey= new JCheckBox("顯示密碼");
		showKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showKey.isSelected()) 
				{
					password.setEchoChar((char)0);
				}
				else 
				{
					password.setEchoChar('\u2022');
				}
			}
		});
		showKey.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		showKey.setBounds(502, 336, 95, 28);
		panel.add(showKey);
		
		JLabel lblNewLabel_1_1 = new JLabel("簡易版WMS倉儲系統");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_1_1.setBounds(224, 46, 353, 45);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("主管→帳號：");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(274, 137, 110, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("admin");
		lblNewLabel_2_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(380, 137, 65, 30);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("密碼：");
		lblNewLabel_2_3_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_3_1.setBounds(455, 137, 65, 30);
		panel.add(lblNewLabel_2_3_1);
		
		JLabel adminPassword = new JLabel("admin");
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowActivated(WindowEvent e)
			{
				wmsmember wm=new wmsMemberDaoImpl().queryMusername2("admin");
				adminPassword.setText(wm.getMpassword());
			}
		});
		adminPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		adminPassword.setBounds(515, 137, 65, 30);
		panel.add(adminPassword);
		
		JLabel lblNewLabel_2_1 = new JLabel("職員→帳號：");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(274, 177, 110, 30);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_3_3 = new JLabel("abc");
		lblNewLabel_2_3_3.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_3_3.setBounds(380, 177, 65, 30);
		panel.add(lblNewLabel_2_3_3);
		
		JLabel lblNewLabel_2_3_1_1 = new JLabel("密碼：");
		lblNewLabel_2_3_1_1.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_3_1_1.setBounds(455, 177, 65, 30);
		panel.add(lblNewLabel_2_3_1_1);
		
		JLabel emPassword = new JLabel("abc");
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowActivated(WindowEvent e)
			{
				wmsmember wm=new wmsMemberDaoImpl().queryMusername2("abc");
				emPassword.setText(wm.getMpassword());
			}
		});
		emPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		emPassword.setBounds(515, 177, 65, 30);
		panel.add(emPassword);
		
		JLabel lblNewLabel_2_2 = new JLabel("客戶→帳號：");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_2.setBounds(274, 217, 110, 30);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3_4 = new JLabel("zxc");
		lblNewLabel_2_3_4.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_3_4.setBounds(380, 217, 65, 30);
		panel.add(lblNewLabel_2_3_4);
		
		JLabel lblNewLabel_2_3_1_2 = new JLabel("密碼：");
		lblNewLabel_2_3_1_2.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblNewLabel_2_3_1_2.setBounds(455, 217, 65, 30);
		panel.add(lblNewLabel_2_3_1_2);
		
		JLabel clientPassword = new JLabel("zxc");
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowActivated(WindowEvent e)
			{
				wmsmember wm=new wmsMemberDaoImpl().queryMusername2("zxc");
				clientPassword.setText(wm.getMpassword());
			}
				
		});
		clientPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		clientPassword.setBounds(515, 217, 65, 30);
		panel.add(clientPassword);
		
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
