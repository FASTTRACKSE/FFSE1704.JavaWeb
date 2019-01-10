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
							<spring:message code="tailieu.them"/> <spring:message code="tailieu.danhMuc"/>				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/home"><spring:message code="tailieu.home"/></a></li>
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/quanlytailieu/MyDocumentPendingApprove"><spring:message code="tailieu.danhMuc"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="tailieu.them"/> <spring:message code="tailieu.danhMuc"/></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1>
				<spring:message code="tailieu.them"/> <spring:message code="tailieu.danhMuc"/>
			</h1>
		</div>
		<!-- ================-- form nhập dữ liệu --====================== -->

		<form:form action="" method="POST" modelAttribute="danhmuc" 
			enctype="multipart/form-data"
			class="form form-horizontal striped-rows form-bordered">

			<div class="form-body">
				<!-- ///////////////////// -->
					<form:hidden path="id" class="form-control" id="projectinput5"
						value="${danhmuc.id}" />
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
				<spring:message code="tailieu.ma"/> <spring:message code="tailieu.danhMuc"/>
					</label>
					<div class="col-md-9">
						<form:input path="maDanhMuc" class="form-control"
							id="projectinput5" value="${danhmuc.maDanhMuc}" />
					</div>
				</div>
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
				<spring:message code="tailieu.danhMuc"/> <spring:message code="tailieu.ten"/>
					</label>
					<div class="col-md-9">
						<form:input path="tenDanhMuc" class="form-control"
							id="projectinput5" value="${danhmuc.tenDanhMuc}" />
					</div>
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
							<spring:message code="tailieu.phongBan"/>					
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
					<fieldset class="form-group">
									<label for="basicInputFile"><spring:message code="tailieu.hinhAnh"/></label>
									<input type="file" class="form-control-file"
										id="basicInputFile" name="file">
								</fieldset>
				<div class="form-actions">
					<button formaction="<%=request.getContextPath()%>/quanlytailieu/addDanhMuc"
						class="btn btn-success mr-1">
						<spring:message code="tailieu.them"/>
					</button>
					<a href="<%=request.getContextPath()%>/quanlytailieu/danhmuc"
						class="btn btn-danger mr-1"><spring:message code="tailieu.cancel"/></a>
				</div>
			</div>
			</div>
		</form:form>
		<!-- ============= kết thúc nhập form dữ liệu ở đây =============  -->
	</div>
	
</div>
<!-- code here end  -->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
