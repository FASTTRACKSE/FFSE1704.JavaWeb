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
	<div>
		<div style="text-align: center;">
			<h1>HỆ THỐNG QUẢN LÝ NHÂN SỰ</h1>
		</div>
		<div>
			<h3>
				<a href="addNS">THÊM NHÂN SỰ</a>
			</h3>
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
					<th scope="col">Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ns" items="${nhansu}">
					<tr>
						<td>${ns.id}</td>
						<td>${ns.maNhanVien}</td>
						<td>${ns.phongBan.tenPhongBan}</td>
						<td>${ns.chucDanh.tenChucDanh}</td>
						<td>${ns.hoLot}</td>
						<td>${ns.ten}</td>
						<td><img style="width:70px;hight=70px;" src="<c:url value="uploads/${ns.anhDaiDien}"/>">
						
						</td>
						
						<td>${ns.namSinh}</td>
						<td><c:choose>
							<c:when test="${ns.gioiTinh == 1}">
						    Nam
						  </c:when>
							<c:when test="${ns.gioiTinh == 2}">
						   Nữ
						  </c:when>
							<c:otherwise>
						   ...
						  </c:otherwise>
							</c:choose></td>
						<%-- <td>${ns.gioiTinh}</td> --%>
						<td>${ns.queQuan}</td>
						<td>${ns.danToc}</td>
						<td>${ns.quocTich.tenQuocTich}</td>
						<td>${ns.noiTamTru}</td>
						<td>${ns.soDienThoai}</td>
						<td>${ns.email}</td>
						<td>${ns.soCMND}</td>
						<td>${ns.noiCap}</td>
						<td>${ns.ngayCap}</td>
						<td><c:choose>
							<c:when test="${ns.trangThai == 1}">
						    Còn Làm
						  </c:when>
							<c:when test="${ns.trangThai == 2}">
						   Nghỉ
						  </c:when>
							<c:otherwise>
						  ...
						  </c:otherwise>
							</c:choose></td>
						<%-- <td>${ns.trangThai}</td> --%>
						<td><a href="editNS/${ns.id}" class="btn btn-success">edit</a>
							<a href="DeleteNS/${ns.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="container" style="float: right">
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
		</div>
	</div>
	
</body>
</html>