<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<%@ attribute name="currentPage" required="true" type="java.lang.Integer"%>
<%@ attribute name="totalPage" required="true" type="java.lang.Integer"%>

<c:if test="${currentPage != 1}">
	<c:if test="${totalPage > 2}">
		<a href='<cs:addParam name="page" value="1"/>'>start</a>
	</c:if>
	<a href='<cs:addParam name="page" value="${currentPage - 1}"/>'>&lt;</a>
</c:if>

<c:choose>
	<c:when test="${currentPage == 1 and totalPage == 1}">1</c:when>
	<c:when test="${currentPage < 3 and totalPage > 1}">
		<c:set var="end" value="${totalPage}" />
		<c:if test="${totalPage > 2}">
			<c:set var="end" value="3" />
		</c:if>
		<c:forEach var="item" begin="1" end="${end}">
			<c:choose>
				<c:when test="${currentPage == item}">${item}</c:when>
				<c:otherwise>
					<a href='<cs:addParam name="page" value="${item}"/>'>${item}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:when>
	<c:when test="${currentPage == totalPage}">
		<a href='<cs:addParam name="page" value="${currentPage - 2}"/>'>${currentPage - 2}</a>
		<a href='<cs:addParam name="page" value="${currentPage - 1}"/>'>${currentPage - 1}</a>
		${currentPage}
	</c:when>
	<c:otherwise>
		<a href='<cs:addParam name="page" value="${currentPage - 1}"/>'>
			${currentPage - 1} </a>${currentPage}<a
			href='<cs:addParam name="page" value="${currentPage + 1}"/>'>${currentPage + 1}</a>
	</c:otherwise>
</c:choose>

<c:if test="${currentPage != totalPage}">
	<a href='<cs:addParam name="page" value="${currentPage + 1}"/>'>&gt;</a>
		<c:if test="${totalPage > 2}">
	<a href='<cs:addParam name="page" value="${totalPage}"/>'>end</a>
	</c:if>
</c:if>