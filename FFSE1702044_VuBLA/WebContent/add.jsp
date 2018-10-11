<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form action="AddServlet" method="post">
	 <input type="text" name="id" value="id">
	 <input type="text" name="username" value="username">
	 <input type="password" name="password" value="password">
	 <input type="text" name="fullname" value="fullname">
	 <input type="text" name="old" value="old">
	 <button name="submit">Submit</button>
	</form>
</body>
</html>