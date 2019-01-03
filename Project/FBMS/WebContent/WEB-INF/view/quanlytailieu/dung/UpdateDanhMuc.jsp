<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<!-- code here -->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					Danh Mục
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/home">Home</a></li>
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/quanlytailieu/MyDocumentPendingApprove">Danh Mục</a></li>
							<li class="breadcrumb-item active">Update Danh Mục</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1>
				Update Danh Mục
			</h1>
			<a href="<%=request.getContextPath()%>/quanlytailieu/MyDocumentPendingApprove">Back</a>
		</div>
		<!-- ================-- form nhập dữ liệu --====================== -->

		<form:form action="" method="POST" modelAttribute="danhmucUpdate" 
			enctype="multipart/form-data"
			class="form form-horizontal striped-rows form-bordered">

			<div class="form-body">
				<!-- ///////////////////// -->
					<form:hidden path="id" class="form-control" id="projectinput5"
						value="${danhmuc.id}" />
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
						Mã Danh Mục
					</label>
					<div class="col-md-9">
						<form:input path="maDanhMuc" class="form-control"
							id="projectinput5" value="${danhmuc.maDanhMuc}" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
						Tên Danh Mục
					</label>
					<div class="col-md-9">
						<form:input path="tenDanhMuc" class="form-control"
							id="projectinput5" value="${danhmuc.tenDanhMuc}" />
					</div>
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
						Phòng Ban
					</label>
					<div class="col-md-9">
						<form:select path="maPhongBan.maPhongBan">
							<c:forEach var="PhongBan" items="${listQuyen}">
								<form:option value="${PhongBan.maPhongBan}"
									label="${PhongBan.tenPhongBan}" />
							</c:forEach>
						</form:select>
					</div>
				</div>
					<div class="form-group col-sm-6">

				<div class="form-actions">
					<button formaction="<%=request.getContextPath()%>/quanlytailieu/updateDanhMuc"
						class="btn btn-success mr-1">
						Update
					</button>
					<a href="<%=request.getContextPath()%>/quanlytailieu/danhmuc"
						class="btn btn-danger mr-1"> Cancel</a>
				</div>
			</div>
			</div>
		</form:form>
		<!-- ============= kết thúc nhập form dữ liệu ở đây =============  -->
	</div>
</div>
<!-- code here end  -->


