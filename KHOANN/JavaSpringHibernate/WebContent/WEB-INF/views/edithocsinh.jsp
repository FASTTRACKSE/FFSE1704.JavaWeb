<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit  Employee</h1>   
       <form:form method="post" action="/JavaSpringHibernate/update" enctype="multipart/form-data" modelAttribute="command">    
        <table >
        <tr>
			<td></td>
			<td><form:hidden path="id" /></td>
		</tr>
		<tr>    
          <td>MaSV : </td>   
          <td><form:hidden path="maSV"  /></td>  
         </tr>    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Address :</td>    
          <td><form:input path="address" /></td>  
         </tr>   
         <tr>    
          <td>Gender :</td>    
          <td><form:input path="gender" /></td>  
         </tr> 
         <tr>
         <td>Image:</td>
			<td><input name="file" id="upload" type="file" />
			<img src='<c:url value = "/resources/upload/${command.image }" ></c:url>'
							 width="100px"
				height="100px" />
         
         </tr>
         
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form> 
</body>
</html>