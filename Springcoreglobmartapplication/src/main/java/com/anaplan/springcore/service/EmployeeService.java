package com.anaplan.springcore.service;

import java.util.List;

import com.anaplan.springcore.entity.Employee;


public interface EmployeeService {
	void addEmployee(Employee employee);
    Employee getEmployeeById(int empId);
    
    /*
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByRole(String role);
    
    */
    
}
