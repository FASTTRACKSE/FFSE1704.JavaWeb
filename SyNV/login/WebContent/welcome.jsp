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
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">id</th>
				<th scope="col">Mã Sinh viên</th>
				<th scope="col">Họ</th>
				<th scope="col">Tên</th>
				<th scope="col">Giới Tính</th>
				<th scope="col">Năm Sinh</th>
				<th scope="col">Lớp</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="User" items="${SinhVien}">
				<tr>
					<td><c:out value="${User.id}" /></td>
					<td><c:out value="${User.masv}" /></td>
					<td><c:out value="${User.ho}" /></td>
					<td><c:out value="${User.ten}" /></td>
					<td><c:out value="${User.gioitinh}" /></td>
					<td><c:out value="${User.namsinh}" /></td>
					<td><c:out value="${User.lop}" /></td>
					<td>
						<a href=""><button type="button" class="btn btn-primary">Edit</button></a>
						<a href=""><button type="button" class="btn btn-danger">Delete</button></a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>