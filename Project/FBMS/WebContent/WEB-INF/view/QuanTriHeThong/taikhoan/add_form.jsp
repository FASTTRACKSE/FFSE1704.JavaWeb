<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới tài khoản</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/tai-khoan/" />'>Danh sách tài khoản</a></li>
							<li class="breadcrumb-item active">Thêm mới tài khoản</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<c:url var="post_url"  value="/tai-khoan/them-moi/luu" />
					<form:form method="POST" modelAttribute="taiKhoan" action="${post_url}">
						<div class="form-group col-sm-6">
						  	<label>Tên tài khoản</label>
						  	<form:input class="form-control" path="tenDangNhap" placeholder="Tên tài khoản" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã nhân viên</label>
						  	<form:input class="form-control" path="maNhanVien" placeholder="Mã nhân viên" />
						  	<%-- <select name='maNhanVien' class="form-control">
							  	<c:forEach items="${listNhanVien}" var="item">
							        <option value="${item.ma}">${item.tenChucDanh}</option>
							    </c:forEach>
						  	</select> --%>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mật khẩu</label>
						  	<form:password showPassword="true" class="form-control" path="matKhau" placeholder="Mật khẩu" />
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
