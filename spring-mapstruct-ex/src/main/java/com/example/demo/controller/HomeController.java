package com.example.demo.controller;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomerNotAddedException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.HealthCheckFailed;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServiceImpl;


@RestController
@RequestMapping("/appone")
public class HomeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CustomerServiceImpl customerservice;
	
	
    @GetMapping("/home")
    String home() {
        LOG.info("sending hello response");
        return "Hello! This is home page";
    }
	
	@GetMapping("/healthcheck")
	public ResponseEntity<String> healthCheck() throws HealthCheckFailed{
		
		LOG.info("Health check called");
		String healthcheckstatus=customerservice.healthCheckMethod();
		ResponseEntity<String> response=new ResponseEntity<String>("Health Check Succefull", HttpStatus.OK);
		return response;
	
	}
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer( @Validated @RequestBody Customer customer) throws CustomerNotAddedException {
		
		LOG.info("Post mapping called for customer:"+customer.getCustomerId());
		Customer addedCustomer=customerservice.addCustomer(customer);
		ResponseEntity<Customer> response=new ResponseEntity<Customer>(addedCustomer, HttpStatus.OK);
		LOG.info(addedCustomer.getCustomerName()+" added");
		return response;
	
	}
	
	@GetMapping("/showcustomers")
	public ResponseEntity<List<Customer>> showAllCustomers() throws CustomerNotFoundException{
		
		LOG.info("Get mapping called for all customers");
		List<Customer> customerlist=customerservice.showAllEntries();
		LOG.info("Customer List fetched");
		return ResponseEntity.ok(customerlist);

	}
	
	@GetMapping("/showcustomerId")
	public ResponseEntity<Customer> showCustomerByID(int id) throws CustomerNotFoundException{
		
		LOG.info("Get mapping called for customer by id");
		Customer customer =customerservice.showEntry(id);
		LOG.info("Customer fetched");
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);

	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) throws ServiceException, CustomerNotFoundException {
		LOG.info("Inside deleteEmployee method");
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerservice.deleteEmployeeById(id));
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity updateCustomer(@Validated @RequestBody Customer customer) throws CustomerNotFoundException {
		LOG.info("Put mapping called for "+customer.getCustomerId());
		
		Customer customervo=customerservice.updateCustomer(customer);
		ResponseEntity<Customer> response=new ResponseEntity<Customer>(customervo, HttpStatus.OK);
		LOG.info(customervo.getCustomerName()+" updated");
		return response;
		
	}

}
