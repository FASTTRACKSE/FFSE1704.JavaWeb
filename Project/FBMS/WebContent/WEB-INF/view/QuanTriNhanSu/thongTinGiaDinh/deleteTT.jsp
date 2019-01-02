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
				<h3 class="content-header-title mb-0">Xóa thông tin</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/ViewTT/${thongTinGiaDinh2.maNhanVien}" />'>Danh
									sách thông tin gia đình</a></li>
							<li class="breadcrumb-item active">Xóa thông tin gia đình</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<%-- <div class="main-content">
			<div class="row">
				<div class="form-group col-md-3"></div>
				<div class="form-group col-md-3">
					<h1 style="text-align: center; color: green">
						<p style="text-align: center">${thongTinGiaDinh.hoLot}
							${thongTinGiaDinh.ten}</p>
						</a>
					</h1>
					<p style="text-align: center;">
						<a style="text-align: center; color: blue">Mã nhân viên:</a>
						${thongTinGiaDinh.maNhanVien}
					</p>
					<p style="text-align: center;">
						<a style="text-align: center; color: blue">Ngày sinh:</a>
						${thongTinGiaDinh.namSinh}
					</p>
					<p style="text-align: center;">
						<a style="text-align: center; color: blue">Phòng ban:</a>
						${thongTinGiaDinh.phongBan.tenPhongBan}
					</p>
					<p style="text-align: center;">
						<a style="text-align: center; color: blue"> Chức vụ:</a>
						${thongTinGiaDinh.chucDanh.tenChucDanh}
					</p>
				</div>
				<div class="form-group col-md-3">
					<p style="text-align: center;">
						<a
							style="text-align: center; color: blue; font-size: 20px; font-family: Arial, Helvetica, sans-serif">Ảnh
							đại diện</a> </br> <img style="width: 200px;hight=150px;"
							src='<c:url value="/uploads/${thongTinGiaDinh.anhDaiDien}" />'>
					</p>
				</div>
				<div class="form-group col-md-3"></div>
			</div>
		</div> --%>
		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post"
						action="/FBMS/viewDeleteTT/${thongTinGiaDinh2.id}/${thongTinGiaDinh2.maNhanVien}"
						modelAttribute="thongTinGiaDinh2">
						<div>
							<form:hidden path="id" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien"
								disabled="true" />
						</div>
						<div class="form-group col-sm-6">
							<label>Họ Và Tên:</label>
							<form:input class="form-control" type="text" path="hoVaTen"
								disabled="true" />
						</div>


						<div class="form-group col-sm-6">
							<label>Quan Hệ:</label>
							<form:input class="form-control" type="text" path="quanHe"
								disabled="true" />

						</div>
						<div class="form-group col-sm-6">
							<label>Năm Sinh:</label>
							<form:input class="form-control" type="Date" path="namSinh"
								disabled="true" />

						</div>
						<div class="form-group col-sm-6">
							<label>Nghề Nghiệp:</label>
							<form:input class="form-control" type="text" path="ngheNghiep"
								disabled="true" />

						</div>
						<div class="form-group col-sm-6">
							<label>Địa Chỉ:</label>
							<form:input class="form-control" type="text" path="diaChi"
								disabled="true" />

						</div>

						<tr>
							<td><input class="btn btn-danger" type="submit" value="Xóa" /></td>
							<td><a class="btn btn-secondary"
								href="/FBMS/ViewTT/${thongTinGiaDinh2.maNhanVien}">Quay lại</a></td>
						</tr>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
<!-- ////////////////////////////////////////////////////////////////////////////-->

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

