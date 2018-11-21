<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class=container>
		<h1>Employees List</h1>
		<a href="addStudent">Add New Employee</a>
		<table border="2" width="100%" cellpadding="2">
			<tr>
				<th>Id</th>
				<th>MaSV</th>
				<th>Tên SV</th>
				<th>Năm Sinh</th>
				<th>Email</th>
				<th>Địa Chỉ</th>
				<th>Lớp</th>
				<th>Avatar</th>
				<th>Action</th>
			</tr>
			<c:forEach var="sv" items="${list}">
				<tr>
					<td>${sv.id}</td>
					<td>${sv.masv}</td>
					<td>${sv.tensv}</td>
					<td>${sv.namsinh}</td>
					<td>${sv.email}</td>
					<td>${sv.diachi}</td>
					<td>${sv.lop}</td>
					<td>
						<img src="<c:url value="/images/${sv.image}" />" width="50px" height="50px" />
					</td>
					<td>
						<a href="editStudent/${sv.id}">Edit</a>
						<a href="deleteStudent/${sv.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br />

		<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${page > 1 }">
				<li class="page-item"><a class="page-link" href="1">First</a></li>
				<li class="page-item"><a class="page-link" href="${page -1 }">${page -1 }</a></li>
			</c:if>

			<li class="page-item"><a class="page-link" href="${page }">${page }</a></li>

			<c:if test="${page < totalPage}">
				<li class="page-item"><a class="page-link" href="${page +1 }">${page +1 }</a></li>
				<li class="page-item"><a class="page-link" href="${totalPage }">Last</a></li>
			</c:if>
		</ul>
		</nav>


	</div>

</body>
</html>