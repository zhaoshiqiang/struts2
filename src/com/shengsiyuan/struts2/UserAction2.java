package com.shengsiyuan.struts2;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.shengsiyuan.bean.User;

public class UserAction2 extends ActionSupport {
	private List<User> user;

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		for(User u:user){
			System.out.println(u.getUsername() + ", " + u.getPassword());
		}
		return SUCCESS;
	}
}
