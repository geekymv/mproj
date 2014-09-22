package com.mproj.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;

/**
 * 零件类型
 * @author Geek_ymv
 *
 */
@Entity
@Table(name="t_part_type")
public class PartType {
	
	private Integer id;
	private String name;	//零件类型名
	
	private Set<Part> parts = new HashSet<Part>();
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JSON(serialize=false)
	@OneToMany(mappedBy="type")
	public Set<Part> getParts() {
		return parts;
	}
	public void setParts(Set<Part> parts) {
		this.parts = parts;
	}
}
