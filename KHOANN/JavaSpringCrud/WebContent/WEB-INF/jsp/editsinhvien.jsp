<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Employee</h1>
<form:form method="POST" action="/JavaSpringCrud/editsave" enctype="multipart/form-data">
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
			<td>BirthDay :</td>
			<td><form:input path="birthday" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Address :</td>
			<td><form:select path="address">
						<form:options items="${countryList}"  itemLabel="tenTinh" itemValue="maTinh"/>
					</form:select></td>
		</tr>
		<tr>
			<td>Class :</td>
			<td><form:input path="classsv" /></td>
		</tr>
		<tr>
			<td>Image:</td>
			<td><input name="file" id="fileToUpload" type="file" />
			<img src="/JavaSpringCrud/images/${command.image}" width="100px"
				height="100px" />
		</tr>	
		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" /></td>
		</tr>
	</table>
</form:form>
