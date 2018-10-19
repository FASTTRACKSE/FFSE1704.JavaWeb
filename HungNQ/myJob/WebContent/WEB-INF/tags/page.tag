<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ attribute name="toatalPage" required="true" type="java.lang.Integer"%>
<%@ attribute name="page" required="true" type="java.lang.Integer"%>


<c:choose>
	<%-- --%>
	<c:when test="${toatalPage eq 1}">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="Hello?page=1">1</a></li>
			</ul>
		</nav>
	</c:when>
	<%-- --%>
	<c:when test="${toatalPage gt 1 && toatalPage lt 3}">
		<c:choose>

			<c:when test="${page eq 1}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="Hello?page=1">1</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=2">2</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=2">Next</a></li>
					</ul>
				</nav>
	   		</c:when>
			<c:otherwise>
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="Hello?page=1">Previous</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=1">1</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=2">2</a></li>

					</ul>
				</nav>
			</c:otherwise>

		</c:choose>
	</c:when>
	<c:when test="${toatalPage ge 3}">
		<c:choose>
			<c:when test="${page eq 1}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<c:forEach var="a" begin="1" end="${toatalPage}">
							<li class="page-item"><a class="page-link"
								href="Hello?page=${a}">${a}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${page+1}">Next</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${toatalPage}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
						</a></li>
					</ul>
				</nav>
			</c:when>

			<c:when test="${page eq 2}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="Hello?page=${page - 1}">Previous</a></li>
						<c:forEach var="a" begin="1" end="${toatalPage}">
							<li class="page-item"><a class="page-link"
								href="Hello?page=${a}">${a}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${page+1}">Next</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${toatalPage}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
						</a></li>
					</ul>
				</nav>
			</c:when>

			<c:when test="${page ge 3}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="Hello?page=1" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
						</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${page - 1}">Previous</a></li>
						<c:forEach var="a" begin="1" end="${toatalPage}">
							<li class="page-item"><a class="page-link"
								href="Hello?page=${a}">${a}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${page+1}">Next</a></li>
						<li class="page-item"><a class="page-link"
							href="Hello?page=${toatalPage}" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
						</a></li>
					</ul>
				</nav>
			</c:when>
		</c:choose>

	</c:when>

</c:choose>