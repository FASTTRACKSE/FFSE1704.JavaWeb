<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Greeting</title>
</head>
<body>
	<%-- các thành phố --%>
	<%
		String[] cities = { "Hà Nội", "Đà Nẵng", "Hồ Chí Minh" };
		pageContext.setAttribute("myCities", cities);
	%>
	<c:forEach var="tempCity" items="${myCities}">${tempCity}</br>
	</c:forEach>
	Ngày và Tháng :
	<%=new java.util.Date()%><br>
	<%-- Câu chào --%>
	<%
		String name = (String) request.getAttribute("username");
	%>
	Hello
	<%=name%>
</body>
</html>