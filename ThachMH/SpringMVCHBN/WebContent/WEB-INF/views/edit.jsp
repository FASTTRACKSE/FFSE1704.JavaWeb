<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-885 9-1">
<title>CRUD</title>
<style type="text/css">
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>

<body>
	<h1>ADD Sinh Viên</h1>

	<hr />

	<form:form method="POST" action="/SpringMVCHBN/saveProcess" modelAttribute="command">
		<table>
			<form:hidden path="id" />
			<tr>
				<td><b>Full Name:</b></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><b>Birth:</b></td>
				<td><form:input path="birth" /></td>
			</tr>
			<tr>
				<td><b>City:</b></td>
				<td><form:input path="city" /></td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>Avatar</label> <input id="myFile" type="file"
							class="form-control-file" name="myFile">
					</div>
				</td>
			</tr>


			<tr>
				<td></td>
				<td><input type="submit" value="Save" /> <input type="reset"
					value="Reset" /></td>
			</tr>
		</table>
	</form:form>

	<hr />

	<a href="list">Back to List</a>

</body>
</html>