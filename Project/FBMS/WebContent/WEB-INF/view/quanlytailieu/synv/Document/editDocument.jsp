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
				<h3 class="content-header-title mb-0">Tài Liệu</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/quanlytailieu">Home</a></li>
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/quanlytailieu">Tài Liệu</a></li>
							<li class="breadcrumb-item active">Sửa Tài Liệu</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1>Sửa Tài Liệu</h1>
			<a href="<%=request.getContextPath()%>/listDocument">Back</a>
		</div>
		<!-- ================-- form nhập dữ liệu --====================== -->

		<form:form action="" method="POST" modelAttribute="documentupdate"
			enctype="multipart/form-data"
			class="form form-horizontal striped-rows form-bordered">

			<div class="form-body">
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
						Tên Tài Liệu </label>
					<div class="col-md-9">
						<form:input path="tenTaiLieu" class="form-control"
							id="projectinput5" value="${document.tenTaiLieu}" />
					</div>
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
						Danh Mục </label>
					<div class="col-md-9">
						<form:select path="maDanhMuc.maDanhMuc">
							<c:forEach var="DanhMuc" items="${listCategory}">
								<form:option value="${DanhMuc.maDanhMuc}"
									label="${DanhMuc.tenDanhMuc}" />
							</c:forEach>
						</form:select>
					</div>
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
						Mô Tả </label>
					<div class="col-md-9">
						<form:textarea path="moTa" class="form-control" id="basicTextarea" />


					</div>
				</div>
				<!-- ///////////////////// -->



				<div class="form-actions">
					<button formaction="<%=request.getContextPath()%>/quanlytailieu"
						class="btn btn-success mr-1">Update</button>
					<a href="<%=request.getContextPath()%>/quanlytailieu"
						class="btn btn-danger mr-1"> Cancel</a>
				</div>
			</div>
		</form:form>
		<!-- ============= kết thúc nhập form dữ liệu ở đây =============  -->
	</div>
</div>
<!-- code here end  -->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
