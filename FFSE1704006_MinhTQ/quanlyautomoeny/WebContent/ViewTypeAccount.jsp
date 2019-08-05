<%@page import="codemaster.servlet.entity.SavingAccount"%>
<%@page import="codemaster.servlet.entity.Account"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>




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
			<a class="navbar-brand" href="controller">Code Master</a>
		</div>
		<div
			style="color: black; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
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
						class="fa fa-dashboard fa-3x"></i> menu</a></li>

				<li><a href="SinhVienSevlet"><i class="fa fa-user fa-3x"></i>
						Add Saving Account</a></li>
				<li><a href="SinhVienSevlet"><i class="fa fa-user fa-3x"></i>
						Add Transaction Account</a></li>
				<li><a href="SinhVienSevlet"><i class="fa fa-user fa-3x"></i>
						withdraw</a></li>
				<li><a href="SinhVienSevlet"><i class="fa fa-user fa-3x"></i>
						Deposit</a></li>
			</ul>
		</div>
		</nav>


		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<ul class="nav nav-tabs">


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
											<!-- <a href="AddSavingAccount.jsp" class="btn btn-success btn-md" id="">
												<i class="fa fa-plus">Add</i>&nbsp;
											</a> -->
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

									<%-- xin chào
									<%=session.getAttribute("user")%> --%>

									<%-- <h2>URL image: ${message}</h2> --%>
									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>AccountNo</th>
												<th>OwnerName</th>
												<th>Amount</th>
												<th>AccountType</th>
												<th>Interest</th>
												<th>Term</th>


											</tr>
										</thead>
										<tbody>

											<tr class="odd gradeX">
												<td><c:out value="${listone.accountNo}" /></td>
												<td><c:out value="${listone.ownerName}" /></td>
												<td><c:out value="${listone.amount}" /></td>
												<td><c:out value="${listone.accountType}" /></td>
												<td><c:out value="${listone.interest}" /></td>
												<td><c:out value="${listone.term}" /></td>
											</tr>

										</tbody>
									</table>
									<div class="row">
										<div class="col-sm-6"></div>
										<div class="col-sm-6" style="text-align: right;">
											<div class="dataTables_paginate paging_simple_numbers"
												id="dataTables-example_paginate">
												<%-- 												<%@ include file="page.jsp"%>
 --%>
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
