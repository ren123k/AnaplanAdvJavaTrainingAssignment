package com.anaplan.springcore.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anaplan.springcore.entity.Employee;
import com.anaplan.springcore.service.EmployeeService;

@Repository
public class EmployeeServiceDao implements EmployeeService {
	
	
    private Map<Integer, Employee> employees;

    public EmployeeServiceDao() {
        employees = new HashMap<>();
    }

	@Override
	public void addEmployee(Employee employee) {
		
		// TODO Auto-generated method stub
		
		employees.put(employee.getEmpId(), employee);
    }
	

	@Override
	public Employee getEmployeeById(int empId) {
		
		// TODO Auto-generated method stub
		
		return employees.get(empId);
		
	}


	
	

	/*
	@Override
	public List<Employee> getAllEmployees() {
		
		// TODO Auto-generated method stub
	        return new ArrayList<>(employees.values());	
	}
	

	@Override
	public List<Employee> getEmployeesByRole(String role) {
		// TODO Auto-generated method stub
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees.values()) {
            if (employee.getRole().equalsIgnoreCase(role)) {
                result.add(employee);
            }
        }
        return result;
    }
    */
    
}
