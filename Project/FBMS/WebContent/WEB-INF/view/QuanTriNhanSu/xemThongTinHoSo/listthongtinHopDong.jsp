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
				<h3 class="content-header-title mb-0">THÔNG TIN NHÂN VIÊN</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>

							<li class="breadcrumb-item"><a
								href='<c:url value="/dsphongban" />'>Danh sách nhân sự</a></li>

							<li class="breadcrumb-item active">Thông tin hợp đồng / Chế
								độ thụ hưởng</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a
						href="<c:url value = "/addHopDongCheDo/${thongTinNhanVien.maNhanVien}"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
						mới</a>
				</div>
			</div>
			<!-- End Path -->

			<div class="content-body">

				<!-- Show message -->
				<c:if test="${button ne null}">
					<div class="alert alert-success alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${button}
					</div>
				</c:if>
				<c:if test="${messageError ne null}">
					<div class="alert alert-danger alert-dismissable" role="alert">
						<button type="button" class="close" data-dismiss="alert">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						${messageError}
					</div>
				</c:if>
				<!-- End Show message -->

				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Thông tin hợp đồng / Chế độ thụ
									hưởng</h4>
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
									<div class="table-responsive">
										<h1 style="text-align: center; color: green">${thongTinNhanVien.hoLot}<a>
												${thongTinNhanVien.ten}</a>
										</h1>
										<p style="text-align: center;">
											<a>Mã nhân viên:</a> ${thongTinNhanVien.maNhanVien}
										</p>
										<p style="text-align: center;">
											<a>Ngày sinh:</a> ${thongTinNhanVien.namSinh}
										</p>
										<p style="text-align: center;">
											Phòng ban:<a>${thongTinNhanVien.phongBan.tenPhongBan}</a> -
											Chức vụ:<a>${thongTinNhanVien.chucDanh.tenChucDanh}</a>
										</p>





										<table id="datatable"
											class="table table-striped table-bordered dataex-res-constructor">
											<thead>
												<tr>
													<th scope="col">Loại hợp đồng</th>
													<th scope="col">Ngày bắt đầu</th>
													<th scope="col">Ngày kết thúc</th>
													<th scope="col">Tổng số ngày nghỉ</th>
													<th scope="col">Số ngày nghỉ còn lại</th>
													<th scope="col">Lương tháng 13</th>
													<th scope="col">Sửa</th>
													<th scope="col">Xóa</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="hopDong"
													items="${thongTinNhanVien.listHopDong}">
													<tr>
														<td>${hopDong.loaihopDong.tenHopDong}</td>
														<td>${hopDong.ngayBatDau}</td>
														<td>${hopDong.ngayKetThuc}</td>
														<c:forEach var="ngayNghi"
															items="${thongTinNhanVien.listNgayNghi}">
															<td>${ngayNghi.soNgayPhepNam}</td>
															<td>${ngayNghi.soNgayNghiConLai}</td>
														</c:forEach>
														<td>${hopDong.cheDoHuong.luong}</td>
														<td><a
															href="/FBMS/editHopDong/${hopDong.id}&${thongTinNhanVien.maNhanVien}"><button
																	class="btn btn-success">Sửa</button></a></td>
														<td><a
															href="/FBMS/deleteHopDongCheDo/${hopDong.id}&${thongTinNhanVien.maNhanVien} "><button
																	class="btn btn-success"
																	onclick="return confirm('Bạn có muốn xóa hợp đồng này?');">Xóa</button></a></td>
													</tr>
												</c:forEach>
											</tbody>
											<tbody>
											</tbody>
										</table>
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