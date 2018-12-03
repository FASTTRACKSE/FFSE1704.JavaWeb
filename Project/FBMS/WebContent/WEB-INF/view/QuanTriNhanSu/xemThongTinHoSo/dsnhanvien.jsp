<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Danh sách nhân viên</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Danh sách nhân viên</h2>
		<c:forEach var="sv" items="${listThongTin}">
		<p>
			Phòng Ban : <a style="color: red">${sv.phongBan.tenPhongBan}</a>
		</p>
		</c:forEach>
		<table class="table">
			<thead>
				<tr>
					<th>Mã NV</th>
					<th>Tên Nhân Viên</th>
					<th>Xem</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${listThongTin}">
					<tr class="table-primary">
						<td>${sv.maNhanVien}</td>
						<td>${sv.hoLot}<a> ${sv.ten}</a></td>

						<td>
							<a href="/FBMS/thongTinNhanVien/${sv.maNhanVien}"><button
									class="btn btn-primary">Xem chi tiết</button></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>

