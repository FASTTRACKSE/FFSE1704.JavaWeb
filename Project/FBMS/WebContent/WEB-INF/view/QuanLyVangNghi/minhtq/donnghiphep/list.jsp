<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">


				<h3 class="content-header-title mb-0">Danh sách đơn nghỉ phép</h3>


			</div>

		</div>
		<!-- End Path -->

		<div class="content-body">

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
				</div>
			</c:if>
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
			<c:if test="${not empty button}">
				<h3 style="color: red">${button}</h3>
			</c:if>
			<c:if test="${empty button}"></c:if>

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
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>
												<th>id</th>
												<th>mã nhân viên</th>
												<th>loại ngày nghỉ</th>
												<th>số lượng</th>
												<th>thời gian bắt đầu</th>
												<th>thời gian kết thúc</th>
												<th>ghi chú</th>
												<th>trạng thái</th>
												<th>chức năng</th>

											</tr>
										</thead>
										<c:forEach var="dnpn" items="${listdonnghiphep}">
											<tr>
												<td>${dnpn.id}</td>
												<td>${dnpn.maNhanVien}</td>
												<td>${dnpn.loaiNgayNghiPhep.tenLoaiNgayNghi}</td>
												<td>${dnpn.soLuong}</td>
												<td>${dnpn.thoiGianBatDau}</td>
												<td>${dnpn.thoiGianKetThuc}</td>
												<td>${dnpn.ghiChu}</td>
												<td>${dnpn.trangThaiDNP.tenTrangThai}</td>
												<td><c:if
														test="${dnpn.trangThaiDNP.maTrangThai.equals('TT1')}">
														<a
															href="/FBMS/QuanLyVangNghi/minhtq/suaDonNghiPhepView/${dnpn.id}">
															<button class="btn btn-primary">Sửa</button>
														</a>
														<a
															href="/FBMS/QuanLyVangNghi/minhtq/deleteDonNghiPhepNhap/${dnpn.id}"><button
																class="btn btn-primary">Xóa</button></a>
													</c:if> <c:if
														test="${dnpn.trangThaiDNP.maTrangThai.equals('TT2')}">
														<a
															href="/FBMS/QuanLyVangNghi/minhtq/pheDuyetDon/daPheDuyet/${dnpn.trangThaiDNP.maTrangThai}">
															<button class="btn btn-primary">Phê duyệt</button>

														</a>
														<a
															href="/FBMS/QuanLyVangNghi/minhtq/pheDuyetDon/tuChoi/${dnpn.trangThaiDNP.maTrangThai}"><button
																class="btn btn-primary">Từ chối</button></a>
													</c:if> <c:if
														test="${dnpn.trangThaiDNP.maTrangThai.equals('TT3')}">
														<a href="/FBMS/QuanLyVangNghi/minhtq/readDNP/${dnpn.id}">
															<button class="btn btn-primary">Xem chi tiết</button>
														</a>
													</c:if> <c:if
														test="${dnpn.trangThaiDNP.maTrangThai.equals('TT4')}">
														<a
															href="/FBMS/QuanLyVangNghi/minhtq/suaDonNghiPhepView/${dnpn.id}">
															<button class="btn btn-primary">Sửa lại đơn</button>

														</a>
														<a
															href="/FBMS/QuanLyVangNghi/minhtq/deleteDonNghiPhepTuChoi/${dnpn.id}"><button
																class="btn btn-primary">Xóa đơn</button></a>
													</c:if></td>
											</tr>
										</c:forEach>

									</table>

									<div class="card-header" style="text-align: center;">
										<nav aria-label="Page navigation example">
											<c:if test="${lastPage > 0}">
												<ul class="pagination">
													<li class="page-item"><a class="page-link"
														href="?page=1">trang đầu</a></li>
													<c:if test="${currentPage > 2}">
														<li class="page-item"><a class="page-link"
															href="?page=${currentPage-2}">${currentPage-2}</a></li>
													</c:if>
													<c:if test="${currentPage > 1}">
														<li class="page-item"><a class="page-link"
															href="?page=${currentPage-1}">${currentPage-1}</a></li>
													</c:if>
													<li class="page-item active"><a class="page-link"
														href="?page=${currentPage}">${currentPage}</a></li>
													<c:if test="${currentPage < lastPage}">
														<li class="page-item"><a class="page-link"
															href="?page=${currentPage+1}">${currentPage+1}</a></li>
													</c:if>
													<c:if test="${currentPage < lastPage - 1}">
														<li class="page-item"><a class="page-link"
															href="?page=${currentPage+2}">${currentPage+2}</a></li>
													</c:if>
													<li class="page-item"><a class="page-link"
														href="?page=${lastPage }">trang cuối</a></li>
												</ul>
											</c:if>
										</nav>
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