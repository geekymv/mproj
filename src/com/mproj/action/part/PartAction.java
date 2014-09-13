package com.mproj.action.part;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Part;
import com.opensymphony.xwork2.ActionSupport;


@Controller("partAction")
@Scope("prototype")
public class PartAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = -1104351318614650459L;
	
	
	private Part part;
	
	/**
	 * 添加零件
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		
		
		
		return "add";
	}
	
	
	/**
	 * 分配零件：将零件分配给一个设备
	 * @return
	 * @throws Exception
	 */
	public String distribute() throws Exception {
		
		return "distribute";
	}


	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	
	
	
}
