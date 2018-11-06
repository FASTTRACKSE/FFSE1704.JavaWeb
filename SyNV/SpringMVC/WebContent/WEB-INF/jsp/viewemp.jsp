<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>Sinh Viên List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Mã Sinh Viên</th>
		<th>Tên Sinh Viên</th>
		<th>Năm Sinh</th>
		<th>Email</th>
		<th>Địa Chỉ</th>
		<th>Lớp học</th>
		<th>Image</th>
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
			<td>${emp.lophoc}</td>
			<td><img src="images/${emp.image}" width="50px" /></td>
			<td><a href="editemp/${emp.id}">Edit</a></td>
			<td><a href="deleteSV/${emp.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="empform">Add New Student</br></a>

<a href="/SpringMVC/viewemp/1">1</a>
<a href="/SpringMVC/viewemp/2">2</a>
<a href="/SpringMVC/viewemp/3">3</a>
