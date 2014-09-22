package com.mproj.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mproj.pojo.Part;

/**
 * 零件报废
 */
public class PartScrap {
	
	private Integer id;
	
	private Part part;
	private Date scrapDate;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name="part_id")
	public Part getPart() {
		return part;
	}
	public void setPart(Part part) {
		this.part = part;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getScrapDate() {
		return scrapDate;
	}
	public void setScrapDate(Date scrapDate) {
		this.scrapDate = scrapDate;
	}
	
}
