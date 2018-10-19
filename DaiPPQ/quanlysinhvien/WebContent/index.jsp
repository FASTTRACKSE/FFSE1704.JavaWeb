<%@ page import="java.io.*,java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="cs"%>

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="i18n.Messages" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="dropdown">
			<button class="btn dropdown-toggle" type="button" id="dropdownMenu1"
				data-toggle="dropdown">
				Ngôn Ngữ <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
				<li><a href='<cs:addParam name="language" value="vn"></cs:addParam>'>Tieng Viet</a></li>
				<li><a href='<cs:addParam name="language" value="en"></cs:addParam>'>English</a></li>
				<li><a href='<cs:addParam name="language" value="cn"></cs:addParam>'>Taiwan</a></li>
			</ul>
		</div>

		<a href="AddSinhVienServlet"><input type="button"
			class="btn btn-success" value="add" name="control"></a> <br>
		<br>
		
		<%-- <cs:page page="${page}" toatalPage="${toatalPage}"/> --%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><fmt:message key="Language1" /></th>
					<th><fmt:message key="Language2" /></th>
					<th><fmt:message key="Language3" /></th>
					<th><fmt:message key="Language4" /></th>
					<th><fmt:message key="Language5" /></th>
					<th><fmt:message key="Language6" /></th>
					<th><fmt:message key="Language7" /></th>
					<th><fmt:message key="Language8" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sinhvien" items="${listSinhVien}">
					<tr>
						<td><c:out value="${sinhvien.id}" /></td>
						<td><c:out value="${sinhvien.masv}" /></td>
						<td><c:out value="${sinhvien.ho}" /></td>
						<td><c:out value="${sinhvien.ten}" /></td>
						<td><c:out value="${sinhvien.gioiTinh}" /></td>
						<td><c:out value="${sinhvien.namsinh}" /></td>
						<td><c:out value="${sinhvien.lop}" /></td>
						<td><a href="EditSinhVienServlet?id=${sinhvien.id}"><button
									type="button" class="btn btn-primary">Edit</button></a> <a
							href="DeleteSinhVienServlet?id=${sinhvien.id}"><button
									type="button" class="btn btn-danger">Delete</button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<%@ include file="page.jsp"%>
	</div>
</body>
</html>