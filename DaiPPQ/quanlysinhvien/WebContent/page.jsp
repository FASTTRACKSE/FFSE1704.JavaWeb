<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
			integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
			crossorigin="anonymous">
	</head>

	<body>
		<c:choose>
			<!-- so trang = 1 -->
			<c:when test="${toatalPage eq 1}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item">
							<a class="page-link" href="sinhvien?page=1">1</a>
						</li>
					</ul>
				</nav>
			</c:when>
			<!-- so trang = 2 -->
			<c:when test="${toatalPage gt 1 && toatalPage lt 3}">
				<c:choose>
					<c:when test="${page eq 1}">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=1">1</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=2">2</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=2">Next</a>
								</li>
							</ul>
						</nav>
					</c:when>
					<c:when test="${page eq 2}">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=1">Previous</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=1">1</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=2">2</a>
								</li>
							</ul>
						</nav>
					</c:when>
				</c:choose>
			</c:when>
			<!-- so trang > 3 -->
			<c:otherwise>
				<c:choose>
					<!-- vi tri o trang  1 -->
					<c:when test="${page eq 1}">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								Trang ${page} của ${toatalPage} trang
								<c:forEach var="i" begin="1" end="3">
									<li class="page-item">
										<a class="page-link" href="sinhvien?page=${i}">${i}</a>
									</li>
								</c:forEach>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=${page + 1}">Next</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=${toatalPage}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
									</a>
								</li>
							</ul>
						</nav>
					</c:when>
					<!-- vi tri o trang cuoi -->
					<c:when test="${page eq toatalPage}">
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								Trang ${page} của ${toatalPage} trang 
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=1" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
									</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=${page - 1}">Previous</a>
								</li>
								<c:forEach var="i" begin="${toatalPage - 2}" end="${toatalPage}">
									<li class="page-item">
										<a class="page-link" href="sinhvien?page=${i}">${i}</a>
									</li>
								</c:forEach>
							</ul>
						</nav>
					</c:when>
					<!-- cac trang o giua -->
					<c:otherwise>
						<nav aria-label="Page navigation example">
							<ul class="pagination">
								Trang ${page} của ${toatalPage} trang		
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=1" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
										<span class="sr-only">Previous</span>
									</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=${page - 1}">Previous</a>
								</li>
								
								<c:forEach var="i" begin="${page -1}" end="${page + 1}">
									<li class="page-item">
										<a class="page-link" href="sinhvien?page=${i}">${i}</a>
									</li>
								</c:forEach>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=${page + 1}">Next</a>
								</li>
								<li class="page-item">
									<a class="page-link" href="sinhvien?page=${toatalPage}" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
										<span class="sr-only">Next</span>
									</a>
								</li>
							</ul>
						</nav>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</body>
</html>