package com.au.soap.person;

public class MainClass {
	public String createPerson(int id, String fname, String lname, int age) {
		return PersonCRUD.createPerson(id, fname, lname, age);
	}
	
	public String retrievePersons() {
		return PersonCRUD.retrievePersons(); 
	}
	
	public String updatePerson(int id, String fname, String lname, int age) {
		return PersonCRUD.updatePerson(id, fname, lname, age);
	}
	
	public String deletePerson(int id) {
		return PersonCRUD.deletePerson(id);
	}
}
