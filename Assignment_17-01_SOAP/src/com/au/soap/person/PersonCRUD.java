package com.au.soap.person;

import java.util.ArrayList;

public class PersonCRUD {
	public static ArrayList<Person> personList = new ArrayList<>();
	
	public static String createPerson(int id, String fname, String lname, int age) {
		int flag = 0;
		
		for(Person p: personList) {
			if(p.getId() == id) {
				flag = 1;
				break;
			}
		}
		
		if(flag == 0) {
			Person person = new Person();
		
			person.setId(id);
			person.setFname(fname);
			person.setLname(lname);
			person.setAge(age);
		
			personList.add(person);
		
			return "Added new person with id : " + id;
		} else {
			return "Person with id : " + id + " already exists";
		}
	}
	
	public static String retrievePersons() {
		String result = "";
		for(Person p: personList) {
			result += p.getId() + ", " + p.getFname() + ", " + p.getLname() + ", " + p.getAge() + ";";
		}
		
		return result;
	}
	
	public static String updatePerson(int id, String fname, String lname, int age) {
		int flag = 0;
		for(Person p: personList) {
			if(p.getId() == id) {
				p.setFname(fname);
				p.setLname(lname);
				p.setAge(age);
				
				flag = 1;
				break;
			}
		}
		
		if(flag == 1) {
			return "Details of person with id : " + id + " updated";
		} else {
			return "Person with id : " + id + " not found";
		}
	}
	
	public static String deletePerson(int id) {
		int flag = 0;
		for(Person p: personList) {
			if(p.getId() == id) {
				personList.remove(p);
				
				flag = 1;
				break;
			}
		}
		
		if(flag == 1) {
			return "Person with id : " + id + " deleted";
		} else {
			return "Person with id : " + id + " not found";
		}
	}
}
