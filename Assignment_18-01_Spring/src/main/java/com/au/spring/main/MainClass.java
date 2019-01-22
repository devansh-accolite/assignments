package com.au.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.spring.dao.StudentDao;
import com.au.spring.model.Student;

public class MainClass {
	public static String factoryMethod(String val) {
		System.out.println("Calling factory method from bean with value: " + val);
		String str = "";
		if(val.equals("1")) {
			str = "First option chosen";
		} else if(val.equals("2")) {
			str = "Second option chosen";
		} else {
			str = "Default option chosen";
		}
		
		System.out.println(str);
		
		return str;
	}
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
		
		StudentDao studentDao = classPathXmlApplicationContext.getBean(StudentDao.class);
		
		Student student = new Student();
		student.setStudent_id(11);
		student.setStudent_name("EFG");
		
		studentDao.saveStudent(student);
		
		System.out.println("Five students data using ResultSetExtractor");
		for(Student s: studentDao.getFiveStudents()) {
			System.out.println(s);
		}
		
		System.out.println("All students data using RowMapper");
		for(Student s: studentDao.getAllStudents()) {
			System.out.println(s);
		}
		
		classPathXmlApplicationContext.close();
	}
}
