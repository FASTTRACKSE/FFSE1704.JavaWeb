<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update CHỨNG CHỈ</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">Delete CHỨNG CHỈ</h1>
		<form:form method="post" action="/FBMS/deleteCC"
			modelAttribute="chungchi">
			<div class="form-group">
				<form:hidden path="ID" />
				<br>
			</div>
			<div class="form-group">
				<label>Mã nhân viên:</label>
				<form:input class="form-control" type="text" path="maNhanVien" />
				<br>
			</div>
			<div class="form-group">
				<label>Tên Chứng Chỉ:</label>
				<form:input class="form-control" type="text" path="tenChungChi" />
				<br>
			</div>
			<div class="form-group">
				<label>Ngày Cấp:</label>
				<form:input class="form-control" type="date" path="ngayCap" />
				<br>
			</div>
			<div class="form-group">
				<label>Đơn Vị Cấp:</label>
				<form:input class="form-control" type="text" path="donViCap" />
				<br>
			</div>
			<tr>
				<td><input type="submit" value=Xóa /></td>
			</tr>
		</form:form>
	</div>
</body>
</html>