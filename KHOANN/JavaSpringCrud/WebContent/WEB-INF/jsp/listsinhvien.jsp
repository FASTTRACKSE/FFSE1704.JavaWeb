<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="2" width="70%" cellpadding="2">

	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Birhday</th>
		<th>Email</th>
		<th>Address</th>
		<th>Class</th>
		<th>Chức Năng</th>
	</tr>
	<c:forEach var="user" items="${list}">

		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.birthday}</td>
			<td>${user.email}</td>
			<td>${user.address}</td>
			<td>${user.classsv}</td>
			<td><a href="editsinhvien/${user.id}">Edit</a>-+-<a
				href="deletesinhvien/${user.id}">Del</a></td>
		</tr>
	</c:forEach>

</table>
<a href="index.jsp">Back Home</a>