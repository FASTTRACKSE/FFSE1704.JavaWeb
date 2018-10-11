<%@ page import="java.io.*,java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.entity.SinhVien"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:requestEncoding value="UTF-8" />
	<fmt:setLocale value="fr" />
	<fmt:setBundle basename="i18n.Messages" />
	
	========
	<fmt:message key="Hello" />
	<c:set  />
	========
	<br>
	<a href="<c:out value='CRUD-INF/create.jsp' />">Creat</a>
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Lop</th>
			<th>MaSV</th>
			<th>Ten</th>
			<th>Tuoi</th>
			<th>GioiTinh</th>
			<th>CRUD</th>
		</tr>
		<c:forEach var="getAll" items="${listSinhVien}">
			<tr>
				<td><c:out value="${getAll.id }" /></td>
				<td><c:out value="${getAll.lop }" /></td>
				<td><c:out value="${getAll.maSV }" /></td>
				<td><c:out value="${getAll.ten }" /></td>
				<td><c:out value="${getAll.tuoi }" /></td>
				<td><c:out value="${getAll.gioitinh }" /></td>
				<td><a href="<c:out value='Read?id=${getAll.id}' />">Read</a> <a
					href="<c:out value='Update?id=${getAll.id}' />">Update</a> <a
					href="<c:out value='Delete?id=${getAll.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>