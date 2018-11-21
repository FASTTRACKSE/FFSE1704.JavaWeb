<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Employee</h1>
	<form:form method="POST" action="/DISampleHocSinh3/editsave">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Mã SV :</td>
				<td><form:input path="masv"  /></td>
			</tr>
			<tr>
				<td>Tên SV :</td>
				<td>
					<form:input path="tensv"/>
					<font color="red"><form:errors path="tensv" /></font>
				</td>
			</tr>
			<tr>
				<td>Năm Sinh :</td>
				<td><form:input path="namsinh" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Địa Chỉ :</td>
				<td><form:input path="diachi" /></td>
			</tr>
			<tr>
				<td>Lớp :</td>
				<td><form:input path="lop" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>