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
	<a href="/myProjectSpring/hocsinhform">Add Student</a>
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
		<c:forEach var="hs" items="${list}">
			<tr>
				<td>${hs.id}</td>
				<td>${hs.nameStudent}</td>
				<td>${hs.classStudent}</td>
				<td>${hs.gender}</td>
				<td>${hs.address}</td>
				<td><img src = "/myProjectSpring/images/${hs.avatar}" width="60px" height="60px"/></td>
				<td><span><a href="/myProjectSpring/editStudent/${hs.id}">Edit</a></span> <span><a
						href="/myProjectSpring/deleteStudent/${hs.id}">Delete</a></span></td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<c:if test="${pageid > 1}">
			<a href="/myProjectSpring/viewhs/1">First</a>
		</c:if>
		<c:if test="${pageid > 1}">
			<a href="/myProjectSpring/viewhs/${pageid-1}">${pageid-1}</a>
		</c:if>
		<a href="/myProjectSpring/viewhs/${pageid}">${pageid}</a>
		<c:if test="${pageid < pagetotal}">
			<a href="/myProjectSpring/viewhs/${pageid+1}">${pageid+1}</a>
		</c:if>
		<c:if test="${pageid < pagetotal}">
			<a href="/myProjectSpring/viewhs/${pagetotal}">Last</a>
		</c:if>
	</div>


</body>
</html>