package com.example.demo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.CustomerNotAddedException;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.ServiceException;

@ControllerAdvice
public class CustomerControllerExcHandler {

	@ExceptionHandler(CustomerNotAddedException.class)
	public ResponseEntity<String> handleCustomerNotAddedException(CustomerNotAddedException customerNotAddedException){
		return new ResponseEntity<String>("Customer not found with given id", HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException noRecordFoundException){
		return new ResponseEntity<String>("No records found",HttpStatus.BAD_REQUEST);
	}
	/*
	 * @ExceptionHandler(ServiceException.class) public ResponseEntity<String>
	 * handleServiceException (ServiceException serviceException){ return new
	 * ResponseEntity<String>("No records found",HttpStatus.BAD_REQUEST); }
	 */
}
