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
import com.service.userService;
@Controller
public class userRegisterController {
	@Autowired
	public userService userService;
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") userDetailsModel user) {
		userService.register(user);
		return new ModelAndView("Welcome","firstName", user.getFirstName());
	}
	
	@RequestMapping(value="/showUsers", method = RequestMethod.GET)
	public ModelAndView showUsers(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user", new userDetailsModel());
		return mv;
	}
}
