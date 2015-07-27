package com.shengsiyuan.listener;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class TheListener implements PreResultListener {
	//这个监听器在action执行之后但是执行结果返回之前执行
	public void beforeResult(ActionInvocation invocation, String resultCode) {
		// TODO Auto-generated method stub
		System.out.println("result code: " + resultCode);
	}

}
