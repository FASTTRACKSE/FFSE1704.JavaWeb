<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sinh vien</h1>
	<form action="SaveServlet" method="post">
		<table>
			<tr><td>id:</td> <td><input type = "text" id = "id"/></td></tr>
			<tr><td>tên:</td> <td><input type = "text" tên = "ten"/></td></tr>
			<tr><td>tuổi:</td><td><input type = "text" tuổi = "tuoi"/></td></tr>
			<tr><td>ngàysinh:</td><td><input type="text" ngày sinh = "ngaysinh"/></td></tr>
			<tr><td>diachi:</td><td><input type = "text" địa chỉ = "diachi"/></td></tr>
			
			<tr><td colspan="2"><input type = "submit" value="Save Employee"/></td></tr>
		</table>
	</form>
</body>
</html>