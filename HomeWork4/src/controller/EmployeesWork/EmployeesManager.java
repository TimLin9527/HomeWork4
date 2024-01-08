package controller.EmployeesWork;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import util.ChangeUI;
import util.ClockRun;
import util.employeesChangeUI;

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

public class EmployeesManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeesManager frame = new EmployeesManager();
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
	public EmployeesManager() {
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
		
		JLabel lblNewLabel = new JLabel("員工管理");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel.setBounds(322, 60, 173, 40);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("新增員工資料");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				employeesChangeUI.addEmployeesUI();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(135, 185, 148, 34);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改員工資料");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employeesChangeUI.updateEmployeesUI();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(334, 185, 148, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("查詢員工資料");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employeesChangeUI.queryEmployeesUI();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(530, 185, 148, 34);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("刪除員工資料");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employeesChangeUI.deleteEmployeesUI();
				dispose();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1_1.setBounds(135, 265, 148, 34);
		panel.add(btnNewButton_1_1_1);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(560, 65, 228, 30);
		panel.add(showDate);
		
		JButton btnNewButton_1_1_1_1 = new JButton("回選單管理");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangeUI.MenuManage();
				dispose();
			}
		});
		btnNewButton_1_1_1_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1_1_1.setBounds(334, 265, 148, 34);
		panel.add(btnNewButton_1_1_1_1);
		
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
