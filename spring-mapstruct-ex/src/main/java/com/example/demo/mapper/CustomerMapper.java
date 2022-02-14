package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerDto;

@Mapper(
	    componentModel = "spring"
		)
public interface CustomerMapper {
	
	CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);
	CustomerDto toDto(Customer customer);
	
	Customer fromDto(CustomerDto custdto);
	List<CustomerDto> toEmployeeListDto(List<Customer> cus);

    List<Customer> fromEmployeeListDto(List<CustomerDto> cusDto);
	
}
