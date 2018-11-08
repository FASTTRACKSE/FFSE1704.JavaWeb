<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

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
		<!-- <div class="dropdown" style="width: 20%">
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
		</div> -->
		<div style="text-align: center;"></div>
		<div>
			<h3>
				<a href="create">thêm</a>
			</h3>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">tên sinh viên</th>
					<th scope="col">tuổi sinh viên</th>
					<th scope="col">địa chỉ</th>
					<th scope="col">avatar</th>
					<th scope="col">email</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${listStudent}">
					<tr>
						<th scope="row">${sv.id}</th>
						<td>${sv.tenSinhVien }</td>
						<td>${sv.tuoiSinhVien }</td>
						<td>${sv.diaChi }</td>
						<td>${sv.avatar }</td>
						<td>${sv.email }</td>
						<td><img style="width: 100px; height: 100px;"
							src='<c:url value = "/resources/upload/${sv.avatar }" ></c:url>'
							alt="image"></td>
						<td><a href="/springHibernateMVCframwork/editview/${sv.id }"><button
									class="btn btn-success">edit</button></a> <a
							href="delete/${sv.id }"><button class="btn btn-danger"
									onclick="return confirm('Bạn có muốn xóa sinh viên này?');">
									delete</button></a></td>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="?page=1">trang đầu</a></li>
			<c:if test="${currentPage > 2}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-2}">${currentPage-2}</a></li>
			</c:if>
			<c:if test="${currentPage > 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-1}">${currentPage-1}</a></li>
			</c:if>
			<li class="page-item active"><a class="page-link"
				href="?page=${currentPage}">${currentPage}</a></li>
			<c:if test="${currentPage < lastPage}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+1}">${currentPage+1}</a></li>
			</c:if>
			<c:if test="${currentPage < lastPage - 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+2}">${currentPage+2}</a></li>
			</c:if>
			<li class="page-item"><a class="page-link"
				href="?page=${lastPage }">trang cuối</a></li>
		</ul>
		</nav>
	</div>
	<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
</body>
</html>