package p3.service;

import p3.dto.EmployeeResponseAccountDTO;
import p3.dto.EmployeeResponseHRDTO;
import p3.exception.InvalidSalaryException;
import p3.model.Employee;

import java.util.List;


public interface EmployeeService {
	
	public boolean createEmployee(Employee e)throws InvalidSalaryException;
	public Employee getEmployeeBasedOnId(int id);
	public List<Employee> getEmployeeBasedOnProject(String projectName);
	public List<Employee> getAllEmployees();
	
	// ----- accessed by Accounts team 
	
		public EmployeeResponseAccountDTO getEmployeeForAccountsTeam(int id);
		
		
	// ----- accessed by HR team 
		
		public EmployeeResponseHRDTO getEmployeeForHRTeam(int id);
		
		
		

}


