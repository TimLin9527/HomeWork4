package model;

import java.sql.Date;

public class wmsclient
{	
	private Integer id;
	private String companyName;
	private String username;
	private String password;
	private String phoneNumber;
	private String GUInumber;
	private String address;
	private String email;
	private Date clientCreateTime;
	
	public wmsclient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wmsclient(String companyName, String username, String password, String phoneNumber, String GUInumber,
			String address, String email) {
		super();
		this.companyName = companyName;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.GUInumber = GUInumber;
		this.address = address;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGUInumber() {
		return GUInumber;
	}

	public void setGUInumber(String GUInumber) {
		this.GUInumber = GUInumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getClientCreateTime() {
		return clientCreateTime;
	}

	public void setClientCreateTime(Date clientCreateTime) {
		this.clientCreateTime = clientCreateTime;
	}

}
