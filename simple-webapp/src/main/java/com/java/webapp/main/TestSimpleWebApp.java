package com.java.webapp.main;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dao.AddressDAO;
import com.java.webapp.db.dao.BankDAO;
import com.java.webapp.db.dao.BankaccountDAO;
import com.java.webapp.db.dao.CardDAO;
import com.java.webapp.db.dao.DocumentDAO;
import com.java.webapp.db.dao.TransactionDAO;
import com.java.webapp.db.dao.UserDAO;
import com.java.webapp.db.dao.UserJoinDAO;

public class TestSimpleWebApp {
	
	static Logger log = LogManager.getLogger(TestSimpleWebApp.class);
	
	public static void main(String[] args) throws SQLException {
	
		//log.debug("Inizio Main");
		
		UserDAO dbu;
		AddressDAO dba;
		BankDAO dbb;
		BankaccountDAO dbba;
		TransactionDAO dbt;
		CardDAO dbc;
		DocumentDAO dbd;
		
		dbu = new UserDAO();
		dbu.create(dbu.creaUser(5 ,"Francesca" ,"Silvestri", 19, "student","2003-02-25", "Napoli", "F", "Italian"));
		
		dba = new AddressDAO();
		dba.create(dba.creaAddress(4, 4, "80020", "Casavatore", "Viale Michelangelo 46"));
		
		dbb = new BankDAO();
		dbb.create(dbb.creaBank(3, "Intesa Sanpaolo", "Basiglio", 250, "banca diretta"));
		
		dbba = new BankaccountDAO();
		dbba.create(dbba.creaBankaccount(4, 4, 1, "simone.perrino@libero.it", "Nonloso12", "personale"));
		
		dbt = new TransactionDAO();
		dbt.create(dbt.creaTransaction(3, 1, 3, "gift", 150, "2022-03-24"));
		
		dbc = new CardDAO();
		dbc.create(dbc.creaCard(4, 4, 1, "3455876725362828", "2027-04-27", "987"));
		
		dbd = new DocumentDAO();
		dbd.create(dbd.creaDocument(4, 4, "2024-06-25", "Comune di Casavatore", "2023-10-28", "CJ35790SR"));
	
		UserJoinDAO dbuj;
		dbuj = new UserJoinDAO();
		dbuj.read(2);
	
	
	}
	
}
