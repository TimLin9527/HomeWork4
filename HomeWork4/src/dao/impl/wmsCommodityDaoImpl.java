package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.wmsCommodityDao;
import model.wmscommodity;
@SuppressWarnings("all")
public class wmsCommodityDaoImpl implements wmsCommodityDao{

	public static void main(String[] args) {
		//new wmsCommodityDaoImpl().add(new wmscommodity("sc07","大象杯","15-07","25","20","2099-12-31"));
		//new wmsCommodityDaoImpl().add(new wmscommodity("sc08","黑糖桂圓紅棗磚","15-08","30","30","2026-05-31"));
		
		wmscommodity wm=new wmsCommodityDaoImpl().queryItemName("黑糖粉");
			System.out.println("id:"+wm.getId()+
								"\t代碼:"+wm.getItemCode()+
								"\t名稱:"+wm.getItemName()+
								"\t儲位:"+wm.getItemLocation()+
								"\t安全量:"+ wm.getItemAmount()+
								"\t數量:"+ wm.getItemCount()+
								"\t有效期限:"+wm.getItemEXP()+
								"\t創立日期:"+wm.getCreateDate());
		
	}
	
	
	@Override
	public void add(wmscommodity wm)
	{	Connection conn=DbConnection.getDb();
		String SQL="insert into wmscommodity "
				+ "(itemCode,itemName,itemLocation,itemAmount,itemCount,itemEXP)"
				+ "values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wm.getItemCode());
			ps.setString(2, wm.getItemName());
			ps.setString(3, wm.getItemLocation());
			ps.setString(4, wm.getItemAmount());
			ps.setString(5, wm.getItemCount());
			ps.setString(6, wm.getItemEXP());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean queryItemCode(String itemcode) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmscommodity where itemCode=?";
		Boolean x=false;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, itemcode);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) x=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public List<wmscommodity> queryAll() {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmscommodity";
		List<wmscommodity> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				wmscommodity wm=new wmscommodity();
				wm.setId(rs.getInt("id"));
				wm.setItemCode(rs.getString("itemCode"));
				wm.setItemName(rs.getString("itemName"));
				wm.setItemLocation(rs.getString("itemLocation"));
				wm.setItemAmount(rs.getString("itemAmount"));
				wm.setItemCount(rs.getString("itemCount"));
				wm.setItemEXP(rs.getString("itemEXP"));
				wm.setCreateDate(rs.getDate("createDate"));
				
				l.add(wm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public List<wmscommodity> queryCreateDate(String startDate, String endDate) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmscommodity where createDate>=? and createDate<?";
		List<wmscommodity> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, startDate);
			ps.setString(2, endDate);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				wmscommodity wm=new wmscommodity();
				wm.setId(rs.getInt("id"));
				wm.setItemCode(rs.getString("itemCode"));
				wm.setItemName(rs.getString("itemName"));
				wm.setItemLocation(rs.getString("itemLocation"));
				wm.setItemAmount(rs.getString("itemAmount"));
				wm.setItemCount(rs.getString("itemCount"));
				wm.setItemEXP(rs.getString("itemEXP"));
				wm.setCreateDate(rs.getDate("createDate"));
				
				l.add(wm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public wmscommodity queryItemCode2(String itemcode)
	{	Connection conn=DbConnection.getDb();
		String SQL="select * from wmscommodity where itemCode=?";
		wmscommodity wm=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, itemcode);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				wm=new wmscommodity();
				wm.setId(rs.getInt("id"));
				wm.setItemCode(rs.getString("itemCode"));
				wm.setItemName(rs.getString("itemName"));
				wm.setItemLocation(rs.getString("itemLocation"));
				wm.setItemAmount(rs.getString("itemAmount"));
				wm.setItemCount(rs.getString("itemCount"));
				wm.setItemEXP(rs.getString("itemEXP"));
				wm.setCreateDate(rs.getDate("createDate"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wm;
	}

	@Override
	public wmscommodity queryItemName(String itemname)
	{	Connection conn=DbConnection.getDb();
		String SQL="select * from wmscommodity where itemName=?";
		wmscommodity wm=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, itemname);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				wm=new wmscommodity();
				wm.setId(rs.getInt("id"));
				wm.setItemCode(rs.getString("itemCode"));
				wm.setItemName(rs.getString("itemName"));
				wm.setItemLocation(rs.getString("itemLocation"));
				wm.setItemAmount(rs.getString("itemAmount"));
				wm.setItemCount(rs.getString("itemCount"));
				wm.setItemEXP(rs.getString("itemEXP"));
				wm.setCreateDate(rs.getDate("createDate"));
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return wm;
	}

	@Override
	public void update(wmscommodity wm)
	{
		Connection conn=DbConnection.getDb();
		String SQL="update wmscommodity set itemName=?,itemLocation=?,itemAmount=?,itemCount=?,itemEXP=? where itemCode=?";
				
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wm.getItemName());
			ps.setString(2, wm.getItemLocation());
			ps.setString(3, wm.getItemAmount());
			ps.setString(4, wm.getItemCount());
			ps.setString(5, wm.getItemEXP());
			ps.setString(6, wm.getItemCode());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String itemcode)
	{
		Connection conn=DbConnection.getDb();
		String SQL="delete from wmscommodity where itemCode=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, itemcode);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
