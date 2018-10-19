<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LoiChao</title>
</head>
<body>
<%-- 
	<% for (int i = 0 ; i < 10; i ++) {%>
		<h1>Hello World <%=i %></h1>
	<% }%>
--%>
	<form action = "login" method = "POST">
		UserName: <input type="text" name="user" /> <br>
		PassWord: <input type="password" name="pass" /> <br>
		<input type="submit" value="Submit">
	</form>
	
	
</body>
</html>