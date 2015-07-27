<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h2><font color="blue">用户注册</font></h2>
  	<!-- 显示action级别的错误 -->
  	<s:actionerror cssStyle="color:red"/>
  	------------------------------------
  	<!-- 显示field级别的错误 -->
  	<s:fielderror cssStyle="color:blue"></s:fielderror>
  	
  	<!-- 
    <form action="register.action">
    
    username:	<input type="text" name="username"><br>
    password:	<input type="password" name="password"><br>
    repassword:	<input type="password" name="repassword"><br>
    age;		<input type="text" name="age"><br>
    birthday:	<input type="text" name="birthday"><br>
    graduation:	<input type="text" name="graduation"><br>
    <input type="submit" name="submit">
    </form>
    -->
    
    <!-- 这个表单会自动呈现field级别的错误信息 -->
    <!--  
    <s:form action="register.action">
    <s:textfield name="username" label="username"></s:textfield>
    <s:password name="password" label="password"></s:password>
    <s:password name="repassword" label="repassword"></s:password>
    <s:textfield name="age" label="age"></s:textfield>
    <s:textfield name="birthday" label="birthday"></s:textfield>
    <s:textfield name="graduation"></s:textfield>
    <s:submit value="submit"></s:submit>
    </s:form>
    -->
    
    <!--  -->
    <s:form action="register.action" theme="simple">
    
    username: <s:textfield name="username" label="username"></s:textfield><br>
    password: <s:password name="password" label="password"></s:password><br>
    repassword: <s:password name="repassword" label="repassword"></s:password><br>
    age: <s:textfield name="age" label="age"></s:textfield><br>
    birthday: <s:textfield name="birthday" label="birthday"></s:textfield><br>
    graduation: <s:textfield name="graduation" label="graduation"></s:textfield><br>
    
    <s:submit value="submit"></s:submit>
    </s:form>
    
  
    
    
  </body>
</html>
