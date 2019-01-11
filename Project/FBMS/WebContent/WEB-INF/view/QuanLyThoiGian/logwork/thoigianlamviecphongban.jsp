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
							<h4 class="card-title">BÁO CÁO THỜI GIAN LÀM VIỆC PHÒNG BAN</h4>
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
						<form action="">
						<div class="form-group col-sm-2">
							<select class="form-control" name="month" id="month">
								<c:forEach var="i" begin="1" end="12">
									<option value="${i}">Tháng ${i}</option>
								</c:forEach>

							</select>
						</div>
						<div class="form-group col-sm-2">
							<select class="form-control" name="year" id="year">
								<c:forEach var="i" begin="2013" end="2023">
									<option value="${i}">Năm ${i}</option>
								</c:forEach>

							</select>
						</div>
						<div class="form-group col-sm-2">
							<button type="submit" name="action" value="xem"
								class="btn btn-success">Xem</button>
						</div>
						</form>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>
												<th scope="col">Phòng</th>
												<th scope="col" style="color: red"><c:out value="${phongBan}" /></th>
												<th scope="col"></th>
												<th scope="col">Tháng</th>
												<th scope="col" style="color: red">${thang}</th>
											</tr>
											<tr>
												<th scope="col">STT</th>
												<th scope="col">Nhân viên</th>
												<th scope="col">Dự án</th>
												<th scope="col">Thời gian</th>
												<th scope="col">Thao tác</th>
											</tr>
										</thead>
										<tbody>
											<c:set var="stt" value="${0}" />
											<c:set var="nv" value="" />
											<c:forEach var="lg" items="${listDSPhongBan}">
												<c:set var="ttg" value="${lg.getKhoangTGReport()*100}" />
												<tr>
													<td><c:if test="${nv ne lg.maNhanVien.maNVien}">
															<c:out value="${stt = stt + 1}" />
														</c:if></td>
													<td><c:if test="${nv ne lg.maNhanVien.maNVien}">${lg.maNhanVien.fullName}</c:if></td>
													<td>${lg.maDuAn.tenDuAn}</td>
													<td><fmt:formatNumber type="number" pattern="#.##"
															value="${lg.getKhoangTGReport()}" /> h</td>
													<%-- <td>${lg.thoiGian}</td> --%>
													<td><a href="view/${lg.id }"><i class="fa fa-eye"></i></a></td>
												</tr>
												<c:set var="nv" value="${lg.maNhanVien.maNVien}" />
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<%-- <div class="card-header">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:if test="${lastPage > 0 }">
										<li class="page-item"><a class="page-link" href="?page=1">trang
												đầu</a></li>
										<c:if test="${currentPage > 2}">
											<li class="page-item"><a class="page-link"
												href="?page=${currentPage-2}">${currentPage-2}</a></li>
										</c:if>
										<c:if test="${currentPage > 1}">
											<li class="page-item"><a class="page-link"
												href="?page=${currentPage-1}">${currentPage-1}</a></li>
										</c:if>
										<li class="page-item active"><a class="page-link"
											href="?page=${currentPage}">${currentPage}</a></li>
										<c:if test="${currentPage < lastPage}">
											<li class="page-item"><a class="page-link"
												href="?page=${currentPage+1}">${currentPage+1}</a></li>
										</c:if>
										<c:if test="${currentPage < lastPage - 1}">
											<li class="page-item"><a class="page-link"
												href="?page=${currentPage+2}">${currentPage+2}</a></li>
										</c:if>
										<li class="page-item"><a class="page-link"
											href="?page=${lastPage }">trang cuối</a></li>
									</c:if>
								</ul>
							</nav>
						</div> --%>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />