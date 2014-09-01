package com.mproj.service;

import java.util.List;

import com.mproj.pojo.User;

public interface UserService {
	
	/**
	 * 检查用户是否合法
	 * @param user
	 * @return
	 */
	public User loginCheck(User user);
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public List<User> queryAllUser();
	
}
