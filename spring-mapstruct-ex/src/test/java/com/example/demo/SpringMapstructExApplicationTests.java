/*
 * package com.example.demo;
 * 
 * import static org.mockito.Mockito.when; import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.apache.logging.log4j.core.util.Assert; import
 * org.junit.jupiter.api.BeforeAll; import org.junit.jupiter.api.Test; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders;
 * 
 * import com.example.demo.controller.HomeController; import
 * com.example.demo.model.Customer; import com.example.demo.model.CustomerDto;
 * import com.example.demo.repository.CustomerRepository; import
 * com.example.demo.service.CustomerService; import
 * com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * 
 * @SpringBootTest //@TestInstance(Lifecycle.PER_CLASS) class
 * SpringMapstructExApplicationTests {
 * 
 * 
 * private MockMvc mockMvc;
 * 
 * 
 * 
 * ObjectMapper objectMapper = new ObjectMapper();
 * 
 * @Mock private CustomerService custService;
 * 
 * @InjectMocks private HomeController homeController;
 * 
 * @MockBean private CustomerRepository customerRepository;
 * 
 * @BeforeAll private void setUp() { mockMvc =
 * MockMvcBuilders.standaloneSetup(homeController).build(); }
 * 
 * @Test public void addCustomerTest() throws Exception { Customer custDto = new
 * CustomerDto(13,"Anusha"); String jsonRequest =
 * objectMapper.writeValueAsString(custDto);
 * Mockito.when(custService.addCustomer(custDto)).thenReturn(custDto);
 * mockMvc.perform(MockMvcRequestBuilders.post("/employee/addEmployee").content(
 * jsonRequest)
 * .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
 * .andExpect(status().isCreated());
 * 
 * }
 * 
 * @Test public void getCustomerByIdTest() throws Exception { CustomerDto
 * custDto = new CustomerDto(12,"eee");
 * when(customerRepository.findById(12)).thenReturn(Optional.of(custDto));
 * Mockito.when(custService.get(Mockito.anyInt())).thenReturn(custDto);
 * mockMvc.perform(MockMvcRequestBuilders.post("/customer/showcustomerId").
 * content(jsonRequest)
 * //mockMvc.perform(get("/employee/getEmployeeById/5")).andExpect(jsonPath(
 * "employeeName", is("ram"))); }
 * 
 * 
 * @Test public void getProductById() throws Exception {
 * 
 * Product product = new Product(12, "Mobile", "good", 5, 1000L);
 * when(productRepository.findById(12)).thenReturn(Optional.of(product));
 * assertEquals(product, productService.getProductWithId(12));
 * 
 * 
 * mockMvc.perform(MockMvcRequestBuilders.get("/api/products/{id}", 12)
 * .accept(MediaType.APPLICATION_JSON)).andDo(print())
 * .andExpect(status().isOk());
 * 
 * 
 * }
 * 
 * @Test public void getEmployees() throws Exception { List<CustomerDto>
 * customerDto=new ArrayList<CustomerDto>(); CustomerDto custDto1 = new
 * CustomerDto( 7,"Asish"); CustomerDto custDto2 = new CustomerDto(8,
 * "Abijith");
 * 
 * CustomerDto.add(custDto2); CustomerDto.add(custDto1);
 * Mockito.when(employeeService.employeeList()).thenReturn(employeeDto);
 * mockMvc.perform(get("/employee/getAllEmployee")).andExpect(status().isOk()).
 * andReturn(); Assert.assertEquals(employeeDto.size(), 2);
 * 
 * }
 * 
 * @Test public void deleteEmployeeById() throws Exception { CustomerDto empDto2
 * = new CustomerDto(4,"ram");
 * 
 * Mockito.when(customerService.delete(empDto2.getId())).
 * thenReturn("employee deleted");
 * mockMvc.perform(delete("/employee/deleteEmployeeById/4")).andExpect(status().
 * isAccepted());
 * 
 * }
 * 
 * 
 * 
 * }
 */