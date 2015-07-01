package com.ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ua.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	
}
