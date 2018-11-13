 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div style="text-align: center;">
			<h1>Danh sách sinh viên</h1>
		</div>
		<div>
			<h3>
				<a href="addSV">Thêm sinh viên</a>
			</h3>
		</div>

		
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Số thứ tự</th>
					<th scope="col">Mã sinh viên</th>
					<th scope="col">Tên sinh viên</th>
					<th scope="col">Ảnh</th>
					<th scope="col">Năm sinh</th>
					<th scope="col">Email</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">Lớp học</th>
					<th scope="col">Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${list}">
					<tr>
						<td>${sv.id}</td>
						<td>${sv.maSV}</td>
						<td>${sv.tenSV}</td>
						<td><img style="width: 50px;" src="<c:url value="img/${sv.images}" />"></td>
						<td>${sv.namSinh}</td>
						<td>${sv.email}</td>
						<td>${sv.diaChi}</td>
						<td>${sv.lopHoc}</td>
						<td><a href="editSV/${sv.id}" class="btn btn-success">Edit</a> <a
							href="deleteSV/${sv.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${page > 1 }">
					<li class="page-item"><a class="page-link" href="1">First</a></li>
					<li class="page-item"><a class="page-link" href="${page -1 }">${page -1 }</a></li>
				</c:if>

				<li class="page-item"><a class="page-link" href="${page }">${page }</a></li>

				<c:if test="${page < totalPage}">
					<li class="page-item"><a class="page-link" href="${page +1 }">${page +1 }</a></li>
					<li class="page-item"><a class="page-link"
						href="${totalPage }">Last</a></li>
				</c:if>
			</ul>
		</nav>
</body>
</html>