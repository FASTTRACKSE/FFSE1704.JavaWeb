<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.card-block input {
	border: 0;
	border-radius: 0;
}

.card-block .table td {
	padding-left: 0px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">DANH SÁCH LOGWORK</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/logwork/list" />'>Danh
									sách Logwork</a></li>
							<li class="breadcrumb-item active">Thông tin Logwork</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Thông tin Logwork</h4>
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
							<div class="card-block">
								<div class="table-responsive">
									<div class="form-group col-sm-4">
										<label>Tên dự án</label> <input class="form-control"
											value="${viewLogwork.maDuAn.tenDuAn}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Tên nhân viên</label> <input class="form-control"
											value="${viewLogwork.maNhanVien.hoDem} ${viewLogwork.maNhanVien.ten}"
											readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Vai trò</label> <input class="form-control"
											value="${viewLogwork.maVaiTroDuAn.tenVaiTro}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Phòng ban</label> <input class="form-control"
											value="${viewLogwork.maPhongBan.tenPhongBan}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Dự án</label> <input class="form-control"
											value="${viewLogwork.trangThaiLogwork.tenTrangThai}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Dự án</label> <input class="form-control"
											value="${viewLogwork.trangThaiLogwork.tenTrangThai}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Trạng thái</label> <input class="form-control"
											value="${viewLogwork.trangThaiLogwork.tenTrangThai}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Thời gian bắt đầu</label> <input class="form-control"
											value="${viewLogwork.thoiGianBatDau}" readonly />
									</div>
									<div class="form-group col-sm-4">
										<label>Thời gian kết thúc</label> <input class="form-control"
											value="${viewLogwork.thoiGianKetThuc}" readonly />
									</div>
									<div class="form-group col-sm-6">
										<label>Công việc</label>
										<textarea class="form-control" readonly style="height: 100px;">${viewLogwork.tenCongViec}</textarea>
									</div>
									<div class="form-group col-sm-6">
										<label>Mô tả</label>
										<textarea class="form-control" readonly style="height: 100px;">${viewLogwork.moTa}</textarea>
									</div>
									<div class="form-group col-sm-6">
										<label>Nhận xét PM</label>
										<textarea class="form-control" readonly style="height: 150px;">${viewLogwork.nhanXetPM}</textarea>
									</div>
									<div class="form-group col-sm-6">
										<label>Nhận xét Trưởng phó phòng</label>
										<textarea class="form-control" readonly style="height: 150px;">${viewLogwork.nhanXetTPP}</textarea>
									</div>
									<div class="form-group col-sm-6">
										<a href="/FBMS/logwork/list">
											<button type="submit" name="action" value="exit"
												class="btn btn-warning">Exit</button>
										</a>
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
