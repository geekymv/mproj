package com.mproj.dao;

import java.util.List;

import com.mproj.dto.PartScrap;
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

	/**
	 * 分页查询零件使用记录
	 * @param partNum
	 * @param pageSize 
	 * @param page 
	 * @return
	 */
	public PageUtil<PartUsageRecord> queryPartUsageRecord(String partNum, int page, int pageSize);

	/**
	 * 查询零件的使用记录
	 * @param partNum
	 * @return
	 */
	public List<PartUsageRecord> queryPartUsageRecord(String partNum);

	/**
	 * 保存零件报废记录
	 * @param partScrap
	 */
	public void save(PartScrap partScrap);

}




