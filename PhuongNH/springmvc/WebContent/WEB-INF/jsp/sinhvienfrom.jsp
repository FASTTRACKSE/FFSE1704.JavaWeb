<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Add New Employee</h1>
<form:form method="post" action="save">
	<table>
		<tr>
			<td>Ma sinh vien :</td>
			<td><form:input path="ten" /></td>
		</tr>
		<tr>
			<td>Ten :</td>
			<td><form:input path="ten" /></td>
		</tr>
		<tr>
			<td>Nam sinh :</td>
			<td><form:input path="namSinh" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="diaChi">Country</form:label></td>
			<td><form:select path="diaChi">
					<form:options items="${list}" itemValue="tenTinhThanh" itemLabel="tenTinhThanh" />
				</form:select></td>
		</tr>
		<tr>
			<td>Lop hoc :</td>
			<td><form:input path="lopHoc" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Save" /></td>
		</tr>
	</table>
</form:form>
