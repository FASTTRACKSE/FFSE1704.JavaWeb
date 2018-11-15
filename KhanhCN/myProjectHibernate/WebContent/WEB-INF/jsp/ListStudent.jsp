<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Student</title>
</head>
<body>
	<h4>List Student</h4>
	<a href="/myProjectHibernate/add">Add Student</a>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Class</th>
			<th>Gender</th>
			<th>Address</th>
			<th>Avatar</th>
			<th>Chức năng</th>
		</tr>
		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.nameStudent}</td>
				<td>${sv.classStudent}</td>
				<td>${sv.gender}</td>
				<td>${sv.address}</td>
				<td><img style="width: 100px; height: 100px;"
					src='<c:url value = "/resources/upload/${sv.avatar }" ></c:url>'
					alt="avatar"></td>
				<td><span><a
						href="/myProjectHibernate/editStudent/${sv.id}">Edit</a></span> <span><a
						href="/myProjectHibernate/deleteStudent/${sv.id}">Delete</a></span></td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<c:if test="${page >1}">
			<a href="/myProjectHibernate/list/1">FIRST</a>
		</c:if>

		<c:if test="${page > 1}">
			<a href="/myProjectHibernate/list/${page-1}">${page-1}</a>
		</c:if>

		<a href="/myProjectHibernate/list/${page}">${page}</a>

		<c:if test="${page < total}">
			<a href="/myProjectHibernate/list/${page+1}">${page+1}</a>
		</c:if>

		<c:if test="${page < total}">
			<a href="/myProjectHibernate/list/${total}">LAST</a>
		</c:if>
	</div>
</body>
</html>