<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "suly" method = "POST">
		Phương trình bậc 2: ax2 + bx + c = 0 <br><br>
		Số a: <input type="text" name="numbera" /> <br> <br>		
		Số b: <input type="text" name="numberb" /> <br> <br>
		Số c: <input type="text" name="numberc" /> <br> <br>
		<input type="Submit" name="tinhtoan" value="Submit"> <br> <br>
		<%= request.getAttribute("ketqua") %>
	</form>
</body>
</html>