package com.mproj.action.machine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Part;
import com.mproj.service.MachineService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 异步加载一个设备上的所有零件
 */
@Controller("queryPartsAction")
@Scope("prototype")
public class QueryPartsAction extends ActionSupport {
	private static final long serialVersionUID = 1813473200911611039L;

	@Autowired
	private MachineService machineService;
	
	private String num;
	private List<Part> parts;
	
	@Override
	public String execute() throws Exception {
		
		parts = machineService.queryParts(num);
		
		return SUCCESS;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public List<Part> getParts() {
		return parts;
	}
	public void setParts(List<Part> parts) {
		this.parts = parts;
	}
	
	
	
	
}
