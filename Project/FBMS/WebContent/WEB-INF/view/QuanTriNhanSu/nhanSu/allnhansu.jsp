<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
			<h1>Danh sách nhân sự</h1>
		</div>


		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Mã nhân viên</th>
					<th scope="col">Mã phòng ban</th>
					<th scope="col">mã chức danh</th>
					<th scope="col">Họ đệm</th>
					<th scope="col">Tên</th>
					<th scope="col">Ảnnh đại diện</th>
					<th scope="col">Năm sinh</th>
					<th scope="col">Giới tính</th>
					<th scope="col">Quê quán</th>
					<th scope="col">Dân tộc</th>
					<th scope="col">Mã quốc tịch</th>
					<th scope="col">Nơi tạm trú</th>
					<th scope="col">SĐT</th>
					<th scope="col">Email</th>
					<th scope="col">CMND</th>
					<th scope="col">Nơi cấp</th>
					<th scope="col">Ngày cấp</th>
					<th scope="col">Trạng thái</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ns" items="${nhansu}">
					<tr>
						<td>${ns.id}</td>
						<td>${ns.maNhanVien}</td>
						<td>${ns.maPhongBan}</td>
						<td>${ns.maChucDanh}</td>
						<td>${ns.hoLot}</td>
						<td>${ns.ten}</td>
						<td>${ns.anhDaiDien}</td>
						<td>${ns.namSinh}</td>
						<td>${ns.gioiTinh}</td>
						<td>${ns.queQuan}</td>
						<td>${ns.danToc}</td>
						<td>${ns.maQuocTich}</td>
						<td>${ns.noiTamTru}</td>
						<td>${ns.soDienThoai}</td>
						<td>${ns.email}</td>
						<td>${ns.soCMND}</td>
						<td>${ns.noiCap}</td>
						<td>${ns.ngayCap}</td>
						<td>${ns.trangThai}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>