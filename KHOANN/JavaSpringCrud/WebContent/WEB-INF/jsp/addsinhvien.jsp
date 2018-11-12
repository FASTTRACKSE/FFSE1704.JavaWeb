<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>  
        <h1>Add New Employee</h1>   
       <form:form method="post" action="/JavaSpringCrud/save" enctype="multipart/form-data">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"  /></td>  
         </tr>    
         <tr>    
          <td>BirthDay :</td>    
          <td><form:input path="birthday" placeholder="yyyy/MM/dd" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr> 
         <tr>    
          <td>Address :</td>    
          <td><form:select path="address">
						<form:options items="${countryList}" itemValue="maTinh" itemLabel="tenTinh" />
					</form:select></td>  
         </tr> 
         <tr>    
          <td>Class :</td>    
          <td><form:input path="classsv" /></td>  
         </tr>
         <tr>
				<td>Image:</td>
				<td><input type="file" name="file"  /></td>
			</tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
       </body>
       </html>