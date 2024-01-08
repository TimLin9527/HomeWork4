package dao;


import java.util.List;
import model.wmsclient;

public interface wmsClientDao
{
	//create
	void addClient(wmsclient wc);
	
	
	//read
	boolean queryUsername(String username,String GUInumber);//註冊驗證是否有此帳號
	wmsclient queryMember(String username,String password);
	List<wmsclient> queryAll();
	List<wmsclient> queryClientCreateTime(String startDate,String endDate);
	wmsclient queryGUInumber(String GUInumber);
	
	
	//update
	void update(wmsclient wc);
	
	
	//delete
	void delete(String GUInumber);

}
