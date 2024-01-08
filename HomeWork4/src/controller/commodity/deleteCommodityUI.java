package controller.commodity;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.impl.wmsCommodityDaoImpl;
import model.wmscommodity;
import util.ClockRun;
import util.commodityChangeUI;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class deleteCommodityUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField itemcode;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteCommodityUI frame = new deleteCommodityUI();
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
	public deleteCommodityUI() {
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
		showDate.setBounds(578, 152, 228, 30);
		panel.add(showDate);
		
		JLabel lblNewLabel_1_1 = new JLabel("全部商品資料");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(38, 88, 126, 38);
		panel.add(lblNewLabel_1_1);
		
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
				
				JTable table=new JTable(tableModel);
				table.setEnabled(false);
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
		btnNewButton_1.setBounds(193, 90, 126, 34);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("指定商品代碼：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(38, 148, 136, 38);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBounds(10, 296, 796, 257);
		panel.add(scrollPane);
				
		table=new JTable();
		table.setEnabled(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		scrollPane.setViewportView(table);
		
		itemcode = new JTextField();
		itemcode.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		itemcode.setColumns(10);
		itemcode.setBounds(184, 149, 145, 40);
		panel.add(itemcode);
		
		JButton btnNewButton = new JButton("刪除");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				new wmsCommodityDaoImpl().delete(itemcode.getText());
				
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
				
				JTable table=new JTable(tableModel);
				table.setEnabled(false);
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
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setBounds(345, 147, 126, 43);
		panel.add(btnNewButton);
		
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
		btnNewButton_1_1.setBounds(623, 84, 134, 39);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("刪除商品資料");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 35));
		lblNewLabel_1_1_1.setBounds(252, 10, 292, 70);
		panel.add(lblNewLabel_1_1_1);
		
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
