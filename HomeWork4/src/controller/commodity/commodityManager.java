package controller.commodity;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.login.LoginUI;
import util.ChangeUI;
import util.ClockRun;
import util.commodityChangeUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class commodityManager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					commodityManager frame = new commodityManager();
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
	public commodityManager() {
		setTitle("商品管理");
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
		
		JButton btnNewButton = new JButton("新增商品資料");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				commodityChangeUI.addCommodityUI();
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(118, 182, 155, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改商品資料");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				commodityChangeUI.updateCommodityUI();
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(333, 182, 155, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查詢商品資料");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				commodityChangeUI.queryCommodityUI();
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2.setBounds(554, 182, 155, 40);
		panel.add(btnNewButton_2);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(578, 51, 228, 30);
		panel.add(showDate);
		
		JButton btnNewButton_2_1 = new JButton("刪除商品資料");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				commodityChangeUI.deleteCommodityUI();
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2_1.setBounds(118, 270, 155, 40);
		panel.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("新增商品管理");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2_1.setBounds(280, 34, 260, 65);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("回選單管理");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ChangeUI.MenuManage();
				dispose();
			}
		});
		btnNewButton_2_1_1.setForeground(new Color(255, 0, 0));
		btnNewButton_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2_1_1.setBounds(333, 270, 155, 40);
		panel.add(btnNewButton_2_1_1);
		
		if(LoginUI.USERNAME.equals("zxc")) btnNewButton_2_1_1.setEnabled(false);
		
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
