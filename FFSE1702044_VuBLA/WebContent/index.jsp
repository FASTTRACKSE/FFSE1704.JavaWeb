<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center;font-style : italic;">LOGIN</h1>
<%
				if(request.getParameter("error") != null){
					out.print("<p style='color:red'> sai tên đăng nhập or mật khẩu </p>");
				}else if(request.getParameter("error2") != null){
					out.print("<p style='color:red'>Bạn Đã Đăng Xuất </p>");
				}else if(request.getParameter("error1") != null){
					out.print("<p style='color:red'>Bạn Chưa Đăng Nhập </p>");
				}
			%>
			<%	if(session.getAttribute("user") != null){
	response.sendRedirect(request.getContextPath()+"/DangNhapServlet?page=1");
}
%>
	<form action="DangNhapServlet?page=1" method="post">
		User: <input type="text" name="user" /> </br>
		Pass: <input type="password" name="pass" /></br>
		<button type="submit" value="Login">Send</button>
	</form>
	
	<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</body>
</html>