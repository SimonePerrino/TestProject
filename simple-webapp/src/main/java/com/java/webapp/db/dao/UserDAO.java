package com.java.webapp.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.java.webapp.db.dto.User;



/**
 * Data Access Object per l'entità Utente.
 * 
 * @author simone.perrino
 *
 */
public class UserDAO {
	private Connection conn = null;
	private String url;
	private String username;
	private String password;
	Logger log = LogManager.getLogger(this.getClass());

	// Class.forName("com.mysql.jdbc.Driver");
	public UserDAO() throws SQLException {
		url = "jdbc:mysql://localhost:3306/db_webapp";
		username = "root";
		password = "Sharingan1*";
		conn = DriverManager.getConnection(url, username, password);
	}
	public User creaUser(int id, String name, String surname,int age, String work, String dateOfBirth, String placeOfBirth, String sex, String nationality) {
		User user = new User();
		
		user.setId(id);
		user.setName(name);
		user.setSurname(surname);
		user.setAge(age);
		user.setWork(work);
		user.setDateOfBirth(dateOfBirth);
		user.setPlaceOfBirth(placeOfBirth);
		user.setSex(sex);
		user.setNationality(nationality);
		return user;
	}
	
	/**insert into user(id, name, surname, age, work, date_of_birth, place_of_birth, sex, nationality)

	 * metodo di inserimento di un utente nel database.
	 * @param user
	 * @throws SQLException
	 */
	public void create(User user) throws SQLException {
		String queryInsert = "insert into user(id, name, surname, age, work, date_of_birth, place_of_birth, sex, nationality)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		PreparedStatement prst = conn.prepareStatement(queryInsert);
		
		log.debug("Sto creando l'utente " + user.getName()+ " " + user.getSurname());
		
		prst.setInt(1, user.getId());
		prst.setString(2, user.getName());
		prst.setString(3, user.getSurname());
		prst.setInt(4, user.getAge());
		prst.setString(5, user.getWork());
		prst.setString(6, user.getDateOfBirth());
		prst.setString(7, user.getPlaceOfBirth());
		prst.setString(8, user.getSex());
		prst.setString(9, user.getNationality());
		
		prst.executeUpdate();
		
		log.debug("utente inserito con successo");
		prst.close();
	}
	
	/**
	 * metodo di aggiornamento dell'utente nel database
	 * 
	 * @param user
	 * @param taxCode
	 * @throws SQLException
	 */
	public void update(User user, int id) throws SQLException {
		String queryUpdate = "UPDATE user SET id = ?, name=?, surname=?, age=?, work=?, date_of_birth=?, place_of_birth=?, sex = ?, nationality = ? where id = ?";
		PreparedStatement prst = conn.prepareStatement(queryUpdate);
		log.debug("Sto aggiornando i dati dell'utente: " + id);
		prst.setInt(1, user.getId());
		prst.setString(2, user.getName() );
		prst.setString(3, user.getSurname());
		prst.setInt(4, user.getAge());
		prst.setString(5, user.getWork());
		prst.setString(6, user.getDateOfBirth());
		prst.setString(7, user.getPlaceOfBirth());
		prst.setString(8, user.getSex());
		prst.setString(9, user.getNationality());
		prst.setInt(10, id);
		prst.executeUpdate();
		log.debug("utente aggiornato con successo");
		prst.close();		
	}
	
	
	
		/**
		 * metodo per visualizzari i dati di un utente
		 * 
		 * @param taxCode
		 * @return
		 * @throws SQLException
		 */
		public User read(int id) throws SQLException {
			String querySelect = "Select * from user where id = ?";
			PreparedStatement prst = conn.prepareStatement(querySelect);
			prst.setInt(1, id);
			ResultSet rs = prst.executeQuery();
			User user = null;
			if(rs.next())
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
			rs.close();
			System.out.println(user);
			return user;
			
	}
	
	
	/**
	 * metodo per cancellare un utente nel database
	 * 
	 * @param taxCode
	 * @throws SQLException
	 */
		
	public void delete(int id) throws SQLException {
		String queryDelete = "delete from user where id = ?;";
		PreparedStatement prst = conn.prepareStatement(queryDelete);
		log.debug("Sto cancellando l'utente " + id);
		prst.setInt(1, id);
		prst.executeUpdate();
		
		log.debug("utente cancellato con successo");
		prst.close();
		
	}
	
	
	
}
