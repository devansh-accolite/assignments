package com.au.collections.practice;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class MainClass {
	static void getEmployeeBelow30(Company c) {
		TreeSet<Employee> eSet = c.getEmployeeSet();
		for(Employee e : eSet) {
			if(e.getAge() < 30) {
				System.out.println(e.getName());
			}
		}
	}

	static TreeSet<Employee> sortEmployeeById(Company c) {
		TreeSet<Employee> eSet = new TreeSet<>((e1, e2) ->
				(e1.getId() > e2.getId() ?
						1 :
						(e1.getId() == e2.getId() ?
								(e1.getAge() > e2.getAge() ?
										1 :
										(e1.getAge() == e2.getAge()) ?
												(e1.getName().compareToIgnoreCase(e2.getName())) :
										-1) :
								-1)));
		for(Employee e : c.getEmployeeSet()) {
			eSet.add(e);
		}

		return eSet;
	}

	static TreeSet<Employee> sortEmployeeByName(Company c) {
		TreeSet<Employee> eSet = new TreeSet<>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				int temp = o1.getName().compareToIgnoreCase(o2.getName());
				if(temp == 0) {
					temp = (o1.getId() > o2.getId()) ?
							1 :
							(o1.getId() == o2.getId()) ?
									(o1.getAge() > o2.getAge()) ?
											1 :
											(o1.getAge() == o2.getAge()) ?
													0 :
													-1 :
									-1;
				}

				return temp;
			}
		});
		for(Employee e : c.getEmployeeSet()) {
			eSet.add(e);
		}

		return eSet;
	}

	static HashMap<String, ArrayList<String>> getCompaniesInCities(ArrayList<Company> cList) {
		HashMap<String, ArrayList<String>> cMap = new HashMap<>();

		for(Company c : cList) {
			String city = c.getAddress().getCity().toUpperCase();
			if(cMap.containsKey(city)) {
				if(! cMap.get(city).contains(c.getName().toUpperCase())) {
					ArrayList<String> list = cMap.get(city);
					list.add(c.getName().toUpperCase());
					cMap.put(city, list);
				}
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(c.getName().toUpperCase());
				cMap.put(city, list);
			}
		}

		return cMap;
	}
	
	public static void main(String args[]) {
		ArrayList<Company> companyList = new ArrayList<>();
		
		companyList.add(new Company("Accolite", new Address("Bangalore", "Karnataka")));
		companyList.add(new Company("Infosys", new Address("Mysore", "Karnataka")));
		companyList.add(new Company("CISCO", new Address("bAngalore", "Karnataka")));
		companyList.add(new Company("Samsung", new Address("Mumbai", "Maharashtra")));
		companyList.add(new Company("Wipro", new Address("mumbai", "Maharashtra")));

		companyList.get(0).addEmployee(new Employee("abc", 1, 23));
		companyList.get(0).addEmployee(new Employee("aBc", 2, 31));
		companyList.get(0).addEmployee(new Employee("ghi", 3, 23));

		companyList.get(1).addEmployee(new Employee("jkl", 4, 55));
		companyList.get(1).addEmployee(new Employee("jkl", 4, 55));
		companyList.get(1).addEmployee(new Employee("pqr", 6, 43));

		companyList.get(2).addEmployee(new Employee("Stu", 7, 23));
		companyList.get(2).addEmployee(new Employee("awx", 8, 26));
		companyList.get(2).addEmployee(new Employee("yza", 9, 22));

		companyList.get(3).addEmployee(new Employee("bcd", 10, 40));
		companyList.get(3).addEmployee(new Employee("bcd", 11, 40));
		companyList.get(3).addEmployee(new Employee("hij", 12, 23));

		companyList.get(4).addEmployee(new Employee("klm", 13, 54));
		companyList.get(4).addEmployee(new Employee("nop", 14, 23));
		companyList.get(4).addEmployee(new Employee("qrs", 15, 23));

		System.out.println("Employees below the age of 30 in :");
		for(Company c : companyList) {
			System.out.println("\n" + c.getName().toUpperCase());
			getEmployeeBelow30(c);
		}

		System.out.println("\n\nEmployees sorted according to age in ascending order :");
		for(Company c : companyList) {
			System.out.println("\n" + c.getName().toUpperCase());
			TreeSet<Employee> eSet = c.getEmployeeSet();
			for(Employee e : eSet) {
				e.getDetails();
			}
		}

		System.out.println("\n\nEmployees sorted according to id in ascending order :");
		for(Company c : companyList) {
			System.out.println("\n" + c.getName().toUpperCase());
			for(Employee e : sortEmployeeById(c)) {
				e.getDetails();
			}
		}

		System.out.println("\n\nEmployees sorted according to name in ascending order :");
		for(Company c : companyList) {
			System.out.println("\n" + c.getName().toUpperCase());
			for(Employee e : sortEmployeeByName(c)) {
				e.getDetails();
			}
		}

		System.out.println("\n\nCompanies in cities :");
		HashMap<String, ArrayList<String>> citiesMap = getCompaniesInCities(companyList);
		for(String key : citiesMap.keySet()) {
			System.out.println("\n" + key);
			for(String c : citiesMap.get(key)) {
				System.out.println(c);
			}
		}
	}
}
