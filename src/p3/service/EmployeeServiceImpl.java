package p3.service;

import p3.databasemock.MyDataBase;
import p3.dto.EmployeeResponseAccountDTO;
import p3.dto.EmployeeResponseHRDTO;
import p3.exception.InvalidSalaryException;
import p3.model.Employee;
import p3.util.DTOConvertor;
import p3.util.ValidateEmployee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

	ValidateEmployee validateEmployee;
	
	
	public EmployeeServiceImpl() {
		validateEmployee = new ValidateEmployee();
		
	}	
	
	
	@Override
	public boolean createEmployee(Employee e) throws InvalidSalaryException {
		
		//1. validate Employee 
		
		boolean isValid = validateEmployee.validateEmployeeSalary(e);
		
		
		// 2. if return true then save employee
		
		if(isValid)
		{
			boolean isSaved = MyDataBase.addEmployee(e);
			return isSaved;
					
		}
		// 3. if return false throw an exception
		else
		{
			throw new InvalidSalaryException("Salary of Employee Cannnot be less than 1000 , given :- "+e.getSalary());
		}
		
		
	}

	@Override
	public Employee getEmployeeBasedOnId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployeeBasedOnProject(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return MyDataBase.getAllEmployees();
	}


	@Override
	public EmployeeResponseAccountDTO getEmployeeForAccountsTeam(int id) {
		Employee e = MyDataBase.getEmployeeBasedOnId(id);
		return DTOConvertor.convertEmployeeToAccountDTO(e);
	}


	@Override
	public EmployeeResponseHRDTO getEmployeeForHRTeam(int id) {
		Employee e = MyDataBase.getEmployeeBasedOnId(id);
		return DTOConvertor.convertEmployeeToHRDTO(e);
	}

	
	
	
	
	
}



















