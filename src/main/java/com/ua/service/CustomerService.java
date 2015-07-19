package com.ua.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ua.entity.Customer;

public interface CustomerService {

	public void createCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public Page<Customer> getAllCustomerPerPage(int page,int size);
	
	public List<String> findAllEmailAddress();
}
