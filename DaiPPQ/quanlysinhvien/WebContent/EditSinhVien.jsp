<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<a href="sinhvien?page=1"><input type="button"
			class="btn btn-success" value="Back" name="control"></a>

		<form action="EditSinhVienServlet" method="post">
			<div class="form-group">
				<label>ID: </label> <input type="hidden" class="form-control"
					name="id" value="${SinhVien.id}"><strong>${SinhVien.id}</strong>
			</div>

			<div class="form-group">
				<label>Mã Sinh Viên: </label> <input type="text"
					class="form-control" name="masv" value="${SinhVien.masv}">
			</div>

			<div class="form-group">
				<label>Họ Sinh Viên</label> <input type="text" class="form-control"
					name="ho" value="${SinhVien.ho}">
			</div>

			<div class="form-group">
				<label>Tên Sinh Viên</label> <input type="text" class="form-control"
					name="ten" value="${SinhVien.ten}">
			</div>

			<div class="form-group">
				<label>Giới Tính</label> <input type="text" class="form-control"
					name="gioitinh" value="${SinhVien.gioiTinh}">
			</div>

			<div class="form-group">
				<label>Năm Sinh</label> <input type="text" class="form-control"
					name="namsinh" value="${SinhVien.namsinh}">
			</div>

			<div class="form-group">
				<label>Lớp</label> <input type="text" class="form-control"
					name="lop" value="${SinhVien.lop}">
			</div>

			<button type="submit" class="btn btn-primary">Sửa</button>
			<button type="reset" class="btn btn-danger">Hủy</button>
		</form>
	</div>
</body>
</html>