package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.Address;
import com.java.webapp.db.dto.Bankaccount;
import com.java.webapp.db.dto.Card;
import com.java.webapp.db.dto.Document;
import com.java.webapp.db.dto.User;

public class UserJoinDAO extends UserDAO{
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public UserJoinDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}

	
	
	@Override
	public void delete(int id) throws SQLException {
		super.delete(id);
		String queryDel = "delete from user u "
				+ "inner join document d on d.owner_card_id = u.id "
				+ "where u.id = " + id;
		PreparedStatement prst = conn.prepareStatement(queryDel);
		log.debug("Sto cancellando l'utente " + id);
		prst.executeUpdate();		
		log.debug("utente cancellato con successo");
		prst.close();
	}
	
	@Override
	public User read(int id) throws SQLException {
		String queryR = "select * "
				+ "from user u "
				+ "inner join document d on d.owner_card_id = u.id "
				+ "inner join bank_account ba on ba.account_id = u.id "
				+ "inner join address a on a.resident_id = u.id "
				+ "inner join card c on c.owner_id = u.id "
				+ "where u.id = " + id;
		PreparedStatement prst = conn.prepareStatement(queryR);
		ResultSet rs = prst.executeQuery();
		User user = null;
		Address address = null;
		Bankaccount bankaccount = null;
		Document document = null;
		Card card = null;
		if (rs.next())
			user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			document = new Document (rs.getInt(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15));
			bankaccount = new Bankaccount (rs.getInt(16), rs.getInt(17), rs.getInt(18), rs.getString(19), rs.getString(20), rs.getString(21));
			address = new Address (rs.getInt(22), rs.getInt(23), rs.getString(24), rs.getString(25), rs.getString(26));
			card = new Card (rs.getInt(27), rs.getInt(28), rs.getInt(29), rs.getString(30), rs.getString(31), rs.getString(32));
			rs.close();
			System.out.println(user);
			System.out.println(address);
			System.out.println(bankaccount);
			System.out.println(document);
			System.out.println(card);
		return super.read(id);		
		
		
		
	}

}
