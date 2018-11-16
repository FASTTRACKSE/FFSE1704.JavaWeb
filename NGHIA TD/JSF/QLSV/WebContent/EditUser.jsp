<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="editUser" method="post">
	
		Mã Sinh viên: <input type="hidden" name="id" value="${sinhvien.id}"/>${sinhvien.id}</br>
		tên: <input type="text" name="name" value="${sinhvien.name}" /></br>
		Tuổi: <input type="text" name="age" value="${sinhvien.age}" /></br>
		Địa chỉ: <input type="text" name="address" value="${sinhvien.diaChi}" /></br>
		Số điện thoại: <input type="text" name="phone" value="${sinhvien.sdt}" /></br>
		<input type="submit"  value="send" />
		
	</form>
	
</body>
</html>