package com.shengsiyuan.converter;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.struts2.util.StrutsTypeConverter;

import com.shengsiyuan.bean.User;

public class UserConverter2 extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		// TODO Auto-generated method stub
		User user = new User();
		
		String value = values[0];
		
		StringTokenizer st = new StringTokenizer(value, ";");
		
		user.setUsername(st.nextToken());
		user.setPassword(st.nextToken());
		
		return user;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		User user = (User)o;
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		String userInfo = "username: " + username + ", password: " + password;
		
		return userInfo;
	}

}
