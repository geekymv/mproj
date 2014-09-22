package com.mproj.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mproj.pojo.User;
import com.mproj.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 4444341950906097844L;

	@Autowired
	private UserService userService;
	
	private String username;
	private String password;
	
	/**
	 * 登录验证
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {

		User user = userService.loginCheck(username, password);
		
		if(null != user){	//验证成功
			session.put("user", user);
			
			return SUCCESS;
		}
		
//		this.addActionError("用户名或密码错误！请重新输入....");
		
//		this.addFieldError("username", "用户名或密码错误！");
		
		return INPUT;
	}

	private Map<String, Object> session;	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}










