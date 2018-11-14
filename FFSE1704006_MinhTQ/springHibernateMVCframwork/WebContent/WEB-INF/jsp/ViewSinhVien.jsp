<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="dropdown" style="width: 20%">
			<button class="btn btn-success dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"><spring:message code="nn" /></button>
				
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="?lang=vi">tiếng việt </a> 
				<a class="dropdown-item" href="?lang=en"> tiếng anh </a> 
				<a class="dropdown-item" href="?lang=fr"> Tiếng pháp </a>
			</div>	
		</div>

	<div>
		<h3>
			<a href="addsinhvien"><spring:message code="btn_add" /></a>
		</h3>
	</div>
	<table border="2" width="100%" height="150" cellpadding="0"
		cellspacing="0" style="text-align: center;">

		<tr>
			<th><spring:message code="th_CodeSV" /></th>
			<th><spring:message code="th_NameSV" /></th>
			<th><spring:message code="th_Arg" /></th>
			<th><spring:message code="th_Address" /></th>
			<th><spring:message code="th_Avatar" /></th>
			<th><spring:message code="th_Email" /></th>
			<th><spring:message code="th_Function" /></th>

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

				<td><a href="/springHibernateMVCframwork/editview/${sv.id}"><button>
							<spring:message code="Function_update" />
						</button></a> <a href="/springHibernateMVCframwork/delete/${sv.id}"><button>
							<spring:message code="Function_delete" />
						</button></a></td>
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



	</div>
</body>
</html>