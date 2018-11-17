<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Sinh Viên</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<h1 style="color: red;">Delete ?</h1>
		<div>
			<img src="<c:url value="/images/${command.avatar}" />" width="350px"
				height="400px" />
		</div>
		<form:form method="post" action="/QLSV_CRUD_Spring/deleteSinhVien">
			<div style="padding-left: 400px; margin-top: -335px">
				<table>

					<tr class="form-group">
						<td><form:hidden path="id" class="form-control" /></td>
					</tr>
					<tr class="form-group">
						<td>Mã Sinh Viên :</td>
						<td><form:hidden path="maSinhVien" class="form-control" /><strong>${command.maSinhVien}</strong>
						</td>
					</tr>

					<tr class="form-group">
						<td>Tên Sinh Viên :</td>
						<td><form:hidden path="tenSinhVien" class="form-control" /><strong>${command.tenSinhVien}</strong>
						</td>
					</tr>

					<tr class="form-group">
						<td>Lớp :</td>
						<td><form:hidden path="lop" class="form-control" /><strong>${command.lop}</strong>
						</td>
					</tr>

					<tr class="form-group">
						<td>Tuổi :</td>
						<td><form:hidden path="tuoi" class="form-control" /><strong>${command.tuoi}</strong>
						</td>
					</tr>

					<tr class="form-group">
						<td>Giới Tính :</td>
						<td><form:hidden path="gioiTinh" class="form-control" /><strong>${command.gioiTinh}</strong>
						</td>
					</tr>
					<tr class="form-group">
						<td>Địa Chỉ :</td>
						<td><form:hidden path="diaChi" class="form-control" /><strong>${command.diaChi}</strong>
						</td>
					</tr>
					<tr class="form-group">
						<td>Số Điện Thoại :</td>
						<td><form:hidden path="soDT" class="form-control" /><strong>${command.soDT}</strong>
						</td>
					</tr>
					<tr class="form-group">
						<td>Email :</td>
						<td><form:hidden path="email" class="form-control" /><strong>${command.email}</strong>
						</td>
					</tr>
					<%-- <tr class="form-group">
						<td>Avatar :</td>
						<td><img width="100px" height="100px"
							src="<c:url value="/images/${command.avatar}" />" /></td>
					</tr> --%>
					<tr>
						<td></td>
						<td><input type="submit" value="Delete"
							class="btn btn-primary" style="margin-left: 5px;" /> <a
							href="/QLSV_CRUD_Spring/view/1" class="btn btn-danger">back</a></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>