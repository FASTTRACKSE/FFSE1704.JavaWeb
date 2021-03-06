<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
				<h3 class="content-header-title mb-0">
					<spring:message code="thongtingd.QuanTriNhanSu.suatt" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message
										code="thongtingd.QuanTriNhanSu.trangchu" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/ViewTT/${thongTinGiaDinh2.maNhanVien}" />'><spring:message
										code="thongtingd.QuanTriNhanSu.dsgiadinh" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="thongtingd.QuanTriNhanSu.suattgd" /></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="main-content">
			<div class="row">
				<div class="form-group col-md-12">
					<p>
						<img src="<c:url value="/uploads/${thongTinGiaDinh.anhDaiDien}"/>"
							style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; height: 150px; display: block; margin-left: auto; margin-right: auto;">
					</p>
					<h1 style="text-align: center; color: green">
						${thongTinGiaDinh.hoLot} ${thongTinGiaDinh.ten}</h1>
					<p style="text-align: center;">
						<a><spring:message code="chungchi.QuanTriNhanSu.manv" />:</a>
						${thongTinGiaDinh.maNhanVien}
					</p>
					<p style="text-align: center;">
						<a><spring:message code="chungchi.QuanTriNhanSu.ngaysinh" />:</a>
						<fmt:formatDate value="${thongTinGiaDinh.namSinh}"
							pattern="dd-MM-yyyy" />
					</p>
					<p style="text-align: center;">
						<spring:message code="chungchi.QuanTriNhanSu.phongban" />
						: <a>${thongTinNhanVien.phongBan.tenPhongBan}</a> -
						<spring:message code="chungchi.QuanTriNhanSu.chucdanh" />
						: <a>${thongTinNhanVien.chucDanh.tenChucDanh}</a>
					</p>
				</div>

				<div class="form-group col-md-3"></div>
			</div>
		</div>
		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post"
						action="/FBMS/viewUpdateTT/${thongTinGiaDinh2.maNhanVien}"
						modelAttribute="thongTinGiaDinh2">
						<div>
							<form:hidden path="id" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="thongtingd.QuanTriNhanSu.manv" />:</label>
							<form:input class="form-control" type="text" path="maNhanVien"
								disabled="true" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="thongtingd.QuanTriNhanSu.hovaten" />:</label>
							<form:input class="form-control" type="text" path="hoVaTen" />
						</div>


						<div class="form-group col-sm-6">
							<label><spring:message
									code="thongtingd.QuanTriNhanSu.quanhe" />:</label>
							<form:input class="form-control" type="text" path="quanHe" />

						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="thongtingd.QuanTriNhanSu.namsinh" />:</label>
							<form:input class="form-control" type="Date" path="namSinh" />

						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="thongtingd.QuanTriNhanSu.nghenghiep" />:</label>
							<form:input class="form-control" type="text" path="ngheNghiep" />

						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="thongtingd.QuanTriNhanSu.diachi" />:</label>
							<form:input class="form-control" type="text" path="diaChi" />

						</div>

						<tr>
							<td><input class="btn btn-success" type="submit"
								value="<spring:message
									code="thongtingd.QuanTriNhanSu.sua" />" /></td>
							<td><a class="btn btn-secondary"
								href="/FBMS/ViewTT/${thongTinGiaDinh.maNhanVien}"><spring:message
										code="thongtingd.QuanTriNhanSu.quaylai" /></a></td>
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

