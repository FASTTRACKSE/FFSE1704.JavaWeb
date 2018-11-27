<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa chức năng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/chuc_nang/view/danhSachChucNang" />'>Danh sách chức năng</a></li>
							<li class="breadcrumb-item active">Sửa chức năng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="chucNang" action="">
						<form:input type="hidden" path="ma_chuc_nang" value="${chucNang.ma_chuc_nang}"/>
						<form:input type="hidden" path="trang_thai" value="${chucNang.trang_thai}"/>
						<div class="form-group col-sm-6">
						  	<label>Tên chức năng </label><small> (Ghi chữ in hoa, bắt đầu bằng ROLE_ + tên phòng ban + tên chức danh)</small>
						  	<form:input class="form-control" path="ten_chuc_nang" value="${chucNang.ten_chuc_nang}" placeholder="Tên chức năng" />
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
