package com.ua.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ua.entity.Customer;
import com.ua.repository.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRep;

	public void createCustomer(Customer customer) {

		customerRep.save(customer);
		// TODO Auto-generated method stub

	}

	public List<Customer> getAllCustomer() {

		
		List<Customer> customers = customerRep.findAll();
		return customers;
	}

	private static final int PAGE_SIZE = 50;

	/*public Page<Customer> getAllCustomerPerPage(Integer pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
		return customerRep.findAll(request);
	}*/

	@Override
	public List<String> findAllEmailAddress() {
		// TODO Auto-generated method stub
		return customerRep.findAllEmailAddress();
		
	}
	
	public Page<Customer> getAllCustomerPerPage(int page,int size) {
		
		return customerRep.findAll(new PageRequest(page, size, Direction.ASC, "firstName"));
	}

}
