  package com.example.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.HomeController;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;


//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
    class SpringMapstructExApplicationTests 
    {
    
  	private MockMvc mockMvc; 
  	ObjectMapper objectMapper = new ObjectMapper();
  	@Mock
  	private CustomerService customerService;
  	@InjectMocks
  	 private HomeController homeController;
  	@MockBean 
  	  private CustomerRepository customerRepository;
  	
  	@Test
    public void addCustomerTest() throws Exception {
    Customer customer = new Customer(11,"Anu");
    String jsonRequest = objectMapper.writeValueAsString(customer);
    Mockito.when(customerService.addCustomer(customer)).thenReturn(customer);
    mockMvc.perform(MockMvcRequestBuilders.post("/appone/addCustomer").content(jsonRequest)
    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isCreated());
    }
    }
  	  