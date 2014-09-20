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
	
	private Integer mNum;
	private Integer pNum;
	
	
	/**
	 * 设备维修
	 * @return
	 * @throws Exception
	 */
	public String repair() throws Exception {
		
		System.out.println("m = " + mNum);
		System.out.println("p = " + pNum);
		
		machineService.repair(mNum, pNum);
		
		return "repair";
	}
	public String prerepair() throws Exception {
		
		return "prerepair";
	}

	public Integer getmNum() {
		return mNum;
	}
	public void setmNum(Integer mNum) {
		this.mNum = mNum;
	}

	public Integer getpNum() {
		return pNum;
	}
	public void setpNum(Integer pNum) {
		this.pNum = pNum;
	}
	
}
