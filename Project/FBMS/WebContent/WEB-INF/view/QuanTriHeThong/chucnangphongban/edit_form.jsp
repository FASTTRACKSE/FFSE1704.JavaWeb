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
				<h3 class="content-header-title mb-0">Sửa chức năng phòng ban</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/chuc-nang-phong-ban/" />'>Danh sách chức năng phòng ban</a></li>
							<li class="breadcrumb-item active">Sửa chức năng phòng ban</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<c:url var="post_url" value="/chuc-nang-phong-ban/sua/luu" />
					<form:form method="POST" modelAttribute="chucNangPhongBan"
						action="${post_url}">
						<form:input type="hidden" path="id" style="display:none"
							value="${chucNangPhongBan.id}" />
						<div class="form-group col-sm-6">
							<label>Mã phòng ban</label> <select name='maPhongBan'
								class="form-control">
								<c:forEach items="${listPhongBan}" var="item">
									<option value="${item.maPhongBan}"
										<c:if test="${item.maPhongBan == chucNangPhongBan.maPhongBan}">selected="selected"</c:if>>${item.tenPhongBan}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-sm-6">
							<label>Mã chức danh</label> <select name='maChucDanh'
								class="form-control">
								<c:forEach items="${listChucDanh}" var="item">
									<option value="${item.maChucDanh}"
										<c:if test="${item.maChucDanh == chucNangPhongBan.maChucDanh}">selected="selected"</c:if>>${item.tenChucDanh}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-sm-6">
							<label>Mã chức năng</label> <select name='maChucNang'
								class="form-control">
								<c:forEach items="${listChucNang}" var="item">
									<option value="${item.ma_chuc_nang}" <c:if test="${item.ma_chuc_nang == chucNangPhongBan.maChucNang}">selected="selected"</c:if>>${item.ten_chuc_nang}</option>
								</c:forEach>
							</select>
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
