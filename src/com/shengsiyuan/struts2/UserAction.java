package com.shengsiyuan.struts2;

import com.opensymphony.xwork2.ActionSupport;
import com.shengsiyuan.bean.User;

public class UserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		
		return SUCCESS;
	}
}
