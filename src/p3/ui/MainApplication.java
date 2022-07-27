package p3.ui;

import p3.dto.EmployeeResponseAccountDTO;
import p3.dto.EmployeeResponseHRDTO;
import p3.exception.InvalidSalaryException;
import p3.model.Employee;
import p3.service.EmployeeService;
import p3.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *		1. Filter employees based on salary
 * 		2. Filter employees based on Project
 * 		3. Update employee salary based on Id
 * 		4. Create employees
 * 		5. Allocate project to employees
 */
public class MainApplication {

	EmployeeService employeeService;
	
	public MainApplication() {
		employeeService = new EmployeeServiceImpl();
	}
	
	public static void main(String[] args) {
		
		MainApplication webportal = new MainApplication();
		
		try {
			
			while(true)
			{
				System.out.println("\n 1. Create Employee ");
				System.out.println("\n 2. Get All Employee");
				System.out.println("\n 3. Get Employee By ID - Accounts ");
				System.out.println("\n 4. Get Employee By ID - HR ");
				System.out.println("\n 5. Filter employees based on salary ");
				System.out.println("\n 6. Filter employees based on Project ");
				System.out.println("\n 7. Update employee salary based on Id ");
				System.out.println("\n 0. EXIT");
				
				System.out.println("\n Enter User Option :- ");
				switch (new Scanner(System.in).nextInt()) 
				{
				
				case 1:
					webportal.createEmployee();
					break;
					
				case 2:
					webportal.renderEmployees();
					break;
					
				case 3:
					webportal.getEmployeeForAccounts();
					break;
					
				case 4:
					webportal.getEmployeeForHR();
					break;
				case 5:{
					webportal.filterEmployeesBasedOnSalary();
					break;
					}
				case 6:{
					webportal.filterEmployeesBasedOnProject();
					break;
				}
				case 7:{
					webportal.updateEmployeeSalaryBasedOnId();
					break;
				}

				default:
					break;
				}//end switch
				
			}//end while
			
			
		} catch (InvalidSalaryException e) {
			System.out.println(e);
		}//end catch
	}//end main

	public void getEmployeeForAccounts()
	{
		System.out.println("Enter Employee ID ");
		int searchId = new Scanner(System.in).nextInt();
		
		EmployeeResponseAccountDTO e = employeeService.getEmployeeForAccountsTeam(searchId);
		
		System.out.println(e);
		
	}
	public void updateEmployeeSalaryBasedOnId()
	{
		System.out.println("Enter Employee ID ");
		int searchId = new Scanner(System.in).nextInt();
		System.out.println("Set salary:");
		int salary = new Scanner(System.in).nextInt();

		Employee e = employeeService.getEmployeeBasedOnId(searchId);
		e.setSalary(salary);
		System.out.println(e);

	}
	public void getEmployeeForHR()
	{
		
		System.out.println("Enter Employee ID ");
		int searchId = new Scanner(System.in).nextInt();
		
		EmployeeResponseHRDTO e = employeeService.getEmployeeForHRTeam(searchId);
		
		System.out.println(e);
	}

	public void filterEmployeesBasedOnSalary()
	{

		System.out.println("Set interval:\n");
		int interval1 = new Scanner(System.in).nextInt();
		int interval2= new Scanner(System.in).nextInt();

		employeeService.getAllEmployees().stream()
				.filter(employee -> employee.getSalary() >= interval1 && employee.getSalary() <= interval2)
				.forEach(employee -> System.out.println(employee));
	}

	public void filterEmployeesBasedOnProject(){
		System.out.println("Select project:\n");
		String str = new Scanner(System.in).nextLine();

		employeeService.getAllEmployees().stream()
				.filter(employee -> employee.getProject().equals("str"))
				.forEach(employee -> System.out.println(employee));
	}
	
	
	
	
	public void renderEmployees()
	{
		List<Employee> allEmployees = employeeService.getAllEmployees();
		
		for (Employee employee : allEmployees) {
			System.out.println(employee);
			System.out.println("\n----------------------------------------\n");
		}
		
	}
	
	public void createEmployee()throws InvalidSalaryException
	{
		 // data comes from HTML form
		int id = new Random().nextInt();
		int bankAccount = new Random().nextInt(1000);
		Employee e = new Employee(id, "D", 1400);
		e.setBankAccount(bankAccount);
		e.setEducation("Angular");
		
		boolean status = employeeService.createEmployee(e);
		
		if(status)
		{
			System.out.println(" Employee Saved ");
		}
		else
		{
			System.out.println(" Contact to Custom Care :- care@abc.com");
		}
		
	}
}
