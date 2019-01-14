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
								href='<c:url value="/QuanLyNhiemVu/cong_viec/danhsachcongviec" />'>Danh
									sách công việc</a></li>
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
					<form:form method="POST" modelAttribute="congViec" action="">


						<div class="form-group col-sm-6">
							<label>Dự án</label>
							<form:select class="form-control" path="maDuAn" id="idDuAn"
								onchange="selectNguoiDuocPC()">
								<option value="" selected="selected" disabled="disabled">Chọn
									dự án</option>
								<c:forEach items="${DuAn}" var="duan">
									<form:option value="${duan.maDAn}" label="${duan.tenDuAn}" />
								</c:forEach>
							</form:select>
						</div>

						<div class="form-group col-sm-6">
							<label>Loại công việc </label>
							<form:select path="maLoaiCongViec" class="form-control">
								<option value="" selected="selected" disabled="disabled">Chọn
									loại công việc</option>
								<c:forEach items="${LoaiCongViec}" var="congviec">
									<form:option value="${congviec.maLoaiCongViec}"
										label="${congviec.loaiCongViec}" />
								</c:forEach>
							</form:select>
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
							<form:select class="custom-select block " path="nguoiPhanCong"
								id="idNguoiDuocPC">
								<option value="" selected="selected" disabled="disabled">Chon
									người được PC</option>
							</form:select>
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

						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:select path="trangThai" items="${TrangThai}"
								itemValue="maTrangThai" itemLabel="tenTrangThai"
								class="form-control" />
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
<script type="text/javascript">
	function selectNguoiDuocPC() {
		var maDAn = $("#idDuAn").val();
		$('#idNguoiDuocPC option').remove();
		$.ajax({
			url : "/FBMS/QuanLyNhiemVu/cong_viec/selectNhanVien/" + maDAn,
			dataType : "json",
			success : function(data) {
				$('#idNguoiDuocPC').append($('<option>', {
					value : '0',
					text : 'Chọn người được phân công'
				}));
				$('#idNguoiDuocPC option[value=0]').attr('disabled', true);

				for (var i = 0; i < data.length; i++) {
					$('#idNguoiDuocPC').append($('<option>', {
						value : data[i].maNguoiDuocPhanCong,
						text : data[i].tenNguoiDuocPhanCong
					}));
				}

			}
		});
	};
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

