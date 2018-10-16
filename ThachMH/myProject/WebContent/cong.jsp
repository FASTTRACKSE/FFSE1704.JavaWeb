<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
		<fmt:setLocale value="${abc }" />
		<fmt:setBundle basename="i18n.messages" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
    border-collapse: collapse;
}
</style>
</head>
<body>
	<h2>
		<a href="/myProject/add.jsp">Add</a>
	</h2>

	<div style="text-align: center; padding: 5px; margin: 5px 0px;">
			<a href="?page=${1}&lang=en">English</a> &nbsp;|&nbsp; 
			 &nbsp;|&nbsp; <a href="?page=${1}&lang=vi">Vietnamese</a>
		</div>
		
	<table border="1" width="100%">
		<tr>

			<th><fmt:message key="user"/></th>
			<th><fmt:message key="password"/></th>
			<th><fmt:message key="fullname"/></th>
			<th><fmt:message key="action"/></th>

		</tr>
		<c:forEach var="User" items="${listSinhVien}">
			<tr>

				<td><c:out value="${User.user }" /></td>
				<td><c:out value="${User.password }" /></td>
				<td><c:out value="${User.fullname }" /></td>
				<td><a href="EditServlet?id=${User.user }"><img src="https://png.icons8.com/windows/1600/0063B1/edit" style="width:20px; "></a>
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<a href="DeleteServlet?user=${User.user}"><img src="https://oit.colorado.edu/sites/default/files/images/trash_0.png" style="width:20px; "></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page.jsp"%>
</body>
</html>