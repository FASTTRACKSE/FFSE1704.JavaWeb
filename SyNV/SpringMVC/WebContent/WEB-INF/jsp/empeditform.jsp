<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h1>Edit Student</h1>
<form:form method="POST" action="/SpringMVC/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>MaSV :</td>
			<td><form:input path="masv" /></td>
		</tr>
		<tr>
			<td>TenSV :</td>
			<td><form:input path="tensv" /></td>
		</tr>
		<tr>
			<td>Namsinh :</td>
			<td><form:input path="namsinh" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Diachi :</td>
			<td><form:input path="diachi" /></td>
		</tr>
		<tr>
			<td>Lophoc :</td>
			<td><form:input path="lophoc" /></td>
		</tr>
		<tr>
			<td>File :</td>
			<td><input type="file" name="file" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
