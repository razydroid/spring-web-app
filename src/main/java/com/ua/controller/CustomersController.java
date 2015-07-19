package com.ua.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ua.conroller.dto.CustomerJsonObject;
import com.ua.entity.Customer;
import com.ua.service.CustomerService;

@Controller
public class CustomersController {

    
	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value = "/customers.web", method = 
	    RequestMethod.GET)
    public String printWelcome(@ModelAttribute("Customer") Customer customer, BindingResult result,ModelMap model, HttpServletRequest 
	    request, HttpServletResponse response) {
	
    	return "customerDetails";

    }

    @RequestMapping(value = "/springPaginationDataTables.web", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody String springPaginationDataTables(HttpServletRequest  request) throws IOException {
		
    	//Fetch the page number from client
    	Integer pageNumber = 0;
    	if (null != request.getParameter("iDisplayStart"))
    		pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;		
    	
    	//Fetch search parameter
    	String searchParameter = request.getParameter("sSearch");
    	
    	//Fetch Page display length
    	Integer pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
    	
    	//Create page list data
    	List<Customer> customersList = createPaginationData(pageDisplayLength);
		
		//Here is server side pagination logic. Based on the page number you could make call 
		//to the data base create new list and send back to the client. For demo I am shuffling 
		//the same list to show data randomly
		
		
		//Search functionality: Returns filtered list based on search parameter
		customersList = getListBasedOnSearchParameter(searchParameter,customersList);
		
		
		CustomerJsonObject customerJsonObject = new CustomerJsonObject();
		//Set Total display record
		customerJsonObject.setiTotalDisplayRecords(customersList.size());
		//Set Total record
		customerJsonObject.setiTotalRecords(customersList.size());
		customerJsonObject.setAaData(customersList);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = gson.toJson(customerJsonObject);
	
		return json2;
    }

	private List<Customer> getListBasedOnSearchParameter(String searchParameter,List<Customer> customersList) {
		
		if (null != searchParameter && !searchParameter.equals("")) {
			List<Customer> customersListForSearch = new ArrayList<Customer>();
			searchParameter = searchParameter.toUpperCase();
			for (Customer customer : customersList) {
				if ((""+customer.getCustomerId()).toUpperCase().indexOf(searchParameter)!= -1 || (""+customer.getActive()).toUpperCase().indexOf(searchParameter)!= -1
						|| customer.getEmail().toUpperCase().indexOf(searchParameter)!= -1 || customer.getFirstName().toUpperCase().indexOf(searchParameter)!= -1
						|| customer.getLastName().toUpperCase().indexOf(searchParameter)!= -1 || (""+customer.getAddressId()).toUpperCase().indexOf(searchParameter)!= -1
						|| (""+customer.getStoreId()).toUpperCase().indexOf(searchParameter)!= -1 || (""+customer.getCreateDate()).toUpperCase().indexOf(searchParameter)!= -1
						|| (""+customer.getLastUpdate()).toUpperCase().indexOf(searchParameter)!= -1) {
					customersListForSearch.add(customer);					
				}
				
			}
			customersList = customersListForSearch;
			customersListForSearch = null;
		}
		return customersList;
	}

	private List<Customer> createPaginationData(Integer pageDisplayLength) {
		List<Customer> customersList = customerService.getAllCustomer();
		
		return customersList;
	}
}