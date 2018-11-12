<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Fans List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Old</th><th>Idol</th><th>Images</th><th>City</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.old}</td>  
   <td>${emp.idol}</td>  
   <td><img src="/SpringMVCDemo/images/${emp.image}" width="50px"/></td>
   <td>${emp.namecity}</td>
   <td><a href="/SpringMVCDemo/editemp/${emp.id}">Edit</a></td>  
   <td><a href="/SpringMVCDemo/deleteemp/${emp.id}">Delete</a></td>  
   </tr>  
     
   </c:forEach>  
   </table>  
   <a href="/SpringMVCDemo/empform">Add New Fans</a> 
   <br/>  


    <a href="/SpringMVCDemo/viewemp/1">1</a>   
   <a href="/SpringMVCDemo/viewemp/2">2</a>   
   <a href="/SpringMVCDemo/viewemp/3">3</a>  
   
</body>
</html>