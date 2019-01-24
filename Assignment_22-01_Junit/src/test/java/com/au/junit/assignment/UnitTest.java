package com.au.junit.assignment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import com.opencsv.CSVReader;

public class UnitTest {
	Student student;
	App app;
	
	@Before
	public void setup() {
		student = new Student();
		app = new App();
	}
	
	@Test
	public void checkReadFromCsv() throws IOException {
		List<Student> studentList = app.readCsv(App.INPUT_FILE);
		assertEquals(100, studentList.size());
	}
	
//	@Test(expected = FileNotFoundException.class)
//	public void checkReadFromWrongFile() throws IOException {
//		List<Student> studentList = null;
//		studentList = app.readCsv(App.WRONG_INPUT_FILE);
//	}
	
	@Test
	public void checkWriteToCsv() throws IOException {
		List<Student> studentList = new ArrayList<Student>();
		
		studentList = app.readCsv(App.INPUT_FILE);
		app.writeCsv(studentList, App.OUTPUT_FILE);
		
		CSVReader csvReader = new CSVReader(new FileReader(App.OUTPUT_FILE));
		String[] record = null;
		int lines = 0;
		
		while ((record = csvReader.readNext()) != null) {	
			lines++;
		}
		
		assertEquals(100, lines);
	}
	
	@Test
	public void checkWriteToCsvMock() throws IOException {
		App appMock = Mockito.mock(App.class);
		List<Student> studentList = app.readCsv(App.INPUT_FILE);
		
		appMock.writeCsv(studentList, App.OUTPUT_FILE);
		
		Mockito.verify(appMock, Mockito.times(1)).writeCsv(studentList, App.OUTPUT_FILE);
	}
	
	@Test(timeout=100)
	public void checkMainMethod() throws Exception {
		App.main(null);
	}
	
	@Test
	public void checkStudentMethods() {
		student = new Student();
		
		student.setStudentId(123456);
		student.setStudentName("Sample");
		student.setStudentAge(20);
		student.setStudentMarks(new ArrayList<Double>() {{ add((double) 90); add((double) 50); }});
		student.setStudentTotal();
		student.setStudentPercentile(140);
		
		assertEquals(123456, student.getStudentId(), 1);
		assertEquals("Sample", student.getStudentName());
		assertEquals(20, student.getStudentAge(), 1);
		assertEquals(2, student.getStudentMarks().size(), 1);
		assertEquals(100, student.getStudentPercentile(), 1);
		
		student.toString();
	}
	
	@Test
	public void checkTopper() throws IOException {
		List<Student> studentList = app.readCsv(App.INPUT_FILE);
		
		app.sortStudents(studentList);
		
		assertEquals("Luther", studentList.get(0).getStudentName());
	}
}
