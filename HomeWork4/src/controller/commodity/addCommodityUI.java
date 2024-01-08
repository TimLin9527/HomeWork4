package controller.commodity;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.wmsCommodityDaoImpl;
import model.wmscommodity;

import util.ClockRun;
import util.calendarSelect;
import util.commodityChangeUI;


import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class addCommodityUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itemcode;
	private JTextField itemname;
	private JTextField itemlocation;
	private JTextField itemamount;
	private JTextField itemcount;
	private JTextField itemEXP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCommodityUI frame = new addCommodityUI();
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
	public addCommodityUI() {
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
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(558, 47, 228, 30);
		panel.add(showDate);
		
		JLabel lblNewLabel = new JLabel("商品代碼：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(55, 140, 110, 40);
		panel.add(lblNewLabel);
		
		itemcode = new JTextField();
		itemcode.setColumns(10);
		itemcode.setBounds(163, 143, 180, 40);
		panel.add(itemcode);
		
		JButton btnNewButton = new JButton("確定新增");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				wmscommodity wm=new wmscommodity
						(itemcode.getText(),itemname.getText(),itemlocation.getText(),itemamount.getText(),
								itemcount.getText(),itemEXP.getText());
				new wmsCommodityDaoImpl().add(wm);
				JOptionPane.showMessageDialog(null, "新增成功");
				itemcode.setText("");
				itemname.setText("");
				itemlocation.setText("");
				itemamount.setText("");
				itemcount.setText("");
				itemEXP.setText("");
			}
		});
		btnNewButton.setBounds(120, 420, 110, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除重填");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				itemcode.setText("");
				itemname.setText("");
				itemlocation.setText("");
				itemamount.setText("");
				itemcount.setText("");
				itemEXP.setText("");
			}
		});
		btnNewButton_1.setBounds(352, 420, 110, 40);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2_1 = new JButton("回商品管理");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				commodityChangeUI.commodityManager();
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(588, 420, 116, 39);
		panel.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("商品名稱：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(55, 234, 110, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("商品儲位：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(55, 333, 110, 40);
		panel.add(lblNewLabel_1_1);
		
		itemname = new JTextField();
		itemname.setColumns(10);
		itemname.setBounds(163, 233, 180, 40);
		panel.add(itemname);
		
		itemlocation = new JTextField();
		itemlocation.setColumns(10);
		itemlocation.setBounds(161, 333, 180, 40);
		panel.add(itemlocation);
		
		JLabel lblNewLabel_2 = new JLabel("商品安全庫存量：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(383, 238, 160, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("商品數量：");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(407, 148, 136, 30);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("商品有效期限：");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_4.setBounds(398, 338, 149, 30);
		panel.add(lblNewLabel_4);
		
		itemamount = new JTextField();
		itemamount.setColumns(10);
		itemamount.setBounds(550, 233, 180, 40);
		panel.add(itemamount);
		
		itemcount = new JTextField();
		itemcount.setColumns(10);
		itemcount.setBounds(550, 143, 180, 40);
		panel.add(itemcount);
		
		itemEXP = new JTextField();
		itemEXP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				calendarSelect cs=new calendarSelect(itemEXP);
				cs.showDialog();
			}
		});
		itemEXP.setColumns(10);
		itemEXP.setBounds(550, 333, 180, 40);
		panel.add(itemEXP);
		
		JLabel lblNewLabel_2_1 = new JLabel("新增商品資料");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2_1.setBounds(277, 30, 260, 65);
		panel.add(lblNewLabel_2_1);
		
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
