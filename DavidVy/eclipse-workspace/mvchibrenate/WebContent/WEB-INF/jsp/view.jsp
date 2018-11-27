<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<!-- 	<a href="/mvchibrenate/add" class="btn btn-danger">add new sv</a> -->
	<div class="container">


		<div style="text-align: center;">
			<h1>DSSV</h1>
		</div>
		<div>
			<h3>
				<button type="button" class="btn btn-default"><a href="add">add new sv</a></button>
			</h3>
		</div>


		<table class="table table-striped">
			<thead>
				<tr>

					<th scope="col">MA</th>
					<th scope="col">Ten</th>
					<th scope="col">lophoc</th>
					<th scope="col">namsinh</th>
					<th scope="col">diachi</th>
					<th scope="col">email</th>
					<th scope="col">images</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${SinhVien}">
					<tr>
						<td>${sv.id}</td>
						<td>${sv.masv}</td>
						<td>${sv.tensv}</td>
						<td>${sv.lopHoc}</td>
						<td>${sv.namsinh}</td>
						<td>${sv.diaChi}</td>
						<td>${sv.email}</td>
						<td><img style="width: 70px; height: 70px;"
							src="<c:url value="img/${sv.images}" />"></td>
						<%-- <td><img style="width: 50px;" src="<c:url value="img/${sv.images}" />"></td>  --%>
						<td><a href="edit/${sv.id}" class="btn btn-success">Edit</a>
							<a href="del/${sv.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="container" style="float: right">
			<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${page > 1 }">
					<li class="page-item"><a class="page-link" href="1">First</a></li>
					<li class="page-item"><a class="page-link" href="${page -1 }">${page -1 }</a></li>
				</c:if>

				<li class="page-item"><a class="page-link" href="${page }">${page }</a></li>

				<c:if test="${page < totalPage}">
					<li class="page-item"><a class="page-link" href="${page +1 }">${page +1 }</a></li>
					<li class="page-item"><a class="page-link"
						href="${totalPage }">Last</a></li>
				</c:if>
			</ul>
			</nav>
		</div>
	</div>
</body>
</html>