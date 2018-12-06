<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/daterange/daterangepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/datetime/bootstrap-datetimepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/pickadate/pickadate.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/pickers/daterange/daterange.css"/>">
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới phòng ban</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/PhuongQuanLyThoiGian/Logwork/list" />'>Danh
									sách Logwork</a></li>
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
					<form:form method="POST" modelAttribute="thongTinLogwork"
						action="add">

						<div class="form-group col-sm-6">
							<label>Phòng ban</label>
							<form:select path="phongBan.maPBan" class="form-control">
								<form:options items="${dsPhongBan}" itemValue="maPBan"
									itemLabel="tenPhongBan" />
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Mã Nhân viên</label>
							<form:input class="form-control" path="nhanVien.maNhanVien"
								placeholder="Mã nhân viên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Chon dự án</label>
							<form:input class="form-control" path="maDuAn"
								placeholder="Chọn dự án" />
						</div>
						<div class="form-group col-sm-6">
							<label>Vai trò dự án</label>
							<form:select path="vaiTro.maVaiTro" class="form-control">
								<form:options items="${dsVaiTro}" itemValue="maVaiTro"
									itemLabel="tenVaiTro" />
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Tên công việc</label>
							<form:input class="form-control" path="tenCongViec"
								placeholder="Tên công việc" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả công việc</label>
							<form:input class="form-control" path="moTa"
								placeholder="Mô tả công việc" />
						</div>


						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu</label>
							<div class='input-group date' id='datetimepicker5'>
								<form:input type='text' class="form-control"
									path="thoiGianBatDau" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
							</div>
						</div>

						<div class="form-group col-sm-6">
							<label>Thời gian Kết thúc</label>
							<div class='input-group date' id='datetimepicker11'>
								<form:input type='text' class="form-control"
									path="thoiGianKetThuc" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
							</div>
						</div>

						<div class="col-sm-12 text-center">
							<input type="submit" name="action" class="button" value="submit" />
						</div>

					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- ////////////////////////////////////////////////////////////////////////////-->
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />

<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.date.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.time.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/legacy.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/daterange/daterangepicker.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/scripts/pickers/dateTime/picker-date-time.js"/> "></script>