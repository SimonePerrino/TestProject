package com.java.webapp.db.dto;

public class Bankaccount {
	private int id;
	private int accountId;
	private int homeBankId;
	private String email;
	private String password;
	private String account_type;
	
	public Bankaccount() {}
	
	public Bankaccount(int id, int account_id, int home_bank_id, String email, String password, String account_type) {
		this.id = id;
		this.accountId = account_id;
		this.homeBankId = home_bank_id;
		this.email = email;
		this.password = password;
		this.account_type = account_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getHomeBankId() {
		return homeBankId;
	}

	public void setHomeBankId(int homeBankId) {
		this.homeBankId = homeBankId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	@Override
	public String toString() {
		return "Bankaccount [id=" + id + ", accountId=" + accountId + ", homeBankId=" + homeBankId + ", email=" + email
				+ ", password=" + password + ", account_type=" + account_type + "]";
	}
	

}
