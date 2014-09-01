package com.mproj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mproj.dao.UserDAO;
import com.mproj.pojo.User;
import com.mproj.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO = null;
	
	
	@Override
	public User loginCheck(User user) {
		
		return userDAO.loginCheck(user);
	}

	@Override
	public List<User> queryAllUser() {
		
		return userDAO.queryAllUser();
	}
	
}
