<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="/editSinhVien" var="action" />
	<form:form modelAttribute="sinhVien" action="${action}">
		<form:hidden path="maSinhVien"/>
		${sinhVien.maSinhVien}<br/>
		<form:input path="tenSinhVien" /><br/>
		<form:input path="pass" /><br/>
		<input type="submit" value="save" />
	</form:form>
</body>
</html> --%>