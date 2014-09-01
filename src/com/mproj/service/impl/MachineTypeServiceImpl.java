package com.mproj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.MachineTypeDAO;
import com.mproj.pojo.MachineType;
import com.mproj.service.MachineTypeService;

@Service("machineTypeService")
public class MachineTypeServiceImpl implements MachineTypeService {

	@Autowired
	private MachineTypeDAO machineTypeDAO = null;
	
	@Override
	public MachineType addType(MachineType type) {
		
		return machineTypeDAO.addType(type);
	}

	@Override
	public MachineType getMachineType(String typeNum) {
		return machineTypeDAO.getMachineType(typeNum);
	}

	@Override
	public List<MachineType> queryMachineTypeByPage(int pageNO, int pageSize) {

		return machineTypeDAO.queryMachineTypeByPage(pageNO, pageSize);
	}

	@Override
	public List<MachineType> queryAll() {
	
		return machineTypeDAO.queryAll();
	}

}
