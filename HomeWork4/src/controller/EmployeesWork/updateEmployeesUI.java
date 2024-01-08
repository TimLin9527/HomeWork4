package controller.EmployeesWork;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

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
import dao.impl.wmsEmployeesDaoImpl;
import model.wmsclient;
import model.wmsemployees;
import util.ClockRun;
import util.employeesChangeUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
@SuppressWarnings("all")
public class updateEmployeesUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField eUsername;
	private JTextField eName;
	private JTextField ecName;
	private JTextField ePassword;
	private JTextField ePhoneNumber;
	private JTextField eAddress;
	private JTextField eEmail;
	private JTable showtable;
	private JTextField ecNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateEmployeesUI frame = new updateEmployeesUI();
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
	public updateEmployeesUI() {
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
		showDate.setBounds(552, 32, 228, 30);
		panel.add(showDate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		panel.add(scrollPane);
				
		showtable = new JTable();
		showtable.setAutoCreateRowSorter(true);
		showtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		showtable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		showtable.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(showtable);
		
		JLabel lblNewLabel_1 = new JLabel("指定帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 121, 110, 38);
		panel.add(lblNewLabel_1);
		
		eUsername = new JTextField();
		eUsername.setColumns(10);
		eUsername.setBounds(121, 127, 134, 30);
		panel.add(eUsername);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				wmsemployees wey=new wmsEmployeesDaoImpl().queryeUsername(eUsername.getText());
				wey.seteName(eName.getText());
				wey.setePhoneNumber(ePhoneNumber.getText());
				wey.seteAddress(eAddress.getText());
				wey.seteEmail(eEmail.getText());
				wey.setEcName(ecName.getText());
				wey.setEcNumber(ecNumber.getText());
				wey.setePassword(ePassword.getText());
				new wmsEmployeesDaoImpl().update(wey);
				JOptionPane.showMessageDialog(null, "修改成功");
				
				eName.setText("");
				ePhoneNumber.setText("");
				eAddress.setText("");
				eEmail.setText("");
				ecName.setText("");
				ecNumber.setText("");
				ePassword.setText("");
				
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
													 
					for(wmsemployees wey1:l)
					{
					Object[]rowData = 
						{wey1.getId(),wey1.getCreateDate(),wey1.geteName(),wey1.getGender(),
						 wey1.geteUsername(),wey1.getePassword(),wey1.getDateOfBirth(),wey1.getePhoneNumber(),
						 wey1.geteAddress(),wey1.geteEmail(),wey1.getEcName(),wey1.getEcNumber()
						};
					    tableModel.addRow(rowData);
					}
				 
				 JTable table=new JTable(tableModel);
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
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(259, 125, 73, 34);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("員工姓名：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(32, 169, 88, 30);
		panel.add(lblNewLabel_2);
		
		eName = new JTextField();
		eName.setColumns(10);
		eName.setBounds(122, 169, 134, 30);
		panel.add(eName);
		
		ecName = new JTextField();
		ecName.setColumns(10);
		ecName.setBounds(485, 127, 134, 30);
		panel.add(ecName);
		
		JLabel lblNewLabel_1_2 = new JLabel("緊急聯絡人：");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(375, 127, 100, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("密碼：");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(36, 211, 81, 30);
		panel.add(lblNewLabel_1_1_1);
		
		ePassword = new JTextField();
		ePassword.setColumns(10);
		ePassword.setBounds(122, 216, 134, 30);
		panel.add(ePassword);
		
		ePhoneNumber = new JTextField();
		ePhoneNumber.setColumns(10);
		ePhoneNumber.setBounds(122, 256, 134, 30);
		panel.add(ePhoneNumber);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("手機號碼：");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBounds(35, 256, 88, 30);
		panel.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("居住地址：");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBounds(387, 216, 88, 30);
		panel.add(lblNewLabel_1_2_1_1);
		
		eAddress = new JTextField();
		eAddress.setColumns(10);
		eAddress.setBounds(485, 216, 295, 30);
		panel.add(eAddress);
		
		eEmail = new JTextField();
		eEmail.setColumns(10);
		eEmail.setBounds(485, 256, 295, 30);
		panel.add(eEmail);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("電子郵件：");
		lblNewLabel_1_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2_1_1_1.setBounds(387, 256, 88, 30);
		panel.add(lblNewLabel_1_2_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("客戶資料");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 79, 110, 38);
		panel.add(lblNewLabel_1_1);
		
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
				 
				 JTable table=new JTable(tableModel);
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
		btnNewButton_1.setBounds(121, 81, 126, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("聯絡人電話：");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(375, 169, 100, 30);
		panel.add(lblNewLabel_1_2_1);
		
		ecNumber = new JTextField();
		ecNumber.setColumns(10);
		ecNumber.setBounds(485, 169, 134, 30);
		panel.add(ecNumber);
		
		JLabel lblNewLabel_2_1 = new JLabel("修改員工資料");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2_1.setBounds(283, 27, 251, 40);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1_1 = new JButton("回員工管理");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employeesChangeUI.EmployeesManager();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(485, 81, 126, 34);
		panel.add(btnNewButton_1_1);
		
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
