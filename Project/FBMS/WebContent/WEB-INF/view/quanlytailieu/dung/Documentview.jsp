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
					Tài Liệu
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/index">Home</a></li>
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/index">Tài Liệu</a></li>
							<li class="breadcrumb-item active">Thêm Tài Liệu</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1>
				Thêm Tài Liệu
			</h1>
			<a href="<%=request.getContextPath()%>/index">Back</a>
		</div>
		<!-- ================-- form nhập dữ liệu --====================== -->

		<form:form action="" method="POST" modelAttribute="viewDocument"
			enctype="multipart/form-data"
			class="form form-horizontal striped-rows form-bordered">

			<div class="form-body">-
				<!-- ///////////////////// -->
				<c:if test="${not empty id}">
					<form:hidden path="id" class="form-control" id="projectinput5"
						value="${document.id}" />
				</c:if>
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
						Tên Tài Liệu
					</label>
					<div class="col-md-9">
						<form:input path="tenTaiLieu" readonly="true" class="form-control"
							id="projectinput5" value="${document.tenTaiLieu}" />
					</div>
				</div>
				<!-- //////////////////// -->
				<div class="form-group row">
						<form:hidden path="maDanhMuc.maDanhMuc" 
								 value="${DanhMuc.maDanhMuc}"   
									/>						
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
						Mô Tả
					</label>
					<div class="col-md-9">
						<form:textarea path="moTa"  readonly="true" class="form-control"
							id="basicTextarea" />					
					</div>
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">				
						<form:hidden path="maPhongBan.maPhongBan"/>	
						<form:hidden path= "nameFile" class= "form-control" />
				<form:hidden path="maIcon.maIcon" class = "form-control"/>
				<form:hidden path="maTrangThai.maTrangThai" class="form-control" />													
				</div>
				<!-- ///////////////////// -->

				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
						Nhắc Nhở
					</label>
					<div class="col-md-9">
						<form:input path="ghiChu" class="form-control"
							id="projectinput5" value="${document.ghiChu}" />
					</div>
				</div>
				<div class="form-actions">
					<button formaction="<%=request.getContextPath()%>/quanlytailieu/documentAccept"
						class="btn btn-success mr-1">
						Chấp nhận
					</button>
					<button formaction="<%=request.getContextPath()%>/quanlytailieu/documentRefuse/${document.id}"
						class="btn btn-success mr-1">
						Từ Chối
					</button>
					<a href="<%=request.getContextPath()%>/quanlytailieu/index"
						class="btn btn-danger mr-1"> Cancel</a>
				</div>
			</div>
		</form:form>
		<!-- ============= kết thúc nhập form dữ liệu ở đây =============  -->
	</div>
</div>
<!-- code here end  -->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
