<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add sinh vien</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>
<a href="SinhVienServlet?page=1"><input type="button" class="btn btn-success" value="Back" name="control"></a>
<hr>
<div class="container">
<form action="AddSinhVienServlet" method="post">
  <div class="form-group">
    <label>Mã Sinh Viên</label>
    <input type="text" class="form-control" name="masinhvien">
  </div>
  
 <div class="form-group">
    <label>Tên Sinh Viên</label>
    <input type="text" class="form-control" name="tensinhvien" >
  </div>
  
   <div class="form-group">
    <label>Lớp Học</label>
    <input type="text" class="form-control" name="lophoc" >
  </div>
  
   <div class="form-group">
    <label>Tuổi</label>
    <input type="text" class="form-control" name="tuoi" >
  </div>
  
   <div class="form-group">
    <label>Giới Tính</label>
    <input type="text" class="form-control" name="gioitinh" value="${SinhVien.gioiTinh}">
  </div>
  
  <div class="form-group">
    <label>Địa Chỉ</label>
    <input type="text" class="form-control" name="diachi" >
  </div>
  
  <div class="form-group">
    <label>Số Điện Thoại</label>
    <input type="text" class="form-control" name="sdt" >
  </div>
  
  <div class="form-group">
    <label>Email</label>
    <input type="text" class="form-control" name="email" >
  </div>
  
  <button type="submit" class="btn btn-primary">Thêm</button>
  <button type="reset" class="btn btn-danger">hủy</button>
</form>
</div>
</body>
</html>