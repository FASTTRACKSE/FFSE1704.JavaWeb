<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT SINH VIÊN</title>
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
		<h1 style="text-align: center;">ADD SINH VIÊN</h1>
		<form:form method="post" action="/QLSV_CRUD/editsave" >
		<div class="form-group">
				
				<form:hidden path="id" />
				<br>

			</div>
			<div class="form-group">
				<label>Mã sinh viên:</label>
				<form:input class="form-control" type="text" path="maSV" />
				<br>

			</div>

			<div class="form-group">
				<label>Tên Sinh Viên:</label>
				<form:input class="form-control" type="text" path="tenSV" />
				<br>
	
			</div>
			
			<div class="form-group">
				<label>Images</label> 
				 <form:input path="images" id="upload" type="file"
					class="form-control-file" name="file"></form:input>
			</div>

			<div class="form-group">
				<label>Năm Sinh:</label>
				<form:input class="form-control" type="text" path="namSinh" />
				<br>

			</div>

			<div class="form-group">
				<label>Email:</label>
				<form:input class="form-control" type="text" path="email" />
				<br>

			</div>

			<div class="form-group">
				<label>Địa Chỉ:</label>
				<form:input class="form-control" type="text" path="diaChi" />
				<br>

			</div>

			<div class="form-group">
				<label>Lớp học:</label>
				<form:input class="form-control" type="text" path="lopHoc" />
				<br>

			</div>

			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>

		</form:form>
		
		</div>
</body>
</html>