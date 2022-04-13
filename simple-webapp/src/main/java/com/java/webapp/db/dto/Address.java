package com.java.webapp.db.dto;

public class Address {
	
	
	private int id;
	private int residentId;
	private String cap;
	private String residence;
	private String street;
	
	public Address() {}
	
	public Address (int id,int resident_id, String cap,String residence,String street) {
		this.id = id;
		this.residentId = resident_id;
		this.cap = cap;
		this.residence = residence;
		this.street = street;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
		this.residentId = residentId;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", residentId=" + residentId + ", cap=" + cap + ", residence=" + residence
				+ ", street=" + street + "]";
	}
	

}
