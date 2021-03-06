<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
</head>
<body>


	<c:choose>


		<c:when test="${toatalPage eq 1}">
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="LoginServlet?page=1">1</a></li>
			</ul>
		</c:when>

		<c:when test="${toatalPage gt 1 && toatalPage lt 3}">
			<c:choose>
				<c:when test="${page eq 1}">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=1">1</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=2">2</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=2">Next</a></li>
					</ul>
				</c:when>
				<c:when test="${page eq 2}">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=1">Previous</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=1">1</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=2">2</a></li>
					</ul>
				</c:when>
			</c:choose>

		</c:when>

		<c:otherwise>
			<c:choose>
				<c:when test="${page eq 1}">
					<ul class="pagination">
						<c:forEach var="i" begin="1" end="${toatalPage}">

							<li class="page-item"><a class="page-link"
								href="LoginServlet?page=${i}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=${page + 1}">Next</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=${toatalPage}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
						</a></li>
					</ul>
				</c:when>

				<c:when test="${page eq toatalPage}">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=1" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
						</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=${page - 1}">Previous</a></li>
						<c:forEach var="i" begin="1" end="${toatalPage}">
							<li class="page-item"><a class="page-link"
								href="LoginServlet?page=${i}">${i}</a></li>
						</c:forEach>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=1" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
						</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=${page - 1}">Previous</a></li>
						<c:forEach var="i" begin="1" end="${toatalPage}">
							<li class="page-item"><a class="page-link"
								href="LoginServlet?page=${i}">${i}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=${page + 1}">Next</a></li>
						<li class="page-item"><a class="page-link"
							href="LoginServlet?page=${toatalPage}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
						</a></li>
					</ul>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>


</body>
</html>