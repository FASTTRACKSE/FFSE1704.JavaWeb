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
					<spring:message code="chungchi.QuanTriNhanSu.suachungchi" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message
										code="chungchi.QuanTriNhanSu.trangchu" /></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/ViewCC/${chungChi2.maNhanVien}" />'><spring:message
										code="chungchi.QuanTriNhanSu.danhsachcc" /></a></li>
							<li class="breadcrumb-item active"><spring:message
									code="chungchi.QuanTriNhanSu.suachungchi" /></li>
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
						<img src="<c:url value="/uploads/${chungChi.anhDaiDien}"/>"
							style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; height: 150px; display: block; margin-left: auto; margin-right: auto;">
					</p>
					<h1 style="text-align: center; color: green">
						${chungChi.hoLot} ${chungChi.ten}
					</h1>
					<p style="text-align: center;">
						<a><spring:message code="chungchi.QuanTriNhanSu.manv" />:</a>
						${chungChi.maNhanVien}
					</p>
					<p style="text-align: center;">
						<a><spring:message code="chungchi.QuanTriNhanSu.ngaysinh" />:</a>
						<fmt:formatDate value="${chungChi.namSinh}" pattern="dd-MM-yyyy" />
					</p>
				</div>

				<div class="form-group col-md-3"></div>
			</div>
		</div>
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
							<label><spring:message code="chungchi.QuanTriNhanSu.manv" />:</label>
							<form:input class="form-control" type="text" path="maNhanVien"
								disabled="true" />
						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="chungchi.QuanTriNhanSu.tenchungchi" />:</label>
							<form:input class="form-control" type="text" path="tenChungChi" />
						</div>


						<div class="form-group col-sm-6">
							<label><spring:message
									code="chungchi.QuanTriNhanSu.ngaycap" />:</label>
							<form:input class="form-control" type="Date" path="ngayCap" />

						</div>
						<div class="form-group col-sm-6">
							<label><spring:message
									code="chungchi.QuanTriNhanSu.donvicap" />:</label>
							<form:input class="form-control" type="text" path="donViCap" />

						</div>

						<tr>
							<td><input class="btn btn-success" type="submit"
								value="<spring:message
										code="chungchi.QuanTriNhanSu.sua" />" /></td>
							<td><a class="btn btn-secondary"
								href="/FBMS/ViewCC/${chungChi.maNhanVien}"><spring:message
										code="chungchi.QuanTriNhanSu.quaylai" /></a></td>
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

