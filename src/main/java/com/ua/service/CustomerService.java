package com.ua.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.ua.entity.Customer;

public interface CustomerService {

	public void createCustomer(Customer customer);

	public ArrayList<Customer> getAllCustomer();

	public Page<Customer> getAllCustomerPerPage(Integer pageNumber);
	
	public List<String> findAllEmailAddress();
}
