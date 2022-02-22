package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//import lombok.Data;

//@Data
@Entity
public class CustomerDto {

	public CustomerDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerDto(int customerId, String customerName) {
		//super();
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Id
	private int customerId;
	private String customerName;
	
	

}
