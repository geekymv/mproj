package com.mproj.dao;

import java.util.List;

import com.mproj.dto.MachinePart;
import com.mproj.pojo.Machine;
import com.mproj.pojo.Part;
import com.mproj.utils.PageUtil;

public interface MachineDAO {
	
	/**
	 * 添加设备
	 * @param machine
	 * @return
	 */
	public Machine save(Machine machine);

	/**
	 * 根据设备id查询设备
	 * @param id
	 * @return
	 */
	public Machine query(Integer id);
	
	/**
	 * 根据设备编号查询设备
	 * @param mNum
	 * @return
	 */
	public Machine query(String num);
	
	/**
	 * 根据设备编号查询设备上的所有零件
	 * @param mNum
	 * @return
	 */
	public List<MachinePart> queryParts(String mNum);
	

	/**
	 * 分页查询设备信息
	 * @param pageNO 页数
	 * @param pageSize 每页显示的记录数
	 * @return
	 */
	public PageUtil<Machine> queryAllByPage(int pageNO, int pageSize);
	
	/**
	 * 获得设备表中记录总数
	 * @return
	 */
	public int getAllRowCount();
	
	/**
	 * 保存
	 * @param machinePart
	 */
	public void saveMachinePart(MachinePart machinePart);
	
}




