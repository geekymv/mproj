package com.mproj.service;

import java.util.List;

import com.mproj.dto.MachinePart;
import com.mproj.pojo.Machine;
import com.mproj.utils.PageUtil;

public interface MachineService {
	
	/**
	 * 分页查询设备信息
	 * @param pageNO 页数
	 * @param pageSize 每页显示的记录数
	 * @return
	 */
	public PageUtil<Machine> queryAllByPage(int pageNO, int pageSize);
	
	/**
	 * 保存设备
	 * @param machine
	 * @return
	 */
	public Machine save(Machine machine);
	
	
	/**
	 * 向一个设备上添加一个零件
	 * @param mNum 设备编号
	 * @param pNum 零件编号
	 */
	public void addPart(String mNum, String pNum);
	
	/**
	 * 根据设备编号查询设备
	 * @param mNum
	 * @return
	 */
	public Machine query(String num);

	/**
	 * 根据设备id查询设备
	 * @param mNum
	 * @return
	 */
	public Machine query(Integer id);
	
	/**
	 * 根据设备编号查询设备上的所有零件
	 * @param mNum
	 * @return
	 */
	public List<MachinePart> queryParts(String mNum);

	/**
	 * 判断该设备是否已使用
	 * @param num
	 * @return true 已使用，false 未使用
	 */
	public boolean machineIsUesed(String num);

	/**
	 * 设备维修：
	 * ①将零件从设备上拆解
	 * ②在零件使用记录表中添加使用记录
	 * ③更新零件的已使用时间
	 */
	public void repair(String mNum, String pNum);
	
}
