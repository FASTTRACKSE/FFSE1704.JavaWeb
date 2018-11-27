<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Sinh Viên</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous" />
</head>
<body>
	
	<div class="container">
	
	<nav aria-label="Page navigation example">
	<ul class="pagination">
	
		<c:if test="${indexPage > 1}">
				<li class="page-item"><a
					href="/QLSV_CRUD_Spring/view/1" class="page-link">First</a></li>
		</c:if>


		<c:if test="${indexPage > 1}">
				<li class="page-item"><a
					href="/QLSV_CRUD_Spring/view/${indexPage-1}"
					class="page-link">${indexPage-1}</a></li>
		</c:if>

		
			<li class="page-item"><a
				href="/QLSV_CRUD_Spring/view/${indexPage}" class="page-link">${indexPage}</a></li>
		

		<c:if test="${indexPage < allPage}">
				<li class="page-item"><a
					href="/QLSV_CRUD_Spring/view/${indexPage+1}"
					class="page-link">${indexPage+1}</a></li>
		</c:if>

		<c:if test="${indexPage < allPage}">
				<li class="page-item"><a
					href="/QLSV_CRUD_Spring/view/${allPage}" class="page-link">Last</a></li>
		</c:if>

	</ul>
	</nav>
	
		<a href="/QLSV_CRUD_Spring/add" class="btn btn-success">Add</a>
		<table class="table table-striped">
			<tr>
				<th>Tên Sinh Viên</th>
				<th>Mã Sinh Viên</th>
				<th>Lớp Học</th>
				<th>Tuổi</th>
				<th>Giới Tính</th>
				<th>Địa Chỉ</th>
				<th>Số Điện Thoại</th>
				<th>Email</th>
				<th>Avatar</th>
				<th>Action</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.tenSinhVien}</td>
					<td>${emp.maSinhVien}</td>
					<td>${emp.lop}</td>
					<td>${emp.tuoi}</td>
					<td>${emp.gioiTinh}</td>
					<td>${emp.diaChi}</td>
					<td>${emp.soDT}</td>
					<td>${emp.email}</td>
					<td><img width="100px" height="100px" src="<c:url value="/images/${emp.avatar}" />"/></td>
					<td><a href="/QLSV_CRUD_Spring/edit/${emp.maSinhVien}"
						class="btn btn-primary">edit</a> <a
						href="/QLSV_CRUD_Spring/delete/${emp.maSinhVien}"
						class="btn btn-danger">delete</a>
						<a
						href="/QLSV_CRUD_Spring/search/${emp.maSinhVien}"
						class="btn btn-danger">search</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="/QLSV_CRUD_Spring/view/1">1</a> <a
			href="/QLSV_CRUD_Spring/view/2">2</a> <a
			href="/QLSV_CRUD_Spring/view/3">3</a>
	</div>
</body>
</html>
