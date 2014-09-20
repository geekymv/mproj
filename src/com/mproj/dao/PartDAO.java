package com.mproj.dao;

import com.mproj.dto.PartUsageRecord;
import com.mproj.pojo.Part;
import com.mproj.utils.PageUtil;

public interface PartDAO {

	/**
	 * 保存零件
	 * @param part
	 * @return
	 */
	public Part save(Part part);

	/**
	 * 根据零件编号查询零件
	 * @param pNum
	 * @return
	 */
	public Part query(String pNum);
	
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
	 * 保存零件使用记录
	 * @param record
	 */
	public void savePartUsageRecord(PartUsageRecord record);
	
}




