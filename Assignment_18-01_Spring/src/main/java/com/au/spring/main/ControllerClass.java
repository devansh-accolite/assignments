package com.au.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.spring.dao.StudentDao;
import com.au.spring.model.Student;

@Controller
public class ControllerClass {	
	@RequestMapping(value = "/addStudentForm")
	public String addStudentForm() {
		return "addStudentForm";
	}
	
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addStudentMVC(@ModelAttribute("student") Student student) {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml"); 
		StudentDao studentDao = classPathXmlApplicationContext.getBean(StudentDao.class);
		studentDao.saveStudent(student);
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add("Content-Type", "text/plain;charset=UTF-8");
		return new ResponseEntity<String>("Student data added to DB", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/showStudents", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> showStudentsMVC(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml"); 
		StudentDao studentDao = classPathXmlApplicationContext.getBean(StudentDao.class);
		studentList = studentDao.getAllStudents();
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add("Content-Type", "text/plain;charset=UTF-8");

		String resp = "";
		for(Student s: studentList) {
			resp += s + "\n";
		}
		
		System.out.println(resp);
		
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}
}
