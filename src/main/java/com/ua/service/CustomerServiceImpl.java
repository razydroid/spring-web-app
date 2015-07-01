package com.ua.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

	public ArrayList<Customer> getAllCustomer() {

		ArrayList customers = new ArrayList<Customer>();
		customers = (ArrayList) customerRep.findAll();
		return customers;
	}

	private static final int PAGE_SIZE = 50;

	public Page<Customer> getAllCustomerPerPage(Integer pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE);
		return customerRep.findAll(request);
	}

}
