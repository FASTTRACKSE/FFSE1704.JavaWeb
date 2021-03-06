<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

	<h4>Edit Student</h4>
	<form:form method="POST" action="/myProjectHibernate/edit"
		enctype="multipart/form-data" modelAttribute="command">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="nameStudent" /></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><form:input path="classStudent" /></td>
			</tr>
			<tr>
				<td>Gender :</td>
				<td><form:input path="gender" /></td>
			</tr>

			<tr>
				<td>Adress</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Avatar :</td>
				<td><input name="file" id="upload" type="file" /> <img
					src='<c:url value = "/resources/upload/${command.avatar }" ></c:url>'
					width="100px" height="100px" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>