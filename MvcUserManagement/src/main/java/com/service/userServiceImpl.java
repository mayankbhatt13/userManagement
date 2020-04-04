package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.userDao;
import com.model.userDetailsModel;
import com.model.userLogin;

public class userServiceImpl implements userService {
	
	@Autowired
	public userDao userDao;

	public void register(userDetailsModel user) {
		// TODO Auto-generated method stub
		userDao.register(user);
	}

	public userDetailsModel validateUser(userLogin login) {
		// TODO Auto-generated method stub
		return userDao.validateUser(login);
	}

}
