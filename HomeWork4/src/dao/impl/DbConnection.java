package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//靜態class
public class DbConnection {
		//動態Class 測試方法可否執行
	public static void main(String[] args)
	{	/*DbConnection db=new DbConnection();
		System.out.println(db.name);*/
		System.out.println(DbConnection.getDb());
	}
	
	//建立一個Connection的methods來連線資料庫
	public static Connection getDb()
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/wms_product";
		String user="root";
		String password="952702";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONECTION");
			e.printStackTrace();
		}
		
		return conn;
	}
}
