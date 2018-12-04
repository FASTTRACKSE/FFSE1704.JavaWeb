<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa chức danh</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh sách chức danh</a></li>
							<li class="breadcrumb-item active">Sửa chức danh</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
				<c:url var="post_url" value="/quanlyvangnghi/khoann/sua/luu" />
					<form:form method="POST" modelAttribute="suaDon"
						action="${post_url}">
						<form:input type="hidden" path="maNhanVien" style="display:none" value="${DonNghiPhepKhoann.maNhanVien}"/>
						
						<div class="form-group col-sm-6">
						  	<label>Thời Gian Bắt Đầu</label>
						  	<form:input type="date" class="form-control" path="tgBatDau" value="${DonNghiPhepKhoann.tgBatDau}" placeholder="Thời Gian Bắt Đầu" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời Gian Kết Thúc</label>
						  	<form:input type="date" class="form-control" path="tgKetThuc" value="${DonNghiPhepKhoann.tgKetThuc}" placeholder="Thời Gian Kết Thúc" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Số Ngày Nghỉ</label>
						  	<form:input class="form-control" path="soNgayNghi" value="${DonNghiPhepKhoann.soNgayNghi}" placeholder="Số Ngày Nghỉ" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Loại Ngày Nghỉ</label>
						  	<form:input class="form-control" path="loaihinhentity" value="${DonNghiPhepKhoann.loaihinhentity.tenNghiPhep}" placeholder="Loại Ngày Nghỉ" />
						</div>
						<div class="form-group col-sm-6">
						  	<form:input type="hidden" path="trangThai" style="display:none" value="${DonNghiPhepKhoann.trangThai}"/>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
