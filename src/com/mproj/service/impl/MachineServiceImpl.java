package com.mproj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.MachineDAO;
import com.mproj.dao.PartDAO;
import com.mproj.dto.MachinePart;
import com.mproj.dto.PartUsageRecord;
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
	public Machine save(Machine machine) {
		
		return machineDAO.save(machine);
	}
	
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
	public List<MachinePart> queryParts(String mNum) {
		return machineDAO.queryParts(mNum);
	}

	@Override
	public Machine query(Integer id) {
		
		return machineDAO.query(id);
	}

	@Override
	public void addPart(String mNum, String pNum) {
		
		Machine machine = machineDAO.query(mNum);
		Part part = partDAO.query(pNum);

		if(null == part.getUseDate()){	//第一次使用
			part.setUseDate(new Date());	
			partDAO.save(part);
		}
		
		MachinePart machinePart = new MachinePart();
		
		machinePart.setMachine(machine);
		machinePart.setPart(part);
		machinePart.setUseDate(new Date());
		machinePart.setIsuse(true);
		
		machineDAO.saveMachinePart(machinePart);
	}

	@Override
	public boolean machineIsUesed(String num) {

		Machine machine = machineDAO.query(num);
		
		return machine.getStatus();
	}

	
	@Override
	public void repair(Integer mNum, Integer pNum) {
		
		//查询
		MachinePart mp = machineDAO.queryMachinePart(mNum, pNum);
		//②在零件使用记录表中添加使用记录 
		PartUsageRecord record = new PartUsageRecord();
		
		record.setMachine(mp.getMachine());
		record.setPart(mp.getPart());
		record.setStartDate(mp.getUseDate());
		record.setEndDate(new Date());
		
		partDAO.savePartUsageRecord(record);
		
		//①将零件从设备上拆解 
		machineDAO.deleteMachinePart(mp);
		
		//③更新零件的已使用年限
		
		Date end = record.getEndDate();
		Date start = record.getStartDate();
		
		long result = end.getTime() - start.getTime();	//毫秒
		
		long days = result / (1000 * 60 * 60 * 24); 

		System.out.println("day = " + days);
		
		Part part = record.getPart();
		part.setUsedYear((float)(days/365.0));
		partDAO.save(part);
		
	}

}
