package com.ua.service;

import com.ua.entity.user;

public interface LoginService {
	
	public user isValidUser(String uid,String pwd);

}
