package com.mproj.pojo;

import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * 设备类型
 * @author Geek_ymv
 *
 */
public class MachineType {

	private Integer id;
//	private String num;		//设备类型编号
	private String name;	//设备类型名称
	
	private Set<Machine> machines = new HashSet<Machine>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JSON(serialize=false)
	public Set<Machine> getMachines() {
		return machines;
	}
	public void setMachines(Set<Machine> machines) {
		this.machines = machines;
	}
	
//	public String getNum() {
//		return num;
//	}
//	public void setNum(String num) {
//		this.num = num;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
















