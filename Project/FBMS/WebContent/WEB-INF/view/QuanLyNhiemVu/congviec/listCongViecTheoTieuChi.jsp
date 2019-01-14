
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách công việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách công việc</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="add"> <span class="fa fa-plus"></span> Thêm mới
					</a>
				</div>
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
							<h4 class="card-title">Danh sách công việc</h4>
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
						<form action="/FBMS/QuanLyNhiemVu/cong_viec/xemds"
							style="width: 650px; text-align: center">
							<div class="col-md-3">
								<a style="color: blue">Dự án</a> <select class="form-control"
									name="maDuAn" id="idDuAn" onchange="selectNguoiDuocPC()">
									<option style="color: red" value="KO">Không chọn</option>
									<c:forEach items="${DuAn}" var="DuAn">
										<option value="${DuAn.maDAn}">${DuAn.tenDuAn}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-3">
								<a style="color: blue">Nhân viên </a> <select
									class="form-control" name="maNV" id="idNguoiDuocPC">
									<option value="KO">Không chọn</option>
									<%-- <option style="color: red" value="KO">Không chọn</option>
									<c:forEach items="${NhanVien}" var="NhanVien">
										<option value="${NhanVien.maNhanVien}">${NhanVien.hoDem}
											${NhanVien.ten}</option>
									</c:forEach> --%>
								</select>
							</div>
							<div class="col-md-3">
								<a style="color: blue">Trạng thái</a> <select
									class="form-control" name="maTrangThai">

									<option style="color: red" value="0">Không chọn</option>
									<c:forEach items="${TrangThai}" var="TrangThai">
										<option value="${TrangThai.maTrangThai}">${TrangThai.tenTrangThai}
										</option>
									</c:forEach>

								</select>
							</div>

							<div class="col-md-3">
								<input class="btn btn-success" type="submit" value="Xem">
								<a class="btn btn-danger"
									href="/FBMS/QuanLyNhiemVu/cong_viec/danhsachcongviec">Xem
									tất cả </a>
							</div>
						</form>


						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>
												<th>Id</th>
												<th>Dự án</th>
												<th>Mã loại cv</th>
												<th>Tên công việc</th>
												<th>Mô tả</th>
												<th>TG bắt đầu</th>
												<th>TG kết thúc</th>
												<th>Người được PC</th>
												<th>TG dự kiến HT</th>
												<th>Trạng thái</th>
												<th>Chức năng</th>
											</tr>
										</thead>
										<c:forEach var="nv" items="${danhsach}">
											<tr>
												<td>${nv.id}</td>
												<td>${nv.duAnKhanhCN.tenDuAn}</td>
												<td>${nv.loaiCongViec.loaiCongViec}</td>
												<td>${nv.tenCongViec}</td>
												<td>${nv.moTa}</td>
												<td>${nv.thoiGianBatDau}</td>
												<td>${nv.thoiGianKetThuc}</td>
												<td>${nv.nhanVienDuAn.nhanVienKhanhCN.hoDem}
													${nv.nhanVienDuAn.nhanVienKhanhCN.ten}</td>
												<td>${nv.thoiGianDuKienHoanThanh}</td>
												<td>${nv.trangThaiKhanhCN.tenTrangThai}</td>
												<td><a href="edit/${nv.id}"><button>sửa</button></a> <a
													href="delete/${nv.id}"><button>xóa</button></a></td>

											</tr>
										</c:forEach>
										<tbody>
											<div class="modal fade" id="confirm-delete" tabindex="-1"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">

														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">&times;</button>
															<h4 class="modal-title" id="myModalLabel">Bạn có
																chắc muốn xóa</h4>
														</div>

														<div class="modal-body">
															<p>Bạn có chắc muốn xóa</p>
															<p class="debug-url"></p>
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-default"
																data-dismiss="modal">Quay lại</button>
															<a class="btn btn-danger btn-ok">Xóa</a>
														</div>
													</div>
												</div>
											</div>
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
<script type="text/javascript">
	function selectNguoiDuocPC() {
		var maDAn = $("#idDuAn").val();
		$('#idNguoiDuocPC option').remove();
		$.ajax({
			url : "/FBMS/QuanLyNhiemVu/cong_viec/selectNhanVienView/" + maDAn,
			dataType : "json",
			success : function(data) {
				$('#idNguoiDuocPC').append($('<option>', {
					value : 'KO',
					text : 'Không chọn',

				}));

				for (var i = 0; i < data.length; i++) {
					$('#idNguoiDuocPC').append($('<option>', {
						value : data[i].maNguoiDuocPhanCong,
						text : data[i].tenNguoiDuocPhanCong
					}));
				}

			}
		});
	};
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />