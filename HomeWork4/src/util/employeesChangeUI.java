package util;

import controller.EmployeesWork.*;

public class employeesChangeUI
{		
	public static void EmployeesManager()
	{
		EmployeesManager em=new EmployeesManager();
		em.setVisible(true);
	}
	
	public static void addEmployeesUI()
	{
		addEmployeesUI aelu=new addEmployeesUI();
		aelu.setVisible(true);
	}
	
	public static void queryEmployeesUI() 
	{
		queryEmployeesUI qeu=new queryEmployeesUI();
		qeu.setVisible(true);
	}
	
	public static void updateEmployeesUI()
	{
		updateEmployeesUI ueu=new updateEmployeesUI();
		ueu.setVisible(true);
	}
	
	public static void deleteEmployeesUI()
	{
		deleteEmployeesUI deu=new deleteEmployeesUI();
		deu.setVisible(true);
	}
}
