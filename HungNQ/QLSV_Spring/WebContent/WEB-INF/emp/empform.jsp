<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Employee</h1>
<form:form method="post" action="save">
	<table>
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
			<td>DiaChi :</td>
			<td><form:input path="diachi" /></td>
		</tr>
		<tr>
			<td>LopHoc :</td>
			<td><form:input path="lophoc" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
