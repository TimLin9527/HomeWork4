package controller.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.wmsClientDaoImpl;
import model.wmsclient;
import util.ClockRun;
import util.clientChangeUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class addClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField companyName;
	private JTextField username;
	private JTextField password;
	private JTextField GUInumber;
	private JTextField phoneNumber;
	private JTextField address;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addClientUI frame = new addClientUI();
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
	public addClientUI() {
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
		
		JLabel lblNewLabel = new JLabel("公司名稱：");
		lblNewLabel.setBounds(42, 114, 124, 30);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號：");
		lblNewLabel_1.setBounds(45, 181, 114, 30);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(45, 250, 114, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("手機號碼：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2.setBounds(440, 177, 117, 38);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("統一編號：");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2_1.setBounds(436, 114, 124, 30);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("公司地址：");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2_1_1.setBounds(46, 319, 117, 30);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("電子郵件：");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 22));
		lblNewLabel_1_2_1_1_1.setBounds(46, 388, 118, 30);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		companyName = new JTextField();
		companyName.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		companyName.setBounds(159, 109, 230, 40);
		panel.add(companyName);
		companyName.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		username.setColumns(10);
		username.setBounds(159, 176, 160, 40);
		panel.add(username);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		password.setColumns(10);
		password.setBounds(159, 245, 160, 40);
		panel.add(password);
		
		GUInumber = new JTextField();
		GUInumber.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GUInumber.setColumns(10);
		GUInumber.setBounds(551, 109, 160, 40);
		panel.add(GUInumber);
		
		phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(551, 176, 160, 40);
		panel.add(phoneNumber);
		
		address = new JTextField();
		address.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		address.setColumns(10);
		address.setBounds(159, 314, 315, 40);
		panel.add(address);
		
		email = new JTextField();
		email.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		email.setColumns(10);
		email.setBounds(159, 383, 315, 40);
		panel.add(email);
		
		JButton btnNewButton = new JButton("確定新增");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				String USERNAME=username.getText();
				String GUINUMBER=GUInumber.getText();
				if(new wmsClientDaoImpl().queryUsername(USERNAME, GUINUMBER)) 
				{
					JOptionPane.showMessageDialog(null, "帳號或統一編號重複，請重新輸入");
				}
				
				else {
				wmsclient wc=new wmsclient(companyName.getText(),
											username.getText(),
											password.getText(),
											phoneNumber.getText(),
											GUInumber.getText(),
											address.getText(),
											email.getText());
				new wmsClientDaoImpl().addClient(wc);
				JOptionPane.showMessageDialog(null, "新增成功");
				companyName.setText("");
				username.setText("");
				password.setText("");
				phoneNumber.setText("");
				GUInumber.setText("");
				address.setText("");
				email.setText("");
				}
			}
		});
		btnNewButton.setBounds(135, 459, 125, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除重填");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				companyName.setText("");
				username.setText("");
				password.setText("");
				phoneNumber.setText("");
				GUInumber.setText("");
				address.setText("");
				email.setText("");
			}
		});
		btnNewButton_1.setBounds(358, 459, 125, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("回客戶管理");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.clientManager();
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(591, 459, 133, 40);
		panel.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("新增客戶資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2.setBounds(290, 25, 260, 65);
		panel.add(lblNewLabel_2);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(578, 42, 228, 30);
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
