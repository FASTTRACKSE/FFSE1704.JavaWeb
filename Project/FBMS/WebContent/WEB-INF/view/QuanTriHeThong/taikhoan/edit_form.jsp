<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa tài khoản</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/tai-khoan/" />'>Danh sách tài khoản</a></li>
							<li class="breadcrumb-item active">Sửa tài khoản</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<c:url var="post_url"  value="/tai-khoan/sua/luu" />
					<form:form method="POST" modelAttribute="taiKhoan" action="${post_url}">
						<form:input type="hidden" path="maNhanVien" value="${taiKhoan.maNhanVien}"/>
						<form:input type="hidden" path="trangThai" value="${taiKhoan.trangThai}"/>
						<div class="form-group col-sm-6">
						  	<label>Tên tài khoản</label>
						  	<form:input class="form-control" path="ten_chuc_nang" value="${taiKhoan.maNhanVien}" />
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
