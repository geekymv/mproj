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
import com.mproj.utils.PageUtil;
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
	private Integer id;	//零件id
	
	private int page = 1;	//第几页
	/**
	 * 分页显示所有零件
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		
		PageUtil<Part> pageUtil = partService.list(page, 8);
		
		request.put("pageUtil", pageUtil);
		
		return "list";
	}
	
	/**
	 * 保存或更新零件
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		
		if(part.getId() == null) {	//添加零件
			part.setStatus(false);
			part.setUsedYear(0f);
		}
		
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
	
	public String edit() throws Exception {
		
		//获得所有零件类型
		List<PartType> partTypes = partTypeService.list();
		request.put("partTypes", partTypes);

		//根据设备id查询设备信息
		part = partService.query(id);
		request.put("part", part);
		
		return "edit";
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

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
