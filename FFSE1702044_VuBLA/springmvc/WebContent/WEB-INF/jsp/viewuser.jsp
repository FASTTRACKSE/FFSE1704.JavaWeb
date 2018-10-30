
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="2" width="70%" cellpadding="2">

	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>môn học</th>
		<th>Chức Năng</th>
	</tr>
	<c:forEach var="user" items="${list}">
		
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.monhoc}</td>
			<td><a href="edituser/${user.id}">Edit</a>-+-<a href="deleteuser/${user.id}">Del</a></td>
		</tr>
	</c:forEach>

</table>
<a href="index.jsp">Back Home</a> 
