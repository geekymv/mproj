package com.mproj.action.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.PartType;
import com.mproj.service.PartTypeService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("partTypeAction")
@Scope("prototype")
public class PartTypeAction extends ActionSupport {
	private static final long serialVersionUID = -3079291571307842956L;
	
	@Autowired
	private PartTypeService partTypeService;
	
	private PartType type;

	/**
	 * 保存零件类型
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		
		System.out.println(type.getName());
		
		
		return "save";
	}
	
	/**
	 * 添加零件类型
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		return "add";
	}

	public PartType getType() {
		return type;
	}
	public void setType(PartType type) {
		this.type = type;
	}
	
}
