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
				<h3 class="content-header-title mb-0">Sửa chứng chỉ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/congviec/" />'>Danh sách
									chứng chỉ</a></li>
							<li class="breadcrumb-item active">Sửa chứng chỉ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<p style="text-align: center;">
		<h5>Mã nhân viên:</h5>
		${chungChi.maNhanVien}
		</p>
		<p style="text-align: center;">
		<h5>Tên nhân viên:</h5>
		${chungChi.hoLot} ${chungChi.ten}
		</p>
		<p style="text-align: center;">
		<h5>Ngày sinh:</h5>
		${chungChi.namSinh}
		</p>
		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post"
						action="/FBMS/viewUpdate/${chungChi.maNhanVien}"
						modelAttribute="chungChi2">
						<div>
							<form:hidden path="ID" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien"
								disabled="true" />
						</div>
						<div class="form-group col-sm-6">
							<label>Tên Chứng Chỉ:</label>
							<form:input class="form-control" type="text" path="tenChungChi" />
						</div>


						<div class="form-group col-sm-6">
							<label>Ngày Cấp:</label>
							<form:input class="form-control" type="Date" path="ngayCap" />

						</div>
						<div class="form-group col-sm-6">
							<label>Đơn Vị Cấp:</label>
							<form:input class="form-control" type="text" path="donViCap" />

						</div>

						<tr>
							<td><input class="btn btn-success" type="submit"
								value="Update" /></td>
							<td><a class="btn btn-secondary"
								href="/FBMS/ViewCC/${chungChi.maNhanVien}">Quay lại</a></td>
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

