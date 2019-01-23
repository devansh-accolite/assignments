package com.au.spring.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.au.spring.model.Student;
import com.au.spring.rowmapper.RowMaps;

@Repository
public class StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Student> getDetails() {
		RowMaps rowMap = new RowMaps();
		return jdbcTemplate.query("select * from student", rowMap);
	}

	public void insertDetails(Student student) {
		jdbcTemplate.update("insert into student values (" + student.getStudentId() + ", '" + student.getStudentName() + "');");
	}
}
