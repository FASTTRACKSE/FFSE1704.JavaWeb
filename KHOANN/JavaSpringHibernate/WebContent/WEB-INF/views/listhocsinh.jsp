<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="add"><spring:message code="Add" /></a>
	<table border="2" width="70%" cellpadding="2">

		<tr>
			<th><spring:message code="Id" /></th>
			<th><spring:message code="Name" /></th>
			<th><spring:message code="Address" /></th>
			<th><spring:message code="Gender" /></th>
			<th><spring:message code="Image" /></th>
			<th><spring:message code="Function" /></th>

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
				<td><a href="/JavaSpringHibernate/getID/${hs.id}"><spring:message code="Edit" /></a>-+-<a
					href="/JavaSpringHibernate/delete/${hs.id}"><spring:message code="Del" /></a></td>

			</tr>
		</c:forEach>

	</table>
	<center>
		<c:if test="${page >1}">
			<a href="/JavaSpringHibernate/list/1"><spring:message code="FIRST" /></a>
		</c:if>

		<c:if test="${page > 1}">
			<a href="/JavaSpringHibernate/list/${page-1}">${page-1}</a>
		</c:if>

		<a href="/JavaSpringHibernate/list/${page}">${page}</a>

		<c:if test="${page < total}">
			<a href="/JavaSpringHibernate/list/${page+1}">${page+1}</a>
		</c:if>

		<c:if test="${page < total}">
			<a href="/JavaSpringHibernate/list/${total}"><spring:message code="LAST" /></a>
		</c:if>
	</center>
	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="?lang=vi"> <spring:message
						code="tiengviet" />
				</a> <a class="dropdown-item" href="?lang=en"> <spring:message
						code="tienganh" />
				</a>
			</div>
</body>
</html>