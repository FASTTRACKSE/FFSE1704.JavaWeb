<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Edit Employee</h1>
<form:form method="POST" action="">
	<table>
		<tr>
			<td>id :</td>
			<td><form:hidden path="id" /></td>
		</tr>
		<tr>
			<td>Students Code :</td>
			<td><form:input path="maSV" /></td>
		</tr>
		<tr>
			<td>Students Name :</td>
			<td><form:input path="tenSV" /></td>
		</tr>
		<tr>
			<td>Năm Sinh :</td>
			<td><form:input path="namSinh" /></td>
		</tr>

		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Địa chỉ :</td>
			<td><form:input path="diaChi" /></td>
		</tr>
		<tr>
			<td>Lớp Học :</td>
			<td><form:input path="lopHoc" /></td>
		</tr>
		<td><input type="submit" class="btn btn-success"  name="delete" /></td>
		<td><input type="submit" class="button" name="cancel"
			value="Cancel" /></td>

	</table>
</form:form>
</body>
</html>