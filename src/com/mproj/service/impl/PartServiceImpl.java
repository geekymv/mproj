package com.mproj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.PartDAO;
import com.mproj.pojo.Part;
import com.mproj.service.PartService;

@Service("partService")
public class PartServiceImpl implements PartService {

	@Autowired
	private PartDAO partDAO;
	
	
	
	@Override
	public Part add(Part part) {
		return partDAO.save(part);
	}
	
}
