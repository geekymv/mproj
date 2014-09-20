package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.PartTypeDAO;
import com.mproj.pojo.PartType;

@Repository("partTypeDAO")
public class PartTypeDAOImpl implements PartTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public void save(PartType type) {
		
		getSession().saveOrUpdate(type);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PartType> list() {

		String hql = "from PartType";
		
		return ( List<PartType>)getSession().createQuery(hql).list();
	}

}
