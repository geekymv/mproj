
package com.mproj.pojo;

import java.util.Date;
/**
 * 零件
 * @author Geek_ymv
 */
public class Part {
	
	private Integer id;
	private String num;	//零件编号
	private String name;	//零件名称
	private Date proDate;	//生产日期
	private Date useDate;	//开始使用日期
	private Float useYear;	//使用年限
	private String supplier;	//供应商名称
	private Boolean status;	//零件状态

	private PartType partType;	//零件类型
	
//	private Machine machine;	//该零件所属设备

	
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
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
	public Float getUseYear() {
		return useYear;
	}
	public void setUseYear(Float useYear) {
		this.useYear = useYear;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public PartType getPartType() {
		return partType;
	}
	public void setPartType(PartType partType) {
		this.partType = partType;
	}
//	public Machine getMachine() {
//		return machine;
//	}
//	public void setMachine(Machine machine) {
//		this.machine = machine;
//	}

}
