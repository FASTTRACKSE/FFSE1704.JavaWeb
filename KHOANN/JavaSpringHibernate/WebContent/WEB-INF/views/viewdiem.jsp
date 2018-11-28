<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search</title>

</head>
<body>
	<table border="2" width="70%" cellpadding="2">
	
		<tr>
			<th>Ma</th>
			<th>TenMH</th>
			<th>Diem</th>
			
			
		</tr>
		<c:forEach var="hs" items="${listDiemSV}">
		
			<tr>
		<c:forEach var="diem" items="${hs.listDiem}">
		</c:forEach>			
				<td>
						${diem.diem }
				</td>
				

			</tr>
		</c:forEach>

	</table>

</body>
</html>