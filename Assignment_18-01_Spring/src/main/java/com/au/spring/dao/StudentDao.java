package com.au.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.au.spring.model.Student;

public class StudentDao {
	public DataSource dataSource;

	public JdbcTemplate jdbcTemplate;

	// For beans
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void saveStudent(Student student) {
		String query = "insert into student(student_id, student_name) values (" + student.getStudent_id() + ", '"
				+ student.getStudent_name() + "');";

		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(query);

		System.out.println("Student " + student + " inserted");
	}

	public List<Student> getFiveStudents() {
		return new JdbcTemplate(dataSource).query("select * from student limit 5", new ResultSetExtractor<List<Student>>() {
			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Student> list = new ArrayList<Student>();  

				while(rs.next()) {
					Student student = new Student();  
					student.setStudent_id(rs.getInt(1));  
					student.setStudent_name((rs.getString(2)));  
					list.add(student);
				}
				return list;
			}
		});
	}

	public List<Student> getAllStudents() {
		return new JdbcTemplate(dataSource).query("select * from Student",new RowMapper<Student>(){  
			public Student mapRow(ResultSet rs, int rownumber) throws SQLException {  
				Student student = new Student();
				student.setStudent_id(rs.getInt(1));
				student.setStudent_name(rs.getString(2));  
				return student;
			}  
		});  
	}  
}  
