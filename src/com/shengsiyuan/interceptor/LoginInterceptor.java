package com.shengsiyuan.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shengsiyuan.struts2.LoginAction;

public class LoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		//将过滤器设置为全局过滤器，之后对不进行过滤的action进行排除
		if(LoginAction.class == invocation.getAction().getClass())
		{
			return invocation.invoke();
		}
		
		Map map = invocation.getInvocationContext().getSession();
		
		if(null == map.get("userInfo"))
		{
			return Action.LOGIN;
		}
		
		return invocation.invoke();
	}

}
