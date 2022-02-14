package com.example.demo.BO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;
import com.example.demo.repository.CustomerRepository;

@Component
public class BusinessLogic {
	@Autowired
	CustomerRepository customerrepository;

	public List<CustomerDto> callDBForHealthCheck() {
		List<CustomerDto> customerdtolist = customerrepository.findAll();
		return customerdtolist;

	}

	public List<CustomerDto> showAllEntries() throws CustomerNotFoundException {

		// LOG.info("showAllEntries called in service layer");

		List<CustomerDto> customerdtolist = customerrepository.findAll();
		if (customerdtolist.isEmpty()) {
			throw new CustomerNotFoundException();
		}
//		Iterator<CustomerDto> dtoiterator = customerdtolist.iterator();
//		List<Customer> customervolist = new ArrayList<Customer>();

//		while (dtoiterator.hasNext()) {
//			customervolist.add(customerMapper.fromDto(dtoiterator.next()));
//		}

		return customerdtolist;

		// return null;
	}
	
	public CustomerDto showEntry(int id) throws CustomerNotFoundException {

		// LOG.info("showAllEntries called in service layer");

		Optional<CustomerDto> customerdto = customerrepository.findById(id);
		if (customerdto.isPresent()) {
			throw new CustomerNotFoundException();
		}
//		Iterator<CustomerDto> dtoiterator = customerdtolist.iterator();
//		List<Customer> customervolist = new ArrayList<Customer>();

//		while (dtoiterator.hasNext()) {
//			customervolist.add(customerMapper.fromDto(dtoiterator.next()));
//		}

		return customerdto.get();

		// return null;
	}

}
