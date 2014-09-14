package com.mproj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.MachineDAO;
import com.mproj.dao.PartDAO;
import com.mproj.pojo.Machine;
import com.mproj.pojo.Part;
import com.mproj.service.MachineService;
import com.mproj.utils.PageUtil;

@Service("machineService")
public class MachineServiceImpl implements MachineService {
	
	@Autowired
	private MachineDAO machineDAO = null;
	@Autowired
	private PartDAO partDAO;

	@Override
	public Machine query(String num) {
		
		Machine machine = machineDAO.query(num);
		return machine;
	}

	@Override
	public PageUtil<Machine> queryAllByPage(int pageNO, int pageSize) {
		return machineDAO.queryAllByPage(pageNO, pageSize);
	}

	@Override
	public List<Part> queryParts(String mNum) {
		return machineDAO.queryParts(mNum);
	}

	@Override
	public Machine query(Integer id) {
		
		return machineDAO.query(id);
	}

	@Override
	public Machine add(Machine machine) {
		
		return machineDAO.add(machine);
	}

	@Override
	public void addPart(String mNum, String pNum) {
		Machine machine = machineDAO.query(mNum);
		Part part = partDAO.query(pNum);
		part.setUseDate(new Date());	//设备零件的使用日期
		
		
		machine.getParts().add(part);
		part.setMachine(machine);
		
		machineDAO.add(machine);
		partDAO.save(part);
	}
}
