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
				<h3 class="content-header-title mb-0">Thêm mới nhân sự</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/congviec/" />'>Danh sách
									nhân sự</a></li>
							<li class="breadcrumb-item active">Thêm mới nhân sự</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
<p style="text-align: center;">
						<a>Mã nhân viên:</a> ${bangCap.maNhanVien}
					</p>
		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post" 
						action="/FBMS/saveBangCap/${bangCap.maNhanVien}" modelAttribute="bang">
						<div class="form-group col-sm-6">
							<form:input path="id" type="hidden" />
							</div>
						<div class="form-group col-sm-6">
							<!-- <label>Mã Nhân Viên:</label> -->
							<form:hidden class="form-control" path="maNhanVien" 
								value="${bangCap.maNhanVien}" />
						</div>
						<div class="form-group col-sm-6">
							<label>Trình độ:</label>
							<form:select path="IdtrinhDo"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${listTrinhDo}" var="ltd">
									<form:option value="${ltd.id}" label="${ltd.tenTrinhDo}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Ngành:</label>
							<form:input class="form-control" type="text" path="tenNganh" />
						</div>
						
						<div class="form-group col-sm-6">
							<label>Thời gian:</label>
							<form:input class="form-control" type="Date" path="batDau" />
						</div>
						
						<div class="form-group col-sm-6">
							<label>Thời gian:</label>
							<form:input class="form-control" type="Date" path="ketThuc" />
						</div>
						<div class="form-group col-sm-6">
							<label>Xếp loại:</label>
							<form:input class="form-control" type="text" path="xepLoai" />
						</div>
						<div class="form-group col-sm-6">
							<label>Nơi cấp:</label>
							<form:input class="form-control" type="text" path="noiCap" />
						</div>



						<tr>
							<td><input class="btn btn-primary" type="submit" value="Save" /></td>
							<td><a class="btn btn-danger" href="/FBMS/ViewBC/${bangCap.maNhanVien}" >Back</a></td>
						</tr>
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

