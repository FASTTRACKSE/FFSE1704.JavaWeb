<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Masv</th>
		<th>TenSV</th>
		<th>Namsinh</th>
		<th>Email</th>
		<th>DiaChi</th>
		<th>LopHoc</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.masv}</td>
			<td>${emp.tensv}</td>
			<td>${emp.namsinh}</td>
			<td>${emp.email}</td>
			<td>${emp.diachi}</td>
			<td>${emp.lophoc}</td>
			<td><a href="editemp/${emp.id}">Edit</a></td>
			<td><a href="deleteemp/${emp.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="empform">Add New Employee</a>
