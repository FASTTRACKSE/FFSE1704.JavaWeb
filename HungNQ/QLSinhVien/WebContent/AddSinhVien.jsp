<%@ page import="java.io.*,java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="main.messages" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-image:
		url("https://cdn-images-1.medium.com/max/1600/1*QV3voZYLAsILm7AN-oFLXg.png");
}
</style>
</head>
<body>

	<hr>
	<div class="container">
		<div class="dropdown" style="float: right;">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				<fmt:message key="Box" />
				<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item"
					href='<cs:addParam name="language" value="vi"/>'>Vietnamese</a></li>
				<li><a class="dropdown-item"
					href='<cs:addParam name="language" value="en"/>'>English</a></li>
			</ul>
		</div>
		<br />
		<form action="Add" method="post">
			<div class="form-group">
				<label><fmt:message key="Language2" /></label> <input type="text"
					class="form-control" name="masinhvien">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language1" /></label> <input type="text"
					class="form-control" name="tensinhvien">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language3" /></label> <input type="text"
					class="form-control" name="lophoc">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language4" /></label> <input type="text"
					class="form-control" name="tuoi">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language5" /></label> <input type="text"
					class="form-control" name="gioitinh" value="${SinhVien.gioiTinh}">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language6" /></label> <input type="text"
					class="form-control" name="diachi">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language7" /></label> <input type="text"
					class="form-control" name="sdt">
			</div>

			<div class="form-group">
				<label><fmt:message key="Language8" /></label> <input type="text"
					class="form-control" name="email">
			</div>

			<button type="submit" class="btn btn-primary">
				<fmt:message key="Botton5" />
			</button>
			<a href="SinhVien?page=1"><input type="button"
				class="btn btn-success" value="<fmt:message key='Botton7' />"
				name="control"></a>
		</form>
	</div>
</body>
</html>