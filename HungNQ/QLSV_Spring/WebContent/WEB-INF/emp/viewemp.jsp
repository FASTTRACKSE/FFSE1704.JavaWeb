<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>Students List</h1>
	<div
		style="text-align: right; padding: 5px; margin: 5px 0px; background: #ccc;">
		<a href="${pageContext.request.contextPath}/viewemp?lang=fr">Language(French)</a>
		&nbsp;|&nbsp; <a
			href="${pageContext.request.contextPath}/viewemp?lang=vi">Language(Vietnamese)</a>
	</div>
	<spring:message code="Hello" />
	<table border="1" width="100%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Masv</th>
			<th>TenSV</th>
			<th>Namsinh</th>
			<th>Email</th>
			<th>DiaChi</th>
			<th>LopHoc</th>
			<th>Events</th>
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
				<td><a href="editemp/${emp.id}">Edit</a> <a
					href="deleteemp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${page > 1 }">
				<li class="page-item"><a class="page-link" href="1">First</a></li>
				<li class="page-item"><a class="page-link" href="${page -1 }">${page -1 }</a></li>
			</c:if>

			<li class="page-item"><a class="page-link" href="${page }">${page }</a></li>

			<c:if test="${page < totalPage}">
				<li class="page-item"><a class="page-link" href="${page +1 }">${page +1 }</a></li>
				<li class="page-item"><a class="page-link" href="${totalPage }">Last</a></li>
			</c:if>
		</ul>
	</nav>
	<br />
	<a href="empform">Add New Employee</a>
</body>
</html>
