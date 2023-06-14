package com.anaplan.springcore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.anaplan.springcore.dao.EmployeeServiceDao;
import com.anaplan.springcore.dao.LoanServiceDao;
import com.anaplan.springcore.entity.Address;
import com.anaplan.springcore.entity.Employee;
import com.anaplan.springcore.entity.Loan;
import com.anaplan.springcore.service.EmployeeService;
import com.anaplan.springcore.service.LoanService;
import com.anaplan.springcore.service.config.AppConfig;
import com.anaplan.springcore.service.impl.ManageEmployeeAndLoanDetatils;

public class App {
  public static void main(String[] args) {
	  
	  
      ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      EmployeeService employeeService = context.getBean(EmployeeService.class);
      LoanService loanService = context.getBean(LoanService.class);
	  
      
	  employeeService = new EmployeeServiceDao();
      loanService = new LoanServiceDao(employeeService);
      
      ManageEmployeeAndLoanDetatils ManageEmployeeAndLoanDetatils = new ManageEmployeeAndLoanDetatils(employeeService, loanService);

      // Adding employees
      Employee employee1 = new Employee(1, "Renuka", "Kumari", "Manager", "IT", new Address("Ranchi", "Jh", 12345,
    		  new Loan(01, 101, 25000.0, 500.10, 4, 2500.0, "open")));
      
      
      Employee employee2 = new Employee(2, "Dipu", "Deepak", "GM", "IT", new Address("Mumbai", "MH", 120911,
    		  new Loan(01, 101, 25000.0, 500.10, 4, 2500.0, "close")));
      
      
      Employee employee3 = new Employee(3, "Deepak", "Dipu", "Manager", "NON IT", new Address("CH", "BH", 1234,
    		  new Loan(01, 101, 25000.0, 500.10, 4, 2500.0, "open")));
      
      
      Employee employee4 = new Employee(4, "Jane", "Smith", "Developer", "IT", new Address("City", "State", 12345,
    		  new Loan(01, 101, 25000.0, 500.10, 4, 2500.0,"close")));
      
      employeeService.addEmployee(employee1);
      employeeService.addEmployee(employee2);
      employeeService.addEmployee(employee3);
      employeeService.addEmployee(employee4);
      
      /*
      // Getting the employee details
      System.out.println(ManageEmployeeAndLoanDetatils.addEmployee(1));
      System.out.println(ManageEmployeeAndLoanDetatils.addEmployee(2));
      System.out.println(ManageEmployeeAndLoanDetatils.addEmployee(3));
      System.out.println(ManageEmployeeAndLoanDetatils.addEmployee(4));
      
      

      // Check loan eligibility
      System.out.println(ManageEmployeeAndLoanDetatils.isLoanEligible(employee1));
      System.out.println(ManageEmployeeAndLoanDetatils.isLoanEligible(employee2));
      System.out.println(ManageEmployeeAndLoanDetatils.isLoanEligible(employee3));
      System.out.println(ManageEmployeeAndLoanDetatils.isLoanEligible(employee4));
      
      
      */
      
      
      
      Employee retrievedEmployee =employeeService.getEmployeeById(2);
      if (retrievedEmployee!= null) {
          System.out.println("Printing the Employee Details:\n");
          System.out.println("Employee ID: " + retrievedEmployee.getEmpId());
          System.out.println("Employee Name: " + retrievedEmployee.getFirstName() + " " + retrievedEmployee.getLastName());
          System.out.println("Role: " + retrievedEmployee.getRole());
          // ... other details
      } else {
          System.out.println("Employee not found.");
      }

      // Check loan eligibility
      boolean isEligible = ManageEmployeeAndLoanDetatils.isLoanEligible(retrievedEmployee);
      if (isEligible) {
          System.out.println("Employee is eligible for a loan."+retrievedEmployee.getFirstName());
      } else {
          System.out.println("Employee is not eligible for a loan.");
      }

      
      
  
  }	  
}
