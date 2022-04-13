package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.Document;

public class DocumentDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public DocumentDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	
	public Document creaDocument(int id, int  owner_card_id, String expiry,String issued_by, String date_issued, String document_number) {
		Document document = new Document();
		document.setId(id);
		document.setOwnerCardId(owner_card_id);
		document.setExpiry(expiry);
		document.setIssuedBy(issued_by);
		document.setDateIssued(date_issued);
		document.setDocumentNumber(document_number);
		
		return document;
	}
	
	public void create (Document document) throws SQLException {
		String queryInsert = "insert into document (id, owner_card_id, expiry, issued_by, date_issued, document_number) "
					+ "values (?,?,?,?,?, ?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando il documento");
		prst.setInt(1, document.getId());
		prst.setInt(2, document.getOwnerCardId());
		prst.setString(3, document.getExpiry());
		prst.setString(4, document.getIssuedBy());
		prst.setString(5, document.getDateIssued());
		prst.setString(6, document.getDocumentNumber());
		
		prst.executeUpdate();
		
		log.debug("Documento inserito con successo");
		prst.close();
	}
	
	public Document read (int id) throws SQLException {
		String queryRead = "Select * from document where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryRead);
		prst.setInt(1, id);
		ResultSet rs = prst.executeQuery();
		Document document = null;
		if(rs.next())
			document = new Document(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
		rs.close();
		System.out.println(document);
		return document;	
	}
	
	public void update(Document document, int id) throws SQLException {
		String queryUpdate = "UPDATE document SET id = ? , owner_card_id = ?, expiry = ?, issued_by = ?, date_issued = ?, document_number = ? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati del documento: " + id);
		prst.setInt(1, document.getId());
		prst.setInt(2, document.getOwnerCardId() );
		prst.setString(3, document.getExpiry());
		prst.setString(4, document.getIssuedBy());
		prst.setString(5, document.getDateIssued());
		prst.setString(6, document.getDocumentNumber());
		prst.setInt(7, id);
		prst.executeUpdate();
		log.debug("documento aggiornato con successo");
		prst.close();		
	}
	
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from document where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando il documento: " + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("documento cancellato con successo");
		prst.close();		
	}

}
