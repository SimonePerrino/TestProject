package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.Bank;

public class BankDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public BankDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	
	public Bank creaBank(int id ,String name, String headquarter, int office_number, String type) {
		Bank bank = new Bank();
		bank.setId(id);
		bank.setName(name);
		bank.setHeadquarter(headquarter);
		bank.setOfficeNumber(office_number);
		bank.setType(type);
		return bank;
	}
	
	public void create (Bank bank) throws SQLException {
		String queryInsert = "insert into bank (id , name, headquarter, office_number, type) "
					+ "values (?,?,?,?,?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando la banca");
		prst.setInt(1, bank.getId());
		prst.setString(2, bank.getName());
		prst.setString(3, bank.getHeadquarter());
		prst.setInt(4, bank.getOfficeNumber());
		prst.setString(5, bank.getType());
		
		prst.executeUpdate();
		
		log.debug("Banca inserita con successo");
		prst.close();
	}
	
	public Bank read (int id) throws SQLException {
		String queryRead = "Select * from bank where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryRead);
		prst.setInt(1, id);
		ResultSet rs = prst.executeQuery();
		Bank bank = null;
		if(rs.next())
			bank = new Bank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
		rs.close();
		System.out.println(bank);
		return bank;	
	}
	
	public void update(Bank bank, int id) throws SQLException {
		String queryUpdate = "UPDATE bank SET id = ? , name = ?, headquarter = ?, office_number = ?, type = ? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati della banca: " + id);
		prst.setInt(1, bank.getId());
		prst.setString(2, bank.getName() );
		prst.setString(3, bank.getHeadquarter());
		prst.setInt(4, bank.getOfficeNumber());
		prst.setString(5, bank.getType());
		prst.setInt(6, id);
		prst.executeUpdate();
		log.debug("banca aggiornata con successo");
		prst.close();		
	}
	
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from bank where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando la banca: " + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("banca cancellata con successo");
		prst.close();		
	}

}
