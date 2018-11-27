<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">


		<div>
			<h3>
				<a href="addsv">them</a>
			</h3>
		</div>
		<table border="2" width="70%" cellpadding="2">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">Name</th>
					<th scope="col">Old</th>
					<th scope="col">Image</th>
					<th scope="col">City</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${listSV}">
					<tr>
						<th scope="row">${sv.id}</th>
						<td>${sv.name }</td>
						<td>${sv.old }</td>

						<td><img style="width: 100px; height: 100px;"
							src='<c:url value = "/resources/upload/${sv.image}" ></c:url>'
							alt="image"></td>
						<td>${sv.city }</td>
						<td><a href="/SpringMVCHibernateDemo/edit/${sv.id }"><button
									class="btn btn-success">sửa</button></a> <a href="delete/${sv.id }"><button
									class="btn btn-danger"
									onclick="return confirm('Bạn có muốn xóa sinh viên này?');">
									xóa</button></a></td>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="?page=1">trangdaau</a></li>
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
				href="?page=${lastPage }">trang cuoi</a></li>
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