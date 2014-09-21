package com.mproj.action.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.service.MachineService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 给设备添加零件
 */
@Controller("addPartAction")
@Scope("prototype")
public class AddPartAction extends ActionSupport {
	private static final long serialVersionUID = 1813473200911611039L;

	@Autowired
	private MachineService machineService;
	
	private String machineNum;
	private String partNum;


	@Override
	public String execute() throws Exception {
		machineService.addPart(machineNum, partNum);
		
		return SUCCESS;
	}
	
	public String getMachineNum() {
		return machineNum;
	}
	public void setMachineNum(String machineNum) {
		this.machineNum = machineNum;
	}
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	
}
