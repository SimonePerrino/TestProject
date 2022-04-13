package com.java.webapp.db.dto;

public class Transaction {
	private int id;
	private int senderId;
	private int recipientId;
	private String cause;
	private int amount;
	private String date;
	
	public Transaction() {}
	
	public Transaction(int id, int sender_id, int recipient_id, String cause, int amount, String date) {
		this.id = id;
		this.senderId = sender_id;
		this.recipientId = recipient_id;
		this.cause = cause;
		this.amount = amount;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", senderId=" + senderId + ", recipientId=" + recipientId + ", cause=" + cause
				+ ", amount=" + amount + ", date=" + date + "]";
	}
	

}
