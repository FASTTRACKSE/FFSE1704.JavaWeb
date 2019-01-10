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
					<spring:message code="tailieu.taiLieu"/>
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/home"><spring:message code="tailieu.home"/></a></li>
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/quanlytailieu/pendingApprove"><spring:message code="tailieu.pheDuyetTaiLieu"/></a></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1>
				<spring:message code="tailieu.pheDuyetTaiLieu"/>
			</h1>
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
						<spring:message code="tailieu.ten"/> <spring:message code="tailieu.taiLieu"/>
					</label>
					<div class="col-md-9">
						<form:input path="tenTaiLieu" readonly="true" class="form-control"
							id="projectinput5" value="${document.tenTaiLieu}" />
					</div>
				</div>
				<!-- //////////////////// -->
				<div class="form-group row">
						<form:hidden path="maDanhMuc.maDanhMuc"/>						
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
						<spring:message code="tailieu.moTa"/>
					</label>
					<div class="col-md-9">
						<form:textarea path="moTa"  readonly="true" class="form-control"
							id="basicTextarea" />					
					</div>
				</div>
				<!-- ///////////////////// -->
				<div class="form-group row">				
						<form:hidden path= "nameFile" class= "form-control" />
						<form:hidden path= "linkFile" class= "form-control" />					
				<form:hidden path="maIcon.maIcon" class = "form-control"/>
				<form:hidden path="maTrangThai.maTrangThai" class="form-control" />													
				</div>
				<!-- ///////////////////// -->

				<!-- ///////////////////// -->
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput5">
						<spring:message code="tailieu.ghiChu"/>
					</label>
					<div class="col-md-9">
						<form:input path="ghiChu" class="form-control"
							id="projectinput5" value="${document.ghiChu}" />
					</div>
				<div class="form-group row">
					<label class="col-md-3 label-control" for="projectinput6">
						<spring:message code="tailieu.taiLieu"/>
					</label>
						<td><img src="<c:url value="${viewDocument.maIcon.hinhAnh}"/>" width="50" height="50"></td>
						<td>${viewDocument.nameFile}</td>
				</div>
				</div>
				<div class="form-actions">
					<button formaction="<%=request.getContextPath()%>/quanlytailieu/documentAccept"
						class="btn btn-success mr-1">
						<spring:message code="tailieu.chapThuan"/>
					</button>
					<button formaction="<%=request.getContextPath()%>/quanlytailieu/documentRefuse/${document.id}"
						class="btn btn-success mr-1">
						<spring:message code="tailieu.tuChoi"/>
					</button>
					<a href="<%=request.getContextPath()%>/quanlytailieu/index"
						class="btn btn-danger mr-1"> <spring:message code="tailieu.cancel"/></a>
				</div>
			</div>
		</form:form>
		<!-- ============= kết thúc nhập form dữ liệu ở đây =============  -->
	</div>
</div>
<!-- code here end  -->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
