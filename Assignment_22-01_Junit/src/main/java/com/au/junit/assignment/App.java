package com.au.junit.assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class App {
	public static final String INPUT_FILE = "data.csv";
	public static final String OUTPUT_FILE = "out.csv";
	public static final String WRONG_INPUT_FILE = "wrong_file.csv";
	public static double maxTotal;

	public List<Student> readCsv(String fileName) throws IOException {
		List<Student> studentList = new ArrayList<>();
		List<Double> marks;

		Student student;
		
		CSVReader csvReader = new CSVReader(new FileReader(fileName));
		String[] record = null;
		
		while ((record = csvReader.readNext()) != null) {
			student = new Student();
			student.setStudentId(Double.parseDouble(record[0]));
			student.setStudentName(record[1]);
			student.setStudentAge(Double.parseDouble(record[2]));
			marks = new ArrayList<>();
			marks.add(Double.parseDouble(record[4]));
			marks.add(Double.parseDouble(record[6]));
			student.setStudentMarks(marks);
			student.setStudentTotal();
			studentList.add(student);
		}
		return studentList;
	}

	public void writeCsv(List<Student> studentList, String fileName) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

		int i = 1;
		String records = "";
		for (Student s : studentList) {
			records += i + ", " + s.getStudentId() + ", " + s.getStudentName() + ", " + s.getStudentPercentile() + ", " + s.getStudentAge() + "\n";
			i++;
		}

		bufferedWriter.write(records);
		bufferedWriter.close();
	}
	
	public void sortStudents(List<Student> studentList) {
		for (Student s : studentList) {
			App.maxTotal = (s.getStudentTotal() > App.maxTotal) ? s.getStudentTotal() : App.maxTotal;
		}
		for (Student s : studentList) {
			s.setStudentPercentile(App.maxTotal);
		}

		Collections.sort(studentList, new StudentComp());
	}

	public static void main(String args[]) throws Exception {
		App app = new App();

		App.maxTotal = 0;
		List<Student> studentList = app.readCsv(INPUT_FILE);

		app.sortStudents(studentList);
		
		app.writeCsv(studentList, OUTPUT_FILE);
	}
}

class StudentComp implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getStudentPercentile() < o2.getStudentPercentile()) {
			return 1;
		} else if (o1.getStudentPercentile() == o2.getStudentPercentile()) {
			return 0;
		} else {
			return -1;
		}
	}
}
