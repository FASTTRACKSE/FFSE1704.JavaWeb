<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>

<fmt:requestEncoding value="UTF-8" />
	<fmt:setLocale value="${lang}" />
	<fmt:setBundle basename="main.MessageBundle" />

<a href="SinhVienServlet?page=1"><input type="button" class="btn btn-success" value="<fmt:message key="minimenuback" />" name="control"></a>



<div class="container">
<form action="DeleteSinhVienServlet" method="post">
  <div class="form-group">
    <label><fmt:message key="key2" />: </label>
    <input type="hidden" class="form-control" name="masinhvien" value="${SinhVien.maSinhVien}" ><strong>${SinhVien.maSinhVien}</strong>
  </div>
  
 <div class="form-group">
    <label><fmt:message key="key1" />: </label>
    <input type="hidden" class="form-control" name="tensinhvien" value="${SinhVien.tenSinhVien}"><strong>${SinhVien.tenSinhVien}</strong>
  </div>
  
   <div class="form-group">
    <label><fmt:message key="key3" />: </label>
    <input type="hidden" class="form-control" name="lophoc" value="${SinhVien.lopHoc}"><strong>${SinhVien.lopHoc}</strong>
  </div>
  
   <div class="form-group">
    <label><fmt:message key="key4" />: </label>
    <input type="hidden" class="form-control" name="tuoi" value="${SinhVien.tuoiSinhVien}" ><strong>${SinhVien.tuoiSinhVien}</strong>
  </div>
  
  <div class="form-group">
    <label><fmt:message key="key5" />: </label>
    <input type="hidden" class="form-control" name="gioitinh" value="${SinhVien.gioiTinh}"><strong>${SinhVien.gioiTinh}</strong>
  </div>
  
  <div class="form-group">
    <label><fmt:message key="key6" />: </label>
    <input type="hidden" class="form-control" name="diachi" value="${SinhVien.diaChi}"><strong>${SinhVien.diaChi}</strong>
  </div>
  
  <div class="form-group">
    <label><fmt:message key="key7" />: </label>
    <input type="hidden" class="form-control" name="sdt" value="${SinhVien.soDT}"><strong>${SinhVien.soDT}</strong>
  </div>
  
  <div class="form-group">
    <label><fmt:message key="key8" />: </label>
    <input type="hidden" class="form-control" name="email" value="${SinhVien.email}"><strong>${SinhVien.email}</strong>
  </div>
  
  <button type="submit" class="btn btn-primary"><fmt:message key="minimenudelete" /></button>
</form>
</div>
</body>
</html>