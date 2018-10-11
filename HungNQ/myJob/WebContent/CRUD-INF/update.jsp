<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Update" method="post">
		<input type="hidden" value="${sinhvien.id}" name="id"/>
		Lop: <input type="text" value="${sinhvien.lop}" name="lop"/>
		MaSV: <input type="text" value="${sinhvien.maSV}" name="masv"/>
		Ten: <input type="text" value="${sinhvien.ten}" name="ten"/>
		Tuoi: <input type="text" value="${sinhvien.tuoi}" name="tuoi"/>
		GioiTinh: <input type="text" value="${sinhvien.gioitinh}" name="gioitinh"/>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>