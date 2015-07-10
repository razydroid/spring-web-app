package com.ua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ua.entity.Customer;
import com.ua.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customers")
	public String getAllCustomer( Model model)
	{
		model.addAttribute("customers",customerService.getAllCustomer());
		
		List<String> allEmail  = customerService.findAllEmailAddress();
		
		allEmail.size();
		
		for(String emails : allEmail)
		{
			System.out.println("email address ="+emails);
		}
		
		/*
		for(int i=0;i<allEmail.size();i++)
		{
			System.out.println("email address = "+allEmail.get(i));
		}*/
		
		
		
		
		System.out.println("SIZE = "+allEmail.size());
		return "customers";
	}
	
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getAllCustomerPerPage(@PathVariable Integer pageNumber, Model model) {
	    Page<Customer> page = customerService.getAllCustomerPerPage(pageNumber);

	    System.out.println("SIZE IS "+page.getSize());
	    
	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());

	    model.addAttribute("customersPage", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);

	    return "customersPage";
	}
	
	
}
