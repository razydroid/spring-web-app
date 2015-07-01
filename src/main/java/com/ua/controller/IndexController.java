package com.ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping("/home")
	public String index(){
		System.out.println("Home Menu is called");
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(){
		System.out.println("About Menu is called");
		return "about";
	}

	@RequestMapping("/contact")
	public String contact(){
		System.out.println("contact Menu is called");
		
		
		
		
		return "contact";
	}
	
}
