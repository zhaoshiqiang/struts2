package com.shengsiyuan.exception;

public class UsernameException extends Exception {
	private String message;
	
	public UsernameException(String message)
	{
		//һ�㶼Ҫ���ø���Ĺ��췽��
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
