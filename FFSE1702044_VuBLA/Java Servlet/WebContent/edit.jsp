<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("error1") != null){
	out.print("<p style='color:red'>Bạn Chưa Đăng Nhập </p>");
} %>
	<form action="EditUserServlet" method="post" >
		<input type="hidden" value="${arrList.id_user}" name="id"/>
		<input type="text" value="${arrList.user}" name="userName"/>
		<input type="text" value="${arrList.pass}" name="passWord"/>
		<input type="submit" value="Edit"/>
	</form>
</body>
</html>