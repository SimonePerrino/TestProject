package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.Transaction;

public class TransactionDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public TransactionDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	public Transaction creaTransaction(int id, int sender_id, int recipient_id, String cause, int amount, String date) {
		Transaction transaction = new Transaction();
		
		transaction.setId(id);
		transaction.setSenderId(sender_id);
		transaction.setRecipientId(recipient_id);
		transaction.setCause(cause);
		transaction.setAmount(amount);
		transaction.setDate(date);
		return transaction;
	}
	
	public void create (Transaction transaction) throws SQLException {
		String queryInsert = "insert into transaction (id, sender_id, recipient_id, cause, amount, date) " 
					+ "values (?,?,?,?,?,?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando la transazione ");
		prst.setInt(1, transaction.getId());
		prst.setInt(2, transaction.getSenderId());
		prst.setInt(3, transaction.getRecipientId());
		prst.setString(4, transaction.getCause());
		prst.setInt(5, transaction.getAmount());
		prst.setString(6, transaction.getDate());
		
		prst.executeUpdate();
		
		log.debug("transazione inserita con successo");
		prst.close();
	}
	
	public Transaction read (int id) throws SQLException {
		String queryRead = "Select * from transaction where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryRead);
		prst.setInt(1, id);
		ResultSet rs = prst.executeQuery();
		Transaction transaction = null;
		if(rs.next())
			transaction = new Transaction (rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6));
		rs.close();
		System.out.println(transaction);
		return transaction;	
	}
	
	public void update(Transaction transaction, int id) throws SQLException {
		String queryUpdate = "UPDATE transaction SET id = ?, sender_id =?, recipient_id =?, cause=?, amount=?, date = ? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati della transazione: " + id);
		prst.setInt(1, transaction.getId());
		prst.setInt(2, transaction.getSenderId() );
		prst.setInt(3, transaction.getRecipientId());
		prst.setString(4, transaction.getCause());
		prst.setInt(5, transaction.getAmount());
		prst.setString(6, transaction.getDate());
		prst.setInt(7, id);
		prst.executeUpdate();
		log.debug("transazione aggiornata con successo");
		prst.close();		
	}
	
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from transaction where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando la transazione" + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("transazione cancellata con successo");
		prst.close();		
	}

}
