package com.au.collections.practice;

import java.util.TreeSet;

public class Company {
	private String name;
	private Address address;
	private TreeSet<Employee> employeeTreeSet;
	
	public Company(String name, Address address) {
		this.name = name;
		this.address = address;
		this.employeeTreeSet = new TreeSet<>((e1, e2) ->
				(e1.getAge() > e2.getAge() ?
						1 :
						(e1.getAge() == e2.getAge() ?
								(e1.getId() > e2.getId() ?
										1 :
										(e1.getId() == e2.getId()) ?
												(e1.getName().compareToIgnoreCase(e2.getName())) :
												-1) :
								-1)));
	}
	
	public String getName() {
		return this.name;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public TreeSet<Employee> getEmployeeSet() {
		return this.employeeTreeSet;
	}
	
	public void addEmployee(Employee employee) {
		this.employeeTreeSet.add(employee);
	}
}
