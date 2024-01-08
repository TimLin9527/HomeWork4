package controller.EmployeesWork;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.impl.wmsEmployeesDaoImpl;
import model.wmsemployees;
import util.ClockRun;
import util.employeesChangeUI;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class deleteEmployeesUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField eUsername;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteEmployeesUI frame = new deleteEmployeesUI();
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
	public deleteEmployeesUI() {
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
		
		JLabel lblNewLabel_1_1 = new JLabel("全部客戶資料");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(109, 115, 126, 38);
		panel.add(lblNewLabel_1_1);
		
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
				List<wmsemployees> l=new wmsEmployeesDaoImpl().queryAll();
				
				// 建立表格模型
				DefaultTableModel tableModel = new DefaultTableModel();

				// 添加列名
				tableModel.addColumn("編號");
				tableModel.addColumn("姓名");
				tableModel.addColumn("性別");
				tableModel.addColumn("出生日期");
				tableModel.addColumn("手機號碼");
				tableModel.addColumn("緊急聯絡人");
				tableModel.addColumn("聯絡人電話");
				tableModel.addColumn("公司地址");
				tableModel.addColumn("Email");
				tableModel.addColumn("帳號");
				tableModel.addColumn("密碼");
				tableModel.addColumn("創立時間");
				
				for(wmsemployees wey:l) 
				{
					Object[] rowData = 
					{
						wey.getId(), wey.geteName(), wey.getGender(), wey.getDateOfBirth(),
						wey.getePhoneNumber(), wey.getEcName(), wey.getEcNumber(), wey.geteAddress(),
						wey.geteEmail(), wey.geteUsername(), wey.getePassword(), wey.getCreateDate()
			        };
					tableModel.addRow(rowData);
				}
				table=new JTable(tableModel);
				table.setEnabled(false);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 80, 30, 100, 100, 70, 100, 180, 180, 100, 100 ,100};
				
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
		btnNewButton_1.setBounds(245, 114, 126, 40);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("指定帳號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(136, 180, 99, 38);
		panel.add(lblNewLabel_1);
		
		eUsername = new JTextField();
		eUsername.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		eUsername.setColumns(10);
		eUsername.setBounds(245, 181, 145, 40);
		panel.add(eUsername);
		
		JButton btnNewButton = new JButton("刪除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				new wmsEmployeesDaoImpl().delete(eUsername.getText());
				JOptionPane.showMessageDialog(null, "刪除成功");
				
				List<wmsemployees> l=new wmsEmployeesDaoImpl().queryAll();
				
				// 建立表格模型
				DefaultTableModel tableModel = new DefaultTableModel();

				// 添加列名
				tableModel.addColumn("編號");
				tableModel.addColumn("姓名");
				tableModel.addColumn("性別");
				tableModel.addColumn("出生日期");
				tableModel.addColumn("手機號碼");
				tableModel.addColumn("緊急聯絡人");
				tableModel.addColumn("聯絡人電話");
				tableModel.addColumn("公司地址");
				tableModel.addColumn("Email");
				tableModel.addColumn("帳號");
				tableModel.addColumn("密碼");
				tableModel.addColumn("創立時間");
				
				for(wmsemployees wey:l) 
				{
					Object[] rowData = 
					{
						wey.getId(), wey.geteName(), wey.getGender(), wey.getDateOfBirth(),
						wey.getePhoneNumber(), wey.getEcName(), wey.getEcNumber(), wey.geteAddress(),
						wey.geteEmail(), wey.geteUsername(), wey.getePassword(), wey.getCreateDate()
			        };
					tableModel.addRow(rowData);
				}
				table=new JTable(tableModel);
				table.setEnabled(false);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 70, 80, 100, 100, 70, 100, 150, 150, 70, 70 ,100};
				
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
		btnNewButton.setBounds(420, 179, 126, 40);
		panel.add(btnNewButton);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(558, 30, 228, 30);
		panel.add(showDate);
		
		JLabel lblNewLabel_2 = new JLabel("刪除員工資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2.setBounds(284, 25, 248, 40);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_2_1 = new JButton("回員工管理");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				employeesChangeUI.EmployeesManager();
				dispose();
			}
		});
		btnNewButton_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2_1.setBounds(580, 179, 132, 40);
		panel.add(btnNewButton_2_1);
		
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
