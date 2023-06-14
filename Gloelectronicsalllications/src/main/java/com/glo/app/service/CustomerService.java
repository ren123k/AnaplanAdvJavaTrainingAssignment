package com.glo.app.service;

import java.util.List;
import java.util.Optional;

import com.glo.app.model.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomers();
    Optional<Customer> findById(int id);
    Customer addCustomer(Customer customer);
    void deleteById(int id);

}
