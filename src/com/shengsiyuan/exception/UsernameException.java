package com.shengsiyuan.exception;

public class UsernameException extends Exception {
	private String message;
	
	public UsernameException(String message)
	{
		//一般都要调用父类的构造方法
		super(message);
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
