package com.hcoding.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcoding.demo.model.People;
import com.hcoding.demo.service.DemoService;

@Controller
public class DemoController {

	@Resource(name = "demoService")
	private DemoService demoService;

	@RequestMapping("/test")
	public String test() {
		People p = demoService.newPeople();
		demoService.save(p);
		return "ceshi";
	}

	@RequestMapping("/query")
	public String query() {
		People p = demoService.newPeople();
		demoService.queryPeople(p);
		return "ceshi";
	}
}