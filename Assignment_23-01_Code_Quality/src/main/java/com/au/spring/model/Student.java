package com.au.spring.model;

public class Student {
	private int studentId;
	private String studentName;
	
	public static final String STUDENT_NAME = "name";
	
	/**
	 * Gets the student id.
	 *
	 * @return the student id
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * Sets the student id.
	 *
	 * @param studentId the new student id
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Gets the student name.
	 *
	 * @return the student name
	 */
	public String getStudentName() {
		return studentName;
	}
	
	/**
	 * Sets the student name.
	 *
	 * @param studentName the new student name
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
}
