<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Class</th>
			<th>Gender</th>
		</tr>
		<c:forEach var="hs" items="${list}">
			<tr>
				<td>${hs.id}</td>
				<td>${hs.nameStudent}</td>
				<td>${hs.classStudent}</td>
				<td>${hs.gender}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>