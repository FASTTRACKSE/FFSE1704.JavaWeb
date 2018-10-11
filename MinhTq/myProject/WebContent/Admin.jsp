

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AdminCP | Fasttrack SE</title>
<!-- BOOTSTRAP STYLES-->
<link href="asset/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="asset/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="asset/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>

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
				<a class="navbar-brand" href="https://www.fasttrack.edu.vn/">Fasttrack
					SE</a>
			</div>
			<div
				style="color: white; padding: 15px 50px 5px 50px; float: right; font-size: 16px;">
				Xin chào, <b>Admin</b> &nbsp; <a href="logoutSevlet"
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
							class="fa fa-dashboard fa-3x"></i> Trang chủ</a></li>
					<li><a href="loginSevlet"><i class="fa fa-list fa-3x"></i>
							Quản lý admin</a></li>
					<li><a href="SinhVienSevlet?page=1"><i
							class="fa fa-user fa-3x"></i> Quản lý sinh viên</a></li>
				</ul>
			</div>
		</nav>


		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Quản lý admin</h2>
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
											<a href="add.html" class="btn btn-success btn-md" id="">
												<i class="fa fa-plus"></i>&nbsp;Thêm
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

									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>
											<tr>
												<th>tên admin</th>
												<th>tuổi</th>
												<th>địa chỉ</th>
												<th>password</th>
												<th width="160px">Chức năng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="User" items="${listAdmin}">
												<tr class="odd gradeX">

													<td><c:out value="${User.tenAdmin}" /></td>
													<td><c:out value="${User.passWord}" /></td>
													<td><c:out value="${User.tuoiAdmin}" /></td>
													<td><c:out value="${User.diachi}" /></td>
													
													<td class="center"><a
														href="" title=""
														class="btn btn-primary"><i class="fa fa-edit "></i>thêm</a> <a
														href="" title=""
														class="btn btn-danger"><i class="fa fa-pencil"></i>delete</a></td>


												</tr>
											</c:forEach>
										</tbody>
									</table>
									<div class="row">
										<div class="col-sm-6"></div>
										<div class="col-sm-6" style="text-align: right;">
											<div class="dataTables_paginate paging_simple_numbers"
												id="dataTables-example_paginate">
												<ul class="pagination">
													<li class="paginate_button previous disabled"
														aria-controls="dataTables-example" tabindex="0"
														id="dataTables-example_previous"><a href="#">Trang
															trước</a></li>
													<li class="paginate_button active"
														aria-controls="dataTables-example" tabindex="0"><a
														href="#">1</a></li>
													<li class="paginate_button "
														aria-controls="dataTables-example" tabindex="0"><a
														href="#">2</a></li>
													<li class="paginate_button "
														aria-controls="dataTables-example" tabindex="0"><a
														href="#">3</a></li>
													<li class="paginate_button "
														aria-controls="dataTables-example" tabindex="0"><a
														href="#">4</a></li>
													<li class="paginate_button "
														aria-controls="dataTables-example" tabindex="0"><a
														href="#">5</a></li>
													<li class="paginate_button next"
														aria-controls="dataTables-example" tabindex="0"
														id="dataTables-example_next"><a href="#">Trang
															tiếp</a></li>
												</ul>
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
