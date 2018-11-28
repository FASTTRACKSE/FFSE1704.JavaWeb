<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
<form action="TinhToanPhuongTrinhBac2" method="post">
	nhap so a: <input type="text" name="so a" ><br>
	nhap so b: <input type="text" name="so b" ><br>
	nhap so c: <input type="text" name="so c" ><br>
	<input type="submit" value="xac nhan" >
	</form>
<% String ketQua = (String) request.getAttribute("ketqua");%>
<%=ketQua %>
</body>
</html>