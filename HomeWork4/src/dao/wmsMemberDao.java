package dao;

import model.wmsmember;

public interface wmsMemberDao 
{
	//create
	
	//read
	boolean queryMusername(String Musername);
	wmsmember queryMember(String Musername,String Mpassword);
	wmsmember queryMusername2(String Musername);
	
	//update
	void update(wmsmember wm);
	
	//delete
}
