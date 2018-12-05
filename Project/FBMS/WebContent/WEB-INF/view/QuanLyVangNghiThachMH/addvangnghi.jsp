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
				<h3 class="content-header-title mb-0">Vắng Nghỉ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyVangNghi512/list/" />'>Vắng Nghỉ</a></li>
							<li class="breadcrumb-item active">Vắng Nghỉ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="donXinNghiPhep"
						action="doadd">
						<div class="form-group col-sm-6">
							<label>Tên nhân viên</label>
							<form:input class="form-control" path="tenNhanVien"
								placeholder="Tên nhân viên " />
						</div>
						<div class="form-group col-sm-6">
							<label>Phòng ban</label>
							<form:input class="form-control" path="phongBan"
								placeholder="Phòng ban " />
						</div>
						<div class="form-group col-sm-6">
							<label>Lý do</label>
							<form:input class="form-control" path="maNghiPhep"
								placeholder="Lý do " />
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày bắt đầu</label>
							<form:input path="thoiGianBatDau" cssClass="form-control"
								type="date" />
							<div class="help-block"></div>
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày kết thúc</label>
							<form:input path="thoiGianKetThuc" cssClass="form-control"
								type="date" />
							<div class="help-block"></div>
						</div>
						<div class="form-group col-sm-6">
							<label>Ghi chú</label>
							<form:input class="form-control" path="ghiChu"
								placeholder="Ghi chú " />
						</div>
						<div class="form-group col-sm-6">
							<label>Tình trạng</label>
							<form:input class="form-control" path="tinhTrang"
								placeholder="Tình trạng " />
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:input class="form-control" path="maTrangThai"
								placeholder="Trạng thái " />
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

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
