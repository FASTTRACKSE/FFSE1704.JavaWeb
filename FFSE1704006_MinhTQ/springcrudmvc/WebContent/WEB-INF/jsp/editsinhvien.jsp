<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Sinh Viên</h1>
	<form:form method="POST" action="/springcrudmvc/editsave">
		<table>
			<tr>
				<td>id:</td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td>Tên:</td>
				<td><form:input path="tenSinhVien" /></td>
			</tr>
			<tr>
				<td>Tuổi:</td>
				<td><form:input path="tuoiSinhVien" /></td>
			</tr>
			<tr>
				<td>địa chỉ:</td>
				<td><form:select path="diaChi">
						<form:options items="${countryList}"  itemLabel="tenTinhThanh" itemValue="maTinhThanh"/>
					</form:select></td>
			</tr>
			<tr>
				<td>avatar:</td>
				<td><input name="file" id="fileToUpload" type="file" />
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>