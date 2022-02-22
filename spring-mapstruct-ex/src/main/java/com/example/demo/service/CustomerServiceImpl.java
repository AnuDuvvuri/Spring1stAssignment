package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bo.BusinessLogic;
import com.example.demo.controller.HomeController;
import com.example.demo.exception.CustomerNotAddedException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.HealthCheckFailed;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private  CustomerMapper customerMapper;
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	BusinessLogic customerBO;
	@Autowired
	CustomerRepository customerrepository;
	/*
	 * Method to add a new customer
	 */
	
	
	/*
	 * Method to show all customers
	 */
	@Override
	public List<Customer> showAllEntries() throws CustomerNotFoundException {
		
		 LOG.info("showAllEntries called in service layer");
		 
			
			  List<CustomerDto> customerdtolist = customerrepository.findAll(); 
			  if(customerdtolist.isEmpty()) { throw new CustomerNotFoundException(); }
			  Iterator<CustomerDto> dtoiterator = customerdtolist.iterator();
			  List<Customer> customervolist = new ArrayList<Customer>();
			  
			  while (dtoiterator.hasNext()) {
			  customervolist.add(customerMapper.fromDto(dtoiterator.next())); }
			  
			  return customervolist;
	
	}

	/*
	 * Method to update a Customer
	 */

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		/*
		 * LOG.info("updateCustomer called in service layer"); Customer customertemp =
		 * null; CustomerDto customerdto = customerMapper.toDto(customer);
		 * 
		 * Optional<CustomerDto> customerdtoretrieved =
		 * customerrepository.findById(customerdto.getCustomerId());
		 * 
		 * if (customerdtoretrieved.isEmpty()) { throw new CustomerNotFoundException();
		 * }
		 * 
		 * customerdto = customerrepository.save(customerdto); customertemp =
		 * customerMapper.fromDto(customerdto); return customertemp;
		 */
		return null;
	}

	@Override
	public String healthCheckMethod() throws HealthCheckFailed {
		LOG.info("Health check called in service layer");
		List<CustomerDto> customerdtolist = customerBO.callDBForHealthCheck();
		if (customerdtolist.isEmpty()) {
			throw new HealthCheckFailed();
		}
		return "Health check Succesfull";
	}
	@Override
	public String deleteEmployeeById(int id) throws  ServiceException, CustomerNotFoundException {
		try {if (customerrepository.existsById(id)) {
			customerrepository.deleteById(id);
		} else

			throw new CustomerNotFoundException();}
		catch(CustomerNotFoundException e) {
			throw e;
		}
		return "employee deleted";
	}
	
	

	@Override
	public Customer showEntry(int id) throws CustomerNotFoundException {
		Customer customer = customerMapper.fromDto(customerBO.showEntry(id));
		return customer;
	}

	@Override
	public Customer addCustomer(Customer customer) throws CustomerNotAddedException {
		 LOG.info("addCustomer called in service layer"); 
	
		  CustomerDto savecustomer=customerrepository.save(customerMapper.toDto(customer));
		  
		  CustomerDto customerdtoadded;
		  return customerMapper.fromDto(savecustomer); 
		 
		
	}

	

		  
		  
	/*
	 * @Override public com.example.demo.model.Customer
	 * addCustomerDto(com.example.demo.model.Customer customer) throws
	 * com.example.demo.exception.CustomerNotAddedException { // TODO Auto-generated
	 * method stub return null; }
	 */

	/*
	 * @Override public com.example.demo.model.Customer
	 * updateCustomer(com.example.demo.model.Customer customer) throws
	 * com.example.demo.exception.CustomerNotFoundException { // TODO Auto-generated
	 * method stub return null; }
	 */

}
