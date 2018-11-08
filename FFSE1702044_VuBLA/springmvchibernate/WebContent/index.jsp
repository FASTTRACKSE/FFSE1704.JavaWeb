<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:p="http://primefaces.org/ui"
	xmlns:ui="http://java.sun.com/jsf/facelets">
<head>

<title>Quản Lí Nhân Viên</title>
</head>
<body>
	<form:form method="post" action="save" enctype="multipart/form-data" modelAttribute="sinhvien">
		<table>

			<tr>
				<td>Mã SV:</td>
				<td><form:input path="maSV" /></td>
				<td><form:errors path="maSV" /></td>
			</tr>
			<tr>
				<td>Tên SV:</td>
				<td><form:input id="tenSV" path="tenSV" /></td>
				<td><form:errors path="tenSV" /></td>
			</tr>
			<tr>
				<td>Năm Sinh:</td>
				<td><form:input path="namSinh" /></td>
				<td><form:errors path="namSinh" /></td>
			</tr>
			<tr>
				<td>Địa Chỉ:</td>
				<td><form:input path="diaChi" /></td>
				<td><form:errors path="diaChi" /></td>
			</tr>
			<tr>
				<td>Lớp Học:</td>
				<td><form:input path="lopHoc" /></td>
				<td><form:errors path="lopHoc" /></td>
			</tr>
			<tr>
				<td>avatar:</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
