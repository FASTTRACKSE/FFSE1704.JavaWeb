<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	<div class="container">
		<div class="dropdown" style="width: 20%">
			<button class="btn btn-success dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">
				<spring:message code="ngonngu" />
			</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="?lang=vi"> <spring:message
						code="tiengviet" />
				</a> <a class="dropdown-item" href="?lang=en"> <spring:message
						code="tienganh" />
				</a>
			</div>
		</div>

		<div style="text-align: center;">
			<h1><spring:message code="list" /></h1>
		</div>
		<div>
			<h3>
				<a href="addSV"><spring:message code="them" /></a>
			</h3>
		</div>


		<table class="table table-striped">
			<thead>
				<tr>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${sinhvien}">
					<tr>
						<td>${sv.id}</td>
						<td>${sv.maSV}</td>
						<td>${sv.tenSV}</td>
						<td><img style="width: 70px; height:70px;"
							src="<c:url value="img/${sv.images}" />"></td>
						<%-- <td><img style="width: 50px;" src="<c:url value="img/${sv.images}" />"></td>  --%>

						<td>${sv.namSinh}</td>
						<td>${sv.email}</td>
						<td>${sv.diaChi}</td>
						<td>${sv.lopHoc}</td>
						<td><a href="editSV/${sv.id}" class="btn btn-success">Edit</a>
							<a href="deleteSV/${sv.id}" class="btn btn-danger">Delete</a></td>
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
				<li class="page-item"><a class="page-link" href="${totalPage }">Last</a></li>
			</c:if>
		</ul>
		</nav>
		</div>
		</div>
</body>
</html>