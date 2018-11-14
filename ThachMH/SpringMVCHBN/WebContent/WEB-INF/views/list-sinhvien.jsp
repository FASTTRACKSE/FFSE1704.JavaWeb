<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">List Sinh Vien</h1>
	<button onclick="window.location.href = 'showAdd'; return false;">Add
		Sinh Vien</button>

	<hr />

	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Birth</th>
				<th>City</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${sinhVienList}" var="s">
				<c:url var="updateLink" value="/sinhvien/displayUpdateForm.html">
					<c:param name="sinhVienID" value="${s.id}" />
				</c:url>

				<c:url var="deleteLink" value="/sinhvien/displayDeleteForm.html">
					<c:param name="sinhVienID" value="${s.id}" />
				</c:url>
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.birth}</td>
					<td>${s.city}</td>

					<td><a href="${updateLink}">Update</a> | <a
						href="${deleteLink}"
						onclick="if(!(confirm('Are you sure want to delete this Student permanently?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>