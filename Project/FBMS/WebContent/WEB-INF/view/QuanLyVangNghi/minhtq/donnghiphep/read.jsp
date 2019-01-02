<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}

#datatable>thead>tr>th:last-child[class*="sort"]::after {
	content: ""
}

#datatable>thead>tr>th:last-child[class*="sort"]::before {
	content: ""
}
</style>
<style>
* {
	box-sizing: border-box
}

/* Set height of body and the document to 100% */
body, html {
	height: 100%;
	margin: 0;
	font-family: Arial;
}

/* Style tab links */
.tablink {
	background-color: #555;
	color: black;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 16px;
	width: 14%;
}

.tablink:hover {
	background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: black;
	display: none;
	padding: 100px 20px;
	height: 100%;
}

#Home {
	background-color: white;
}

#News {
	background-color: white;
}

#Contact {
	background-color: white;
}

#About {
	background-color: white;
}
</style>
<style>

/* Style tab links */
.tablink {
	background-color: #555;
	color: black;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 16px;
	width: 14%;
}

.tablink:hover {
	background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: black;
	display: none;
	padding: 100px 20px;
	height: 100%;
}

#Home {
	background-color: white;
}

#News {
	background-color: white;
}

#Contact {
	background-color: white;
}

#About {
	background-color: white;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Chi tiết đơn nghỉ phép</h3>

			</div>

			<!-- End Path -->

			<div class="content-body">



				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">

								<a class="heading-elements-toggle"><i
									class="fa fa-ellipsis-v font-medium-3"></i></a>
								<div class="heading-elements">
									<ul class="list-inline mb-0">
										<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
										<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
										<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
										<li><a data-action="close"><i class="ft-x"></i></a></li>
									</ul>
								</div>
							</div>
							<div class="card-body collapse in">
								<div class="card-block card-dashboard">



									<div class="row">
										<div class="col-md-12">
											<h4 style="text-align: center">Đơn nghỉ phép của :</h4>


											<a class="heading-elements-toggle"><i
												class="fa fa-ellipsis-v font-medium-3"></i></a>
										</div>
										<div class="col-md-2"></div>
										<div class="col-md-8" style="background: #dce1e8">
											<table class="table table-borderless mb-0">
												<tbody>
													<tr>
														<td>
															<h6>id :</h6>
														</td>
														<td><a style="color: red"><h6>${thongtindonnghiphep.id}</h6></a></td>
													</tr>
													<tr>
														<td>
															<h6>Mã nhân viên :</h6>
														</td>
														<td><a style="color: red"><h6>${thongtindonnghiphep.maNhanVien}</h6></a></td>
													</tr>
													<tr>
														<td>
															<h6>Lý do nghỉ :</h6>
														</td>
														<td><a style="color: red"><h6>${thongtindonnghiphep.loaiNgayNghiPhep.tenLoaiNgayNghi}</h6></a></td>
													</tr>
													<tr>
														<td>
															<h6>Số lượng :</h6>
														</td>
														<td><a style="color: red"><h6>${thongtindonnghiphep.soLuong}</h6></a></td>
													</tr>
													<tr>
														<td>
															<h6>thời gian bắt đầu :</h6>
														</td>
														<td><a style="color: red"><h6>${thongtindonnghiphep.thoiGianBatDau}</h6></a></td>
													</tr>
													<tr>
														<td>
															<h6>Thời gian kết thúc :</h6>
														</td>
														<td><a style="color: red"><h6>${thongtindonnghiphep.thoiGianKetThuc}</h6></a></td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="col-md-2" ></div>
										<div style="text-align: center;" class="form-group col-sm-12">
											<tr>

												<td><a class="btn btn-success"
													href="<c:url value="/QuanLyVangNghi/minhtq/listDonNghiPhep/TT3"/>"
													class="btn btn-warning">Quay lại</a></td>

											</tr>

										</div>
									</div>


								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />