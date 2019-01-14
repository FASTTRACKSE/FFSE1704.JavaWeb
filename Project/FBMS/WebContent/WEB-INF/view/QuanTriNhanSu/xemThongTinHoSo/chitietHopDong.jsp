<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
								href='<c:url value="/thongTinHopDong/${thongTinNhanVien.maNhanVien}" />'>Danh
									sách hợp đồng</a></li>

							<li class="breadcrumb-item active">Chi tiết hợp đồng / Chế
								độ thụ hưởng</li>
						</ol>
					</div>
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
										<p>
											<img
												src="<c:url value="/uploads/${thongTinNhanVien.anhDaiDien}"/>"
												style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; height: 150px; display: block; margin-left: auto; margin-right: auto;">
										</p>
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
											Phòng ban:<a>${thongTinNhanVien.phongBan.tenPhongBan}</a> - Chức vụ:<a>${thongTinNhanVien.chucDanh.tenChucDanh}</a>
										</p>

										<div class="col-sm-12 col-md-6">

											<div class="card">
												<div class="card-header">
													<h4 class="card-title">
														Thông tin hợp đồng <small class="text-muted">Mã
															HD: ${hopDong.id }</small>
													</h4>
													<a class="heading-elements-toggle"><i
														class="fa fa-ellipsis-v font-medium-3"></i></a>
													<div class="heading-elements">
														<ul class="list-inline mb-0">
															<li><a data-action="expand"><i
																	class="ft-maximize"></i></a></li>
														</ul>
													</div>
												</div>
												<div class="card-content">
													<div class="table-responsive">
														<table class="table table-borderless mb-0">
															<tbody>
																<tr>
																	<td>
																		<h6>Loại hợp đồng</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.loaihopDong.tenHopDong}</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Trạng thái</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.trangthai.tenTrangThai}</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Ngày bắt đầu</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>
																				<fmt:formatDate value="${hopDong.ngayBatDau}"
																					pattern="dd-MM-yyyy" />
																			</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Ngày kết thúc</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>
																				<fmt:formatDate value="${hopDong.ngayKetThuc}"
																					pattern="dd-MM-yyyy" />
																			</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Loại công việc</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.congViec.tenCongViec}</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Phòng ban</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.phongBan.tenPhongBan}</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Chức vụ</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.chucDanh.tenChucDanh}</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Địa điểm làm việc</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.diaDiem.tenDiaDiem}</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Thời gian làm việc</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.thoiGianBatDauLamViec}
																				đến ${hopDong.thoiGianKetThucLamViec}</h6></a></td>
																</tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
										<div class="col-sm-12 col-md-6">
											<div class="card">
												<div class="card-header">
													<h4 class="card-title">Chế độ thụ hưởng:</h4>
													<a class="heading-elements-toggle"><i
														class="fa fa-ellipsis-v font-medium-3"></i></a>
													<div class="heading-elements">
														<ul class="list-inline mb-0">
															<li><a data-action="expand"><i
																	class="ft-maximize"></i></a></li>
														</ul>
													</div>
												</div>
												<div class="card-content">
													<div class="table-responsive">
														<table class="table table-borderless mb-0">
															<tbody>
																<tr>
																	<td>
																		<h6>Mức lương ban đầu</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.mucLuongBanDau}
																				VND</h6></a></td>
																</tr>
																<tr>
																	<td>
																		<h6>Lương tháng 13</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>${hopDong.cheDoHuong.luong}</h6></a></td>
																</tr>
																<c:forEach var="ngayNhi"
																	items="${thongTinNhanVien.listNgayNghi}">
																	<tr>
																		<td>
																			<h6>Số ${ngayNhi.danhSachNgayNghi.tenNgayNghi }</h6>
																		</td>
																		<td class="type-info text-right"><a
																			style="color: blue"><h6>${ngayNhi.tongSoNgayDuocNghi}</a>
																			-- Đã nghỉ <a style="color: blue">${ngayNhi.soNgayDaNghi}</a>
																			</h6></td>
																	</tr>
																</c:forEach>
																<tr>
																	<td>
																		<h6>Hình thức thanh toán lương</h6>
																	</td>
																	<td class="type-info text-right"><a
																		style="color: blue"><h6>
																				<c:choose>
																					<c:when test="${hopDong.hinhThucTraLuong == 0}">
						    Chưa được chọn
						  </c:when>
																					<c:when test="${hopDong.hinhThucTraLuong == 1}">
						    Tiền mặt
						  </c:when>
																					<c:when test="${hopDong.hinhThucTraLuong == 2}">
						   Ngân hàng
						  </c:when>
																					<c:otherwise>
						  ...
						  </c:otherwise>
																				</c:choose>
																			</h6></a></td>
																</tr>

															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>
										<div style="padding-left: 350px;" class="form-group col-sm-12">
											<tr>
												<td></td>
												<c:if test="${hopDong.maTrangThai == 'WAITING'}">
													<td><a
													href="/FBMS/editHopDong/${hopDong.id}&${thongTinNhanVien.maNhanVien}"
													class="btn btn-success">Sửa thông tin</a></td>
												</c:if>
												<c:if test="${hopDong.maTrangThai == 'WAITING' || hopDong.maTrangThai == 'OUT'}">
												<td><a class="btn btn-danger"
													href="/FBMS/deleteHopDongCheDo/${hopDong.id}&${thongTinNhanVien.maNhanVien}"
													class="btn btn-danger"
													onclick="return confirm('Bạn có muốn hợp đồng này?');">Xóa
														hợp đồng</a></td>
														</c:if>
												
												<td><a class="btn btn-success"
													href="/FBMS/thongTinHopDong/${thongTinNhanVien.maNhanVien}"
													class="btn btn-secondarys">Quay lại</a></td>

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


	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />