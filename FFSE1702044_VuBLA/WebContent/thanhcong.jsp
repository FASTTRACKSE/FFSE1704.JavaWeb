<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8" />
    <fmt:setLocale value="${lang}"/>
    <fmt:setBundle basename="i18n.messages" />    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	if(session.getAttribute("user") == null){
	response.sendRedirect(request.getContextPath()+"/index.jsp?error1=0");
}
%>
	Xin Chào User : <%=session.getAttribute("user") %>
	<h3 style="text-align: center; color: #456789"><fmt:message key="title" /></h3>
		<button> <a href="AddServlet"><fmt:message key="add"/></a></button>
		<button> <a href="LogOutServlet">LogOut</a></button>
		<a href="?page=${1}&lang=vi">Tiếng Việt</a>
		<a href="?page=${1}&lang=en">Tiếng Anh</a>
	<form action="DangNhapServlet" method="post">
		<table border="1px solid #ccc" width="100%">
			<tr>
				<th>Id</th>
				<th><fmt:message key="us" /></th>
				<th><fmt:message key="pass" /></th>
				<th><fmt:message key="fullname" /></th>
				<th><fmt:message key="Old" /></th>
				<th><fmt:message key="function" /></th>
			</tr>
			<c:forEach var="user" items="${listSinhVien}">
				<tr>
					<td><c:out value="${user.id_user}" /></td>
					<td><c:out value="${user.user}" /></td>
					<td><c:out value="${user.pass}" /></td>
					<td><c:out value="${user.fullname}" /></td>
					<td><c:out value="${user.old}" /></td>
					<td>
					<a href="EditUserServlet?id=${user.id_user}">edit</a> 
					<a href="DeleteServlet?id=${user.id_user}">delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</form>
	<%@ include file="page.jsp"%>
	<style>
table {
	width: 100%;
	border-collapse: collapse;
}
/* Zebra striping */
tr:nth-of-type(odd) {
	background: #eee;
}

th {
	background: #333;
	color: white;
	font-weight: bold;
}

td, th {
	padding: 6px;
	border: 1px solid #ccc;
	text-align: left;
}
</style>
</body>
</html>