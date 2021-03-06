﻿<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

	<form:form method="post" action="/springcrudmvc/themsinhvien"
		enctype="multipart/form-data">
		<table>

			<tr>
				<td>tên:</td>
				<td><form:input path="tenSinhVien" /></td>
				<td><form:errors path="tenSinhVien" cssStyle="color: red"/></td>
			</tr>
			<tr>
				<td>tuổi:</td>
				<td><form:input path="tuoiSinhVien" /></td>
				<td><form:errors path="tuoiSinhVien" cssStyle="color: red"/></td>
			</tr>

			<tr>
				<td>địa chỉ:</td>
				<td><form:select path="diaChi">
						<form:options items="${countryList}" itemValue="maTinhThanh" itemLabel="tenTinhThanh" />
					</form:select></td>
					<td><form:errors path="diaChi" cssStyle="color: red"/></td>
			</tr>
			<tr>
				<td>avatar:</td>
				<td><input type="file" name="file"  /></td>
				<td><form:errors path="avatar" cssStyle="color: red"/></td>
			</tr>

			<tr>
				<td>email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssStyle="color: red"/></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="thêm" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>