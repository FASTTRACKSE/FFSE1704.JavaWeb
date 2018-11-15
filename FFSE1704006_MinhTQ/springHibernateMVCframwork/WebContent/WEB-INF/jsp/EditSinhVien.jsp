<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/springHibernateMVCframwork/editSinhVien"
		method="POST" enctype="multipart/form-data" modelAttribute="command">
		<table>
			<tr>
				<td>id</td>
				<td><form:input path="id"></form:input></td>
			</tr>
			<tr>
				<td>tên sinh viên</td>
				<td><form:input path="tenSinhVien"></form:input></td>

			</tr>
			<tr>
				<td>tuổi sinh viên</td>
				<td><form:input path="tuoiSinhVien"></form:input></td>

			</tr>
			<tr>
				<td>địa chỉ</td>
				<td><form:input path="diaChi"></form:input></td>

			</tr>
			<tr>
				<td>Avatar</td>
				<td><input type="file" name="file" id="upload" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><form:input path="email"></form:input></td>
				<br />
				<td><img
					src="/springHibernateMVCframwork/images/${command.avatar}"
					width="100px" height="100px"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="sửa" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>