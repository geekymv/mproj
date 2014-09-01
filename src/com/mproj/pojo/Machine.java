package com.mproj.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 设备
 * @author Geek_ymv
 */
public class Machine{

	private Integer id;
	private String num;	//设备编号
	private String name;	//设备名称
	private Float useYear;	//使用年限
	private Date proDate;	//生产日期
	private Date useDate;	//开始使用日期
	private String suppliper;	//供应商名称
	private String function;	//功能简介
	private Boolean status;	//设备状态，在使用时值为true，未使用时值为false
	
	private MachineType type;	//设备类型
	
	private Set<Part> parts = new HashSet<Part>();	//设备上的零件

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Float getUseYear() {
		return useYear;
	}
	public void setUseYear(Float useYear) {
		this.useYear = useYear;
	}
	public Date getProDate() {
		return proDate;
	}

	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	public Date getUseDate() {
		return useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public String getSuppliper() {
		return suppliper;
	}

	public void setSuppliper(String suppliper) {
		this.suppliper = suppliper;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public MachineType getType() {
		return type;
	}

	public void setType(MachineType type) {
		this.type = type;
	}

	public Set<Part> getParts() {
		return parts;
	}

	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}

	@Override
	public String toString() {
		return "Machine [function=" + function + ", id=" + id + ", name="
				+ name + ", num=" + num + ", parts=" + parts + ", proDate="
				+ proDate + ", status=" + status + ", suppliper=" + suppliper
				+ ", type=" + type + ", useDate=" + useDate + ", useYear="
				+ useYear + "]";
	}
	
	
}
