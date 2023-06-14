package com.anaplan.springcore.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.anaplan.springcore.entity.Employee;
import com.anaplan.springcore.entity.Loan;
import com.anaplan.springcore.service.EmployeeService;
import com.anaplan.springcore.service.LoanService;


public class ManageEmployeeAndLoanDetatils {
	
	private EmployeeService employeeService;
    private LoanService loanService;
    
    @Autowired
	public ManageEmployeeAndLoanDetatils(EmployeeService employeeService, LoanService loanService) {
		super();
		this.employeeService = employeeService;
		this.loanService = loanService;
	}
	
	public void addEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

	
	/*
    public Employee getEmployee(int empId) {
        return employeeService.getEmployeeById(empId);
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public List<Employee> getEmployeesByRole(String role) {
        return employeeService.getEmployeesByRole(role);
    }
    */
	
	
    
    
 
    public boolean isLoanEligible(Employee employee) {
    	
        // I am checking the Employee is eligible for applying the loan or not 
    	
    	// Manager" and "GM" roles are not eligible for applying for a loan
    	
    	if (employee.getRole().equalsIgnoreCase("Manager") || employee.getRole().equalsIgnoreCase("GM")) {
            return false;
        }

    	
    	//If an employee already has taken a loan and it is still not closed also not eligible for the loan
    	
        List<Loan> loans = loanService.getLoansByEmployee(employee.getEmpId());
        for (Loan loan : loans) {
            if (loan.getStatus().equalsIgnoreCase("open")) {
                return false;
            }
        }

        return true;
    }

	
    
    /*
	
	   

    public boolean isLoanEligible(int empId) {
        Employee employee = employeeService.getEmployee(empId);
        if (employee == null) {
            return false; // Employee not found
        }

        String role = employee.getRole();
        if (role.equals("Manager") || role.equals("GM")) {
            return false; // Manager and GM roles are not eligible
        }

        // Check if employee already has an open loan

        return true; // Employee is eligible for a loan
    }
    */

}
