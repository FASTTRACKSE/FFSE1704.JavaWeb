<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Add New Employee</h1>
		
		<form:form method="post" action="save" enctype="multipart/form-data" modelAttribute="command">
			<table border="0">
				<tr>
					<td>Mã SV :</td>
					<td><form:input path="masv" /></td>
					<td><form:errors path="masv" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td>Tên SV :</td>
					<td><form:input path="tensv" /></td>
					<td><form:errors path="tensv" cssStyle="color: red" /></td>
				</tr>
				<tr>
					<td>Năm Sinh :</td>
					<td><form:input path="namsinh" /></td>
					<td><form:errors path="namsinh" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Địa Chỉ :</td>
					<td><form:input path="diachi" /></td>
					<td><form:errors path="diachi" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Lớp :</td>
					<td><form:input path="lop" /></td>
					<td><form:errors path="lop" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Avatar :</td>
					<td>
						<input type="file" name="file" />
						<!-- <input id="upload" type="file" class="form-control" name="file">
						<input id="imgUrl" class="form-control" type="file" name="file" /> -->
					</td>
					<td><form:errors path="image" cssClass="error" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Edit Save" /></td>
				</tr>
			</table>
		</form:form>	
	</div>
</body>
</html>