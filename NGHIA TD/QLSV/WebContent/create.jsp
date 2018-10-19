<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="i18n.Messages" />
	<form action="create" mnethod="post">
		<fmt:message key="Language2"/>: <input type="text" name="name" /></br>
		<fmt:message key="Language3"/>: <input type="text" name="age" /></br>
		<fmt:message key="Language4"/>: <input type="text" name="address" /></br>
		<fmt:message key="Language5"/>: <input type="text" name="phone" /></br>
		<input type="submit"  value="send" />
		
	</form>
</body>
</html>