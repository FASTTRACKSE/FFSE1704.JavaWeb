<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>masinhvien</th>
		<th>Ten</th>
		<th>namsinh</th>
		<th>Email</th>
		<th>Diachi</th>
		<th>Lophoc</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.maSV}</td>
			<td>${emp.ten}</td>
			<td>${emp.namSinh}</td>
			<td>${emp.email}</td>
			<td>${emp.diaChi}</td>
			<td>${emp.lopHoc}</td>
			<td><a href="editemp/${emp.id}">Edit</a></td>
			<td><a href="deleteemp/${emp.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="sinhvienfrom">Add New Employee</a>
