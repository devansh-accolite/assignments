package com.au.collections.practice;

import java.util.ArrayList;
import java.util.TreeSet;

public class MainClass {
	public void getEmployeeBelow30(Company c) {
		TreeSet<Employee> eSet = c.getEmployeeSet();
		for(Employee e : eSet) {
			if(e.getAge() < 30) {
				System.out.println(e.getName());
			}
		}
	}
	
	public static void main(String args[]) {
		ArrayList<Company> companyList = new ArrayList<>();
		
		companyList.add(new Company("Accolite", new Address("Bangalore", "Karnataka")));
		companyList.add(new Company("HP", new Address("Mysore", "Karnataka")));
		companyList.add(new Company("CISCO", new Address("Bangalore", "Karnataka")));
		companyList.add(new Company("Samsung", new Address("Mumbai", "Maharashtra")));
		companyList.add(new Company("Wipro", new Address("Mumbai", "Maharashtra")));

		companyList.get(0).addEmployee(new Employee("abc", 1, 45));
		companyList.get(0).addEmployee(new Employee("def", 2, 31));
		companyList.get(0).addEmployee(new Employee("ghi", 3, 25));

		companyList.get(1).addEmployee(new Employee("jkl", 4, 55));
		companyList.get(1).addEmployee(new Employee("mno", 5, 29));
		companyList.get(1).addEmployee(new Employee("pqr", 6, 23));

		companyList.get(2).addEmployee(new Employee("stu", 7, 23));
		companyList.get(2).addEmployee(new Employee("vwx", 8, 26));
		companyList.get(2).addEmployee(new Employee("yza", 9, 22));

		companyList.get(3).addEmployee(new Employee("bcd", 10, 40));
		companyList.get(3).addEmployee(new Employee("efg", 11, 34));
		companyList.get(3).addEmployee(new Employee("hij", 12, 23));

		companyList.get(4).addEmployee(new Employee("klm", 13, 54));
		companyList.get(4).addEmployee(new Employee("nop", 14, 23));
		companyList.get(4).addEmployee(new Employee("qrs", 15, 64));
		
		getEmployeeBelow30(companyList.get(0));
	}
}
