package com.mproj.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Machine;
import com.mproj.service.MachineService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("queryMachineAction")
@Scope("prototype")
public class QueryMachineAction extends ActionSupport {
	private static final long serialVersionUID = -1577860690769696038L;
	
	@Autowired
	private MachineService machineService;
	
	private String num;
	private Machine machine;

	/**
	 * 查询设备信息
	 * @return
	 * @throws Exception
	 */
	
	@Override
	public String execute() throws Exception {

		machine = machineService.query(num);
		
		return SUCCESS;
	}

	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
