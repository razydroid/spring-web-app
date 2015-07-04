package com.ua.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ua.beans.UserBean;
import com.ua.entity.user;
import com.ua.service.LoginService;


@Controller
public class LoginController
{
	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView model = new ModelAndView("login");
		user loginUser = new user();
		model.addObject("user", loginUser);
		return model;
		
		//return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")user userBean)
	{
		ModelAndView model= null;
		
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("userName="+userName+" password="+password+ "uname from bean"+userBean.getName()+"PWD"+userBean.getPassword());
		
		try
		{
			user validUser = loginService.isValidUser(userName, password);
			System.out.println("ValidUser"+validUser);
			if(validUser !=null)
			{
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", userName);
				model = new ModelAndView("welcome","user",validUser);
			}
			else
			{
				System.out.println("User couldnt login successfully");
				model = new ModelAndView("login");
				model.addObject("userBean", validUser);
				request.setAttribute("message", "Invalid credentials!!");
			}
			

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return model;
	}
}

