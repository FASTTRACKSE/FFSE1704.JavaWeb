<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit sinhvien</title>
</head>
<body>
	<h1>Edit SinhVien</h1>
	<form:form method="POST" action="/SpringHibernateExample/edit"
		enctype="multipart/form-data" modelAttribute="sinhvien">
		<table>
			<tr>
				<td></td>
				<td><form:input path="id" type="hidden"  /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:select path="address">
						<form:options items="${countryList}" itemValue="id"
							itemLabel="nametp" />
					</form:select></td>
			</tr>
			<tr>
				<td>Birth :</td>
				<td><form:input path="birth" /></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><form:input path="nameClass" /></td>
			</tr>
			<tr>
				<td>File :</td>
				<td><input id="upload" type="file" name="file" /></td>
			</tr>
			<tr>
				<td></td>
				<td><img src="/SpringHibernateExample/resources/upload/${sinhvien.image}" width="200" /></td>
			</tr>
			<tr>
				<td></td>
				<td>-<input type="submit"
					value="Edit Save" /></td>
			</tr>
			<tr>
				<td>${nameClass}</td>
			</tr>
		</table>
	</form:form>
</body>
</html>