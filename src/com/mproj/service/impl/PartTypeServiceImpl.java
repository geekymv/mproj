package com.mproj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.PartTypeDAO;
import com.mproj.pojo.PartType;
import com.mproj.service.PartTypeService;

@Service("partTypeService")
public class PartTypeServiceImpl implements PartTypeService{

	@Autowired
	private PartTypeDAO partTypeDAO;
	
	@Override
	public List<PartType> list() {
		
		return partTypeDAO.list();
	}
	
	
	

}
