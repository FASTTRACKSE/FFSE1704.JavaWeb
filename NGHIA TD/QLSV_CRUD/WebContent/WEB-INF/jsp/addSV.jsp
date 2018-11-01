<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>Add New STUDENTS</h1>
<form:form method="post" action="saveSV">
	<table>
		<tr>
			<td>Students Code :</td>
			<td><form:input path="maSV" /></td>
		</tr>
		<tr>
			<td>Students Name :</td>
			<td><form:input path="tenSV" /></td>
		</tr>
		<tr>
			<td>Năm Sinh :</td>
			<td><form:input path="namSinh" /></td>
		</tr>
		
		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Địa chỉ :</td>
			<td><form:input path="diaChi" /></td>
		</tr>
		<tr>
			<td>Lớp Học :</td>
			<td><form:input path="lopHoc" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>