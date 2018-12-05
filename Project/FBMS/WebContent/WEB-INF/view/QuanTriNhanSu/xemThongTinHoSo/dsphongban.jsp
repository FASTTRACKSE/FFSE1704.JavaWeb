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
			<h1>Danh sách phòng ban</h1>
		</div>


		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Mã phòng ban</th>
					<th scope="col">Tên phòng ban</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ns" items="${phongban}">
					<tr>
						<td>${ns.maPhongBan}</td>
						<td>${ns.tenPhongBan}</td>
						<td><a href="listThongTin/${ns.maPhongBan }"><button
									class="btn btn-success">Xem</button></a></td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
	</div>
	<spring:url value="/dsphongban/?type=xls" var="xlsURL" />
	<a href="${xlsURL}">Download Excel</a>
</body>
</html>