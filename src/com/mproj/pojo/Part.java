
package com.mproj.pojo;

import java.util.Date;
import java.util.HashMap;
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
 * 零件
 * @author Geek_ymv
 */
@Entity
@Table(name="t_part")
public class Part {
	
	private Integer id;
	private String num;	//零件编号
	private String name;	//零件名称
	private Date proDate;	//生产日期
	private Date useDate;	//开始使用日期
	private Float useYear;	//使用年限
	private Float usedYear;	//已使用年限
	private String supplier;	//供应商名称
	private Boolean status;	//零件状态

	private PartType type;	//零件类型
	
	private Set<MachinePart> machineParts = new HashSet<MachinePart>();

	@Id
	@GeneratedValue
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
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	
	@ManyToOne
	@JoinColumn(name="type_id")
	public PartType getType() {
		return type;
	}
	public void setType(PartType type) {
		this.type = type;
	}

	@OneToMany(mappedBy="part")
	public Set<MachinePart> getMachineParts() {
		return machineParts;
	}
	public void setMachineParts(Set<MachinePart> machineParts) {
		this.machineParts = machineParts;
	}
	
	
}
