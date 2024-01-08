package controller.EmployeesWork;

import java.awt.Dimension;
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

import dao.impl.wmsEmployeesDaoImpl;
import model.wmsemployees;
import util.ClockRun;
import util.calendarSelect;
import util.employeesChangeUI;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class queryEmployeesUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField eUsername;
	private JTextField startDate;
	private JTextField endDate;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryEmployeesUI frame = new queryEmployeesUI();
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
	public queryEmployeesUI() {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		panel.add(scrollPane);
	
		table = new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
				
		JButton btnNewButton_1 = new JButton("查詢全部");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{	
				DefaultTableModel tableModel= new DefaultTableModel();
				List<wmsemployees> l=new wmsEmployeesDaoImpl().queryAll();
											
				tableModel.addColumn("編號");
				tableModel.addColumn("創立時間");
				tableModel.addColumn("姓名");
				tableModel.addColumn("性別");
				tableModel.addColumn("帳號");
				tableModel.addColumn("密碼");
				tableModel.addColumn("出生日期");
				tableModel.addColumn("手機號碼");
				tableModel.addColumn("公司地址");
				tableModel.addColumn("Email");
				tableModel.addColumn("緊急聯絡人");
				tableModel.addColumn("聯絡人電話");
													 
					for(wmsemployees wey:l)
					{
					Object[]rowData = 
						{wey.getId(),wey.getCreateDate(),wey.geteName(),wey.getGender(),
						  wey.geteUsername(),wey.getePassword(),wey.getDateOfBirth(),wey.getePhoneNumber(),
						  wey.geteAddress(),wey.geteEmail(),wey.getEcName(),wey.getEcNumber()
						};
					    tableModel.addRow(rowData);
					}
				 
				 table=new JTable(tableModel);
				 table.setEnabled(false);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				 table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{25, 100, 70, 25, 70, 70, 100, 100, 200, 200, 100, 100};
				
				int columnCount = Math.min(columnsWidths.length, table.getColumnCount());

				for (int i = 0; i < columnCount; i++) {
				    TableColumn column = table.getColumnModel().getColumn(i);
				    column.setPreferredWidth(columnsWidths[i]);
				}
				 
				    JScrollPane scrollPane = new JScrollPane(table);
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
		btnNewButton_1.setBounds(188, 89, 126, 34);
		panel.add(btnNewButton_1);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(552, 30, 228, 30);
		panel.add(showDate);
		
		eUsername = new JTextField();
		eUsername.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		eUsername.setColumns(10);
		eUsername.setBounds(188, 140, 145, 40);
		panel.add(eUsername);
		
		JLabel lblNewLabel_1 = new JLabel("指定帳號搜尋：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(38, 141, 150, 38);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				wmsemployees wey=new wmsEmployeesDaoImpl().queryeUsername(eUsername.getText());
								
				Object[][]rowData = 
					{{wey.getId(),wey.getCreateDate(),wey.geteName(),wey.getGender(),
					  wey.geteUsername(),wey.getePassword(),wey.getDateOfBirth(),wey.getePhoneNumber(),
					  wey.geteAddress(),wey.geteEmail(),wey.getEcName(),wey.getEcNumber()
					}};
				String[] ColumnName= 
					{"編號","創立時間","員工姓名","性別","帳號","密碼","出生日期","手機號碼","居住地址","Email",
						"緊急聯絡人","聯絡人電話"};
				
				 DefaultTableModel tableModel = new DefaultTableModel(rowData,ColumnName);
				 table=new JTable(tableModel);
				 table.setEnabled(true);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				 table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{25, 100, 70, 25, 70, 70, 100, 100, 200, 200, 100, 100};
				
				for (int i = 0; i < columnsWidths.length; i++) {
	                TableColumn column = table.getColumnModel().getColumn(i);
	                column.setPreferredWidth(columnsWidths[i]);
	            }
				 
				    JScrollPane scrollPane = new JScrollPane(table);
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
		btnNewButton.setBounds(381, 141, 73, 34);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1 = new JLabel("日期搜尋：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(86, 193, 100, 40);
		panel.add(lblNewLabel_1_1);
		
		startDate = new JTextField();
		startDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				calendarSelect cs=new calendarSelect(startDate);
				cs.showDialog();
			}
		});
		startDate.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		startDate.setColumns(10);
		startDate.setBounds(188, 196, 145, 40);
		panel.add(startDate);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("到");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(344, 197, 27, 38);
		panel.add(lblNewLabel_1_1_1);
		
		endDate = new JTextField();
		endDate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				calendarSelect cs=new calendarSelect(endDate);
				cs.showDialog();
			}
		});
		endDate.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		endDate.setColumns(10);
		endDate.setBounds(381, 196, 145, 40);
		panel.add(endDate);
		
		JButton btnNewButton_2 = new JButton("送出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				List<wmsemployees> l=new wmsEmployeesDaoImpl().queryCreateTime
												(startDate.getText(), endDate.getText());
				
				// 建立表格模型
				DefaultTableModel tableModel = new DefaultTableModel();
				tableModel.addColumn("編號");
				tableModel.addColumn("創立時間");
				tableModel.addColumn("姓名");
				tableModel.addColumn("性別");
				tableModel.addColumn("帳號");
				tableModel.addColumn("密碼");
				tableModel.addColumn("出生日期");
				tableModel.addColumn("手機號碼");
				tableModel.addColumn("公司地址");
				tableModel.addColumn("Email");
				tableModel.addColumn("緊急聯絡人");
				tableModel.addColumn("聯絡人電話");
													 
					for(wmsemployees wey:l)
					{
					Object[]rowData = 
						{wey.getId(),wey.getCreateDate(),wey.geteName(),wey.getGender(),
						  wey.geteUsername(),wey.getePassword(),wey.getDateOfBirth(),wey.getePhoneNumber(),
						  wey.geteAddress(),wey.geteEmail(),wey.getEcName(),wey.getEcNumber()
						};
					    tableModel.addRow(rowData);
					}
				 
				 table=new JTable(tableModel);
				 table.setEnabled(true);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				 table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{25, 100, 70, 25, 70, 70, 100, 100, 200, 200, 100, 100};
				
				int columnCount = Math.min(columnsWidths.length, table.getColumnCount());

				for (int i = 0; i < columnCount; i++) {
				    TableColumn column = table.getColumnModel().getColumn(i);
				    column.setPreferredWidth(columnsWidths[i]);
				}
				 
				    JScrollPane scrollPane = new JScrollPane(table);
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
		btnNewButton_2.setBounds(540, 199, 73, 34);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("回員工管理");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				employeesChangeUI.EmployeesManager();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(540, 141, 126, 34);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("查詢員工資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2.setBounds(283, 25, 251, 40);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("指定帳號搜尋：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(38, 87, 150, 38);
		panel.add(lblNewLabel_1_2);
		
		JButton btnNewButton_21 = new JButton("輸出");
		btnNewButton_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JOptionPane.showMessageDialog(null, "前往輸出");
					table.print();			
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_21.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_21.setBounds(686, 140, 100, 34);
		panel.add(btnNewButton_21);
		
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
