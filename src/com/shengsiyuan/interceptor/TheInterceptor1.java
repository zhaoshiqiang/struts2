package com.shengsiyuan.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TheInterceptor1 implements Interceptor {

	/*
	 * 拦截器的配置
		1）编写实现 Interceptor 接口的类。
		2）在 struts.xml 文件中定义拦截器。
		3）在 action 中使用拦截器
	 * */
	//拦截器只能拦截action，而过滤器可以过滤所有内容
	private String test;
	
	public String getTest() {
		return test;
	}
	/*
	 * 在Struts配置文件中设置了初始化参数，set方法比init方法要更早调用。当然，初始化参数类型要匹配
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
