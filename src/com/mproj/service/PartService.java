package com.mproj.service;

import com.mproj.dto.PartUsageRecord;
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
	 * 根据零件id查询零件
	 * @param pNum
	 * @return
	 */
	public Part query(Integer id);
	
	/**
	 * 分页显示零件
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageUtil<Part> list(int page, int pageSize);

	/**
	 * 分页查询零件使用记录
	 * @param partNum
	 * @param pageSize 
	 * @param page 
	 * @return
	 */
	public PageUtil<PartUsageRecord> queryPartUsageRecord(String partNum, int page, int pageSize);

	
	
}
