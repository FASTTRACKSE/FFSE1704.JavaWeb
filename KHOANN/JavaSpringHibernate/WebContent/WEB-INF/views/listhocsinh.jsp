<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="add">Add Sinh Vien</a>
	<table border="2" width="70%" cellpadding="2">

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Gender</th>
			<th>Image</th>
			<th>Function</th>

		</tr>
		<c:forEach var="hs" items="${list}">

			<tr>
				<td>${hs.id}</td>
				<td>${hs.name}</td>
				<td>${hs.address}</td>
				<td>${hs.gender}</td>
				<td><img style="width: 100px; height: 100px;"
					src='<c:url value = "/resources/upload/${hs.image }" ></c:url>'
					alt="image"></td>
				<td><a href="/JavaSpringHibernate/getID/${hs.id}">Edit</a>-+-<a
					href="/JavaSpringHibernate/delete/${hs.id}">Del</a></td>

			</tr>
		</c:forEach>

	</table>
	<center>
		<c:if test="${page >1}">
			<a href="/JavaSpringHibernate/list/1">FIRST</a>
		</c:if>

		<c:if test="${page > 1}">
			<a href="/JavaSpringHibernate/list/${page-1}">${page-1}</a>
		</c:if>

		<a href="/JavaSpringHibernate/list/${page}">${page}</a>

		<c:if test="${page < total}">
			<a href="/JavaSpringHibernate/list/${page+1}">${page+1}</a>
		</c:if>

		<c:if test="${page < total}">
			<a href="/JavaSpringHibernate/list/${total}">LAST</a>
		</c:if>
	</center>
</body>
</html>