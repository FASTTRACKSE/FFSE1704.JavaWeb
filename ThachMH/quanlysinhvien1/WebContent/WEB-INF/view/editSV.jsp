<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/quanlysinhvien1/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>Birth_year :</td>    
          <td><form:input path="birth_year" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>
         <tr>    
          <td>Address :</td>    
          <td><form:input path="address" /></td>  
         </tr> 
         <tr>    
          <td>Class :</td>    
          <td><form:input path="lop" /></td>  
         </tr> 
         <tr>    
          <td>Gender :</td>    
          <td><form:input path="gender" /></td>  
         </tr>    
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" />
          <a href="view">   
         </tr>    
        </table>    
       </form:form>    
</body>
</html>