package com.mproj.service;

import com.mproj.pojo.Part;
import com.mproj.utils.PageUtil;

public interface PartService {

	/**
	 * 添加零件
	 * @param part
	 * @return
	 */
	public Part add(Part part);
	
	/**
	 * 分页显示零件
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageUtil<Part> list(int page, int pageSize);
	
	
}
