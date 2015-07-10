package com.ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ua.entity.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	
	@Query(" SELECT c.email FROM Customer c")
	public List<String> findAllEmailAddress();
	
	
	
}
