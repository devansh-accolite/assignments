package org.accolite.java.EmployeeManagement.EmployeeManagementDTO;

public class EmployeeDTO {
	private String empId, empName;
	private int empAge;

	public EmployeeDTO() {}
	
	public EmployeeDTO(String empName, String empId, int empAge) {
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
	}
	
	public String getEmpName() {
		return this.empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String getEmpId() {
		return this.empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public int getEmpAge() {
		return this.empAge;
	}
	
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	
	@Override
	public String toString() {
		return this.empName + ", " + this.empId + ", " + this.empAge;
//		return "hello";
	}
}
