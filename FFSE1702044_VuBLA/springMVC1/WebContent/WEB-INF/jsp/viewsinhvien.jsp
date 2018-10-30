<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Danh sách Sinh Viên</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Tên SV</th>
			<th>Năm Sinh</th>
			<th>Địa Chỉ</th>
			<th>Lớp Học</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.tenSV}</td>
				<td>${sv.namSinh}</td>
				<td>${sv.diaChi}</td>
				<td>${sv.lopHoc}</td>
				<td><a href="editemp/${sv.id}">Edit</a></td>
				<td><a href="deleteemp/${sv.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>