package com.mproj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.Machine;
import com.mproj.pojo.MachineType;
import com.mproj.service.MachineService;
import com.mproj.service.MachineTypeService;
import com.mproj.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;


@Scope("prototype")
@Controller("machineAction")
public class MachineAction extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = -2312153102411139763L;

	@Autowired
	private MachineService machineService;
	
	@Autowired
	private MachineTypeService machineTypeService;
	
	private Machine machine;
	
	private Integer id;	//设备id
	
	private int pageNO = 1;	//第几页
	
	private Map<String, Object> request;
	
	/**
	 * 分页显示设备信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		PageUtil<Machine> pageUtil = machineService.queryAllByPage(pageNO, 3);
		
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
		
		machineService.add(machine);
		
		return "save";
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
	
	
	
	public int getPageNO() {
		return pageNO;
	}
	public void setPageNO(int pageNO) {
		this.pageNO = pageNO;
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
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}




















