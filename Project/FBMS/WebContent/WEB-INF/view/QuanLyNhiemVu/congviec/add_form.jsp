<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/daterange/daterangepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/datetime/bootstrap-datetimepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/pickadate/pickadate.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/pickers/daterange/daterange.css"/>">
<!-- ////////////////////////////////////////////////////////////////////////////-->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới công việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/congviec/" />'>Danh sách
									công việc</a></li>
							<li class="breadcrumb-item active">Thêm mới công việc</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="congViec" action="add">
						<div class="form-group col-sm-6">
							<label>Mã dự án</label>
							<form:input class="form-control" path="maDuAn"
								placeholder="Mã dự án" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã loại CV</label>
							<form:input class="form-control" path="maLoaiCongViec"
								placeholder="Mã loại CV" />
							<form:errors path="maLoaiCongViec" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên CV</label>
							<form:input class="form-control" path="tenCongViec"
								placeholder="Tên công việc" />

						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả</label>
							<form:input class="form-control" path="moTa" placeholder="Mô tả" />
						</div>


						<div class="form-group col-sm-6">
							<label>TG bắt đầu</label>
							<div class='input-group date' id='datetimepicker11'>
								<form:input type='text' path="thoiGianBatDau"
									class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="thoiGianBatDau" cssClass="error" />
							</div>
						</div>

						<div class="form-group col-sm-6">
							<label>TG kết thúc</label>
							<div class='input-group date' id='datetimepicker4'>
								<form:input type='text' path="thoiGianKetThuc"
									class="form-control" />
								<span class="input-group-addon"> <span
									class="fa fa-calendar"></span>
								</span>
								<form:errors path="thoiGianKetThuc" cssClass="error" />
							</div>
						</div>




						<div class="form-group col-sm-6">
							<label>Người được PC</label>
							<form:input class="form-control" path="nguoiDuocPhanCong"
								placeholder="Người được PC" />
							<form:errors path="nguoiDuocPhanCong" cssClass="error" />
						</div>

						<div class="form-group col-sm-6">
							<label>TG dự kiến</label>
							<div class='input-group date' id='datetimepicker3'>
								<form:input type='text' class="form-control"
									path="thoiGianDuKienHoanThanh" />
								<span class="input-group-addon"> <span class="ft-clock"></span>
								</span>
								<form:errors path="thoiGianDuKienHoanThanh" cssClass="error" />
							</div>
						</div>
						
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>


					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
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

