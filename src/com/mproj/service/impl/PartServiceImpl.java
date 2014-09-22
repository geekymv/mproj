package com.mproj.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.PartDAO;
import com.mproj.dto.PartScrap;
import com.mproj.dto.PartUsageRecord;
import com.mproj.pojo.Part;
import com.mproj.service.PartService;
import com.mproj.utils.PageUtil;

@Service("partService")
public class PartServiceImpl implements PartService {

	@Autowired
	private PartDAO partDAO;
	
	@Override
	public Part add(Part part) {
		return partDAO.save(part);
	}

	@Override
	public Part query(Integer id) {
		return partDAO.query(id);
	}

	@Override
	public PageUtil<Part> list(int page, int pageSize) {
		
		return partDAO.list(page, pageSize);
	}

	@Override
	public PageUtil<PartUsageRecord> queryPartUsageRecord(String partNum,
			int page, int pageSize) {
		
		return partDAO.queryPartUsageRecord(partNum, page, pageSize);
	}

	@Override
	public List<PartUsageRecord> queryPartUsageRecord(String partNum) {
		
		return partDAO.queryPartUsageRecord(partNum);
	}

	@Override
	public void scrap(String partNum) {
		List<PartUsageRecord> purs = partDAO.queryPartUsageRecord(partNum);
		
		for(PartUsageRecord pur : purs) {
			pur.setUsable(false);
		}
		
		Part part = partDAO.query(partNum);
		
		PartScrap partScrap = new PartScrap();
		partScrap.setPart(part);
		partScrap.setScrapDate(new Date());
		
		partDAO.save(partScrap);
		
		
	}
	
}
