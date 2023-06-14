package com.anaplan.springcore.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anaplan.springcore.entity.Employee;
import com.anaplan.springcore.entity.Loan;
import com.anaplan.springcore.service.EmployeeService;
import com.anaplan.springcore.service.LoanService;

public class LoanServiceDao implements LoanService{
	
	private Map<Integer, Employee> employeeMap;
	
	private Map<Integer, Loan> loans;

    public LoanServiceDao(EmployeeService employeeService) {
    	
        loans = new HashMap<>();
    }
    

	@Override
	public void addLoan(Loan loan) {
		// TODO Auto-generated method stub
		
        loans.put(loan.getLoanId(), loan);
	}

	public Loan getLoan(int loanId) {
        return loans.get(loanId);
    }
	
	@Override
	public Loan getLoanById(int loanId) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Loan> getAllLoans() {
		// TODO Auto-generated method stub
		
		return new ArrayList<>(loans.values());
	}

	@Override
	public List<Loan> getLoansByEmployee(int empId) {
		// TODO Auto-generated method stub
		
		 List<Loan> result = new ArrayList<>();
	        for (Loan loan : loans.values()) {
	            if (loan.getEmpId() == empId) {
	                result.add(loan);
	            }
	        }
	        return result;
	}

}
