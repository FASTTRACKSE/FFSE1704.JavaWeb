<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center;">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>SinhVien List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Birth_year</th>
			<th>Email</th>
			<th>Address</th>
			<th>Class</th>
			<th>Gender</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.name}</td>
				<td>${sv.birth_year}</td>
				<td>${sv.email}</td>
				<td>${sv.address}</td>
				<td>${sv.gender}</td>
				
				<td><a href="editsv/${sv.id}">Edit</a></td>
				<td><a href="deletesv/${sv.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="sinhvienform">Add New SinhVien</a>
</body>
</html>