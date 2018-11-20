<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
		<div class="container">
		<h1 style="text-align: center;">ADD SINH VIÊN</h1>
		<form:form method="post" action="saveSV" enctype="multipart/form-data" modelAttribute="sinhVien">
			<div class="form-group">
				
			<%-- 	<spring:message code="MASV" /> --%>
				<p>Mã SV</p>
				<form:input class="form-control" type="text" path="masv" />
				 <form:errors path="masv" cssClass="error" style="color:pink" />
				<br>

			</div>
			<div class="form-group">
			<p>tensv</p>
				<%-- <spring:message code="TenSV" /> --%>
				<form:input class="form-control" type="text" path="tensv" />
				<form:errors path="tensv" cssClass="error" style="color:pink" />
				<br>
			</div>
		<div class="form-group">
		<p>ảnh</p>
				<%-- <spring:message code="images" /> --%> <input id="upload" type="file"
					class="form-control-file" name="file">
					
			</div>
			<div class="form-group">
			<p>namsv</p>
				<%-- <spring:message code="NamSinh" /> --%>
				<form:input class="form-control" type="text" path="namsinh" />
				<form:errors path="namsinh" cssClass="error" style="color:pink" />
				<br>
			</div>
			<div class="form-group">
			<p>email</p>
				<%-- <spring:message code="Email" /> --%>
				<form:input class="form-control" type="text" path="email" />
				<form:errors path="email" cssClass="error" style="color:pink" />
				<br>
			</div>
			<div class="form-group">
				<p>diachi</p>
				<form:input class="form-control" type="text" path="diaChi" />
				<form:errors path="diaChi" cssClass="error" style="color:pink" />
				<br>
			</div>
			<div class="form-group">
				<%-- <spring:message code="LopHoc" /> --%>
				<p>lophoc</p>
				<form:input class="form-control" type="text" path="lopHoc" />
				<form:errors path="lopHoc" cssClass="error" style="color:pink" />
				<br>
			</div>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</form:form>
	</div>

</body>
</html>