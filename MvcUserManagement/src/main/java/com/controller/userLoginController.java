package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.userDetailsModel;
import com.model.userLogin;
import com.service.userService;

@Controller
public class userLoginController {
	
	@Autowired
	public userService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView userLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") userLogin login) {
		ModelAndView mv = null;
		userDetailsModel user = userService.validateUser(login);
		if(null != user) {
			mv = new ModelAndView("welcome");
			mv.addObject("firstName", user.getFirstName());
		}else {
			mv = new ModelAndView("login");
			mv.addObject("message", "User name or Password is wrong!!");
		}
		return mv;
	}
}
