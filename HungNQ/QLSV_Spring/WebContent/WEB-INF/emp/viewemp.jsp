<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>

<h1>Students List</h1>
<div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
       <a href="${pageContext.request.contextPath}/viewemp1?lang=fr">Language(French)</a>
       &nbsp;|&nbsp;
       <a href="${pageContext.request.contextPath}/viewemp1?lang=vi">Language(Vietnamese)</a>
</div>
 <spring:message  code="label.Hello" />
<table border="1" width="100%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Masv</th>
		<th>TenSV</th>
		<th>Namsinh</th>
		<th>Email</th>
		<th>DiaChi</th>
		<th>LopHoc</th>
		<th>Events</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.masv}</td>
			<td>${emp.tensv}</td>
			<td>${emp.namsinh}</td>
			<td>${emp.email}</td>
			<td>${emp.diachi}</td>
			<td>${emp.lophoc}</td>
			<td>
				<a href="editemp/${emp.id}">Edit</a>
				<a href="deleteemp/${emp.id}">Delete</a>
			</td>
		</tr>
	</c:forEach>
</table>
<br />
<a href="empform">Add New Employee</a>
