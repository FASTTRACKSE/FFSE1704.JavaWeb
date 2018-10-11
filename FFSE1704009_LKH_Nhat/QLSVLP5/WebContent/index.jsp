
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>quan ly admin</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>


</head>

<body>

	<%=session.getAttribute("admin")%>
	<fmt:requestEncoding value="UTF-8" />
	<fmt:setLocale value="${lang}" />
	<fmt:setBundle basename="main.MessageBundle" />

	<h1 style="color: red; margin-left: 420px;">
		<fmt:message key="title" />
	</h1>

	<div class="container">
		<br>
		<form method="POST" name="frm">


			<fieldset>
				<legend>
					<fmt:message key="key10" />
				</legend>
				<fmt:formatDate type="both" dateStyle="full" timeStyle="full"
					value="<%=java.util.Calendar.getInstance().getTime()%>" />
			</fieldset>

			<!-- Example single danger button -->
			<div class="btn-group">
				<button type="button" class="btn btn-danger dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					Language</button>
				<div class="dropdown-menu">
					<ul class="list-group">
						<a href="?page=${page}&language=en"><li
							class="list-group-item list-group-item-primary">English</li></a>
						<a href="?page=${page}&language=vi"><li
							class="list-group-item list-group-item-secondary">Tiếng Việt</li></a>
						<a href="?page=${page}&language=th"><li
							class="list-group-item list-group-item-success">ไทย</li></a>
					</ul>
				</div>
			</div>


			<br> <br>
			<%-- <fieldset>
				<legend>
					<fmt:message key="key11" />
				</legend>
				<input type="radio" onchange="doSubmit();" name="language"
					value="vi_VN"
					<c:if test="${param.language=='vi_VN'}">checked</c:if> />Tiếng
				Việt <input type="radio" onchange="doSubmit();" name="language"
					value="en_US"
					<c:if test="${param.language=='en_US'}">checked</c:if> />English
				<input type="radio" onchange="doSubmit();" name="language"
					value="th_TH"
					<c:if test="${param.language=='th_TH'}">checked</c:if> />ไทย
				<input type="radio" onchange="doSubmit();" name="language"
					value="ja_JP"
					<c:if test="${param.language=='ja_JP'}">checked</c:if> />Japan
				<input type="radio" onchange="doSubmit();" name="language"
					value="ko_KR"
					<c:if test="${param.language=='ko_KR'}">checked</c:if> />Korea
			</fieldset>
 --%>


			<a href="AddSinhVienServlet"><input type="button"
				class="btn btn-success" value="<fmt:message key="menuadd" />"
				name="control"></a> <br> <br> <a href="LogoutServlet"><input
				type="button" class="btn btn-warning" value="Logout"></a> <br>
			<br>
			<%@ include file="Page.jsp"%>

			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col"><fmt:message key="key1" /></th>
						<th scope="col"><fmt:message key="key2" /></th>
						<th scope="col"><fmt:message key="key3" /></th>
						<th scope="col"><fmt:message key="key4" /></th>
						<th scope="col"><fmt:message key="key5" /></th>
						<th scope="col"><fmt:message key="key6" /></th>
						<th scope="col"><fmt:message key="key7" /></th>
						<th scope="col"><fmt:message key="key8" /></th>
						<th scope="col"><fmt:message key="key9" /></th>
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
							<td><a href="EditSinhVienServlet?id=${sinhvien.maSinhVien}"><button
										type="button" class="btn btn-primary">
										<fmt:message key="menuedit" />
									</button></a> <a href="DeleteSinhVienServlet?id=${sinhvien.maSinhVien}"><button
										type="button" class="btn btn-danger">
										<fmt:message key="menudelete" />
									</button></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</form>

	</div>
</body>
</html>