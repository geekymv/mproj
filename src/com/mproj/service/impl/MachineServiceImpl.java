package com.mproj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.MachineDAO;
import com.mproj.pojo.Machine;
import com.mproj.pojo.Part;
import com.mproj.service.MachineService;
import com.mproj.utils.PageUtil;

@Service("machineService")
public class MachineServiceImpl implements MachineService {
	
	@Autowired
	private MachineDAO machineDAO = null;

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
		return null;
	}

	@Override
	public Machine query(Integer id) {
		
		return machineDAO.query(id);
	}

	@Override
	public Machine add(Machine machine) {
		
		return machineDAO.add(machine);
	}
	


}
