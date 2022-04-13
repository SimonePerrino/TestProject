package com.java.webapp.db.dto;

public class Bank {
	private int id;
	private String name;
	private String headquarter;
	private int officeNumber;
	private String type;
	
	public Bank() {}
	
	public Bank (int id , String name, String headquarter, int office_number, String type) {
		this.id = id;
		this.name = name;
		this.headquarter = headquarter;
		this.officeNumber = office_number;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}

	public int getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(int officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", headquarter=" + headquarter + ", officeNumber=" + officeNumber
				+ ", type=" + type + "]";
	}
	
	

}
