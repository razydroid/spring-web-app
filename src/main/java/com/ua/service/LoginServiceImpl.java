package com.ua.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ua.entity.user;
import com.ua.repository.UserRepository;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRep;

	@Override
	public user isValidUser(String uid, String pwd) {
		// TODO Auto-generated method stub
		return userRep.find(uid, pwd);

	}

}
