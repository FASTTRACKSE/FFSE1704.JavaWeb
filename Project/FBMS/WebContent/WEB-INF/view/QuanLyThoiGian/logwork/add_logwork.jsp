<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới Logwork</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanLyThoiGian/Logwork/list" />'>Danh sách logwork</a></li>
							<li class="breadcrumb-item active">Thêm mới logwork</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="logworkk" action="addlogwork">
						<div class="form-group col-sm-6">
						  	<label>Mã dự án</label>
						  	<form:input class="form-control" path="maDuAn" placeholder="Mã dự án" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã nhân viên</label>
						  	<form:input class="form-control" path="maNhanVien" placeholder="Mã nhân viên" />
						  	<form:errors path="maNhanVien" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã vai trò</label>
						  	<form:input class="form-control" path="maVaiTro" placeholder="Mã vai trò" />
						  	<form:errors path="maVaiTro" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã nhân viên</label>
						  	<form:input class="form-control" path="maPhongBan" placeholder="Mã nhân viên" />
						  	<form:errors path="maPhongBan" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Tên công việc</label>
						  	<form:input class="form-control" path="tenCongViec" placeholder="Tên công việc" />
						  	<form:errors path="tenCongViec" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mô tả</label>
						  	<form:input class="form-control" path="moTa" placeholder="Mô tả" />
						  	<form:errors path="moTa" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Trạng thái</label>
						  	<form:input class="form-control" path="trangThai" placeholder="Trạng thái" />
						  	<form:errors path="trangThai" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian bắt đầu</label>
						  	<form:input class="form-control" type="date" path="thoiGianBatDau" placeholder="Thời gian bắt đầu" />
						  	<form:errors path="thoiGianBatDau" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian kết thúc</label>
						  	<form:input class="form-control" type="date" path="thoiGianKetThuc" placeholder="Thời gian kết thúc" />
						  	<form:errors path="thoiGianKetThuc" cssClass="error" />
						</div>	
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
