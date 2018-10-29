<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="value" required="true" type="java.lang.String"%>

<c:url value="">
	<c:forEach items="${paramValues}" var="p">
		<c:forEach items="${p.value}" var="val">
			<c:choose>
				<c:when test = "${p.key eq name}" >
					<c:param name="${p.key}" value="${value}" />
				</c:when>
				<c:otherwise>
					<c:param name="${p.key}" value="${val}" />
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</c:forEach>

	<c:if test="${empty param[name] }">
		<c:param name="${name}" value="${value}" />
	</c:if>
</c:url>