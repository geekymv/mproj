package com.mproj.dao.impl;

import java.util.List;

import org.hibernate.Query;
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
	public User loginCheck(User user) {
		String hql = "from User where username= :username and password= :password";

		Session session = this.getSession();
		
		Query query = session.createQuery(hql);
		query.setString("username", user.getUsername());
		query.setString("password", user.getPassword());

		user = (User) query.uniqueResult();

		return user;
	}

	@Override
	public List<User> queryAllUser() {
		return null;
	}

}
