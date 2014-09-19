package com.mproj.action.machine;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Machine;
import com.mproj.service.MachineService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 使用设备
 */
@Controller("useMachineAction")
@Scope("prototype")
public class UseMachineAction extends ActionSupport {
	private static final long serialVersionUID = -3913207938877710262L;

	@Autowired
	private MachineService machineService;
	
	private String num;	//设备编号
	

	/**
	 * 使用设备
	 * @return
	 * @throws Exception
	 */
	public String use() throws Exception {
		
		Machine machine = machineService.query(num);
		
		machine.setStatus(true);	//设置设备状态为使用(true)
		machine.setUseDate(new Date());	//设置使用日期
		
		machineService.save(machine);

		return "use";
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
