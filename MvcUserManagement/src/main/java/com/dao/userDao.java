package com.dao;

import com.model.userDetailsModel;
import com.model.userLogin;

public interface userDao {
	void register(userDetailsModel user);
	userDetailsModel validateUser(userLogin login);
}
