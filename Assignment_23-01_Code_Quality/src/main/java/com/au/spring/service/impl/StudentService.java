package com.au.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.au.spring.dao.impl.StudentDAO;
import com.au.spring.model.Student;

@Service
public class StudentService {
	@Autowired
	StudentDAO studentDAO;
	
	public List<Student> getDetails() {
		return studentDAO.getDetails();
	}

	public void insertDetails(Student student) {
		studentDAO.insertDetails(student);
	}
}
