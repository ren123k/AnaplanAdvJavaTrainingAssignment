package com.anaplan.springcore.service.config;

import org.springframework.context.annotation.Bean;

import com.anaplan.springcore.dao.EmployeeServiceDao;
import com.anaplan.springcore.dao.LoanServiceDao;
import com.anaplan.springcore.service.EmployeeService;
import com.anaplan.springcore.service.LoanService;

public class AppConfig {
	
	 @Bean
	    public EmployeeService employeeService() {
	        return new EmployeeServiceDao();
	    }

	    @Bean
	    public LoanService loanService(EmployeeService employeeService) {
	        return new LoanServiceDao(employeeService);
	    }

}
