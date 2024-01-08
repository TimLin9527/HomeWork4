package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.wmsClientDao;
import model.wmsclient;
@SuppressWarnings("all")
public class wmsClientDaoImpl implements wmsClientDao{

	public static void main(String[] args)
	{
		//new wmsClientDaoImpl().addClient(new wmsclient("紫霞仙子有限公司","def","1234","0996677","55555555","台北南港","bbb@bbb.com"));
		//System.out.println(new wmsClientDaoImpl().queryMember("sss", "1234").getName());
		/*wmsclient wc=new wmsClientDaoImpl().queryGUInumber("88885555");
			System.out.println("id:"+wc.getId()+
								"\t公司名:"+wc.getCompanyName()+
								"\t統一編號："+wc.getGUInumber()+
								"\t帳號:"+wc.getUsername()+
								"\t密碼:"+wc.getPassword()+
								"\t手機:"+wc.getPhoneNumber()+
								"\t地址："+wc.getAddress()+
								"\tEmail"+wc.getEmail());*/
		
			List<wmsclient> l=new wmsClientDaoImpl().queryAll();
			for(wmsclient wc:l) 
			{
				System.out.println("編號："+wc.getId()+
						"\t創立時間:"+wc.getClientCreateTime()+
						"\t公司名稱:"+wc.getCompanyName()+
						"\t統一編號："+wc.getGUInumber()+
						"\t帳號:"+wc.getUsername()+
						"\t密碼:"+wc.getPassword()+
						"\t手機號碼:"+wc.getPhoneNumber()+
						"\t公司地址："+wc.getAddress()+
						"\tEmail"+wc.getEmail());
			}
			
			/*List<wmsclient> l=new wmsClientDaoImpl().queryClientCreateTime("2023-12-24", "2023-12-28");
			for(wmsclient wc:l)
			{
				System.out.println("編號："+wc.getId()+
						"\t創立時間:"+wc.getClientCreateTime()+
						"\t公司名稱:"+wc.getCompanyName()+
						"\t統一編號："+wc.getGUInumber()+
						"\t帳號:"+wc.getUsername()+
						"\t密碼:"+wc.getPassword()+
						"\t手機號碼:"+wc.getPhoneNumber()+
						"\t公司地址："+wc.getAddress()+
						"\tEmail"+wc.getEmail());
			}*/
	}

	@Override  //新增客戶資料
	public void addClient(wmsclient wc) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into wmsclient(companyName,username,password,phoneNumber,GUInumber,address,email) "
				+ "values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,wc.getCompanyName());
			ps.setString(2,wc.getUsername());
			ps.setString(3,wc.getPassword());
			ps.setString(4,wc.getPhoneNumber());
			ps.setString(5,wc.getGUInumber());
			ps.setString(6,wc.getAddress());
			ps.setString(7,wc.getEmail());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override  //驗證帳號與統一編號是否重複申請
	public boolean queryUsername(String username,String GUInumber) 
	{	Connection conn=DbConnection.getDb();
		String SQL="select * from wmsclient where username=? or GUInumber=?";
		Boolean x=false;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2,GUInumber);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) x=true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}

	@Override  //登入驗證
	public wmsclient queryMember(String username, String password)
	{	/*
		 * 1.連線-->connection
		 * 2.SQL
		 * 3.PreparedStatement
		 * 4.ResultSet-->new member
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsclient where username=? and password=?";
		wmsclient ws=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ws=new wmsclient();
				ws.setId(rs.getInt("id"));
				ws.setCompanyName(rs.getString("companyName"));
				ws.setUsername(rs.getString("username"));
				ws.setPassword(rs.getString("password"));
				ws.setPhoneNumber(rs.getString("phoneNumber"));
				ws.setGUInumber(rs.getString("GUInumber"));
				ws.setAddress(rs.getString("address"));
				ws.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ws;
	}

	@Override //修改客戶資料
	public void update(wmsclient wc) {
		Connection conn=DbConnection.getDb();
		String SQL="update wmsclient set "
				+ "companyName=?,username=?,password=?,phoneNumber=?,address=?,email=? where GUInumber=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wc.getCompanyName());
			ps.setString(2, wc.getUsername());
			ps.setString(3, wc.getPhoneNumber());
			ps.setString(4, wc.getPassword());
			ps.setString(5, wc.getAddress());
			ps.setString(6, wc.getEmail());
			ps.setString(7, wc.getGUInumber());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override  //調出所以資料
	public List<wmsclient> queryAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsclient";
		List<wmsclient> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				wmsclient wc=new wmsclient();
				wc.setId(rs.getInt("id"));
				wc.setClientCreateTime(rs.getDate("clientCreateTime"));
				wc.setCompanyName(rs.getString("companyName"));
				wc.setGUInumber(rs.getString("GUInumber"));
				wc.setUsername(rs.getString("username"));
				wc.setPassword(rs.getString("password"));
				wc.setPhoneNumber(rs.getString("phoneNumber"));
				wc.setAddress(rs.getString("address"));
				wc.setEmail(rs.getString("email"));
				
				l.add(wc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override //調出指定統一編號的資料
	public wmsclient queryGUInumber(String GUInumber) 
	{   Connection conn=DbConnection.getDb();
		String SQL="select * from wmsclient where GUInumber=?";
		wmsclient wc=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, GUInumber);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{	
				wc=new wmsclient();
				wc.setId(rs.getInt("id"));
				wc.setClientCreateTime(rs.getDate("clientCreateTime"));
				wc.setCompanyName(rs.getString("companyName"));
				wc.setGUInumber(rs.getString("GUInumber"));
				wc.setUsername(rs.getString("username"));
				wc.setPassword(rs.getString("password"));
				wc.setPhoneNumber(rs.getString("phoneNumber"));
				wc.setAddress(rs.getString("address"));
				wc.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wc;
	}

	@Override   //刪除指定統一編號的資料
	public void delete(String GUInumber) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from wmsclient where GUInumber=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,GUInumber);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<wmsclient> queryClientCreateTime(String startDate, String endDate) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsclient where clientCreateTime=>? and clientCreateTime<?";
		
		List<wmsclient> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				wmsclient wc=new wmsclient();
				wc.setId(rs.getInt("id"));
				wc.setClientCreateTime(rs.getDate("clientCreateTime"));
				wc.setCompanyName(rs.getString("companyName"));
				wc.setGUInumber(rs.getString("GUInumber"));
				wc.setUsername(rs.getString("username"));
				wc.setPassword(rs.getString("password"));
				wc.setPhoneNumber(rs.getString("phoneNumber"));
				wc.setAddress(rs.getString("address"));
				wc.setEmail(rs.getString("email"));
				
				l.add(wc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;
	}
}
