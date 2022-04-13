package com.java.webapp.db.dto;

public class Card {
	private int id;
	private int ownerId;
	private int bankId;
	private String code;
	private String expiry;
	private String cvc;
	
	public Card() {}
	
	public Card(int id, int owner_id, int bank_id, String code, String expiry, String cvc) {
		this.id = id;
		this.ownerId = owner_id;
		this.bankId = bank_id;
		this.code = code;
		this.expiry = expiry;
		this.cvc = cvc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", ownerId=" + ownerId + ", bankId=" + bankId + ", code=" + code + ", expiry="
				+ expiry + ", cvc=" + cvc + "]";
	}
	

}
