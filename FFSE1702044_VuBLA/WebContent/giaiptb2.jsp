<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="GiaiPTB2">
            <input type="text" style="width: 20px" name="a" value=""/>x <sup>2</sup>
            +
            <input type="text" style="width: 20px" name="b" value=""/>x
            + 
            <input type="text" style="width: 20px" name="c" value=""/>
            = 0
            <br/><br/>
            <input type="submit" name="calculate" value="Tính" />
        </form>
       

        <b> Kết quả :</b> <%float a = (float)request.getAttribute("delta"); %><%=a %>
</body>
</html>