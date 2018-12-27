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
				<h3 class="content-header-title mb-0">Xoá thông tin</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/congviec/" />'>Danh sách
									thông tin gia đình</a></li>
							<li class="breadcrumb-item active">Xóa thông tin gia đình</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<p style="text-align: center;">
		<h5>Mã nhân viên:</h5>
		${thongTinGiaDinh.maNhanVien}
		</p>
		<p style="text-align: center;">
		<h5>Tên nhân viên:</h5>
		${thongTinGiaDinh.hoLot} ${thongTinGiaDinh.ten}
		</p>
		<p style="text-align: center;">
		<h5>Ngày sinh:</h5>
		${thongTinGiaDinh.namSinh}
		</p>
		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post"
						action="/FBMS/viewDeleteTT/${thongTinGiaDinh2.id}"
						modelAttribute="thongTinGiaDinh2">
						<div>
							<form:hidden path="id" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien" disabled="true"/>
						</div>
						<div class="form-group col-sm-6">
							<label>Họ Và Tên:</label>
							<form:input class="form-control" type="text" path="hoVaTen" disabled="true"/>
						</div>


						<div class="form-group col-sm-6">
							<label>Quan Hệ:</label>
							<form:input class="form-control" type="text" path="quanHe" disabled="true"/>

						</div>
						<div class="form-group col-sm-6">
							<label>Năm Sinh:</label>
							<form:input class="form-control" type="Date" path="namSinh" disabled="true"/>

						</div>
						<div class="form-group col-sm-6">
							<label>Nghề Nghiệp:</label>
							<form:input class="form-control" type="text" path="ngheNghiep" disabled="true"/>

						</div>
						<div class="form-group col-sm-6">
							<label>Địa Chỉ:</label>
							<form:input class="form-control" type="text" path="diaChi" disabled="true"/>

						</div>

						<tr>
							<td></td>
							<td><input type="submit" value="Xóa" /></td>
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

