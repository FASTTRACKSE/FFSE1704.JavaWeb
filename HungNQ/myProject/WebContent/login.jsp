<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Xin chào bạn!</p>
	<form action="LoginServlet" method="post">
		Username: <input type="text" name="user" /> 
		Password: <input type="password" name="pass" /><br /> 
		<input type="submit" value="Login">
	</form>
</body>
</html>