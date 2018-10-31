<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>Sinh Viên List</h1>

<a href="addSV">Add New Students</a>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Mã Sinh Viên</th>
		<th>Tên Sinh Viên</th>
		<th>Năm Sinh</th>
		<th>Email</th>
		<th>Địa Chỉ</th>
		<th>Lớp học</th>
		<th>Chức Năng</th>
	</tr>
	<c:forEach var="sv" items="${list}">
		<tr>
			<td>${sv.id}</td>
			<td>${sv.maSV}</td>
			<td>${sv.tenSV}</td>
			<td>${sv.namSinh}</td>
			<td>${sv.email}</td>
			<td>${sv.diaChi}</td>
			<td>${sv.lopHoc}</td>
			<td><a href="editSV/${sv.id}">Edit</a></td>
			<td><a href="deleteSV/${sv.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
