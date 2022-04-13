package com.java.webapp.db.dto;

/**
 * Entity Bean che rappresenta entità utente.
 * @author simone.perrino
 *
 */
public class User implements java.io.Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String surname;
	private int age;
	private String work;
	private String dateOfBirth;
	private String placeOfBirth;
	private String sex;
	private String nationality;
	
	public User() {}
	
	
	public User (int id, String name, String surname,int age, String work, String dateOfBirth, String placeOfBirth, String sex, String nationality  ) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.work = work;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.sex = sex;
		this.nationality = nationality;
	}
	
	
	

	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getWork() {
		return work;
	}


	public void setWork(String work) {
		this.work = work;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPlaceOfBirth() {
		return placeOfBirth;
	}


	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", work=" + work
				+ ", dateOfBirth=" + dateOfBirth + ", placeOfBirth=" + placeOfBirth + ", sex=" + sex + ", nationality="
				+ nationality + "]";
	}
	


}
