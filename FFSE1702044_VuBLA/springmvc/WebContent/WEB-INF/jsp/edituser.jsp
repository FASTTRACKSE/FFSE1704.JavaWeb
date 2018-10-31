<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h1>Edit Employee</h1>
	<form:form method="POST" action="/springmvc/edit">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>MaSV :</td>
				<td><form:input path="maSV" /></td>
			</tr>
			<tr>
				<td>ten SV :</td>
				<td><form:input path="tenSV" /></td>
			</tr>
			<tr>
				<td>nam sinh :</td>
				<td><form:input path="namSinh" /></td>
			</tr>
			<tr>
				<td>dia chi:</td>
				<td><form:input path="diaChi" /></td>
			</tr>
			<tr>
				<td>lop hoc :</td>
				<td><form:input path="lopHoc" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>