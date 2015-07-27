package com.shengsiyuan.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TheInterceptor1 implements Interceptor {

	/*
	 * ������������
		1����дʵ�� Interceptor �ӿڵ��ࡣ
		2���� struts.xml �ļ��ж�����������
		3���� action ��ʹ��������
	 * */
	//������ֻ������action�������������Թ�����������
	private String test;
	
	public String getTest() {
		return test;
	}
	/*
	 * ��Struts�����ļ��������˳�ʼ��������set������init����Ҫ������á���Ȼ����ʼ����������Ҫƥ��
	 * */
	public void setTest(String test) {
		System.out.println("setTest invoked!");
		this.test = test;
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init() {
		
		System.out.println("init invoked!");
		System.out.println("test: " + this.test);
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("before");
		String result=invocation.invoke();
		System.out.println("after");
		return result;
	}

}
