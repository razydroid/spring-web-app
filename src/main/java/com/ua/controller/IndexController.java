package com.ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping("/home")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "about";
	}

	@RequestMapping("/contact")
	public String contact(){
		return "contact";
	}
	
}
