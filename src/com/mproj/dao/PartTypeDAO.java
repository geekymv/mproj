package com.mproj.dao;

import java.util.List;

import com.mproj.pojo.PartType;

public interface PartTypeDAO {

	/**
	 * 保存零件类型
	 * @param type
	 */
	public void save(PartType type);
	
	/**
	 * 获得所有零件类型
	 * @return
	 */
	public List<PartType> list();
	
}
