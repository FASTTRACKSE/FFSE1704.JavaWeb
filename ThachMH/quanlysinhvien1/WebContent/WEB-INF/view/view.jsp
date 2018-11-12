<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>XXXX</title>
</head>
<body style="text-align: center;">
	<h1>SinhVien List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Birth_year</th>
			<th>Email</th>
			<th>Address</th>
			<th>NameClass</th>
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
				<td>${sv.lop}</td>
				<td>${sv.gender}</td>
				<td><a href="editSV/${sv.id}">Edit</a></td>
				<td><a href="deletesv/${sv.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addSV">Add New SinhVien</a>
</body>
</html>