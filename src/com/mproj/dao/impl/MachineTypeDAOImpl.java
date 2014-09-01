package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.MachineTypeDAO;
import com.mproj.pojo.MachineType;

@Repository("machineTypeDAO")
public class MachineTypeDAOImpl implements MachineTypeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public MachineType addType(MachineType type) {
		return null;
	}

	@Override
	public MachineType getMachineType(String typeNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MachineType> queryMachineTypeByPage(int pageNO, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MachineType updateMachineType(MachineType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MachineType> queryAll() {

		String hql = "from MachineType";

		return getSession().createQuery(hql).list();
	}
	
	
	
	
}




