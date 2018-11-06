<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>List Student</h4>
	<a href="hocsinhform">Add Student</a>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Class</th>
			<th>Gender</th>
			<th>Chức năng</th>
		</tr>
		<c:forEach var="hs" items="${list}">
			<tr>
				<td>${hs.id}</td>
				<td>${hs.nameStudent}</td>
				<td>${hs.classStudent}</td>
				<td>${hs.gender}</td>
				<td><span><a href="editStudent/${hs.id}">Edit</a></span> <span><a
						href="deleteStudent/${hs.id}">Delete</a></span></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>