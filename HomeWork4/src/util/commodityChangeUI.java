package util;

import controller.commodity.*;

public class commodityChangeUI
{
	public static void commodityManager()
	{
		commodityManager cm=new commodityManager();
		cm.setVisible(true);
	}
	
	public static void addCommodityUI()
	{
		addCommodityUI acu=new addCommodityUI();
		acu.setVisible(true);
	}
	
	public static void queryCommodityUI()
	{
		queryCommodityUI qcu=new queryCommodityUI();
		qcu.setVisible(true);
	}
	
	public static void updateCommodityUI()
	{
		updateCommodityUI ucu=new updateCommodityUI();
		ucu.setVisible(true);
	}
	
	public static void deleteCommodityUI()
	{
		deleteCommodityUI dcu=new deleteCommodityUI();
		dcu.setVisible(true);
	}
}
