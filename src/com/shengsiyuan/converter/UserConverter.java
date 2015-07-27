package com.shengsiyuan.converter;

import java.util.Map;
import java.util.StringTokenizer;

import com.shengsiyuan.bean.User;

import ognl.DefaultTypeConverter;

public class UserConverter extends DefaultTypeConverter {
	
	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		// TODO Auto-generated method stub
		if(User.class == toType)	//从页面向后台转
		{
			String[] str=(String[])value;
			String firstValue=str[0];
			
			StringTokenizer st=new StringTokenizer(firstValue,";");
			
			String username=st.nextToken();
			String password=st.nextToken();
			
			User user=new User();
			user.setUsername(username);
			user.setPassword(password);
			return user;
		}else if(String.class == toType)	//从后台向页面转
		{
			User user=(User)value;
			
			String username=user.getUsername();
			String password=user.getPassword();
			
			String info=username+";"+password;
			return info;
		}
		
		return null;
	}
}
