package com.djb.service;

import java.util.List;

import com.djb.po.Demo;

public interface DemoService {
	public List<Demo> findByName(String name);
	
	public void insertDemo(Demo demo);
}
