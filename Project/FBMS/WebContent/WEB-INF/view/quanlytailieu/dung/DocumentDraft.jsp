<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<!-- code here -->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="tailieu.taiLieu"/> <spring:message code="tailieu.nhap"/>		</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/home"><spring:message code="tailieu.home"/>	</a></li>
							<li class="breadcrumb-item active"><spring:message code="tailieu.taiLieu"/> <spring:message code="tailieu.nhap"/></li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right text-md-right col-md-6 col-xs-12">
				<div class="form-group">
					<button type="button" class="btn-icon btn btn-secondary btn-round">
						<i class="ft-bell"></i>
					</button>
					<button type="button" class="btn-icon btn btn-secondary btn-round">
						<i class="ft-life-buoy"></i>
					</button>
					<button type="button" class="btn-icon btn btn-secondary btn-round">
						<i class="ft-settings"></i>
					</button>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1><spring:message code="tailieu.taiLieu"/> <spring:message code="tailieu.nhap"/></h1>
		</div>

		<!-- Border color end-->
		<div class="row">
			<div class="col-xs-12">
				<div class="card">
					<div class="card-header">
						<a class="heading-elements-toggle"><i
							class="fa fa-ellipsis-v font-medium-3"></i></a>
						<div class="heading-elements">
							<ul class="list-inline mb-0">
								<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
								<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
								<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
								<li><a data-action="close"><i class="ft-x"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="card-body collapse in">
						<div class="table-responsive">
							<table class="table mb-0" id="table_id" >
								<thead>
									<tr class="border-bottom-active border-custom-color">
										<th><spring:message code="tailieu.id"/></th>
										<th><spring:message code="tailieu.ten"/></th>
										<th><spring:message code="tailieu.moTa"/></th>
										<th><spring:message code="tailieu.danhMuc"/></th>
										<th><spring:message code="tailieu.phongBan"/></th>
										<th><spring:message code="tailieu.phuongThuc"/></th>
										<th><spring:message code="tailieu.download"/></th>
									</tr>
								</thead>
								<tbody>
										<c:forEach var="document" items="${listDocumentDraft}" varStatus="stt">
											<tr class="border-bottom-success border-custom-color">
												<td>${stt.count}</td>
												<td><img src="<c:url value="${document.maIcon.hinhAnh}"/>" width="20" height="20"> ${document.tenTaiLieu}</td>
												<td>${document.moTa}</td>
												<td>${document.maDanhMuc.tenDanhMuc}</td>
												<td>${document.maDanhMuc.maPhongBan.tenPhongBan}</td>
												<td>
												<a href="documentDelete/${document.id}" class="btn-warning btn" role="button"><spring:message code="tailieu.delete"/></a>
												<a href="<%=request.getContextPath()%>/quanlytailieu/documentUpdateView/${document.id}" class="btn-warning btn" role="button" > <spring:message code="tailieu.update"/> </a>
												</td>
												<td><a href="<%=request.getContextPath()%>${document.linkFile}" class="btn btn-success mr-1" role="button" > <spring:message code="tailieu.download"/></a></td>
											</tr>
										</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Border color end -->
		
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
<script>
  $(function(){
    $("#table_id").dataTable();
  })
</script>
