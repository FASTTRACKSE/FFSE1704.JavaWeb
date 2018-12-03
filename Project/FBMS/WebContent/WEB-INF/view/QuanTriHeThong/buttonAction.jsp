<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 
<!DOCTYPE html>
<html>
 <head>
 <title>Multiple Action Buttons</title>
 </head>
 <body>
<h1>Multiple Action Buttons</h1>

<c:if test = "${not empty button}">
<h3 style="color:red">${button}</h3>
</c:if>
<c:if test = "${empty button}">
<h3 style="color:blue">Click a button to test!</h3>
</c:if>
<form:form method="post" action="/FBMS/demo/buttons">
<input type="submit" name="action" class="button" value="draft" />
<input type="submit" name="action" class="button" value="submit" />
<input type="submit" name="action" class="button" value="approved" />
<input type="submit" name="action" class="button" value="rejected" />
</form:form>
</body>
</html>