package org.accolite.java.EmployeeManagement.EmployeeManagementServices;

import java.util.ArrayList;
import java.util.List;

//import org.accolite.java.EmployeeManagementDTO.EmployeeDTO;;

import org.accolite.java.EmployeeManagement.EmployeeManagementDTO.EmployeeDTO;

public class EmployeeService {
	public List<EmployeeDTO> employeeList = new ArrayList<>();
	
	public EmployeeService() {
		employeeList.add(new EmployeeDTO("abc", "1", 20));
		employeeList.add(new EmployeeDTO("def", "2", 30));
		employeeList.add(new EmployeeDTO("ghi", "3", 40));
	}
	
	public List<EmployeeDTO> getAllEmployees() {
		return employeeList;
	}
	
	public EmployeeDTO getEmployeeById(String empId) {
		for(EmployeeDTO edto : employeeList) {
//			System.out.println("inside service" + edto.getEmpId());
//			System.out.println("abc " + edto.toString());
			System.out.println(edto.getEmpId().compareTo(empId));
			if(edto.getEmpId().compareTo(empId) == 0) {
				return edto;
			}
			System.out.println("inside service" + edto.getEmpId());
		}
		return null;
	}
	
	public String updateEmployee(EmployeeDTO em) {
		String id = em.getEmpId();
		for(EmployeeDTO edto : employeeList) {
			if(edto.getEmpId().compareTo(id) == 0) {
				edto.setEmpId(em.getEmpId());
				edto.setEmpName(em.getEmpName());
				edto.setEmpAge(em.getEmpAge());
				
				return "Updated data for employee " + id;
			}
		}
		
		return "ID not found";
	}
}
