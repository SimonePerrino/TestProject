package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.Bankaccount;


public class BankaccountDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public BankaccountDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	public Bankaccount creaBankaccount(int id, int account_id, int home_bank_id, String email, String password, String account_type) {
		Bankaccount bankaccount = new Bankaccount();
		bankaccount.setId(id);
		bankaccount.setAccountId(account_id);
		bankaccount.setHomeBankId(home_bank_id);
		bankaccount.setEmail(email);
		bankaccount.setPassword(password);
		bankaccount.setAccount_type(account_type);
		return bankaccount;
	}
	
	public void create (Bankaccount bankaccount) throws SQLException {
		String queryInsert = "insert into bank_account (id, account_id, home_bank_id, email, password, account_type) "
					+ "values (?,?,?,?,?,?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando l' account");
		prst.setInt(1, bankaccount.getId());
		prst.setInt(2, bankaccount.getAccountId());
		prst.setInt(3, bankaccount.getHomeBankId());
		prst.setString(4, bankaccount.getEmail());
		prst.setString(5, bankaccount.getPassword());
		prst.setString(6, bankaccount.getAccount_type());
		
		prst.executeUpdate();
		
		log.debug("Account inserito con successo");
		prst.close();
	}
	
	public Bankaccount read (int id) throws SQLException {
		String queryRead = "Select * from bank_account where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryRead);
		prst.setInt(1, id);
		ResultSet rs = prst.executeQuery();
		Bankaccount bankaccount = null;
		if(rs.next())
			bankaccount = new Bankaccount (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
		rs.close();
		System.out.println(bankaccount);
		return bankaccount;	
	}
	
	public void update(Bankaccount bankaccount, int id) throws SQLException {
		String queryUpdate = "UPDATE transaction SET id = ?, account_id =?, home_bank_id =?, email=?, password=?, account_type = ? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati del profilo" + id);
		prst.setInt(1, bankaccount.getId());
		prst.setInt(2, bankaccount.getAccountId() );
		prst.setInt(3, bankaccount.getHomeBankId());
		prst.setString(4, bankaccount.getEmail());
		prst.setString(5, bankaccount.getPassword());
		prst.setString(6, bankaccount.getAccount_type());
		prst.setInt(7, id);
		prst.executeUpdate();
		log.debug("profilo aggiornato con successo");
		prst.close();		
	}
	
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from bank_account where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando il profilo" + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("profilo cancellato con successo");
		prst.close();		
	}

}
