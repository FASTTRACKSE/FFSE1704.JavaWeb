<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="container">

		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">Xóa thông tin vai trò thành viên trong dự án</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item active">Quản lý dự án</li>
								<li class="breadcrumb-item active">Quản lý danh mục</li>
								<li class="breadcrumb-item"><a
									href='<c:url value="/Quan_Ly_Du_An/List_VaiTroThanhVien/1" />'> vai trò thành viên</a></li>
								<li class="breadcrumb-item active">Xóa thông tin vai trò thành viên trong dự án</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- End Path -->
		</div>
		<form:form method="post"
			action="/FBMS/Quan_Ly_Du_An/Submit_Delete_Domain">
			<div class="form-body">

				<div class="form-group">
					<form:hidden path="id" class="form-control" />
				</div>
				<div class="form-group">
					<label for="issueinput2">Mã Vai Trò: </label>
					<form:hidden path="maVaiTro" class="form-control" />
					<strong>${command.maVaiTro}</strong>
				</div>
				<div class="form-group">
					<label for="issueinput2">Tên Vai Trò</label>
					<form:hidden path="tenVaiTro" class="form-control" />
					<strong>${command.tenVaiTro}</strong>
				</div>

				<div class="form-group">
					<label for="issueinput2">Ghi Chú: </label>
					<form:hidden path="ghiChu" class="form-control" />
					<strong>${command.ghiChu}</strong>
				</div>

				<div class="form-actions">

					<button type="button" class="btn btn-warning mr-1">
						<i class="ft-x"></i><a
							href='<c:url value="/Quan_Ly_Du_An/List_VaiTroThanhVien/1" />'>Cancel</a>
					</button>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-check-square-o"></i> Delete
					</button>
				</div>
			</div>

		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />