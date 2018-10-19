<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Admin</title>
<script src='<c:url value="/resources/web/js/jquery.min.js"/>'></script>
<!-- Custom Theme files -->
<link href='<c:url value="/resources/web/css/style.css" />' rel="stylesheet" type="text/css" />
<!-- for-mobile-apps -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Classy Login form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700' rel='stylesheet' type='text/css'>
</head>
<body>

<!--header start here-->
<div class="header">
		<div class="header-main">
		       <h1>Login</h1>
			<div class="header-bottom">
				<div class="header-right w3agile">
					
					<div class="header-left-bottom agileinfo">
						
					 <form action="LoginServlet" method="post">
						<input type="text"  name="username" />
					<input type="password"   name="password"/>
						<div class="remember">
			             <span class="checkbox1">
							   <label class="checkbox"><input type="checkbox" name="" checked=""><i> </i>Remember me</label>
						 </span>
						 <div class="forgot">
						 	<h6><a href="#">Forgot Password?</a></h6>
						 </div>
						<div class="clear"> </div>
					  </div>
					   
						<input type="submit" value="Login">
					</form>	
					<div class="header-left-top">
						<div class="sign-up"> <h2>or</h2> </div>
					
					</div>
					<div class="header-social wthree">
							<a href="#" class="face"><h5>Facebook</h5></a>
							<a href="#" class="twitt"><h5>Twitter</h5></a>
						</div>
						
				</div>
				</div>
			  
			</div>
		</div>
</div>
<!--header end here-->
<div class="copyright">
	<p>Login Form 2018 | Design by  <a href="https://www.facebook.com/Lekhahongnhat.LeoKun.1998" target="_blank">  Joker </a></p>
</div>
<!--footer end here-->






	<%-- <%=session.getAttribute("admin") %> --%>
	<%-- <div class="container">
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Username</label> <input type="text"
					class="form-control" name="username">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name="password">
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div> --%>
	 ${mess}
</body>
</html>