package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.Address;

public class AddressDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public AddressDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	
	public Address creaAddress(int id, int resident_id, String cap, String residence, String street) {
		Address address = new Address();
		address.setId(id);
		address.setResidentId(resident_id);
		address.setCap(cap);
		address.setResidence(residence);
		address.setStreet(street);
		return address;
	}
	
	public void create (Address address) throws SQLException {
		String queryInsert = "insert into address(id, resident_id, cap, residence, street) " 
					+ "values (?,?,?,?,?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando l' indirizzo " + address.getStreet());
		prst.setInt(1, address.getId());
		prst.setInt(2, address.getResidentId());
		prst.setString(3, address.getCap());
		prst.setString(4, address.getResidence());
		prst.setString(5, address.getStreet());
		
		prst.executeUpdate();
		
		log.debug("indirizzo inserito con successo");
		prst.close();
	}
	
	public Address read (int id) throws SQLException {
		String queryRead = "Select * from address where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryRead);
		prst.setInt(1, id);
		ResultSet rs = prst.executeQuery();
		Address address = null;
		if(rs.next())
			address = new Address (rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5));
		rs.close();
		System.out.println(address);
		return address;	
	}
	
	public void update(Address address, int id) throws SQLException {
		String queryUpdate = "UPDATE address SET id = ?, resident_id =?, cap =?, residence=?, street=? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati dell'indirizzo: " + id);
		prst.setInt(1, address.getId());
		prst.setInt(2, address.getResidentId() );
		prst.setString(3, address.getCap());
		prst.setString(4, address.getResidence());
		prst.setString(5, address.getStreet());
		prst.setInt(6, id);
		prst.executeUpdate();
		log.debug("indirizzo aggiornato con successo");
		prst.close();		
	}
	
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from address where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando l'indirizzo" + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("indirizzo cancellato con successo");
		prst.close();		
	}
	


}
