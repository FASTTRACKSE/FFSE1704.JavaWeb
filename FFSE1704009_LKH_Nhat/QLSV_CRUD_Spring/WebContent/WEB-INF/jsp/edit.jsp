<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Sinh Viên</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit Sinh Viên</h1>
		
		<form:form method="POST" action="/QLSV_CRUD_Spring/editsave"
			enctype="multipart/form-data">
			<table>

				<tr class="form-group">
					<td><form:hidden path="id" class="form-control" /></td>
				</tr>

				<tr class="form-group">
					<td>Mã Sinh Viên:</td>
					<td><form:hidden path="maSinhVien" class="form-control" /><strong>${command.maSinhVien}</strong></td>
				</tr>

				<tr class="form-group">
					<td>Tên Sinh Viên :</td>
					<td><form:input path="tenSinhVien" class="form-control" /></td>
					<td><form:errors path="tenSinhVien" cssStyle="color: red" /></td>
				</tr>

				<tr class="form-group">
					<td>Lớp :</td>
					<td><form:input path="lop" class="form-control" /></td>
					<td><form:errors path="lop" cssStyle="color: red" /></td>
				</tr>

				<tr class="form-group">
					<td>Năm Sinh :</td>
					<td><form:input path="tuoi" class="form-control" /></td>
					<td><form:errors path="tuoi" cssStyle="color: red" /></td>
				</tr>

				<tr class="form-group">
					<td>Giới Tính :</td>
					<td><form:input path="gioiTinh" class="form-control" /></td>
					<td><form:errors path="gioiTinh" cssStyle="color: red" /></td>
				</tr>
				<tr class="form-group">
					<td>Địa Chỉ :</td>
					<td><form:input path="diaChi" class="form-control" /></td>
					<td><form:errors path="diaChi" cssStyle="color: red" /></td>
				</tr>
				<tr class="form-group">
					<td>Số Điện Thoại :</td>
					<td><form:input path="soDT" class="form-control" /></td>
					<td><form:errors path="soDT" cssStyle="color: red" /></td>
				</tr>
				<tr class="form-group">
					<td>Email :</td>
					<td><form:input path="email" class="form-control" /></td>
					<td><form:errors path="email" cssStyle="color: red" /></td>
				</tr>
				<tr class="form-group">
					<td>Old Avatar :</td>
					<td><img width="100px" height="100px"
						src="<c:url value="/images/${command.avatar}" />" /></td>
				</tr>
				<tr class="form-group">
					<td>New Avatar :</td>
					<td><input id="imgUrl" class="form-control" type="file"
						name="file" /> <br> <img id="img" src="#" alt="your image"
						width="100" height="150" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Edit Save"
						class="btn btn-primary" style="margin-left: 5px;" />
						<a href="/QLSV_CRUD_Spring/view/1" class="btn btn-danger">back</a></td>
				</tr>
			</table>
		</form:form>
	</div>

	<script type="text/javascript">
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#img').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		$("#imgUrl").change(function() {
			readURL(this);
		});
	</script>
</body>
</html>
