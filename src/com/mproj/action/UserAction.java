package com.mproj.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.User;
import com.mproj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Scope("prototype")
@Controller("userAction")
public class UserAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -2348593734993697319L;
	
	@Autowired
	private UserService userService;
	
	private Map<String, Object> session;
	private User user;
	private String rememberMe;
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}
	public String getRememberMe() {
		return rememberMe;
	}
	
	/**
	 * 登录验证
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		
//		System.out.println("login method is invoked");
		System.out.println("username = " + user.getUsername());
		System.out.println("password = " + user.getPassword());
//		System.out.println("rememberMe = " + rememberMe);

		user = userService.loginCheck(user);
		
		if(null != user){	//验证成功
			session.put("user", user);
			return SUCCESS;
		}
		
		this.addActionError("用户名或密码错误！请重新输入....");
		return LOGIN;
	}

	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}










