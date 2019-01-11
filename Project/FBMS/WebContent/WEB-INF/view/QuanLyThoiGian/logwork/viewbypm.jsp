<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa chức năng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_nang/view/danhSachChucNang" />'>Danh
									sách chức năng</a></li>
							<li class="breadcrumb-item active">Sửa chức năng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="editlogwork" action="">
						<div class="form-group col-sm-6">
							<label>Dự án</label>
							<form:select path="maDuAn.maDAn" class="form-control"
								items="${dsDuAn}" itemValue="maDAn" itemLabel="tenDuAn" />
							<form:errors path="maDuAn.maDAn" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:select path="maNhanVien.maNVien" class="form-control"
								items="${dsNhanVien}" itemValue="maNVien" itemLabel="fullName" />
							<form:errors path="maNhanVien.maNVien" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Vai trò dự án</label>
							<form:select path="maVaiTroDuAn.maVaiTro" class="form-control"
								items="${dsVaiTroDuAn}" itemValue="maVaiTro"
								itemLabel="tenVaiTro" />
							<form:errors path="maVaiTroDuAn.maVaiTro" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Phòng ban</label>
							<form:select path="maPhongBan.maPBan" class="form-control"
								items="${dsPhongBan}" itemValue="maPBan" itemLabel="tenPhongBan" />
							<form:errors path="maPhongBan.maPBan" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên công việc</label>
							<form:input class="form-control" path="tenCongViec"
								placeholder="Tên công việc" readonly="readonly"/>
							<form:errors path="tenCongViec" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả</label>
							<form:input class="form-control" path="moTa" placeholder="Mô tả" readonly="readonly" />
							<form:errors path="moTa" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu</label>
							<div class='input-group date' id='datetimepicker1'>
								<form:input class="form-control" type="text"
									path="thoiGianBatDau" placeholder="Thời gian bắt đầu" readonly="readonly" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian kết thúc</label>
							<div class='input-group date' id='datetimepicker5'>
								<form:input path="thoiGianKetThuc" class="form-control"
									type="text" readonly="readonly" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:input class="form-control"
								path="trangThaiLogwork.maTrangThai" type="hidden" />
							<input class="form-control"
								value="${editlogwork.trangThaiLogwork.tenTrangThai}"
								readonly="readonly" />
						</div>
						<div class="form-group col-sm-6">
							<label>Nhận xét PM</label></br>
							<form:textarea path="nhanXetPM" rows="4" cols="62" />
						</div>
						<h1>${da}</h1>
						<div class="col-sm-12 text-center">
						<c:if test="${editlogwork.trangThaiLogwork.maTrangThai == 5}">
						<button type="submit" name="action" value="pheduyet"
								class="btn btn-success">Phê duyệt</button>
						</c:if>
							
							<c:if test="${editlogwork.trangThaiLogwork.maTrangThai == 4}">
								<button type="submit" name="action" value="submit"
									class="btn btn-info">Submit</button>
							</c:if>
							<c:if test="${editlogwork.trangThaiLogwork.maTrangThai == 3 }">
								<button type="submit" name="action" value="luuNhap"
									class="btn btn-success">Lưu nháp</button>
								<button type="submit" name="action" value="submit"
									class="btn btn-info">Submit</button>
							</c:if>
							<button type="submit" name="action" value="exit"
								class="btn btn-warning">Back</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
