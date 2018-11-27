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
	<form:form method="POST" action="/myProjectSpring/editsave"
		enctype="multipart/form-data">
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
				<td><form:select path="address">
						<form:options items="${listTinhThanh}" itemValue="maTinh"
							itemLabel="tenTinh"></form:options>
					</form:select></td>
			</tr>
			<tr>
				<td>Avatar :</td>
				<td><input type="file" id="fileToUpload" name="file" /></td>

				<td><img src="/myProjectSpring/images/${command.avatar}"
					width="60px" height="60px" /></td>


			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>