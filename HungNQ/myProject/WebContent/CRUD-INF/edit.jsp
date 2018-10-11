<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit nè!</title>
</head>
<body>
	<form action="edit" method="post">
		<input type="hidden" value="${user.id}" name="id"/>
		Username: <input type="text" value="${user.username}" name="username" disabled="disabled" />
		Password: <input type="text" value="${user.password}" name="password" disabled="disabled" />
		Fullname: <input type="text" value="${user.fullname}" name="fullname"disabled="disabled" />
		Age: <input type="text" value="${user.old }" name="old" disabled="disabled" />
		<input type="submit" value="comback" name="submit"/>
	</form>
	<a href="<%=request.getContextPath()%>/LoginServlet">Comback List</a>
</body>
</html>