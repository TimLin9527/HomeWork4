package dao;

import java.util.List;

import model.wmscommodity;

public interface wmsCommodityDao 
{
	//create
	void add(wmscommodity wm);
	
	
	//read
	boolean queryItemCode(String itemcode);
	List<wmscommodity> queryAll();
	List<wmscommodity> queryCreateDate(String startDate,String endDate);
	wmscommodity queryItemCode2(String itemcode);
	wmscommodity queryItemName(String itemname);
	
	
	//update
	void update(wmscommodity wm);
	
	//delete
	void delete(String itemcode);
}	
