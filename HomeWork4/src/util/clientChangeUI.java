package util;

import controller.client.*;

public class clientChangeUI
{
	public static void clientManager()
	{
		clientManager cm=new clientManager();
		cm.setVisible(true);
	}
	
	public static void addClientUI()
	{
		addClientUI acu=new addClientUI();
		acu.setVisible(true);
	}
	
	public static void queryClientUI()
	{
		queryClientUI qcu=new queryClientUI();
		qcu.setVisible(true);
	}
	
	public static void updateClientUI()
	{
		updateClientUI ucu=new updateClientUI();
		ucu.setVisible(true);
	}
	
	public static void deleteClientUI()
	{
		deleteClientUI dcu=new deleteClientUI();
		dcu.setVisible(true);
	}
	
}
