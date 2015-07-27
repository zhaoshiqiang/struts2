package com.shengsiyuan.struts2;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.shengsiyuan.bean.User;
import com.shengsiyuan.exception.PasswordException;
import com.shengsiyuan.exception.UsernameException;

public class LoginAction extends ActionSupport implements Preparable{
	
	private String username;
	
	private String password;
	
	private int age;
	
	private Date date;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	public String execute() throws Exception
	{
//		if(!"hello".equals(username))
//		{
//			throw new UsernameException("username invalid!");
//		}
//		if(!"world".equals(password))
//		{
//			throw new PasswordException("password invalid!");
//		}
		
//		HttpServletRequest request=ServletActionContext.getRequest();
//		HttpSession session=request.getSession();
//		session.setAttribute("hello", username);
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		
		ActionContext.getContext().getSession().put("userInfo", user);
		
		return SUCCESS;
	}
	
	public String myExecute() throws Exception
	{
		System.out.println("myExecute invoked!!");
		
		return SUCCESS;
	}
	
	public void validateMyExecute()
	{
		System.out.println("validateMyExecute invoked!!");
		
		this.addActionError("action error");
	}
	/*
	 * 当在 Action 中指定了自定义的 execute 方法时，首先会执行自定义
		的 execute 方法所对应的输入校验方法，然后再去执行 validate 方
		法，执行完毕后如果出现了任何错误都不会再去执行自定义的
		execute 方法，流程转向了 input 这个名字所对应的页面上。
	 * */
	@Override
	public void validate()
	{
		//System.out.println("validate invoked!");
		
		//this.addActionError("action error");
	}
	/*
	 * Preparable 接口的作用是让 Action 完成一些初始化工作，
	 * 这些初始化工作是放在 Preparable 接口的 prepare 方法中完成的，
	 * 该方法会在 execute 方法执行之前得到调用。
	 * */
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("prepare invoked!!");
	}
	
}
