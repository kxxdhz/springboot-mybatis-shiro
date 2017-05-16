package com.djb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.djb.po.Demo;
import com.djb.service.DemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/findByName")
	@ResponseBody
	public List<Demo> findByName(String name){
		return demoService.findByName(name);
	}
	
	@RequestMapping(value="/insertDemo")
	@ResponseBody
	public String insertDemo(String name){
		Demo demo=new Demo();
		demo.setName(name);
		demoService.insertDemo(demo);
		return "success";
	}
	
}
