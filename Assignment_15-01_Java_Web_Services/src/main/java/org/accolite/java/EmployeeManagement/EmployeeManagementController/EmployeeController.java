package org.accolite.java.EmployeeManagement.EmployeeManagementController;

//import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
//
//import org.accolite.java.EmployeeManagementDTO.EmployeeDTO;
//import org.accolite.java.EmployeeManagementServices.EmployeeService;
import javax.xml.bind.annotation.XmlRootElement;

import org.accolite.java.EmployeeManagement.EmployeeManagementServices.EmployeeService;
import org.accolite.java.EmployeeManagement.EmployeeManagementDTO.EmployeeDTO;

@XmlRootElement
class MyJaxBean {
    @XmlElement public String param1;
    @XmlElement public String param2;
}

@Path("empcontroller")
public class EmployeeController {
	static EmployeeService employeeService = new EmployeeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeDTO> getAllEmployee() {
//		System.out.println("\n\n\n\n\n\n\nhello\n\n\n\n\n\n\n\n\n\n");
		return employeeService.getAllEmployees();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeDTO getEmployeeById(@PathParam("id") String id) {
		System.out.println("inside controller" +id);
		return employeeService.getEmployeeById(id);
	}
	
	@POST
	@Path("update")
	@Consumes({"application/xml", "application/json"})
//	@Produces(MediaType.TEXT_PLAIN)
	public String updatePath(EmployeeDTO temp) {
			System.out.println("Update Path "+temp.getEmpName());
			return employeeService.updateEmployee(temp);
	}
}
