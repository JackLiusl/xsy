<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>用户登录</h2>
	${authticationError}
	<form method="post" action="">
		用户名：<input type="text" name="username" value="<shiro:principal/>"><br />
		密码:<input type="password" name="password" id="password"> <input
			type="submit" value="Add">
	</form>
</body>
</html>