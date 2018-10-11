<%@ page import="java.io.*,java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>


<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="main.messages" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>♥Hello♥</title>
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
		padding-top: 1px;
}
</style>
</head>
<body>
	<div class="container">
		<a href="Add"><input type="button" class="btn btn-success"
			value="<fmt:message key='Botton1' />" name="control"></a>
		<div class="dropdown" style="float: right;">
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				<fmt:message key="Box" /> <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a class="dropdown-item" href='<cs:addParam name="language" value="vi"/>'>Vietnamese</a></li>
				<li><a class="dropdown-item" href='<cs:addParam name="language" value="en"/>'>English</a></li>
			</ul>
		</div>
		<br> <br>
		<%@ include file="Page.jsp"%>

		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col"><fmt:message key="Language1" /></th>
					<th scope="col"><fmt:message key="Language2" /></th>
					<th scope="col"><fmt:message key="Language3" /></th>
					<th scope="col"><fmt:message key="Language4" /></th>
					<th scope="col"><fmt:message key="Language5" /></th>
					<th scope="col"><fmt:message key="Language6" /></th>
					<th scope="col"><fmt:message key="Language7" /></th>
					<th scope="col"><fmt:message key="Language8" /></th>
					<th scope="col"><fmt:message key="Language9" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sinhvien" items="${listSinhVien}">
					<tr>
						<td><c:out value="${sinhvien.tenSinhVien}" /></td>
						<td><c:out value="${sinhvien.maSinhVien}" /></td>
						<td><c:out value="${sinhvien.lopHoc}" /></td>
						<td><c:out value="${sinhvien.tuoiSinhVien}" /></td>
						<td><c:out value="${sinhvien.gioiTinh}" /></td>
						<td><c:out value="${sinhvien.diaChi}" /></td>
						<td><c:out value="${sinhvien.soDT}" /></td>
						<td><c:out value="${sinhvien.email}" /></td>
						<td><a href="Edit?id=${sinhvien.maSinhVien}"><button
									type="button" class="btn btn-primary"><fmt:message key='Botton2' /></button></a> <a
							href="Delete?id=${sinhvien.maSinhVien}"><button type="button"
									class="btn btn-danger"><fmt:message key='Botton3' /></button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<a href="<c:url value='/Logout' />"><input type="button" class="btn btn-success"
			value="<fmt:message key='Botton4' />"></a>
	</div>
</body>
</html>