package com.djb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.djb.po.User;
import com.djb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/findUserByName")
	@ResponseBody
	public User findUserByName(String username){
		User user=userService.getByUsername(username);
		return user;
	}

}
