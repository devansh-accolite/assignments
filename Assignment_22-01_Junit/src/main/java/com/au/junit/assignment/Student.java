package com.au.junit.assignment;

import java.util.List;

public class Student {
	private double studentId, studentAge, studentTotal;
	private float studentPercentile;
	private String studentName;
	private List<Double> studentMarks;
	
	public double getStudentId() {
		return studentId;
	}
	
	public void setStudentId(double studentId) {
		this.studentId = studentId;
	}
	
	public double getStudentAge() {
		return studentAge;
	}
	
	public void setStudentAge(double studentAge) {
		this.studentAge = studentAge;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public List<Double> getStudentMarks() {
		return studentMarks;
	}
	
	public void setStudentMarks(List<Double> studentMarks) {
		this.studentMarks = studentMarks;
	}
	
	public double getStudentTotal() {
		return studentTotal;
	}
	
	public void setStudentTotal() {
		double t = 0;
		for(Double i: studentMarks) {
			t += i;
		}
		
		this.studentTotal = t;
	}
	
	public float getStudentPercentile() {
		return studentPercentile;
	}
	
	public void setStudentPercentile(double maxTotal) {
		this.studentPercentile = (float) (this.getStudentTotal() * 100 / maxTotal);
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentAge=" + studentAge + ", studentTotal=" + studentTotal
				+ ", studentPercentile=" + studentPercentile + ", studentName=" + studentName + ", studentMarks="
				+ studentMarks + "]";
	}
}
