package model;

import java.sql.Date;

public class wmscommodity 
{
	private Integer id;
	private String itemCode;
	private String itemName;
	private String itemLocation;
	private String itemAmount;
	private String itemCount;
	private String itemEXP;
	private Date createDate;
	
	public wmscommodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public wmscommodity(String itemCode, String itemName, String itemLocation, String itemAmount, String itemCount,
			String itemEXP) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemLocation = itemLocation;
		this.itemAmount = itemAmount;
		this.itemCount = itemCount;
		this.itemEXP = itemEXP;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemLocation() {
		return itemLocation;
	}

	public void setItemLocation(String itemLocation) {
		this.itemLocation = itemLocation;
	}

	public String getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(String itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getItemCount() {
		return itemCount;
	}

	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemEXP() {
		return itemEXP;
	}

	public void setItemEXP(String itemEXP) {
		this.itemEXP = itemEXP;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
