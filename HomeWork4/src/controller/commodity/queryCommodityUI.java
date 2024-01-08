package controller.commodity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
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

import model.wmscommodity;
import dao.impl.wmsCommodityDaoImpl;
import util.ClockRun;
import util.commodityChangeUI;
import util.calendarSelect;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class queryCommodityUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField startDate;
	private JTextField itemcode;
	private JTextField endDate;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryCommodityUI frame = new queryCommodityUI();
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
	public queryCommodityUI() {
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
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		panel.add(scrollPane);
				
		table=new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		JLabel showDate = new JLabel("date");
		showDate.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		showDate.setBounds(567, 30, 228, 30);
		panel.add(showDate);
		
		JLabel lblNewLabel_1 = new JLabel("指定商品代碼搜尋：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(55, 148, 166, 38);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("日期搜尋：");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(120, 218, 100, 38);
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
		startDate.setBounds(230, 220, 145, 35);
		panel.add(startDate);
		
		itemcode = new JTextField();
		itemcode.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		itemcode.setColumns(10);
		itemcode.setBounds(230, 155, 145, 35);
		panel.add(itemcode);
		
		JButton btnNewButton = new JButton("送出");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				wmscommodity wm=new wmsCommodityDaoImpl().queryItemCode2(itemcode.getText());
				
				Object[][] rowData= 
					{{wm.getId(), wm.getItemCode(), wm.getItemName(), wm.getItemLocation(), 
						wm.getItemAmount(), wm.getItemCount(), wm.getItemEXP(), wm.getCreateDate()}};
			
				String[] cloumsName=
					{"編號","商品代碼","商品名稱","商品儲位","商品庫存量","商品數量","商品有效期限","建立時間"};
				
				DefaultTableModel tableModel= new DefaultTableModel(rowData,cloumsName);
				
				 table=new JTable(tableModel);
				 table.setEnabled(false);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				 table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 150, 150, 100, 100, 70, 100, 100};
				
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
		btnNewButton.setBounds(444, 150, 73, 34);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("到");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(395, 218, 27, 38);
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
		endDate.setBounds(444, 220, 145, 35);
		panel.add(endDate);
		
		JButton btnNewButton_2 = new JButton("送出");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{	
				List<wmscommodity> l=new wmsCommodityDaoImpl().queryCreateDate(startDate.getText(),endDate.getText());
				DefaultTableModel tableModel= new DefaultTableModel();
				
				
				tableModel.addColumn("編號");
				tableModel.addColumn("商品代碼");
				tableModel.addColumn("商品名稱");
				tableModel.addColumn("商品儲位");
				tableModel.addColumn("商品安全庫存量");
				tableModel.addColumn("商品數量");
				tableModel.addColumn("商品有效期限");
				tableModel.addColumn("建立時間");
				
				for(wmscommodity wm:l)
				{
					Object[] rowDate=
					{
						wm.getId(), wm.getItemCode(), wm.getItemName(),	wm.getItemLocation(),
						wm.getItemAmount(),	wm.getItemCount(), wm.getItemEXP(), wm.getCreateDate()
					};
					tableModel.addRow(rowDate);
				}
				
				table=new JTable(tableModel);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 150, 150, 100, 100, 70, 100, 100};
				
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
		btnNewButton_2.setBounds(615, 220, 73, 34);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("查詢全部");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				List<wmscommodity> l=new wmsCommodityDaoImpl().queryAll();
				DefaultTableModel tableModel= new DefaultTableModel();
				
				tableModel.addColumn("編號");
				tableModel.addColumn("商品代碼");
				tableModel.addColumn("商品名稱");
				tableModel.addColumn("商品儲位");
				tableModel.addColumn("商品安全庫存量");
				tableModel.addColumn("商品數量");
				tableModel.addColumn("商品有效期限");
				tableModel.addColumn("建立時間");
				
				for(wmscommodity wm:l)
				{
					Object[] rowDate=
					{
						wm.getId(), wm.getItemCode(), wm.getItemName(),	wm.getItemLocation(),
						wm.getItemAmount(),	wm.getItemCount(), wm.getItemEXP(), wm.getCreateDate()
					};
					tableModel.addRow(rowDate);
				}
				
				table=new JTable(tableModel);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
				
				int[] columnsWidths = 
					{30, 150, 150, 100, 100, 70, 100, 100};
				
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
		btnNewButton_1.setBounds(230, 95, 126, 34);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("回商品管理");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				commodityChangeUI.commodityManager();
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1_1.setBounds(519, 95, 126, 34);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("查詢商品資料");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_1_1_1_1.setBounds(262, 10, 292, 70);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("全部商品資料");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(95, 93, 126, 38);
		panel.add(lblNewLabel_1_1_2);
		
		JButton btnNewButton_21 = new JButton("輸出");
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
		btnNewButton_21.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_21.setBounds(671, 95, 100, 34);
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
