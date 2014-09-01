package com.mproj.dao;

import java.util.List;

import com.mproj.pojo.MachineType;

public interface MachineTypeDAO {
	
	/**
	 * 添加设备类型
	 * @return
	 */
	public MachineType addType(MachineType type);
	
	/**
	 * 获取设备类型
	 * @return
	 */
	public MachineType getMachineType(String typeNum);

	/**
	 * 修改设备类型信息
	 * @param type
	 * @return
	 */
	public MachineType updateMachineType(MachineType type);
	
	/**
	 * 查询所有设备类型
	 * @return
	 */
	public List<MachineType> queryAll();
	
	/**
	 * 分页查询设备类型
	 * @param pageNO
	 * @param pageSize
	 * @return
	 */
	public List<MachineType> queryMachineTypeByPage(int pageNO, int pageSize);
		
		

}
