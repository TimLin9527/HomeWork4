package model;

import java.sql.Date;

public class wmsemployees
{	
	private Integer id;
	private String eName;
	private String gender;
	private String dateOfBirth;
	private String ePhoneNumber;
	private String eAddress;
	private String eEmail;
	private String ecName;
	private String ecNumber;
	private String eUsername;
	private String ePassword;
	private Date createDate;
	
	public wmsemployees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wmsemployees(String eName, String gender, String dateOfBirth, String ePhoneNumber, String eAddress,
			String eEmail, String ecName, String ecNumber, String eUsername, String ePassword) {
		super();
		this.eName = eName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.ePhoneNumber = ePhoneNumber;
		this.eAddress = eAddress;
		this.eEmail = eEmail;
		this.ecName = ecName;
		this.ecNumber = ecNumber;
		this.eUsername = eUsername;
		this.ePassword = ePassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getePhoneNumber() {
		return ePhoneNumber;
	}

	public void setePhoneNumber(String ePhoneNumber) {
		this.ePhoneNumber = ePhoneNumber;
	}

	public String geteAddress() {
		return eAddress;
	}

	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	public String geteEmail() {
		return eEmail;
	}

	public void seteEmail(String eEmail) {
		this.eEmail = eEmail;
	}

	public String getEcName() {
		return ecName;
	}

	public void setEcName(String ecName) {
		this.ecName = ecName;
	}

	public String getEcNumber() {
		return ecNumber;
	}

	public void setEcNumber(String ecNumber) {
		this.ecNumber = ecNumber;
	}

	public String geteUsername() {
		return eUsername;
	}

	public void seteUsername(String eUsername) {
		this.eUsername = eUsername;
	}

	public String getePassword() {
		return ePassword;
	}

	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	
}
