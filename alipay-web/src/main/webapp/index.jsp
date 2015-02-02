<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">
<title>用户登录</title>
</head>
<body>
	<form action="login.do" method="post">
		<input type="text" name="username" /> <br /> 
		<input type="password" name="passcode" /> <br /> 
		<input type="submit" value="登录">
	</form>
</body>
</html>