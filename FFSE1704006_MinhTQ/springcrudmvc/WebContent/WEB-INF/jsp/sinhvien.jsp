<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="2" width="100%" height="150" cellpadding="0" cellspacing="0">
		<tr>
			<th>Id</th>
			<th>tên</th>
			<th>tuổi</th>
			<th>địa chỉ</th>
			<th>email</th>
			<th>Chức năng</th>
		</tr>
		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.tenHocSinh}</td>
				<td>${sv.tuoiHocSinh}</td>
				<td>${sv.diaChi}</td>
				<td>${sv.email}</td>
				<td><span><a href="">Edit</a></span>  <span><a href="">Delete</a></span></td>
				

			</tr>
		</c:forEach>
	</table>
</body>
</html>