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
				<h3 class="content-header-title mb-0">Sửa công việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									sách công việc </a></li>
							<li class="breadcrumb-item active">Sửa công việc</li>
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
						<form:input type="hidden" path="id" style="display:none"
							value="${congViec.id}" />
						<div class="form-group col-sm-6">
							<label>Mã dự án</label>
							<form:select path="duAnKhanhCN.maDAn" items="${maDuAn}"
								itemValue="maDAn" itemLabel="tenDuAn" class="form-control" />

						</div>
						<div class="form-group col-sm-6">
							<label>Mã loại CV</label>
							<form:select path="loaiCongViec.maLoaiCongViec"
								items="${maLoaiCongViec}" itemValue="maLoaiCongViec"
								itemLabel="loaiCongViec" class="form-control" />
						</div>

						<div class="form-group col-sm-6">
							<label>Tên công việc</label>
							<form:input class="form-control" path="tenCongViec"
								value="${congViec.tenCongViec}" placeholder="Tên công việc" />
						</div>

						<div class="form-group col-sm-6">
							<label>Mô tả</label>
							<form:input class="form-control" path="moTa"
								value="${congViec.moTa}" placeholder="Mô tả" />
						</div>

						<div class="form-group col-sm-6">
							<label>TG bắt đầu</label>
							<form:input class="form-control" path="thoiGianBatDau"
								value="${congViec.thoiGianBatDau}" placeholder="TG bắt đầu" />
						</div>

						<div class="form-group col-sm-6">
							<label>TG kết thúc</label>
							<form:input class="form-control" path="thoiGianKetThuc"
								value="${congViec.thoiGianKetThuc}" placeholder="TG kết thúc" />
						</div>

						<div class="form-group col-sm-6">
							<label>Người được PC</label>
							<form:select path="nhanVienKhanhCN.maNhanVien"
								items="${nhanVien}" itemValue="maNhanVien" itemLabel="hoDem"
								class="form-control" />
						</div>

						<div class="form-group col-sm-6">
							<label>TG dự kiến HT</label>
							<form:input class="form-control" path="thoiGianDuKienHoanThanh"
								value="${congViec.thoiGianDuKienHoanThanh}"
								placeholder="TG dự kiến HT" />
						</div>
						
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:select path="trangThai"
								items="${trangThai}" itemValue="maTrangThai"
								itemLabel="tenTrangThai" class="form-control" />
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
