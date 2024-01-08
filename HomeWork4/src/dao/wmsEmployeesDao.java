package dao;

import java.util.List;

import model.wmsemployees;

public interface wmsEmployeesDao
{
	//create
	void add(wmsemployees wey);
	
	//read
	boolean queryUsername(String eUsername);//註冊驗證是否有此帳號
	wmsemployees queryMember(String username,String password);
	List<wmsemployees> queryAll();
	wmsemployees queryeUsername(String eUsername);
	List<wmsemployees> queryCreateTime(String startDate,String endDate);
	
	//update
	void update(wmsemployees wey);
	
	
	//delete
	void delete(String eUsername);
}
