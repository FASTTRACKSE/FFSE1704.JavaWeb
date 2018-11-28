<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<h1>Provide Student Information</h1>

	<hr />

	<form:form action="saveProcess.html" modelAttribute="student">
		<table>
			<form:hidden path="id" />
			<form:hidden path="" value="${student.hobbies}" id="hobbies" />
			<tr>
				<td><b>Full Name:</b></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><b>Email:</b></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><b>Gender:</b></td>
				<td><form:radiobutton path="gender" value="Male" />Male&nbsp;&nbsp;<form:radiobutton
						path="gender" value="Female" />Female</td>
			</tr>
			<tr>
				<td><b>Hobbies:</b></td>
				<td><form:checkbox path="hobbies" value="Cricket" />Cricket <form:checkbox
						path="hobbies" value="Football" />Football <form:checkbox
						path="hobbies" value="Volleyball" />Volleyball <form:checkbox
						path="hobbies" value="Hockey" />Hockey</td>
			</tr>
			<tr>
				<td><b>City:</b></td>
				<td><form:select path="city">
						<form:option value="0">--Select--</form:option>
						<form:option value="Banglore">Banglore</form:option>
						<form:option value="Hubli">Hubli</form:option>
						<form:option value="Davangere">Davangere</form:option>
						<form:option value="Mysore">Mysore</form:option>
						<form:option value="Belgaum">Belgaum</form:option>
						<form:option value="Tumkur">Tumkur</form:option>
						<form:option value="Chitradurga">Chitradurga</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><b>Address:</b></td>
				<td><form:textarea path="address" /></td>
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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			var hobbies = $("#hobbies").val().split(",");
			var $checkboxes = $("input[type=checkbox]");
			$checkboxes.each(function(idx, element) {
				if (hobbies.indexOf(element.value) != -1) {
					element.setAttribute("checked", "checked");
					$("#hobbies").val("");
				} else {
					element.removeAttribute("checked");
				}
			});
		});
	</script>
</body>
</html>