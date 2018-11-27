<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en" data-textdirection="ltr" class="loading">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta name="description" content="Stack admin is super flexible, powerful, clean &amp; modern responsive bootstrap 4 admin template with unlimited possibilities.">
    <meta name="keywords" content="admin template, stack admin template, dashboard template, flat admin template, responsive admin template, web app">
    <meta name="author" content="PIXINVENT">
    <title>FastTrackSE - The Business Management System - Login</title>
	<link rel="apple-touch-icon" href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/09/fasttrackselogo.png"/>">
	<link rel="shortcut icon" type="image/x-icon" href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <!-- BEGIN VENDOR CSS-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.css" />">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/feather/style.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/font-awesome/css/font-awesome.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/fonts/flag-icon-css/css/flag-icon.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/extensions/pace.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/forms/icheck/icheck.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendors/css/forms/icheck/custom.css" />">
    <!-- END VENDOR CSS-->
    <!-- BEGIN STACK CSS-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap-extended.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/colors.css" />">
    <!-- END STACK CSS-->
    <!-- BEGIN Page Level CSS-->
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/core/menu/menu-types/vertical-menu-modern.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/core/menu/menu-types/vertical-overlay-menu.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/core/colors/palette-gradient.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/pages/login-register.css" />">
    <!-- END Page Level CSS-->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <!-- END Custom CSS-->
</head>

<body data-open="click" data-menu="vertical-menu-modern" data-col="1-column" class="vertical-layout vertical-menu-modern 1-column   menu-expanded blank-page blank-page">
    <!-- ////////////////////////////////////////////////////////////////////////////-->
    <div class="app-content content container-fluid">
        <div class="content-wrapper">
            <div class="content-header row">
            </div>
            <div class="content-body">
                <section class="flexbox-container">
                    <div class="col-md-4 offset-md-4 col-xs-10 offset-xs-1  box-shadow-2 p-0">
                        <div class="card border-grey border-lighten-3 m-0">
                            <div class="card-header no-border">
                                <div class="card-title text-xs-center">
                                    <div class="p-1"><img src="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/fasttrack-title-logo-color-new-1.png" alt="branding logo" style="max-height: 50px;"></div>
                                </div>
                                <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span>Login to System</span></h6>
                            </div>
                            <div class="card-body collapse in">
                                <div class="card-block">
                                    <form class="form-horizontal form-simple" name='loginForm' action="<c:url value='j_spring_security_login' />" method='POST'>
                                        <style type="text/css">
                                            .alert-dismissible p {
                                                margin-bottom: 5px !important;
                                            }
                                        </style>
                                        <c:if test="${!empty message}">
                                        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                            <span id="error-msg">${message}</span>
                                            <button type="button" class="close"><span aria-hidden="true">&times;</span></button>
                                        </div>
                                        </c:if>
                                        <fieldset class="form-group position-relative has-icon-left mb-0">
                                            <input type="text" class="form-control form-control-lg input-lg" name="username" id="username" value="giamdoc" placeholder="Your Username" required>
                                            <div class="form-control-position">
                                                <i class="ft-user"></i>
                                            </div>
                                        </fieldset>
                                        <fieldset class="form-group position-relative has-icon-left">
                                            <input type="password" class="form-control form-control-lg input-lg" name="password" id="password" value="123456" placeholder="Enter Password" required>
                                            <div class="form-control-position">
                                                <i class="fa fa-key"></i>
                                            </div>
                                        </fieldset>
                                        <fieldset class="form-group row">
                                            <div class="col-md-6 col-xs-12 text-xs-center text-md-left">
                                                <fieldset>
                                                    <input type="checkbox" id="remember-me" class="chk-remember">
                                                    <label for="remember-me"> Remember Me</label>
                                                </fieldset>
                                            </div>
                                        </fieldset>
                                        <button type="submit" class="btn btn-primary btn-lg btn-block"><i class="ft-unlock"></i> Login</button>
				                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    </form>
                                    <h6 class="card-subtitle line-on-side text-muted text-xs-center font-small-3 pt-2"><span>Login as</span></h6>
                                    <div class="form-group">
                                      <div class="btn-group" role="group" aria-label="Basic example">
			                            <button type="button" class="btn btn-outline-success btn-sm" data-user="giamdoc">Giám đốc</button>
			                            <button type="button" class="btn btn-outline-success btn-sm" data-user="truongphongnhansu">TP Nhân sự</button>
			                            <button type="button" class="btn btn-outline-success btn-sm" data-user="truongphongit">TP Kỹ Thuật</button>
			                            <button type="button" class="btn btn-outline-success btn-sm" data-user="truongphongdaotao">TP Đào Tạo</button>
			                            <button type="button" class="btn btn-outline-success btn-sm" data-user="truongphongduan">TP Dự Án</button>
			                          </div>
                                      <div class="btn-group" role="group" aria-label="Basic example">
			                            <button type="button" class="btn btn-outline-warning btn-sm" data-user="thuky">Thư Ký</button>
			                            <button type="button" class="btn btn-outline-warning btn-sm" data-user="nhanvienphongnhansu">NV Nhân sự</button>
			                            <button type="button" class="btn btn-outline-warning btn-sm" data-user="nhanvienphongit">NV Kỹ Thuật</button>
			                            <button type="button" class="btn btn-outline-warning btn-sm" data-user="nhanvienphongdaotao">NV Đào Tạo</button>
			                            <button type="button" class="btn btn-outline-warning btn-sm" data-user="nhanvienphongduan">NV Dự Án</button>
			                          </div>
			                        </div>
									<script>
									$(document).ready(function(){
										$("button").click(function() {
											 var username = $(this).data('user');
											 var password = "123456";
											 if (username) {
											 	$("#username").val(username);
											 	$("#password").val(password);
											 }
										});
									});
									</script>                                    
                                </div>
                            </div>
                            <div class="card-footer">
                                <div class="center">
                                    <p>Welcome to FastTrackSE - The FFSE1704 Team!!!</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
    <!-- ////////////////////////////////////////////////////////////////////////////-->

    <!-- BEGIN VENDOR JS-->
    <script src="<c:url value="/resources/vendors/js/vendors.min.js" />" type="text/javascript"></script>
    <!-- BEGIN VENDOR JS-->
    <!-- BEGIN PAGE VENDOR JS-->
    <script src="<c:url value="/resources/vendors/js/forms/icheck/icheck.min.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/vendors/js/forms/validation/jqBootstrapValidation.js" />" type="text/javascript"></script>
    <!-- END PAGE VENDOR JS-->
    <!-- BEGIN STACK JS-->
    <script src="<c:url value="/resources/js/core/app-menu.js" />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/core/app.js" />" type="text/javascript"></script>
    <!-- END STACK JS-->
    <!-- BEGIN PAGE LEVEL JS-->
    <script src="<c:url value="/resources/js/scripts/forms/form-login-register.js" />" type="text/javascript"></script>
    <!-- END PAGE LEVEL JS-->
</body>

</html>