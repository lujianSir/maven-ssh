package com.hcoding.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hcoding.demo.model.People;

@Repository("demoDao")
public class DemoDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	/**
	 * 保存对象
	 * 
	 * @param p
	 * @return
	 * @return
	 */
	public void save(People p) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(p);
	}

	/**
	 * 查询
	 * 
	 * @param p
	 * @return
	 */
	public List<People> queryPeople(People p) {
		Session session = sessionFactory.getCurrentSession();
		// String s = "FROM People";
		// Query query = session.createQuery(s);
		// List<People> list = query.list();
		Criteria criteria = session.createCriteria(People.class);
		criteria.add(Restrictions.eq("name", "1"));
		criteria.add(Restrictions.or(Restrictions.like("name", "1"), Restrictions.like("name", "1")));
		List<People> list = criteria.list();
		return list;
	}

}