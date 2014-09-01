package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.MachineDAO;
import com.mproj.pojo.Machine;
import com.mproj.pojo.Part;
import com.mproj.utils.PageUtil;

@Repository("machineDAO")
public class MachineDAOImpl implements MachineDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Machine add(Machine machine) {
		
		getSession().saveOrUpdate(machine);
		
		return machine;
	}
	
	
	
	@Override
	public Machine query(String mNum) {
		
		String hql = "from Machine where num = :num";
		
		return (Machine) getSession().createQuery(hql).setString("num", mNum).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public PageUtil<Machine> queryAllByPage(int pageNO, int pageSize) {
		
		PageUtil<Machine> pageUtil = new PageUtil<Machine>();
		
		List<Machine> machines = getSession().createQuery("from Machine")
							.setFirstResult((pageNO-1) * pageSize).setMaxResults(pageSize).list();
		
		int rowCounts = this.getAllRowCount();	//总记录数
		
//		System.out.println("总记录数 = " + rowCounts);
		
		pageUtil.getTotalPage(rowCounts, pageSize);	//总页数
		
		
		
		pageUtil.setDatas(machines);
		
		return pageUtil;
	}
	
	@Override
	public List<Part> queryParts(String mNum) {
		return null;
	}
	
	@Override
	public Machine query(Integer id) {
		String hql = "from Machine where id = ?";

		Machine machine = (Machine)getSession().createQuery(hql).setInteger(0, id).uniqueResult();
	
		System.out.println(machine);
		
		return machine;
	}
	
	@Override
	public int getAllRowCount() {
		
		String hql = "from Machine";

		return getSession().createQuery(hql).list().size();
		
	}

}

