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





	<form action="DeleteSevlet" method="post">
		<div class="form-group">
			<label>Mã Sinh Viên: </label> <input type="hidden"
				class="form-control" name="maSV" value="${SinhVien.maSinhVien}"><strong>${SinhVien.maSinhVien}</strong>
		</div>

		<div class="form-group">
			<label>Tên Sinh Viên: </label> <input type="hidden"
				class="form-control" name="tenSV" value="${SinhVien.tenSinhVien}">
			<strong>${SinhVien.tenSinhVien}</strong>
		</div>

		<div class="form-group">
			<label>Tuổi Học: </label> <input type="hidden" class="form-control"
				name="tuoiSV" value="${SinhVien.tuoiSinhVien}"><strong>${SinhVien.tuoiSinhVien}</strong>
		</div>

		<div class="form-group">
			<label>Lớp Học: </label> <input type="hidden" class="form-control"
				name="lophoc" value="${SinhVien.lopHoc}"><strong>${SinhVien.lopHoc}</strong>
		</div>

		<div class="form-group">
			<label>Địa Chỉ: </label> <input type="hidden" class="form-control"
				name="diachi" value="${SinhVien.diaChi}"><strong>${SinhVien.diaChi}</strong>
		</div>


		<button type="submit" class="btn btn-primary">Xóa</button>
	</form>
	</body>
</html>