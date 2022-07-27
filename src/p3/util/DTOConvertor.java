package p3.util;


import p3.dto.EmployeeResponseAccountDTO;
import p3.dto.EmployeeResponseHRDTO;
import p3.model.Employee;

public class DTOConvertor {
	
	public static EmployeeResponseAccountDTO convertEmployeeToAccountDTO(Employee e)
	{
		return new EmployeeResponseAccountDTO(e.getId(),e.getName(), e.getBankAccount());
	}
	
	public static EmployeeResponseHRDTO convertEmployeeToHRDTO(Employee e)
	{
		return new EmployeeResponseHRDTO(e.getId(),e.getName(), e.getEducation()); 
	}
	
	

}
