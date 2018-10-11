<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.entity.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<c:out value='CRUD-INF/create.jsp' />">Creat</a>
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Fullname</th>
			<th>Age</th>
			<th>CRUD</th>
		</tr>
		<c:forEach var="user" items="${listUser}">
			<tr>
				<td><c:out value="${user.id }" /></td>
				<td><c:out value="${user.username }" /></td>
				<td><c:out value="${user.password }" /></td>
				<td><c:out value="${user.fullname }" /></td>
				<td><c:out value="${user.old }" /></td>
				<td>
					<a href="<c:out value='Edit?id=${user.id}' />">Edit</a> 
					<a href="<c:out value='Update?id=${user.id}' />">Update</a> 
					<a href="<c:out value='Delete?id=${user.id}' />">Delete</a> 
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>