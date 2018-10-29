<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="language" />

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><fmt:message key="titleListSvScreen" /></title>
	</head>
	<body>
		<cs:header />
		<h1><fmt:message key="titleListSvScreen" /></h1>
		<table border="1" style="width: 100%">
			<tr>
				<td colspan="4"><a href="addSinhVien"><fmt:message key="addSv" /></a></td>
			</tr>
			<c:choose>
				<c:when test="${not empty listSinhVien}">
					<tr>
						<th><fmt:message key="codeSv" /></th>
						<th><fmt:message key="nameSv" /></th>
						<th><fmt:message key="passSv" /></th>
						<th><fmt:message key="menu" /></th>
					</tr>
					<c:forEach var="sinhVien" items="${listSinhVien}">
						<tr>
							<td>${sinhVien.maSinhVien}</td>
							<td>${sinhVien.tenSinhVien}</td>
							<td>${sinhVien.pass}</td>
							<td>
								<a href="editSinhVien?maSinhVien=${sinhVien.maSinhVien}">
									<fmt:message key="editSv"/>
								</a>
								|
								<a href="deleteSinhVien?maSinhVien=${sinhVien.maSinhVien}">
									<fmt:message key="deleteSv"/>
								</a>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="4">
							<cs:paging totalPage="${totalPage}" currentPage="${currentPage}"></cs:paging>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="4" style="color: red"><fmt:message key="error.listSvEmpty"/></td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
	</body>
</html>