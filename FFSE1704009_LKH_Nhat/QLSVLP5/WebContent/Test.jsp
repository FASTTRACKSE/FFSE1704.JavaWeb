<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.Locale" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            function doSubmit()
            {
                document.frm.submit();
            }
        </script>
    </head>

    <c:if test="${empty param.language}">
        <fmt:setLocale value="<%= request.getLocale().getDefault()%>"/>
    </c:if>
    <c:if test="${! empty param.language}">
        <fmt:setLocale value="${param.language}"/>
    </c:if>

    <fmt:setBundle basename="codes.gui" scope="session"/>

    <body>

     

        <form method="POST" name="frm">
            <fieldset>
                <legend>Thông Báo</legend>
                <fmt:formatNumber type="currency" value="20000.02"/><br/>
                <fmt:formatDate type="both" dateStyle="full" timeStyle="full"
                value="<%= java.util.Calendar.getInstance().getTime()%>"/>

            </fieldset>
            <fieldset>
                <legend>Ngôn Ngữ</legend>
                <input type="radio" onchange="doSubmit();"
                       name="language" value="vi_VN"
                       <c:if test="${param.language=='vi_VN'}">checked</c:if>
                       />Tiếng Việt
                <input type="radio" onchange="doSubmit();"
                       name="language" value="en_US"
                       <c:if test="${param.language=='en_US'}">checked</c:if>
                       />English
                <input type="radio" onchange="doSubmit();"
                       name="language" value="th_TH"
                       <c:if test="${param.language=='th_TH'}">checked</c:if>
                       />Thai
            </fieldset>

        </form>
        
        
        
        
   <%
   //Get the client's Locale
   Locale locale = request.getLocale().KOREA;
   String language = locale.getLanguage();
   String country = locale.getCountry();
%>     
        
    <p align="center">
<% 
   out.println("Language : " + language  + "<br />");
   out.println("Country  : " + country   + "<br />");
%>
</p>    
        
        
        
        
        
    </body>
</html>


