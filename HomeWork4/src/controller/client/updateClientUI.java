package controller.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import dao.impl.wmsClientDaoImpl;
import model.wmsclient;

import util.ClockRun;
import util.clientChangeUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JTable;

public class updateClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField GUInumber;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateClientUI frame = new updateClientUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JTextField username;
	private JTextField companyName;
	private JTextField password;
	private JTextField email;
	private JTextField address;
	private JTextField phoneNumber;
	/**
	 * Create the frame.
	 */
	public updateClientUI() {
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
		
		JPanel pane1 = new JPanel();
		pane1.setBackground(new Color(179, 217, 255));
		pane1.setBounds(0, 0, 816, 563);
		contentPane.add(pane1);
		pane1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改客戶資料");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(284, 24, 249, 40);
		pane1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("指定統一編號：");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 126, 135, 38);
		pane1.add(lblNewLabel_1);
		
		GUInumber = new JTextField();
		GUInumber.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GUInumber.setBounds(160, 128, 145, 35);
		pane1.add(GUInumber);
		GUInumber.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		pane1.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
				
		JLabel lblNewLabel_1_1 = new JLabel("全部客戶資料");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(30, 81, 126, 38);
		pane1.add(lblNewLabel_1_1);
		
		
		JButton btnNewButton_1 = new JButton("查詢全部");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				List<wmsclient> l=new wmsClientDaoImpl().queryAll();
				
				// 建立表格模型
				DefaultTableModel tableModel = new DefaultTableModel();

				// 添加列名
				tableModel.addColumn("編號");
				tableModel.addColumn("創立時間");
				tableModel.addColumn("公司名稱");
				tableModel.addColumn("統一編號");
				tableModel.addColumn("帳號");
				tableModel.addColumn("密碼");
				tableModel.addColumn("手機號碼");
				tableModel.addColumn("公司地址");
				tableModel.addColumn("Email");

				// 添加資料行
				for (wmsclient wc : l) {
				    Object[] rowData = {
				            wc.getId(),
				            wc.getClientCreateTime(),
				            wc.getCompanyName(),
				            wc.getGUInumber(),
				            wc.getUsername(),
				            wc.getPassword(),
				            wc.getPhoneNumber(),
				            wc.getAddress(),
				            wc.getEmail()
				    };
				    tableModel.addRow(rowData);
				}
				
				table=new JTable(tableModel);
				table.setEnabled(false);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 100, 150, 100, 70, 80, 100, 200,200};
				
				int columnCount = Math.min(columnsWidths.length, table.getColumnCount());

				for (int i = 0; i < columnCount; i++) {
				    TableColumn column = table.getColumnModel().getColumn(i);
				    column.setPreferredWidth(columnsWidths[i]);
				}
				
				JScrollPane scrollPane=new JScrollPane(table);
				scrollPane.setBounds(10, 296, 796, 257);
				
				Component[] components = pane1.getComponents();
				for (Component component : components) {
				    if (component instanceof JScrollPane) {
				        pane1.remove(component);
				        break;  // 只移除第一個找到的 JScrollPane
				    }
				}
				
				pane1.add(scrollPane);
				pane1.revalidate();
				pane1.repaint();				
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(160, 83, 126, 34);
		pane1.add(btnNewButton_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("公司名稱：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_2.setBounds(65, 177, 100, 30);
		pane1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("帳號：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(512, 174, 88, 30);
		pane1.add(lblNewLabel_1_2);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		username.setColumns(10);
		username.setBounds(611, 172, 145, 35);
		pane1.add(username);
		
		companyName = new JTextField();
		companyName.setColumns(10);
		companyName.setBounds(160, 172, 230, 35);
		pane1.add(companyName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(512, 213, 88, 30);
		pane1.add(lblNewLabel_1_1_1);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		password.setColumns(10);
		password.setBounds(611, 211, 145, 35);
		pane1.add(password);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("電子郵件：");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_1_1_1.setBounds(65, 256, 100, 30);
		pane1.add(lblNewLabel_1_2_1_1_1);
		
		email = new JTextField();
		email.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		email.setColumns(10);
		email.setBounds(160, 251, 315, 35);
		pane1.add(email);
		
		address = new JTextField();
		address.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		address.setColumns(10);
		address.setBounds(160, 211, 315, 35);
		pane1.add(address);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("公司地址：");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_1_1.setBounds(65, 216, 100, 30);
		pane1.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("手機號碼：");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2_2.setBounds(505, 253, 101, 30);
		pane1.add(lblNewLabel_1_2_2);
		
		phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		phoneNumber.setColumns(10);
		phoneNumber.setBounds(611, 251, 145, 35);
		pane1.add(phoneNumber);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				wmsclient wc=new wmsClientDaoImpl().queryGUInumber(GUInumber.getText());
					wc.setCompanyName(companyName.getText());
					wc.setUsername(username.getText());
					wc.setPassword(password.getText());
					wc.setPhoneNumber(phoneNumber.getText());
					wc.setAddress(address.getText());
					wc.setEmail(email.getText());
				
					new wmsClientDaoImpl().update(wc);
					JOptionPane.showMessageDialog(null, "修改成功");
				
				companyName.setText("");
				username.setText("");
				password.setText("");
				phoneNumber.setText("");
				address.setText("");
				email.setText("");
				
				List<wmsclient> l=new wmsClientDaoImpl().queryAll();
				
				// 建立表格模型
				DefaultTableModel tableModel = new DefaultTableModel();

				// 添加列名
				tableModel.addColumn("編號");
				tableModel.addColumn("創立時間");
				tableModel.addColumn("公司名稱");
				tableModel.addColumn("統一編號");
				tableModel.addColumn("帳號");
				tableModel.addColumn("密碼");
				tableModel.addColumn("手機號碼");
				tableModel.addColumn("公司地址");
				tableModel.addColumn("Email");

				// 添加資料行
				for (wmsclient wc1 : l) {
				    Object[] rowData = {
				            wc1.getId(),
				            wc1.getClientCreateTime(),
				            wc1.getCompanyName(),
				            wc1.getGUInumber(),
				            wc1.getUsername(),
				            wc1.getPassword(),
				            wc1.getPhoneNumber(),
				            wc1.getAddress(),
				            wc1.getEmail()
				    };
				    tableModel.addRow(rowData);
				}
				
				JTable table=new JTable(tableModel);
				table.setEnabled(false);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 100, 150, 100, 70, 80, 100, 200,200};
				
				int columnCount = Math.min(columnsWidths.length, table.getColumnCount());

				for (int i = 0; i < columnCount; i++) {
				    TableColumn column = table.getColumnModel().getColumn(i);
				    column.setPreferredWidth(columnsWidths[i]);
				}
				
				JScrollPane scrollPane=new JScrollPane(table);
				scrollPane.setBounds(10, 296, 796, 257);
				
				Component[] components = pane1.getComponents();
				for (Component component : components) {
				    if (component instanceof JScrollPane) {
				        pane1.remove(component);
				        break;  // 只移除第一個找到的 JScrollPane
				    }
				}
				
				pane1.add(scrollPane);
				pane1.revalidate();
				pane1.repaint();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(316, 128, 73, 34);
		pane1.add(btnNewButton);
		
		JButton btnNewButton_2_1 = new JButton("回客戶管理");
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.clientManager();
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(611, 127, 118, 39);
		pane1.add(btnNewButton_2_1);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(543, 29, 228, 30);
		pane1.add(showDate);
		
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
