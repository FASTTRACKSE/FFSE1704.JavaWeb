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
								href='<c:url value="/logwork/listChoPheDuyetPM" />'>Danh
									sách Chờ Phê Duyệt của PM</a></li>
							<li class="breadcrumb-item active">Thông tin Chờ Phê Duyệt
								của PM</li>
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
						<form:form method="POST" modelAttribute="viewPheDuyet" action="">
							<div class="card-body collapse in">
								<div class="card-block">
									<div class="table-responsive">
										<div class="form-group col-sm-4">
											<label>Tên dự án</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.maDuAn.tenDuAn}" />
											</output>
										</div>
										<div class="form-group col-sm-4">
											<label>Tên nhân viên</label>
											<output class="form-control">
												<c:out
													value="${viewPheDuyet.maNhanVien.hoDem} ${viewPheDuyet.maNhanVien.ten}" />
											</output>
										</div>
										<div class="form-group col-sm-4">
											<label>Vai trò</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.maVaiTroDuAn.tenVaiTro}" />
											</output>
										</div>
										<div class="form-group col-sm-4">
											<label>Tên Phòng Ban</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.maPhongBan.tenPhongBan}" />
											</output>
										</div>

										<div class="form-group col-sm-4">
											<label>Trạng thái</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.trangThaiLogwork.tenTrangThai}" />
											</output>
										</div>
										<div class="form-group col-sm-4">
											<label>Công việc</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.tenCongViec}" />
											</output>
										</div>
										<div class="form-group col-sm-4">
											<label>Thời gian bắt đầu</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.thoiGianBatDau}" />
											</output>
										</div>
										<div class="form-group col-sm-4">
											<label>Thời gian kết thúc</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.thoiGianKetThuc}" />
											</output>
										</div>


										<div class="form-group col-sm-4">
											<label>Mô tả</label>
											<output class="form-control">
												<c:out value="${viewPheDuyet.moTa}" />
											</output>
										</div>

										<div class="form-group col-sm-12">
											<label>Nhận xét PM</label>
											<textarea name="nhanXetPM" class="form-control">${viewPheDuyet.nhanXetPM}</textarea>
										</div>
										<div class="form-group col-sm-12">


											<button type="submit" name="action" value="exit"
												class="btn btn-warning">Exit</button>


											<c:if
												test="${viewPheDuyet.trangThaiLogwork.maTrangThai == 5}">
												<button type="submit" name="action" value="pheDuyet"
													class="btn btn-success">Phê Duyệt</button>

												<button type="submit" name="action" value="tuChoi"
													class="btn btn-success">Từ Chối</button>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
