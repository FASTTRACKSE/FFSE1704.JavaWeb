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
	<h1>Employees List</h1>
	<a href="/DISampleHocSinh3/empform">Add New Employee</a>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>MaSV</th>
			<th>Tên SV</th>
			<th>Năm Sinh</th>
			<th>Email</th>
			<th>Địa Chỉ</th>
			<th>Lớp</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.masv}</td>
				<td>${emp.tensv}</td>
				<td>${emp.namsinh}</td>
				<td>${emp.email}</td>
				<td>${emp.diachi}</td>
				<td>${emp.lop}</td>
				<td><a href="/DISampleHocSinh3/editemp/${emp.id}">Edit</a></td>
				<td><a href="/DISampleHocSinh3/deleteemp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="/DISampleHocSinh3/viewemp/1">1</a>
	<a href="/DISampleHocSinh3/viewemp/2">2</a>
	<a href="/DISampleHocSinh3/viewemp/3">3</a>
</body>
</html>