package com.hcoding.demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcoding.demo.dao.DemoDao;
import com.hcoding.demo.model.People;

@Service("demoService")
public class DemoService {

	@Resource(name = "demoDao")
	private DemoDao demoDao;;

	@Transactional
	public void save(People p) {
		demoDao.save(p);
	}

	@Transactional(readOnly = true)
	public List<People> queryPeople(People p) {
		return demoDao.queryPeople(p);
	}

	public People newPeople() {
		People p = new People();
		p.setName("小白");
		p.setSex("男");
		return p;
	}
}