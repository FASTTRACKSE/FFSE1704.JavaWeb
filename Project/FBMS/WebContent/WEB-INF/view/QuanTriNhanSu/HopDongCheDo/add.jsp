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
								href='<c:url value="/thongTinHopDong/${thongTinNhanVien.maNhanVien}" />'>Thông tin
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
					<p>
						<img
							src="<c:url value="/uploads/${thongTinNhanVien.anhDaiDien}"/>"
							style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; height: 150px; display: block; margin-left: auto; margin-right: auto;">
					</p>
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
						Phòng ban:<a>${pbcd.phongBan.tenPhongBan}</a> - Chức vụ:<a>${pbcd.chucDanh.tenChucDanh}</a>
					</p>

					<form:form method="post"
						action="/FBMS/saveHopDongCheDo/${thongTinNhanVien.maNhanVien}"
						modelAttribute="hopdongchedo">
						<div class="form-group col-sm-4">
							<form:input path="id" type="hidden" />


							<form:input path="maNhanVien" type="hidden"
								value="${thongTinNhanVien.maNhanVien}" />
							<label>Loại hợp đồng:</label>
							<form:select path="maHopDong" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${hd}" var="lhd">
									<form:option value="${lhd.maHopDong}" label="${lhd.tenHopDong}" />
								</c:forEach>
							</form:select>


						</div>
						<div class="form-group col-sm-4">
							<label>Ngày bắt đầu</label>
							<form:input class="form-control" type="Date" path="ngayBatDau" />
							<form:errors path="ngayBatDau" cssClass="error"
								style="color:pink" />

						</div>

						<div class="form-group col-sm-4">
							<label>Ngày kết thúc</label>
							<form:input class="form-control" type="Date" path="ngayKetThuc" />
							<form:errors path="ngayKetThuc" cssClass="error"
								style="color:pink" />

						</div>
						<div class="form-group col-sm-3">
							<label>Loại công việc:</label>
							<form:select path="maCongViec" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${dscv}" var="dscv">
									<form:option value="${dscv.maCongViec}"
										label="${dscv.tenCongViec}" />
								</c:forEach>
							</form:select>

						</div>
						<div class="form-group col-sm-3">
							<label>Phòng ban:</label>
							<form:select path="maPhongBan" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listPhongBan}" var="cd">
									<form:option value="${cd.maPhongBan}" label="${cd.tenPhongBan}" />
								</c:forEach>
							</form:select>

						</div>
						<div class="form-group col-sm-3">
							<label>Chức danh:</label>
							<form:select path="maChucDanh" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listChucDanh}" var="cd">
									<form:option value="${cd.maChucDanh}" label="${cd.tenChucDanh}" />
								</c:forEach>
							</form:select>

						</div>
						<div class="form-group col-sm-3">
							<label>Địa điểm làm việc:</label>
							<form:select path="maDiaDiemLamViec"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${ddlv}" var="ddlv">
									<form:option value="${ddlv.maDiaDiem}"
										label="${ddlv.tenDiaDiem}" />
								</c:forEach>
							</form:select>

						</div>

						<div class="form-group col-sm-3">
							<label>Mức lương ban đầu</label>
							<form:input class="form-control" type="text"
								path="mucLuongBanDau" value="0" />
						</div>
						<div class="form-group col-sm-3">
							<label>Lương tháng 13 </label>
							<form:select path="luongThang13"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${cdh}" var="lcdh">
									<form:option value="${lcdh.id}" label="${lcdh.luong}" />
								</c:forEach>
							</form:select>

						</div>

						<div class="form-group col-sm-4">
							<label>Số ngày nghỉ trong năm</label>
							<form:input value="15" class="form-control" type="text"
								path="soNgayNghiTrongNam" />
						</div>


						<form:input value="FULL" path="ngayNghiDacBiet" type="hidden" />


						<div class="form-group col-sm-4">
							<label>Thời gian bắt đầu làm việc</label>
							<div class='input-group date' id='datetimepicker3'>
								<form:input value="08:00 AM" type='text' class="form-control"
									path="thoiGianBatDauLamViec" />
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-time">Chọn thời gian</span>
								</span>
							</div>
						</div>

						<div class="form-group col-sm-4">
							<label>Thời gian kết thúc làm việc</label>
							<div class='input-group date' id='dateout'>
								<form:input value="05:00 PM" type='text' class="form-control"
									path="thoiGianKetThucLamViec" />
								<span class="input-group-addon"> <span
									class="glyphicon glyphicon-time">Chọn thời gian</span>
								</span>
							</div>
						</div>
						<div class="form-group col-sm-6">
							<label>Hình thức trả lương: </label><br> Tiền mặt
							<form:radiobutton path="hinhThucTraLuong" value="1" />
							Ngân hàng
							<form:radiobutton path="hinhThucTraLuong" value="2" />
						</div>
						<div class="form-group col-sm-12">


							<td><input class="btn btn-primary" type="submit"
								value="Thêm" /></td>
								<p style="color: red">${attenion}</p>
							<td><a
								href="/FBMS/thongTinHopDong/${thongTinNhanVien.maNhanVien}"
								class="btn btn-secondary">Quay lại</a></td>

						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker3').datetimepicker({
			format : 'LT'
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$('#dateout').datetimepicker({
			format : 'LT'
		});
	});
</script>
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

