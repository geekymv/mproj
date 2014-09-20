package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.PartDAO;
import com.mproj.dto.PartUsageRecord;
import com.mproj.pojo.Part;
import com.mproj.utils.PageUtil;

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


	@Override
	public Part query(String pNum) {
		String hql = "from Part p where p.num = ?";
		
		return (Part) getSession().createQuery(hql)	//
					.setString(0, pNum).uniqueResult();
	}
	
	@Override
	public Part query(Integer id) {
		
		return (Part) getSession().get(Part.class, id);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<Part> list(int page, int pageSize) {
		PageUtil<Part> pageUtil = new PageUtil<Part>();
		
		List<Part> parts = (List<Part>)getSession().createQuery("from Part")	//
				.setFirstResult((page-1)*pageSize)	//
				.setMaxResults(pageSize)	//
				.list();	
		
		
		pageUtil.setDatas(parts);
		pageUtil.getTotalPage(getRowCounts(), pageSize);
		
		return pageUtil;
	}
	
	private int getRowCounts(){
		Long rowCounts = (Long) getSession()	//
				.createQuery("select count(*) from Part").uniqueResult();
		
		System.out.println("总记录数 = " + rowCounts);
		
		return Integer.parseInt(String.valueOf(rowCounts));
	}


	@Override
	public void savePartUsageRecord(PartUsageRecord record) {
		
		getSession().save(record);
	}

}
