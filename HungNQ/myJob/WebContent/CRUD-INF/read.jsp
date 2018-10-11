<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Read" method="get">
		<input type="hidden" value="${read.id}" name="id" /> 
		Lop: <input type="text" value="${read.lop}" name="lop" /> 
		MaSV: <input type="text" value="${read.maSV}" name="maSV" /> 
		Ten: <input type="text" value="${read.ten }" name="ten" /> 
		Tuoi: <input type="text" value="${read.tuoi}" name="tuoi" /> 
		GioiTinh: <input type="text" value="${read.gioitinh}" name="gioitinh" /> 
		<input type="submit" value="Comback" name="submit" />
	</form>
</body>
</html>