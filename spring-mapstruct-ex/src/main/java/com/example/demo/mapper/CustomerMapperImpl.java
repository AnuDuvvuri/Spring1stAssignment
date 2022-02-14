package com.example.demo.mapper;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

import java.util.List;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.0.Beta2, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.3.jar, environment: Java 17.0.1 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer cust) {
        if ( cust == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerId( cust.getCustomerId() );
        customerDto.setCustomerName( cust.getCustomerName() );

        return customerDto;
    }

    @Override
    public Customer fromDto(CustomerDto custdto) {
        if ( custdto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCustomerId( custdto.getCustomerId() );
        customer.setCustomerName( custdto.getCustomerName() );

        return customer;
    }

	@Override
	public List<CustomerDto> toEmployeeListDto(List<Customer> cus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> fromEmployeeListDto(List<CustomerDto> cusDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
