package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mproj.dao.UserDAO;
import com.mproj.pojo.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public User loginCheck(String username, String password) {
		String hql = "from User user where user.username=? and user.password=?";
		
		User user = (User) getSession().createQuery(hql)
			.setString(0, username)
			.setString(1, password)
			.uniqueResult();
		
		System.out.println(hql);
		
		return user;
	}

	@Override
	public List<User> queryAllUser() {
		return null;
	}

}
