package com.service;

import com.model.userDetailsModel;
import com.model.userLogin;

public interface userService {
	void register(userDetailsModel user);
	userDetailsModel validateUser(userLogin login);
}
