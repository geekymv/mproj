package com.mproj.action.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.service.MachineService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 设备维修：
 * ①将零件从设备上拆解
 * ②在零件使用记录表中添加使用记录
 * ③更新零件的已使用时间
 */
@Controller("repairAction")
@Scope("prototype")
public class RepairAction extends ActionSupport {
	private static final long serialVersionUID = -8963268551183101595L;

	@Autowired
	private MachineService machineService;
	
	private String machineNum;
	private String partNum;
	
	/**
	 * 设备维修
	 * @return
	 * @throws Exception
	 */
	public String repair() throws Exception {
		
		System.out.println("m = " + machineNum);
		System.out.println("p = " + partNum);
		
		machineService.repair(machineNum, partNum);
		
		return "repair";
	}
	public String prerepair() throws Exception {
		
		return "prerepair";
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
