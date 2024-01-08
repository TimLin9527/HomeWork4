package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.wmsEmployeesDao;
import model.wmsemployees;

@SuppressWarnings("all")
public class wmsEmployeesDaoImpl implements wmsEmployeesDao{

	public static void main(String[] args)
	{
		//new wmsEmployeesDaoImpl().add(new wmsemployees("ccccc","女","2000-02-09","33399911","我孩是是地址","oooccc@qqwww111.com","llkkjj","9993000","sa","0000"));
		
		/*List<wmsemployees> l=new wmsEmployeesDaoImpl().queryAll();
		
		for(wmsemployees wey:l)
		{
			System.out.println("ID:"+wey.getId()+
					"\t姓名:"+wey.geteName()+"\t性別:"+wey.getGender()+
					"\t出生日期:"+wey.getDateOfBirth()+"\t手機號碼:"+wey.getePhoneNumber()+
					"\t住址:"+wey.geteAddress()+"\t電子郵件:"+wey.geteEmail()+"\t緊急聯絡人:"+wey.getEcName()+
					"\t聯絡人電話:"+wey.getEcNumber()+"\t帳號:"+wey.geteUsername()+"\t密碼"+wey.getePassword()+
					"\t創建時間:"+wey.getCreateDate());
		}*/
	}

	@Override
	public void add(wmsemployees wey) {
		Connection conn=DbConnection.getDb();
		String SQL="insert into wmsemployees"
				+ "(eName,gender,dateOfBirth,ePhoneNumber,eAddress,eEmail,ecName,ecNumber,"
				+ "eUsername,ePassword) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wey.geteName());
			ps.setString(2, wey.getGender());
			ps.setString(3, wey.getDateOfBirth());
			ps.setString(4, wey.getePhoneNumber());
			ps.setString(5, wey.geteAddress());
			ps.setString(6, wey.geteEmail());
			ps.setString(7, wey.getEcName());
			ps.setString(8, wey.getEcNumber());
			ps.setString(9, wey.geteUsername());
			ps.setString(10, wey.getePassword());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean queryUsername(String eUsername) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsemployees where eUsername=?";
		Boolean x=false;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1,eUsername);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) x=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public wmsemployees queryMember(String username, String password)
	{	/*
		 * 1.連線-->connection
		 * 2.SQL
		 * 3.PreparedStatement
		 * 4.ResultSet-->new member
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsemployees where eUsername=? and ePassword=?";
		wmsemployees wey=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wey.geteUsername());
			ps.setString(2, wey.getePassword());
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{	
				wey=new wmsemployees();
				wey.setId(rs.getInt("id"));
				wey.seteName(rs.getString("eName"));
				wey.setGender(rs.getString("gender"));
				wey.setDateOfBirth(rs.getString("dateOfBirth"));
				wey.setePhoneNumber(rs.getString("ePhoneNumber"));
				wey.seteAddress(rs.getString("eAddress"));
				wey.seteEmail(rs.getString("eEmail"));
				wey.setEcName(rs.getString("ecName"));
				wey.setEcNumber(rs.getString("ecNumber"));
				wey.seteUsername(rs.getString("eUsername"));
				wey.setePassword(rs.getString("ePassword"));
				wey.setCreateDate(rs.getDate("createAIdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wey;
	}
	
	@Override
	public List<wmsemployees> queryCreateTime(String startDate, String endDate) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsemployees where createAIdate>=? and createAIdate<?";
		List<wmsemployees> l=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				wmsemployees wey=new wmsemployees();
				wey.setId(rs.getInt("id"));
				wey.seteName(rs.getString("eName"));
				wey.setGender(rs.getString("gender"));
				wey.setDateOfBirth(rs.getString("dateOfBirth"));
				wey.setePhoneNumber(rs.getString("ePhoneNumber"));
				wey.seteAddress(rs.getString("eAddress"));
				wey.seteEmail(rs.getString("eEmail"));
				wey.setEcName(rs.getString("ecName"));
				wey.setEcNumber(rs.getString("ecNumber"));
				wey.seteUsername(rs.getString("eUsername"));
				wey.setePassword(rs.getString("ePassword"));
				wey.setCreateDate(rs.getDate("createAIdate"));
				l.add(wey);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<wmsemployees> queryAll() {
		Connection conn=DbConnection.getDb();
		List<wmsemployees> l=new ArrayList();
		String SQL="select * from wmsemployees";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) 
			{
				wmsemployees wey=new wmsemployees();
				wey.setId(rs.getInt("id"));
				wey.seteName(rs.getString("eName"));
				wey.setGender(rs.getString("gender"));
				wey.setDateOfBirth(rs.getString("dateOfBirth"));
				wey.setePhoneNumber(rs.getString("ePhoneNumber"));
				wey.seteAddress(rs.getString("eAddress"));
				wey.seteEmail(rs.getString("eEmail"));
				wey.setEcName(rs.getString("ecName"));
				wey.setEcNumber(rs.getString("ecNumber"));
				wey.seteUsername(rs.getString("eUsername"));
				wey.setePassword(rs.getString("ePassword"));
				wey.setCreateDate(rs.getDate("createAIdate"));
				l.add(wey);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public wmsemployees queryeUsername(String eUsername) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsemployees where eUsername=?";
		wmsemployees wey=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, eUsername);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{	
				wey=new wmsemployees();
				wey.setId(rs.getInt("id"));
				wey.seteName(rs.getString("eName"));
				wey.setGender(rs.getString("gender"));
				wey.setDateOfBirth(rs.getString("dateOfBirth"));
				wey.setePhoneNumber(rs.getString("ePhoneNumber"));
				wey.seteAddress(rs.getString("eAddress"));
				wey.seteEmail(rs.getString("eEmail"));
				wey.setEcName(rs.getString("ecName"));
				wey.setEcNumber(rs.getString("ecNumber"));
				wey.seteUsername(rs.getString("eUsername"));
				wey.setePassword(rs.getString("ePassword"));
				wey.setCreateDate(rs.getDate("createAIdate"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wey;
	}

	@Override
	public void update(wmsemployees wey) {
		Connection conn=DbConnection.getDb();
		String SQL="update wmsemployees set eName=?,ePhoneNumber=?,eAddress=?,eEmail=?,"
				+ "ecName=?,ecNumber=?,ePassword=? where eUsername=?";
				
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wey.geteName());
			ps.setString(2, wey.getePhoneNumber());
			ps.setString(3, wey.geteAddress());
			ps.setString(4, wey.geteEmail());
			ps.setString(5, wey.getEcName());
			ps.setString(6, wey.getEcNumber());
			ps.setString(7, wey.getePassword());
			ps.setString(8, wey.geteUsername());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String eUsername) {
		Connection conn=DbConnection.getDb();
		String SQL="delete from wmsemployees where eUsername=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, eUsername);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
