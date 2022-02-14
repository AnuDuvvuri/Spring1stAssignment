package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.CustomerNotAddedException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.HealthCheckFailed;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

public interface CustomerService {
	public Customer addCustomer(Customer customer) throws CustomerNotAddedException;
	public List<Customer> showAllEntries() throws CustomerNotFoundException;
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;
	public String healthCheckMethod() throws HealthCheckFailed;
	public Customer showEntry (int id) throws CustomerNotFoundException;
	String deleteEmployeeById(int id) throws CustomerNotFoundException;
}
