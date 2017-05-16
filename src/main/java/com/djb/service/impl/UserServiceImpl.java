package com.djb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djb.mapper.UserMapper;
import com.djb.po.User;
import com.djb.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	public User getByUsername(String username) {
		return userMapper.getByUsername(username);
	}

}
