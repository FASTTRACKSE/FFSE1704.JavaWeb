
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<table border="2" width="70%" cellpadding="2">

	<tr>
		<th>Id</th>
		<th>Mã SV</th>
		<th>Ten SV</th>
		<th>Nam Sinh</th>
		<th>Dia Chi</th>
		<th>Lop Hoc</th>
		<th>Avatar</th>
		<th>Chức Năng</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.id}</td>
			<td>${user.maSV}</td>
			<td>${user.tenSV}</td>
			<td>${user.namSinh}</td>
			<td>${user.diaChi}</td>
			<td>${user.lopHoc}</td>
			<td><img src="/springmvc/Image/${user.avatar}" width="50px"/></td>
			<td><a href="edituser/${user.id}">Edit</a>-+-<a
				href="deleteuser/${user.id}">Del</a></td>
		</tr>
	</c:forEach>

</table>
</br>

<center>
	<c:if test="${pageid > 1}">
		<a href="/springmvc/viewuser/1">First</a>
	</c:if>
	<c:if test="${pageid > 1}">
		<a href="/springmvc/viewuser/${pageid-1}">${pageid-1}</a>
	</c:if>
	<a href="/springmvc/viewuser/${pageid}">${pageid}</a>
	<c:if test="${pageid < pagetotal}">
		<a href="/springmvc/viewuser/${pageid+1}">${pageid+1}</a>
	</c:if>
	<c:if test="${pageid < pagetotal}">
		<a href="/springmvc/viewuser/${pagetotal}">Last</a>
	</c:if>

</center>
<a href="http://localhost:8080/springmvc/">Back Home</a>
