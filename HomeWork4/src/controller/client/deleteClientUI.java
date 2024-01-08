package controller.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.impl.wmsClientDaoImpl;
import model.wmsclient;
import util.ClockRun;
import util.clientChangeUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class deleteClientUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable showtable;
	private JTextField GUInumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteClientUI frame = new deleteClientUI();
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
	public deleteClientUI() {
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
		panel.setBackground(new Color(179, 217, 255));
		panel.setBounds(0, 0, 816, 563);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("刪除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				new wmsClientDaoImpl().delete(GUInumber.getText());
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
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.setBounds(359, 169, 126, 40);
		panel.add(btnNewButton);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(578, 27, 228, 30);
		panel.add(showDate);
		
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
		btnNewButton_1.setBounds(193, 103, 126, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("全部客戶資料");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(57, 101, 130, 40);
		panel.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		panel.add(scrollPane);
		
		showtable = new JTable();
		showtable.setRowSelectionAllowed(false);
		showtable.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(showtable);
		
		JLabel lblNewLabel_1 = new JLabel("指定統一編號：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(63, 169, 135, 40);
		panel.add(lblNewLabel_1);
		
		GUInumber = new JTextField();
		GUInumber.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		GUInumber.setColumns(10);
		GUInumber.setBounds(193, 169, 145, 40);
		panel.add(GUInumber);
		
		JLabel lblNewLabel_2 = new JLabel("刪除客戶資料");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_2.setBounds(300, 10, 260, 65);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton_2_1_1 = new JButton("回客戶管理");
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				clientChangeUI.clientManager();
				dispose();
			}
		});
		btnNewButton_2_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_2_1_1.setBounds(606, 170, 135, 40);
		panel.add(btnNewButton_2_1_1);
		
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
