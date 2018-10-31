<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<form:form method="post" action="save">
	<table>

		<tr>
			<td>Mã SV:</td>
			<td><form:input path="maSV" /></td>
		</tr>
		<tr>
			<td>Tên SV:</td>
			<td><form:input path="tenSV" /></td>
		</tr>
		<tr>
			<td>Năm Sinh:</td>
			<td><form:input path="namSinh" /></td>
		</tr>
		<tr>
			<td>Địa Chỉ:</td>
			<td><form:input path="diaChi" /></td>
		</tr>
		<tr>
			<td>Lớp Học:</td>
			<td><form:input path="lopHoc" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>

