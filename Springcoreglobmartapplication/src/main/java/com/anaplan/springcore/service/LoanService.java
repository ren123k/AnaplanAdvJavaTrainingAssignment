package com.anaplan.springcore.service;

import java.util.List;

import com.anaplan.springcore.entity.Loan;

public interface LoanService {
	
	void addLoan(Loan loan);
    Loan getLoanById(int loanId);
    List<Loan> getAllLoans();
    List<Loan> getLoansByEmployee(int empId);

}

