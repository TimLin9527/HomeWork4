package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import controller.login.LoginUI;
import util.ChangeUI;
import util.ClockRun;
import util.clientChangeUI;
import util.commodityChangeUI;
import util.employeesChangeUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuManage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuManage frame = new MenuManage();
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
	public MenuManage() {
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
		panel.setBounds(0, 0, 814, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("選單管理");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(305, 21, 200, 69);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("員工管理");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{					
					employeesChangeUI.EmployeesManager();
					dispose();	
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(92, 229, 125, 45);
		panel.add(btnNewButton);
		
		if(LoginUI.USERNAME.equals("abc")) btnNewButton.setEnabled(false);

		
		JButton btnNewButton_1 = new JButton("客戶管理");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				clientChangeUI.clientManager();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(343, 229, 125, 45);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("商品管理");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				commodityChangeUI.commodityManager();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(586, 229, 125, 45);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("回登入頁");
		btnNewButton_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ChangeUI.LoginUI();
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_2.setBounds(343, 404, 125, 45);
		panel.add(btnNewButton_1_2);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(515, 40, 228, 30);
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


