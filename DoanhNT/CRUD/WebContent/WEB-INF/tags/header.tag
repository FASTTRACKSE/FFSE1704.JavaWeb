<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>
<%@ attribute name="hideLogout" required="false" type="java.lang.Boolean"%>

<ol>
	<li>
		<a href='<cs:addParam name="language" value="vi"/>'>TiengViet</a>
	</li>
	<li>
		<a href='<cs:addParam name="language" value="en"/>'>English</a>
	</li>
</ol>

<c:if test="${hideLogout != true}">
	<a href="logout">Logout</a>
</c:if>