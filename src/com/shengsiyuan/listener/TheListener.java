package com.shengsiyuan.listener;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;

public class TheListener implements PreResultListener {
	//�����������actionִ��֮����ִ�н������֮ǰִ��
	public void beforeResult(ActionInvocation invocation, String resultCode) {
		// TODO Auto-generated method stub
		System.out.println("result code: " + resultCode);
	}

}
