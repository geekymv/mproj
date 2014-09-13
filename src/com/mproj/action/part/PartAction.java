package com.mproj.action.part;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Part;
import com.mproj.pojo.PartType;
import com.mproj.service.PartService;
import com.mproj.service.PartTypeService;
import com.opensymphony.xwork2.ActionSupport;


@Controller("partAction")
@Scope("prototype")
public class PartAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = -1104351318614650459L;
	
	@Autowired
	private PartService partService;
	@Autowired
	private PartTypeService partTypeService;
	
	private Part part;
	
	/**
	 * 保存或更新零件
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		
		partService.add(part);
		
		return "save";
	}
	
	
	/**
	 * 添加零件
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		//获得所有零件类型
		List<PartType> partTypes = partTypeService.list();
		
		request.put("partTypes", partTypes);
		
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


	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	
}
