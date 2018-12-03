<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới phòng ban</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/PhuongQuanLyThoiGian/Logwork/list" />'>Danh sách Logwork</a></li>
							<li class="breadcrumb-item active">ThongTinLogwork</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="thongTinLogwork" action="add">
						<div class="form-group col-sm-6">
						  	<label>Mã phòng ban</label>
						  	<form:input class="form-control" path="maPhongBan" placeholder="Mã phòng ban" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã Nhân viên</label>
						  	<form:input class="form-control" path="maNhanVien" placeholder="Mã nhân viên" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Chon dự án</label>
						  	<form:input class="form-control" path="maDuAn" placeholder="Chọn dự án" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Vai trò</label>
						  	<form:input class="form-control" path="maVaiTro" placeholder="Vai trò" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Tên công việc</label>
						  	<form:input class="form-control" path="tenCongViec" placeholder="Tên công việc" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mô tả công việc</label>
						  	<form:input class="form-control" path="moTa" placeholder="Mô tả công việc" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian bắt đầu</label>
						  	<form:input class="form-control" path="thoiGianBatDau" type="Date" placeholder="" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian kết thúc</label>
						  	<form:input class="form-control" path="thoiGianKetThuc" type="Date" placeholder="" />
						</div>
						
				
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
						
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />