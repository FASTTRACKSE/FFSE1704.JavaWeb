<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông Tin</title>
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
			<h1>Thông Tin Gia Đình</h1>
		</div>
		<div>
			<h3>
				<a href="#">Thêm thông tin</a>
			</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Mã Nhân Viên</th>
					<th scope="col">Họ Và Tên</th>
					<th scope="col">Quan Hệ</th>
					<th scope="col">Năm Sinh</th>
					<th scope="col">Nghề Nghiệp</th>
					<th scope="col">Địa Chỉ</th>
					<th scope="col">Chức Năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tt" items="${thongtin}">
					<tr>
						<td>${tt.id}</td>
						<td>${tt.nhanSu.maNhanVien}</td>
						<td>${tt.hoVaTen}</td>
						<td>${tt.quanHe}</td>
						<td>${tt.namSinh}</td>
						<td>${tt.ngheNghiep}</td>
						<td>${tt.diaChi}</td>
						<td><a href="#" class="btn btn-success">Edit</a> <a href="#"
							class="btn btn-danger">Delete</a></td>
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
				<li class="page-item"><a class="page-link" href="${totalPage }">Last</a></li>
			</c:if>
		</ul>
		</nav>
	</div>
</body>
</html>