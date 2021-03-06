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

import com.mproj.pojo.Machine;
import com.mproj.pojo.Part;

/**
 * 设备--零件中间类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_machine_part")
public class MachinePart {
	
	private Integer id;
	private Machine machine;
	private Part part;
	
	private Date useDate;
	
	private Boolean isuse;	//零件是否在设备上

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="machine_id")
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
	@ManyToOne
	@JoinColumn(name="part_id")
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	@Temporal(TemporalType.DATE)
	public Date getUseDate() {
		return useDate;
	}
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	
	public Boolean getIsuse() {
		return isuse;
	}
	public void setIsuse(Boolean isuse) {
		this.isuse = isuse;
	}

}
