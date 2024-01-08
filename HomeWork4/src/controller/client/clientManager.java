package controller.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ChangeUI;
import util.ClockRun;
import util.clientChangeUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientManager frame = new clientManager();
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
	public clientManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
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
		panel.setBounds(0, 0, 786, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("客戶管理");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel.setBounds(267, 56, 250, 65);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("新增客戶資料");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.addClientUI();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton.setBounds(95, 197, 135, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改客戶資料");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.updateClientUI();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1.setBounds(325, 197, 135, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("查詢客戶資料");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.queryClientUI();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(555, 197, 135, 40);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("刪除客戶資料");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.deleteClientUI();
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_1_1_1.setBounds(95, 291, 135, 40);
		panel.add(btnNewButton_1_1_1);
		
				
		JButton btnNewButton_2_1 = new JButton("回選單管理");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangeUI.MenuManage();
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(new Color(255, 0, 0));
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		btnNewButton_2_1.setBounds(325, 291, 135, 40);
		panel.add(btnNewButton_2_1);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(542, 73, 228, 30);
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
