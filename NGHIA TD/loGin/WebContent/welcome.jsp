<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<a href="<c:out value='create.jsp' />">create</a>
<body>
	<table border="1" width="100%">
		<tr>
			<th>username</th>
			<th>password</th>
			<th>fullname</th>
			<th>old</th>
			<th>crud</th>
		</tr>
		<c:forEach var="user" items="${arrList}">
			<tr>
				<td><c:out value="${user.username}"/></td>
				<td><c:out value="${user.password}"/></td>
				<td><c:out value="${user.fullname}"/></td>
				<td><c:out value="${user.old}"/></td>
				<td>
					<a href="editUser?id=${user.id}">Edit</a>
					
						<a href="">Delete</a>
					<a href="<c:out value='create.jsp' />">update</a>
					<a href="<c:out value='create.jsp' />">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>