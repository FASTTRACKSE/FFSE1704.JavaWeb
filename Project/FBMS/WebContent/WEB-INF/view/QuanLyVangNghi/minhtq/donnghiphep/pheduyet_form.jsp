<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="" />'>sửa
									đơn nghỉ phép </a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="pheduyetdon"
						action="/FBMS/QuanLyVangNghi/minhtq/pheDuyetDon">
						<div class="form-group col-sm-6">
							<label>id</label>
							<form:input class="form-control" path="id" readonly="true" />

						</div>

						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien"
								readonly="true" />

						</div>

						<div class="form-group col-md-6">
							<label for="location1">Phòng ban</label>
							<form:select path="maPhongBan" class="custom-select form-control"
								id="location1" name="location" items="${phongban}"
								itemValue="maPhongBan" itemLabel="tenPhongBan" readonly="true">

							</form:select>

						</div>
						<div class="form-group col-md-6">
							<label for="location1">Loại ngày nghỉ </label>
							<form:select path="loaiNgayNghi"
								class="custom-select form-control" id="location1"
								name="location" items="${countryList}" itemValue="maNgayNghi"
								itemLabel="tenLoaiNgayNghi" readonly="true">

							</form:select>

						</div>



						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu </label>
							<form:input class="form-control" path="thoiGianBatDau"
								readonly="true" />


						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian kết thúc </label>
							<form:input class="form-control" path="thoiGianKetThuc"
								readonly="true" />

						</div>


						<div class="form-group col-sm-6">
							<label>Số ngày nghỉ</label>
							<form:input type="text" class="form-control" readonly="true"
								path="soLuong" />

						</div>

						<div class="form-group col-sm-12">
							<label>ghi chú</label>
							<form:textarea rows="5" cols="63" type="text"
								class="form-control" path="ghiChu" />

						</div>


						<div class="row">
							<div class="col-md-12" style="padding-left: 3%;">
								<button type="submit"
									class="btn btn-outline-success round  mr-1 mb-1"
									value="duyetdon" name="action">Phê duyệt</button>

								<button type="submit"
									class="btn btn-outline-success round  mr-1 mb-1" value="tuchoi"
									name="action">Từ Chối</button>

							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
