package com.accolite.au.practice;

public class Employee {
	static String companyName = "Accolite";					// static variable values common for all objects
	static int numManager = 0, numDeveloper = 0;
	private int totEmployees = 0;							// Data hiding using private access specifier
	
	private void calcTotalEmployees() {						// private function only accessible by Employee class
		totEmployees = (numManager + numDeveloper);
		System.out.println("Total employees = " + totEmployees);
	}
	
	public void listEmployee() {
		System.out.println("Employee: numManager = " + numManager);
		System.out.println("Employee: numDeveloper = " + numDeveloper);
	}
	
	public static void main(String args[]) {
		System.out.println("Company: " + companyName);		// static method accessing static data member
		System.out.println();
		
		Manager m = new Manager();
		Developer d = new Developer();
		
		m.addEmployee();
		d.addEmployee();

		System.out.println();
		
		m.addEmployee();
		d.addEmployee();
		
		System.out.println();
		
		m.addEmployee();
		System.out.println();

		Employee e = new Employee(); 						// static methods cannot call non-static methods directly (listEmployees)
		e.listEmployee();
		System.out.println();
		m.listEmployee(); 									// calling overidden methods from Manager class
		System.out.println();
		d.listEmployee(); 									// calling overidden methods from Employee class
		System.out.println();
		
		e.calcTotalEmployees();
	}
}

class Manager extends Employee {
	void addEmployee() {
		System.out.println("Manager added in " + Employee.companyName);
		Employee.numManager++;								// accessing static members using class name
	}
	
	@Override
	public void listEmployee() {							// overriding method of parent class (Employee)
		super.listEmployee();								// using super to call method of parent class
		System.out.println("Manager: numManager = " + Employee.numManager);
	}
}

class Developer extends Employee {
	void addEmployee() {
		System.out.println("Developer added in " + Employee.companyName);
		Employee.numDeveloper++;							// accessing static members using class name
	}
	
	@Override
	public void listEmployee() {							// overriding method of parent class (Employee)
		super.listEmployee();								// using super to call method of parent class
		System.out.println("Developer: numDeveloper = " + Employee.numDeveloper);
	}
}
