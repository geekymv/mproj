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
 * 设备类型
 * @author Geek_ymv
 *
 */
@Entity
@Table(name="t_machine_type")
public class MachineType {

	private Integer id;
	private String name;	//设备类型名称
	
	private Set<Machine> machines = new HashSet<Machine>();
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="type")
	@JSON(serialize=false)
	public Set<Machine> getMachines() {
		return machines;
	}
	public void setMachines(Set<Machine> machines) {
		this.machines = machines;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
















