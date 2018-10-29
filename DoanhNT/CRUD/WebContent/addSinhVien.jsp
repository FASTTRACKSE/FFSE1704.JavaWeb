<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="language" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><fmt:message key="titleAddSvScreen" /></title>
	</head>
	<body>
		<cs:header />
		<h1><fmt:message key="titleAddSvScreen" /></h1>
		<form action="addSinhVien" method="post">
			<table border="1">
				<tr>
					<td><fmt:message key="codeSv"/></td>
					<td><input type="text" name="codeSv"/></td>
				</tr>
				<tr>
					<td><fmt:message key="nameSv"/></td>
					<td><input type="text" name="nameSv"/></td>
				</tr>
				<tr>
					<td><fmt:message key="passSv"/></td>
					<td><input type="text" name="passSv"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add"/></td>
				</tr>
			</table>
		</form>
		<a href="${pageContext.request.contextPath}" >Back to list</a>
	</body>
</html>