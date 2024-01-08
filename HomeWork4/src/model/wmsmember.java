package model;

public class wmsmember 
{
	private Integer id;
	private String Mname;
	private String Musername;
	private String Mpassword;
	
	
	
	public wmsmember() {
		super();
		// TODO Auto-generated constructor stub
	}


	public wmsmember(String mname, String musername, String mpassword) {
		super();
		Mname = mname;
		Musername = musername;
		Mpassword = mpassword;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getMname() {
		return Mname;
	}


	public void setMname(String mname) {
		Mname = mname;
	}


	public String getMusername() {
		return Musername;
	}


	public void setMusername(String musername) {
		Musername = musername;
	}


	public String getMpassword() {
		return Mpassword;
	}


	public void setMpassword(String mpassword) {
		Mpassword = mpassword;
	}
	
}	
