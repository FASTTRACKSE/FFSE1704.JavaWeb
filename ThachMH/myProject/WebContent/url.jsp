<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:url,c:param example</title>
</head>
<body>
 
<h2>c:url,c:param example</h2>
 
 
<c:url value="http://example.com/showPage.jsp" var="myURL">
  <c:param name="color" value="red"/>
  <c:param name="background" value="blue"/>
</c:url>
 
<c:out value="${myURL}"/>
 
</body>
</html>