<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.tbl_actions a {
	color: #333;
	font-size: 13px;
	display: inline-block;
	padding: 2px 5px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #FFF;
}

.tbl_actions a i {
	margin-right: 3px;
}

.green {
	color: #5cb85c;
}

.blue {
	color: #337ab7;
}

.red {
	color: #d9534f;
}

.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 8px;
	border-radius: 4px;
	width: 100px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.card-header {
	margin-bottom: -35px;
}

.dropdown-content {
	display: none;
	padding: 8px;
	position: absolute;
	background-color: #17a2b8;
	border-radius: 0px 25px 25px 0px;
	min-width: 570px;
	box-shadow: 0px 0px 0px 0px rgba(0, 0, 0, 100);
	z-index: 1;
	display: none;
	margin-left: 97px;
	margin-top: -36px;
}

.dropdown-content a {
	color: white;
	padding: 12px 16px;
	text-decoration: none;
}

.dropdown-content a:hover {
	background-color: #ffc107;
	color: black;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

#datatable tr td:last-child {
	letter-spacing: 15px;
	min-width: 100px;
	text-align: center !important;
}

#datatable>thead>tr>th:last-child[class*="sort"]::after {
	content: ""
}

#datatable>thead>tr>th:last-child[class*="sort"]::before {
	content: ""
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách Logwork</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách Logwork</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="<c:url value = "/logwork/addlogwork"/>"
						class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
						mới</a>
				</div>
			</div>


		</div>
	</div>
	<!-- End Path -->

	<div class="content-body">

		<!-- Show message -->
		<c:if test="${button ne null}">
			<div class="alert alert-success alert-dismissable" role="alert">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				${button}
			</div>
		</c:if>
		<c:if test="${messageError ne null}">
			<div class="alert alert-danger alert-dismissable" role="alert">
				<button type="button" class="close" data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				${messageError}
			</div>
		</c:if>
		<!-- End Show message -->

		<div class="row">
			<div class="col-xs-12">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách Logwork</h4>
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
						<div class="card-block card-dashboard">
							<div class="table-responsive">
								<table id="datatable"
									class="table table-striped table-bordered dataex-res-constructor">
									<thead>
										<tr>
											<th scope="col">STT</th>
											<th scope="col">Mã Nhân Viên</th>
											<th scope="col">Dự Án</th>
											<th scope="col">Thời Gian (Giờ)</th>
											<th scope="col">Chức Năng</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="currentMaNV" value="" />
										<c:set var="stt" value="${0}" />

										<c:forEach var="lg" items="${baocaologwork}">
											<tr>
												<c:set var="stt" value="${stt = stt+1}" />
												<td><c:out value="${stt}" /></td>
												<td><c:if
														test="${currentMaNV ne lg.maNhanVien.maNVien}">
													${lg.maNhanVien.fullName}
												</c:if></td>
												<td>${lg.maDuAn.tenDuAn}</td>
												<td><fmt:formatNumber value="${lg.getKhoangTGReport()}" /></td>
												<td><a
													href="/FBMS/logwork/maNV/${lg.maNhanVien.maNVien }"><button
															class="btn btn-success">Chi Tiết</button></a></td>
											</tr>
											<c:set var="currentMaNV" value="${lg.maNhanVien.maNVien}" />
										</c:forEach>

									</tbody>
									<tbody>
										<div class="modal fade" id="confirm-delete" tabindex="-1"
											role="dialog" aria-labelledby="myModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">

													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title" id="myModalLabel">Bạn có chắc
															muốn xóa</h4>
													</div>

													<div class="modal-body">
														<p>Bạn có chắc muốn xóa</p>
														<p class="debug-url"></p>
													</div>

													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">Quay lại</button>
														<a class="btn btn-danger btn-ok">Xóa</a>
													</div>
												</div>
											</div>
										</div>
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />