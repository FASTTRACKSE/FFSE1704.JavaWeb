
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title></title>
<!-- BOOTSTRAP STYLES-->
<link href="asset/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="asset/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="asset/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
	<fmt:requestEncoding value="UTF-8" />
	<fmt:setLocale value="${languge}" />
	<fmt:setBundle basename="i18n.messages" />



	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="https://www.fasttrack.edu.vn/">Fasttrack
					SE</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				Xin chào, <b>Admin</b> &nbsp; <a href="#"
					class="btn btn-danger square-btn-adjust">Đăng xuất</a>
			</div>
		</nav>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li class="text-center"><img src="asset/img/minh.jpg"
						class="user-image img-responsive" /></li>

					<li><a class="active-menu" href="index.html"><i
							class="fa fa-dashboard fa-3x"></i> <fmt:message
								key="menu_Homepage" /></a></li>
					<li><a href="loginSevlet"><i class="fa fa-list fa-3x"></i>
							<fmt:message key="menu_StudentManagement" /></a></li>
					<li><a href="SinhVienSevlet"><i class="fa fa-user fa-3x"></i>
							<fmt:message key="menu_ManagerAdmin" /></a></li>
				</ul>
			</div>
		</nav>


		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<ul class="nav nav-tabs">
							<a href="?page=${1}&lang=vi"><li>vietnammes</li></a>
							<a href="?page=${1}&lang=en"><li>English</li></a>
							<a href="?page=${1}&lang=fr"><li>France</li></a>

						</ul>
					</div>
				</div>
				<!-- /. ROW  -->

				<hr />

				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="table-responsive">
									<div class="row">
										<div class="col-sm-6">
											<a href="AddView.jsp" class="btn btn-success btn-md" id="">
												<i class="fa fa-plus"><fmt:message key="btn_add" /></i>&nbsp;
											</a>
										</div>
										<div class="col-sm-6" style="text-align: right;">
											<form method="post" action="">
												<input type="submit" name="search" value="Tìm kiếm"
													class="btn btn-warning btn-sm" style="float: right" /> <input
													type="search" class="form-control input-sm"
													placeholder="Nhập họ tên"
													style="float: right; width: 300px;" />
												<div style="clear: both"></div>
											</form>
											<br />
										</div>
									</div>
									
									xin chào <%=session.getAttribute("user")%>
									
									<h2>URL image: ${message}</h2>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th><fmt:message key="th_CodeSV" /></th>
												<th><fmt:message key="th_NameSV" /></th>
												<th><fmt:message key="th_Arg" /></th>
												<th><fmt:message key="th_Class" /></th>
												<th><fmt:message key="th_address" /></th>
												<th width="160px"><fmt:message key="th_Function" /></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="User" items="${SinhVien}">
												<tr class="odd gradeX">

													<td><c:out value="${User.maSinhVien}" /></td>
													<td><c:out value="${User.tenSinhVien}" /></td>
													<td><c:out value="${User.tuoiSinhVien}" /></td>
													<td><c:out value="${User.lopHoc }" /></td>
													<td><c:out value="${User.diaChi }" /></td>
												
													<td class="center"><a
														href="EditSevlet?id=${User.maSinhVien }" title=""
														class="btn btn-primary"><i class="fa fa-edit "></i> <fmt:message
																key="Function_update" /></a> <a
														href="DeleteSevlet?id=${User.maSinhVien }" title=""
														class="btn btn-danger"><i class="fa fa-pencil"></i> <fmt:message
																key="Function_delete" /></a></td>


												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="row">
										<div class="col-sm-6"></div>
										<div class="col-sm-6" style="text-align: right;">
											<div class="dataTables_paginate paging_simple_numbers"
												id="dataTables-example_paginate">
												<%@ include file="page.jsp"%>

											</div>
										</div>
									</div>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>
			</div>

		</div>
		<!-- /. PAGE INNER  -->

	</div>
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="assets/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>


</body>

</html>
