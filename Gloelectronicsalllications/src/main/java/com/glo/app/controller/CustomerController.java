package com.glo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glo.app.exception.CustomerNotFoundException;
import com.glo.app.model.Customer;
import com.glo.app.service.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	 
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
    @GetMapping(value="/customer")
    public List<Customer> getAllCustomers(){
        return customerServiceImpl.getAllCustomers();
    }           
    
    
    @GetMapping(value="/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") int id) {
        Customer customer =customerServiceImpl.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with "+id+" is Not Found!"));
        return customer;
    }           
    @PostMapping(value="/customer")
    public Customer addCustomer(@Validated @RequestBody Customer customer) {
        return customerServiceImpl.addCustomer(customer);
    }           
    
    
    @PutMapping(value="/customer/{id}")
    public Customer updateCustomer(@PathVariable("id") int id, @Validated @RequestBody Customer  newCustId) {
        Customer customer = customerServiceImpl.findById(id)
                                     .orElseThrow(()->new CustomerNotFoundException("Customer with "+id+" is Not Found!"));
        customer.setCustomerId(newCustId.getCustomerId());
        customer.setCustomerName(newCustId.getCustomerName());
        return customerServiceImpl.addCustomer(customer); 
    }           
    
    
    
    
    @DeleteMapping(value="/customer/{id}")
    public String deleteCustomerById(@PathVariable("id")  int id) {
        Customer customer = customerServiceImpl.findById(id)
                                     .orElseThrow(()->new CustomerNotFoundException("CUstomer with "+id+" is Not Found!"));
        customerServiceImpl.deleteById(customer.getCustomerId());
        return "Customer with ID :"+id+" is deleted";            
    }
}
