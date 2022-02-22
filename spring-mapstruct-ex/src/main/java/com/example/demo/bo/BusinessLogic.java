package com.example.demo.bo;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.CustomerDto;
import com.example.demo.repository.CustomerRepository;

import lombok.extern.log4j.Log4j;
@Log4j
@Component
public class BusinessLogic {
	@Autowired
	CustomerRepository customerrepository;
	Logger logger = LogManager.getLogger(BusinessLogic.class);

	public List<CustomerDto> callDBForHealthCheck() {
		List<CustomerDto> customerdtolist = customerrepository.findAll();
		return customerdtolist;

	}

	public List<CustomerDto> showAllEntries() throws CustomerNotFoundException {

		logger.info("showAllEntries called in service layer");

		List<CustomerDto> customerdtolist = customerrepository.findAll();
		if (customerdtolist.isEmpty()) {
			throw new CustomerNotFoundException();
		}

		return customerdtolist;

	
	}
	
	public CustomerDto showEntry(int id) throws CustomerNotFoundException {

		//LOG.info("showAllEntries called in service layer");

		Optional<CustomerDto> customerdto = customerrepository.findById(id);
		if (customerdto.isPresent()) {
			throw new CustomerNotFoundException();
		}


		return customerdto.get();

	}

}
