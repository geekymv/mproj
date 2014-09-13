package com.mproj.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.PartDAO;
import com.mproj.pojo.Part;

@Repository("partDAO")
public class PartDAOImpl implements PartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public Part save(Part part) {
		
		getSession().saveOrUpdate(part);
		
		return part;
	}

}
