<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Xuân Kỳ</title>
</head>
<body style="margin: auto; width: 325px;">
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Add New SinhVien</h1>
	<form:form method="post" action="addsv" enctype="multipart/form-data"
		modelAttribute="sinhvien">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name"></form:input></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email"></form:input></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:select path="address">
						<form:options items="${countryList}" itemValue="matp"
							itemLabel="nametp" />
					</form:select></td>
			</tr>

			<tr>
				<td>Birth :</td>
				<td><form:input path="birth"></form:input></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><form:input path="nameClass"></form:input></td>
			</tr>
			<tr>
				<td>File :</td>
				<td><input id="upload" type="file" name="file"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Save</button> <a href="view"><input
						type="button" value="edit" /></a></td>

			</tr>
		</table>
	</form:form>
</body>
</html>