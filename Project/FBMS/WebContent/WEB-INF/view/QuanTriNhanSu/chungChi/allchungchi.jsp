<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chứng Chỉ</title>
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
			<h1>Danh sách chứng chỉ</h1>
		</div>
		<div>
			<h3>
				<a href="/FBMS/QuanTriNhanSu/danhsach_chungchi/addCC">Thêm sinh
					viên</a>
			</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Mã Nhân Viên</th>
					<th scope="col">Tên Chứng Chỉ</th>
					<th scope="col">Ngày Cấp</th>
					<th scope="col">Đơn vị cấp</th>
					<th scope="col">Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cc" items="${chungchi.listChungChi}">
					<tr>
						<td>${cc.ID}</td>
						<td>${cc.nhanSu.maNhanVien}</td>
						<td>${cc.tenChungChi}</td>
						<td>${cc.ngayCap}</td>
						<td>${cc.donViCap}</td>
						<td><a
							href="/FBMS/QuanTriNhanSu/danhsach_chungchi/updateCC/${cc.ID}"
							class="btn btn-success">Edit</a> <a
							href="/FBMS/QuanTriNhanSu/danhsach_chungchi/deleteCC/${cc.ID}"
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