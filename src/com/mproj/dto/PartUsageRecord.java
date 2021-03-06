package com.mproj.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;

import com.mproj.pojo.Machine;
import com.mproj.pojo.Part;

/**
 * 零件使用记录
 * @author Geek_ymv
 */
@Entity
@Table(name="t_part_record")
public class PartUsageRecord {

	private Integer id;
	private Date startDate;
	private Date endDate;
	
	private Part part;
	private Machine machine;
	
	private Boolean usable;	//零件是否可用，true可用 false报废
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.DATE)
	@JSON(format="yyyy-MM-dd")
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Temporal(TemporalType.DATE)
	@JSON(format="yyyy-MM-dd")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@ManyToOne
	@JoinColumn(name="part_id")
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	@ManyToOne
	@JoinColumn(name="machine_id")
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
	public Boolean getUsable() {
		return usable;
	}
	public void setUsable(Boolean usable) {
		this.usable = usable;
	}
	
}















