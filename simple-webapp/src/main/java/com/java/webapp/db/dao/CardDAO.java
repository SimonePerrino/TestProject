package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.java.webapp.db.dto.Card;


public class CardDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public CardDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	
	public Card creaCard(int id , int owner_id, int bank_id, String code, String expiry, String cvc) {
		Card card = new Card();
		card.setId(id);
		card.setOwnerId(owner_id);
		card.setBankId(bank_id);
		card.setCode(code);
		card.setExpiry(expiry);
		card.setCvc(cvc);
		return card;
	}
	
	public void create (Card card) throws SQLException {
		String queryInsert = "insert into card (id , owner_id, bank_id, code, expiry, cvc) "
					+ "values (?,?,?,?,?,?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando la carta");
		prst.setInt(1, card.getId());
		prst.setInt(2, card.getOwnerId());
		prst.setInt(3, card.getBankId());
		prst.setString(4, card.getCode());
		prst.setString(5, card.getExpiry());
		prst.setString(6, card.getCvc());
		
		prst.executeUpdate();
		
		log.debug("Carta inserita con successo");
		prst.close();
	}
	
	public Card read (int id) throws SQLException {
		String queryRead = "Select * from card where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryRead);
		prst.setInt(1, id);
		ResultSet rs = prst.executeQuery();
		Card card = null;
		if(rs.next())
			card = new Card(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6));
		rs.close();
		System.out.println(card);
		return card;	
	}
	
	public void update(Card card, int id) throws SQLException {
		String queryUpdate = "UPDATE card SET id = ? , owner_id = ?, bank_id = ?, code = ?, expiry = ?, cvc = ? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati della carta: " + id);
		prst.setInt(1, card.getId());
		prst.setInt(2, card.getOwnerId() );
		prst.setInt(3, card.getBankId());
		prst.setString(4, card.getCode());
		prst.setString(5, card.getExpiry());
		prst.setString(6, card.getCvc());
		prst.setInt(7, id);
		prst.executeUpdate();
		log.debug("carta aggiornata con successo");
		prst.close();		
	}
	
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from card where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando la carta: " + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("carta cancellata con successo");
		prst.close();		
	}
}
