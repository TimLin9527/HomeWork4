package controller.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.wmsMemberDaoImpl;
import model.wmsmember;
import util.ChangeUI;
import util.ClockRun;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class LoginRepasswordUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Musername;
	private JTextField Mpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginRepasswordUI frame = new LoginRepasswordUI();
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
	public LoginRepasswordUI() {
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
		
		JLabel lblNewLabel = new JLabel("帳號確認");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(244, 156, 110, 45);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("確認修改");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				wmsmember wm=new wmsMemberDaoImpl().queryMusername2(Musername.getText());
				
				wm.setMpassword(Mpassword.getText());
				new wmsMemberDaoImpl().update(wm);
				
				JOptionPane.showMessageDialog(null, "修改成功");
				
				Musername.setText("");
				Mpassword.setText("");
			}
		});
		btnNewButton.setBounds(254, 309, 110, 34);
		panel.add(btnNewButton);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(520, 59, 228, 30);
		panel.add(showDate);
		
		Musername = new JTextField();
		Musername.setToolTipText("請輸入修改帳號");
		Musername.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Musername.setBounds(364, 161, 150, 35);
		panel.add(Musername);
		Musername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("忘記密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_1.setBounds(333, 52, 150, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("輸入修改密碼");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(210, 223, 144, 45);
		panel.add(lblNewLabel_2);
		
		Mpassword = new JTextField();
		Mpassword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Mpassword.setColumns(10);
		Mpassword.setBounds(364, 228, 150, 35);
		panel.add(Mpassword);
		
		JButton btnNewButton_1 = new JButton("回登入頁");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangeUI.LoginUI();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.setBounds(429, 309, 110, 34);
		panel.add(btnNewButton_1);
		
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
