package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.wmsMemberDao;
import model.wmsmember;

public class wmsMemberDaoImpl implements wmsMemberDao{

	public static void main(String[] args) {
		wmsmember wm=new wmsMemberDaoImpl().queryMusername2("admin");
		System.out.println(wm.getMname());

	}

	@Override
	public boolean queryMusername(String Musername) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsmember where Musername=?";
		Boolean x=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, Musername);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) x=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return x;
	}

	@Override
	public wmsmember queryMember(String Musername, String Mpassword) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsmember where Musername=? and Mpassword=?";
		wmsmember wm=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, Musername);
			ps.setString(2, Mpassword);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				wm=new wmsmember();
				wm.setId(rs.getInt("id"));
				wm.setMname(rs.getString("Mname"));
				wm.setMusername(rs.getString("Musername"));
				wm.setMpassword(rs.getString("Mpassword"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wm;
	}

	@Override
	public wmsmember queryMusername2(String Musername) {
		Connection conn=DbConnection.getDb();
		String SQL="select * from wmsmember where Musername=?";
		wmsmember wm=null;
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, Musername);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) 
			{	
				wm=new wmsmember();
				wm.setId(rs.getInt("id"));
				wm.setMname(rs.getString("Mname"));
				wm.setMusername(rs.getString("Musername"));
				wm.setMpassword(rs.getString("Mpassword"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wm;
	}

	@Override
	public void update(wmsmember wm) {
		Connection conn=DbConnection.getDb();
		String SQL="update wmsmember set Mpassword=? where Musername=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, wm.getMpassword());
			ps.setString(2, wm.getMusername());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
