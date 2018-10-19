<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
       <div align="center">
       <form action="AddServlet" method="POST">
       
        <table border="1" cellpadding="5">
           
                <c:if test="">
                    <input type="hidden" name="id" value="<c:out value='' />" />
                </c:if>           
            <tr>
                <th>Tài Khoản: </th>
                <td>
                    <input type="text" name="user" size="45"
                            value="<c:out value='' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Mật Khẩu: </th>
                <td>
                    <input type="text" name="password" size="45"
                            value="<c:out value='' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Họ Và Tên: </th>
                <td>
                    <input type="text" name="fullname" size="45"
                            value="<c:out value='' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>