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
				<h3 class="content-header-title mb-0">Thêm TT hợp đồng và chế
					độ thụ hưởng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/congviec/" />'>Thông tin
									hợp đồng</a></li>
							<li class="breadcrumb-item active">Thêm mới</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<h1 style="text-align: center; color: green">${thongTinNhanVien.hoLot}<a>
							${thongTinNhanVien.ten}</a>
					</h1>
					<p style="text-align: center;">
						<a>Mã nhân viên:</a> ${thongTinNhanVien.maNhanVien}
					</p>
					<p style="text-align: center;">
						<a>Ngày sinh:</a> ${thongTinNhanVien.namSinh}
					</p>
					<p style="text-align: center;">
						Phòng ban:<a>${thongTinNhanVien.phongBan.tenPhongBan}</a> - Chức
						vụ:<a>${thongTinNhanVien.chucDanh.tenChucDanh}</a>
					</p>

					<form:form method="post" action="/FBMS/saveHopDongCheDo"
						modelAttribute="hopdongchedo">
						<div class="form-group col-sm-6">
							<form:input path="id" type="hidden" />
							
							
							<form:input path="maNhanVien" type="hidden"
								value="${thongTinNhanVien.maNhanVien}" />
							<label>Loại hợp đồng:</label>
							<form:select path="maHopDong"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${hd}" var="lhd">
									<form:option value="${lhd.maHopDong}" label="${lhd.tenHopDong}" />
								</c:forEach>
							</form:select>


						</div>
						<div class="form-group col-sm-6">
							<label>Ngày bắt đầu</label>
							<form:input class="form-control" type="Date" path="ngayBatDau" />

						</div>

						<div class="form-group col-sm-6">
							<label>Ngày kết thúc</label>
							<form:input class="form-control" type="Date" path="ngayKetThuc" />

						</div>

						<div class="form-group col-sm-6">
							<label>Lương tháng 13 </label>
							<form:select path="luongThang13"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${cdh}" var="lcdh">
									<form:option value="${lcdh.id}" label="${lcdh.luong}" />
								</c:forEach>
							</form:select>

						</div>
						<tr>
							<td></td>
							<td><input class="btn btn-secondary" type="submit" value="Thêm" /></td>
							<td><a href="/FBMS/thongTinHopDong/${thongTinNhanVien.maNhanVien}" class="btn btn-warning">Quay lại</a></td>
							
						</tr>
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
