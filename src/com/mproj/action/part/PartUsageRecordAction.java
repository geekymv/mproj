package com.mproj.action.part;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.dto.PartUsageRecord;
import com.mproj.service.PartService;
import com.mproj.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 查看零件的使用记录
 */
@Controller("partUsageRecordAction")
@Scope("prototype")
public class PartUsageRecordAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = 4329078070901872869L;

	@Autowired
	private PartService partService;
	
	private String partNum;	//零件编号
	
	private int page = 1;
	
	/**
	 * 查看零件的使用记录
	 * @return
	 * @throws Exception
	 */
	public String record() throws Exception {
		
		PageUtil<PartUsageRecord> pageUtil = partService.queryPartUsageRecord(partNum, page, 5);
		
		request.put("pageUtil", pageUtil);
		
		return "record";
	}
	/**
	 * 跳转至查询页面
	 * @return
	 * @throws Exception
	 */
	public String prerecord() throws Exception {
		return "prerecord";
	}
	
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}



















