package com.djb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.djb.mapper.DemoMapper;
import com.djb.po.Demo;
import com.djb.service.DemoService;

@Service
@Transactional
public class DemoServiceImpl implements DemoService{

	@Autowired
    private DemoMapper demoMappper;
	
	public List<Demo> findByName(String name){
		return demoMappper.findByName(name);
	}
	
	public void insertDemo(Demo demo){
		demoMappper.insertDemo(demo);
		try {
			throw new Exception();
		} catch (Exception e) {
			throw new RuntimeException("事务测试！"); 
		}
	}
	
}
