package com.mproj.service;

import java.util.List;

import com.mproj.pojo.PartType;

public interface PartTypeService {
	
	/**
	 * 获得所有零件类型
	 * @return
	 */
	public List<PartType> list();

	/**
	 * 保存
	 * @param type
	 */
	public void save(PartType type);

}
