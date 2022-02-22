package com.example.demo.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@AllArgsConstructor
@NoArgsConstructor*/
public class Customer {
	
	private int customerId;
	private String customerName;

	public Customer(int i, String string) {
		// TODO Auto-generated constructor stub
	}
	public Customer() {
		// TODO Auto-generated constructor stub
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

}
