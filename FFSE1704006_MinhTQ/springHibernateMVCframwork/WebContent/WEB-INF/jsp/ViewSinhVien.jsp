<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>

	<div>
		<h3>
			<a href="addsinhvien">thêm</a>
		</h3>
	</div>
	<table border="2" width="100%" height="150" cellpadding="0"
		cellspacing="0" style="text-align: center;">

		<tr>
			<th>id</th>
			<th>tên sinh viên</th>
			<th>tuổi sinh viên</th>
			<th>địa chỉ</th>
			<th>avatar</th>
			<th>email</th>
			<th>chức năng</th>

		</tr>


		<c:forEach var="sv" items="${list}">
			<tr>
				<td>${sv.id}</td>
				<td>${sv.tenSinhVien }</td>
				<td>${sv.tuoiSinhVien }</td>
				<td>${sv.diaChi }</td>
				<td><img style="width: 100px; height: 100px;"
					src='<c:url value = "/resources/upload/${sv.avatar }" ></c:url>'
					alt="images"></td>
				<td>${sv.email }</td>

				<td><a href="/springHibernateMVCframwork/editview/${sv.id}"><button>edit</button></a>
					<a href="/springHibernateMVCframwork/delete/${sv.id}"><button>delete</button></a></td>
		</c:forEach>

	</table>

	 <center>
		<c:if test="${page >1}">
			<a href="/springHibernateMVCframwork/list/1">FIRST</a>
		</c:if>

		<c:if test="${page > 1}">
			<a href="/springHibernateMVCframwork/list/${page-1}">${page-1}</a>
		</c:if>

		<a href="/springHibernateMVCframwork/list/${page}">${page}</a>

		<c:if test="${page < total}">
			<a href="/springHibernateMVCframwork/list/${page+1}">${page+1}</a>
		</c:if>

		<c:if test="${page < total}">
			<a href="/springHibernateMVCframwork/list/${total}">LAST</a>
		</c:if>
	</center>


</body>
</html>