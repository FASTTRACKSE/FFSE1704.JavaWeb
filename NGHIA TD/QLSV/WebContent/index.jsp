<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="cs" tagdir="/WEB-INF/tags"%>


<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="i18n.Messages" />

<!DOCTYPE html>
<html>
<head>
<%=session.getAttribute("list") %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Quản lý lớp học</title>
	<style type="text/css">
		body{
			background-image: url("https://www.freepptbackgrounds.net/wp-content/uploads/2013/01/Light-Blue-Effect-PPT-Backgrounds.jpg");
		}
	</style>
</head>
<body>




<div class="dropdown">
  <button class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown">
    Ngôn Ngữ
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    
		<li><a href="?language=vi">Tieng Viet</a></li>
		<li><a href="?language=en">English</a></li>
		<li><a href="?language=cn">taiwan</a></li>
	
 </ul>
</div>

	<cs:page page="${page}" toatalPage="${toatalPage}"/>
	<a href="create.jsp"><input value="CREATE" type="button" class="btn btn-success"></a>
	
	<h1>Hello world</h1>
	<table border="1" width="100%">
		<tr>
			<th><fmt:message key="Language1"/></th>
			<th><fmt:message key="Language2"/></th>
			<th><fmt:message key="Language3"/></th>
			<th><fmt:message key="Language4"/></th>
			<th><fmt:message key="Language5"/></th>
			<th><fmt:message key="Language6"/></th>

		</tr>
		<tr>
			<c:forEach var="user" items="${pageList}">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.age}" /></td>
					<td><c:out value="${user.diaChi}" /></td>
					<td><c:out value="${user.sdt}" /></td>
					<td><a href="editUser?id=${user.id}">Edit</a>
						<a href="deleteServlet?id=${user.id}">Delete</a>
						
				</tr>
			</c:forEach>
		</tr>
	</table>
	<div style="float:right;">
	<a href='<c:url value="logout"/>'><input name="deleteSession" value="Đăng xuất" type="button" class="btn btn-success"></a>
	
	</div>
	
</body>
</html>