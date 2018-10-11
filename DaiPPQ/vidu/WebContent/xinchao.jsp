<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String name = (String)request.getAttribute("username"); %>
	Chao <%= name %> 
	<%-- 
	<br> 
	----------------------------------------------
	<br>
	jsp:include
	<br>
	<jsp:include page="error.jsp" flush="true"/>
	<jsp:include page="date.jsp" flush="true" />
	
	 --%>
	<br> 
	----------------------------------------------
	<br>
	jsp:forward
	<br>
	<jsp:forward page = "date.jsp" />


</body>
</html>