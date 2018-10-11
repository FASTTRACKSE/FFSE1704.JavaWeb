<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>quan ly admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>

	<h1 style="color:red; margin-left: 420px;">Welcome back Boss</h1>


	
<div class="container">
<a href="AddSinhVienServlet"><input type="button" class="btn btn-success" value="add" name="control"></a>
<br>
<br>
<%@ include file="Page.jsp" %>

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">Tên Sinh Viên</th>
				<th scope="col">Mã Sinh viên</th>
				<th scope="col">Lớp Học</th>
				<th scope="col">Tuổi</th>
				<th scope="col">Giới Tính</th>
				<th scope="col">Địa Chỉ</th>
				<th scope="col">Số Điện Thoại</th>
				<th scope="col">Email</th>
				<th scope="col">Control</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sinhvien" items="${listSinhVien}">
				<tr>
					<td><c:out value="${sinhvien.tenSinhVien}" /></td>
					<td><c:out value="${sinhvien.maSinhVien}" /></td>
					<td><c:out value="${sinhvien.lopHoc}" /></td>
					<td><c:out value="${sinhvien.tuoiSinhVien}" /></td>
					<td><c:out value="${sinhvien.gioiTinh}" /></td>
					<td><c:out value="${sinhvien.diaChi}" /></td>
					<td><c:out value="${sinhvien.soDT}" /></td>
					<td><c:out value="${sinhvien.email}" /></td>
					<td>
						<a href="EditSinhVienServlet?id=${sinhvien.maSinhVien}"><button type="button" class="btn btn-primary">Edit</button></a>
						<a href="DeleteSinhVienServlet?id=${sinhvien.maSinhVien}"><button type="button" class="btn btn-danger">Delete</button></a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</div>
</body>
</html>