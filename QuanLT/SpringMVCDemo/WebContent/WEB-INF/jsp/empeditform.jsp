<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Information Fans</h1>
	<form:form method="POST" action="/SpringMVCDemo/editsave"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
				
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
				
			</tr>
			<tr>
				<td>Old :</td>
				<td><form:input path="old" /></td>
			</tr>
			<tr>
				<td>Idol :</td>
				<td><form:input path="idol"/></td>
			</tr>
			<tr>
				<td>Image :</td>
				<td><form:input path="image"/></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:select path="city" items="${countryList}" itemValue="matp" itemLabel="nametp" >
        </form:select></td>
			</tr>
			<tr>
				<td>File :</td>
				<td><input type="file" class="file" name="textFile" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>