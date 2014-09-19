package com.mproj.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;

import com.mproj.dto.MachinePart;

/**
 * 设备
 * @author Geek_ymv
 */
@Entity
@Table(name="t_machine")
public class Machine{

	private Integer id;
	private String num;	//设备编号
	private String name;	//设备名称
	private Float useYear;	//使用年限
	private Float usedYear;	//已使用年限
	private Date proDate;	//生产日期
	private Date useDate;	//开始使用日期
	private String suppliper;	//供应商名称
	private String function;	//功能简介
	private Boolean status;	//设备状态，在使用时值为true，未使用时值为false
	
	private MachineType type;	//设备类型
	
	private Set<MachinePart> machineParts = new HashSet<MachinePart>();
	
	/*struts2 传递json对象时的延迟加载异常处理方法： 
	 * http://www.niwozhi.net/demo_c68_i38874.html
	 * http://perfectplan.iteye.com/blog/1561903*/
//	@JSON(serialize=false)  	//不进行序列化
	

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="machine")
	@JSON(serialize=false)
	public Set<MachinePart> getMachineParts() {
		return machineParts;
	}
	public void setMachineParts(Set<MachinePart> machineParts) {
		this.machineParts = machineParts;
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
	@Column(columnDefinition="float default 0")
	public Float getUsedYear() {
		return usedYear;
	}
	public void setUsedYear(Float usedYear) {
		this.usedYear = usedYear;
	}

	@Temporal(TemporalType.DATE)
	@JSON(format="yyyy-MM-dd")
	public Date getProDate() {
		return proDate;
	}
	public void setProDate(Date proDate) {
		this.proDate = proDate;
	}

	@Temporal(TemporalType.DATE)
	@JSON(format="yyyy-MM-dd")
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

	@ManyToOne
	@JoinColumn(name="type_id")
	public MachineType getType() {
		return type;
	}
	public void setType(MachineType type) {
		this.type = type;
	}

}
