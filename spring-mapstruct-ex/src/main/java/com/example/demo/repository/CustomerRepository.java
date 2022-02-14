package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CustomerDto;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Integer>{

}
