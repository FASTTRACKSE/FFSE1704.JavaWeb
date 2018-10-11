<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tính Toán</title>
</head>
<body>

	<form action="tinhtoan" method="post">
		Nhập Số a: <input type="text" name="numbera" /><br /> 
		Nhập Số b: <input type="text" name="numberb" /><br /> 
		<input type="submit" value="+" name="pheptinh"> 
		<input type="submit" value="-" name="pheptinh"> 
		<input type="submit" value="x" name="pheptinh">
		<input type="submit" value="%" name="pheptinh">
	</form>
</body>
</html>