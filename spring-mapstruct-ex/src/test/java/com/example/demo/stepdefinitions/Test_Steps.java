package com.example.demo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Steps {
	
	
	  @Given("Admin is on login page") public void admin_is_on_login_page() {
	  System.out.println("Inside step-customer login page"); 
	  //throw new io.cucumber.java.PendingException(); 
	  }
	  
	  @When("Admin enters the customer details") public void
	  admin_enters_the_customer_details() {
	  System.out.println("Inside step-customer details page"); 
	  //throw new io.cucumber.java.PendingException();
	  }
	  
	  @When("Clicks on post button") public void clicks_on_post_button() {
	  System.out.println("Inside step-customer clicks post button on  page");
	  //throw new io.cucumber.java.PendingException();
	  }
	  
	  @Then("Admin is notified") public void admin_is_notified() {
	  System.out.println("Inside step-customer details added and Admin notified");
	  //throw new io.cucumber.java.PendingException(); 
	  }
	 
}
