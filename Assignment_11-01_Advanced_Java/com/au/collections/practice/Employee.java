package com.au.collections.practice;

public class Employee {
	private String name;
	private int id, age;
	
	public Employee(String name, int id, int age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void getDetails() {
		System.out.println(this.name + ", " + this.id + ", " + this.age);
	}
}
