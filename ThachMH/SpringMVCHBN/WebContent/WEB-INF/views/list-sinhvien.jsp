<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRUD</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<h1 align="center">List Sinh Vien</h1>
	<a href="/SpringMVCHBN/showAdd">ADD Sinh Vien</a>

	<hr />

	<center>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Birth</th>
				<th>City</th>
				<th>Avatar</th>
				<th>Action</th>

			</tr>
			<c:forEach items="${list}" var="s">
				
				<tr>
					<td>${s.id}</td>
					<td>${s.name}</td>
					<td>${s.birth}</td>
					<td>${s.city}</td>
					<td><img alt="image" style="width: 310px"
						src='<c:url value="/image/${entities.nameFile}"></c:url>'></td>

					<td><a href="/SpringMVCHBN/getID/${s.id}"
						class="btn btn-primary">Edit</a></td>
					<td><a href="/SpringMVCHBN/delete/${s.id}"
						class="btn btn-primary"
						onclick="if (!confirm('Are you sure you want to delete this student?')) return false">Delete</a></td>
				</tr>
			</c:forEach>
			<center>
				<c:if test="${page >1}">
					<a href="/SpringMVCHBN/list/1">FIRST</a>
				</c:if>

				<c:if test="${page > 1}">
					<a href="/SpringMVCHBN/list/${page-1}">${page-1}</a>
				</c:if>

				<a href="/SpringMVCHBN/list/${page}">${page}</a>

				<c:if test="${page < total}">
					<a href="/SpringMVCHBN/list/${page+1}">${page+1}</a>
				</c:if>

				<c:if test="${page < total}">
					<a href="/SpringMVCHBN/list/${total}">LAST</a>
				</c:if>
			</center>
		</table>
	</center>
</body>
</html>
