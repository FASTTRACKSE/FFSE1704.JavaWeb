<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>quan ly admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>

	<h1>Hello</h1>
	<h1 style="color: red">${listUser[0].userName}</h1>


	<input type="button" class="btn btn-success" value="add" name="control">

	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">UserName</th>
				<th scope="col">PassWord</th>
				<th scope="col">Control</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser}">
				<tr>
					<td><c:out value="${user.userName}" /></td>
					<td><c:out value="${user.passWord}" /></td>
					<td>
						<a href="editUser?id=${user.id}">Edit</a>
						<a href="">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>