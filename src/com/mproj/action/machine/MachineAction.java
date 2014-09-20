package com.mproj.action.machine;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Machine;
import com.mproj.pojo.MachineType;
import com.mproj.pojo.Part;
import com.mproj.service.MachineService;
import com.mproj.service.MachineTypeService;
import com.mproj.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("machineAction")
@Scope("prototype")
public class MachineAction extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = -2312153102411139763L;

	@Autowired
	private MachineService machineService;
	@Autowired
	private MachineTypeService machineTypeService;
	
	private Machine machine;
	private Integer id;	//设备id
	
	private int page = 1;	//第几页

	/**
	 * 跳转至使用设备页面
	 * @return
	 */
	public String preuse() throws Exception {
		return "preuse";
	}
	
	
	/**
	 * 分页显示设备信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		PageUtil<Machine> pageUtil = machineService.queryAllByPage(page, 6);
		
		request.put("pageUtil", pageUtil);
		
		return SUCCESS;
		
	}
	
	/**
	 * 保存设备
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		if(null == id){	//判断是添加设备
			machine.setStatus(false);
		}
		
		machineService.save(machine);
		
		return "save";
	}
	
	/**
	 * 查询设备信息
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		
		
		machine = machineService.query("1000");
		
		request.put("machine", machine);
		
		System.out.println("machine = " + machine);
		
		
		return "query";
	}
	
	/**
	 * 添加设备
	 * @return
	 * @throws Exception
	 */
	public String add() throws Exception {
		//查询所有设备类型
		List<MachineType> machineTypes =  machineTypeService.queryAll();
		request.put("machineTypes", machineTypes);
		
		return "add";
	}
	
	
	/**
	 * 修改设备信息
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {

		//查询所有设备类型
		List<MachineType> machineTypes =  machineTypeService.queryAll();
		request.put("machineTypes", machineTypes);
		
		//根据设备id查询设备信息
		machine = machineService.query(id);
		
		request.put("machine", machine);

		return "edit";
	}
	
	
	/**
	 * 删除设备信息
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		
		
		return SUCCESS;
	}
	
	/**
	 * 根据设备编号查询设备上的所有零件
	 * @return
	 * @throws Exception
	 */
	public String listParts() throws Exception {
		
		List<Part> parts = machineService.queryParts(machine.getNum());
		
		System.out.println(parts);
		
		
		return "listParts";
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}


	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public Machine getMachine() {
		return machine;
	}
	
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}

