package controller.client;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.impl.wmsClientDaoImpl;
import model.wmsclient;
import util.ClockRun;
import util.calendarSelect;
import util.clientChangeUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class queryClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField GUInumber;
	private JTable table;
	private JTextField startDate;
	private JTextField endDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryClientUI frame = new queryClientUI();
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
	public queryClientUI() {
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
		panel.setBackground(new Color(168, 211, 255));
		panel.setBounds(0, 0, 816, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		btnNewButton_2_1.setBounds(486, 129, 126, 39);
		panel.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("指定統一編號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(49, 129, 135, 38);
		panel.add(lblNewLabel_1);
		
		GUInumber = new JTextField();
		GUInumber.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GUInumber.setColumns(10);
		GUInumber.setBounds(179, 128, 145, 40);
		panel.add(GUInumber);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				wmsclient wc=new wmsClientDaoImpl().queryGUInumber(GUInumber.getText());
								
				Object[][] rowData = {
			            {wc.getId(),
			            wc.getClientCreateTime(),
			            wc.getCompanyName(),
			            wc.getGUInumber(),
			            wc.getUsername(),
			            wc.getPassword(),
			            wc.getPhoneNumber(),
			            wc.getAddress(),
			            wc.getEmail()}
			    };
				String[] cloumnsName= 
					{"編號","創立時間","公司名稱","統一編號","帳號","密碼","手機號碼","公司地址","Email"};
				DefaultTableModel tableModel = new DefaultTableModel(rowData,cloumnsName);
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
				
				Component[] components = panel.getComponents();
				for (Component component : components) {
				    if (component instanceof JScrollPane) {
				        panel.remove(component);
				        break;  // 只移除第一個找到的 JScrollPane
				    }
				}
				
				panel.add(scrollPane);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(334, 131, 73, 34);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("全部客戶資料");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(58, 66, 126, 38);
		panel.add(lblNewLabel_1_1);
		
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
				
				Component[] components = panel.getComponents();
				for (Component component : components) {
				    if (component instanceof JScrollPane) {
				        panel.remove(component);
				        break;  // 只移除第一個找到的 JScrollPane
				    }
				}
				
				panel.add(scrollPane);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(188, 68, 126, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("查詢客戶資料");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel.setBounds(294, 10, 228, 40);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		
		startDate = new JTextField();
		startDate.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		startDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				calendarSelect cd = new calendarSelect(startDate);
				cd.showDialog();
			}
		});
		startDate.setColumns(10);
		startDate.setBounds(179, 206, 145, 40);
		panel.add(startDate);
		
		endDate = new JTextField();
		endDate.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		endDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				calendarSelect cd = new calendarSelect(endDate);
				cd.showDialog();
			}
		});
		endDate.setColumns(10);
		endDate.setBounds(382, 206, 145, 40);
		panel.add(endDate);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("日期查詢：");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(86, 207, 98, 38);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("到");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1_1_1.setBounds(328, 207, 44, 38);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JButton btnNewButton_2 = new JButton("查詢");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				String S=startDate.getText();
				String E=endDate.getText();
				List<wmsclient> l=new wmsClientDaoImpl().queryClientCreateTime(S, E);
				
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
				
				Component[] components = panel.getComponents();
				for (Component component : components) {
				    if (component instanceof JScrollPane) {
				        panel.remove(component);
				        break;  // 只移除第一個找到的 JScrollPane
				    }
				}
				
				panel.add(scrollPane);
				panel.revalidate();
				panel.repaint();
			}
		});
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2.setBounds(539, 209, 73, 34);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_21 = new JButton("輸出");
		btnNewButton_21.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				try {
					JOptionPane.showMessageDialog(null, "前往輸出");
					table.print();			
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_21.setBounds(661, 129, 100, 39);
		panel.add(btnNewButton_21);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(578, 15, 228, 30);
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
