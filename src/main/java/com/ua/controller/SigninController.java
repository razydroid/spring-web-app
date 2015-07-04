package com.ua.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ua.beans.UserBean;
import com.ua.entity.user;
import com.ua.service.LoginService;

@Controller
public class SigninController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView model = new ModelAndView("signin");
		user loginUser = new user();
		model.addObject("user", loginUser);
		return model;

		// return "login";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView executeLogin(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("user") user userBean, @Valid user user, BindingResult result) {
		
		
		ModelAndView model = null;
		if (result.hasErrors()) {
			System.out.println("I AM HERE !!!!");
			model = new ModelAndView("signin");
			return model;
		}
		
		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println("userName=" + userName + " password=" + password
				+ "uname from bean" + userBean.getName() + "PWD"
				+ userBean.getPassword());

		try {
			user validUser = loginService.isValidUser(userName, password);
			System.out.println("ValidUser" + validUser);
			if (validUser != null) {
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", userName);
				model = new ModelAndView("welcome", "user", validUser);
			} else {
				System.out.println("User couldnt login successfully");
				model = new ModelAndView("signin");
				model.addObject("userBean", validUser);
				request.setAttribute("errorMessage", "Invalid credentials!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return model;
	}
}
