<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<title>Insert title here</title>
</head>
<body>
	<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>image</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>  
   <td>${emp.designation}</td>
   <td><img  src="/crud/images/${emp.image}" width="50px"></td>
   <td><button type="button" class="btn btn-default"><a href="/crud/editemp/${emp.id}">Edit</a></button></td>  
   <td><button type="button" class="btn btn-default"><a href="/crud/deleteemp/${emp.id}">Delete</a></button></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/crud/empform">Add New Employee</a>
 <!--   <a href="/crud/uploadform">Upload Image</a> -->
   <br/>
   <a href="/crud/viewemp/1">1</a>
   <a href="/crud/viewemp/2">2</a>
   <a href="/crud/viewemp/3">3</a>
</body>
</html>