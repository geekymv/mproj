package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.MachineDAO;
import com.mproj.dto.MachinePart;
import com.mproj.pojo.Machine;
import com.mproj.utils.PageUtil;

@Repository("machineDAO")
public class MachineDAOImpl implements MachineDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Machine save(Machine machine) {
		
		getSession().saveOrUpdate(machine);
		
		return machine;
	}
	
	
	@Override
	public Machine query(String num) {
		
		String hql = "from Machine m where m.num = :num";
		
		Machine machine = (Machine) getSession().createQuery(hql).	//
				setString("num", num).uniqueResult();
		
		return machine;
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MachinePart> queryParts(String mNum) {
		Machine machine = query(mNum);
		
		String hql = "from MachinePart mp where mp.machine=? and mp.isuse=true order by useDate";

		return getSession().createQuery(hql).setEntity(0, machine).list();
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

	
	
	@Override
	public void saveMachinePart(MachinePart machinePart) {
	
		getSession().saveOrUpdate(machinePart);
	}

	@Override
	public MachinePart queryMachinePart(String mNum, String pNum) {
		
		String hql = "from MachinePart mp where mp.machine.num=? and mp.part.num=?";
		
		MachinePart mp = (MachinePart)getSession().createQuery(hql)
			.setString(0, mNum).setString(1, pNum).uniqueResult();
	
		return mp;
	}
	
	@Override
	public void deleteMachinePart(MachinePart mp) {
		getSession().delete(mp);
	}

}

