package com.mproj.action.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.service.PartService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 零件报废
 */
@Controller("partScrapAction")
@Scope("prototype")
public class PartScrapAction extends ActionSupport {
	private static final long serialVersionUID = -3869333045427045299L;
	
	@Autowired
	private PartService partService;
	
	private String partNum;
	
	public String scrap() throws Exception {
		
		partService.scrap(partNum);
		
		return "scrap";
	}
	/**
	 * 页面跳转至scrap.jsp
	 * @return
	 */
	public String prescrap() throws Exception {
		return "prescrap";
	}

	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	
}
