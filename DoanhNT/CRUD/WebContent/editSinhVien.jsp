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
		<title>Insert title here</title>
	</head>
	<body>
		<cs:header />
		<h1><fmt:message key="titleEditSvScreen" /></h1>
		<form action="editSinhVien" method="post">
			<table border="1">
				<tr>
					<td><fmt:message key="codeSv" />:</td>
					<td>
						${sinhVien.maSinhVien}
						<input value="${sinhVien.maSinhVien}" type="hidden" name="maSinhVien"/>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="nameSv" />:</td>
					<td><input value="${sinhVien.tenSinhVien}" name="tenSinhVien"/></td>
				</tr>
				<tr>
					<td><fmt:message key="passSv" />:</td>
					<td><input value="${sinhVien.pass}" name="pass"/></td>
				</tr>
				<tr><td colspan="2"><input type="submit" value="Edit" /></td></tr>
			</table>
			
		</form>
		<a href="${pageContext.request.contextPath}" >Back to list</a>
	</body>
</html>