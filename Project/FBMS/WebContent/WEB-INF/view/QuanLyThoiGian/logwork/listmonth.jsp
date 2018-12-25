<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 8px;
	border-radius: 4px;
	width:100px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}
.card-header{
    margin-bottom: -35px;
}
.dropdown-content {
	display : none;
	padding: 8px;
	position: absolute;
	background-color: #17a2b8;
	border-radius:0px 25px 25px 0px;
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
							<li class="breadcrumb-item active">Danh sách Logwork Theo
								Tháng</li>
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

						<div class="card-header">
							<div class="dropdown">
								<button class="dropbtn">Tháng ${month}</button>
								<div class="dropdown-content">
									<c:forEach var="i" begin="1" end="12">
										<a
											href="http://localhost:8080/FBMS/QuanLyThoiGian/Logwork/listMonth/${i}"><c:out
												value="${i}" /></a>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>
												<th scope="col">ID</th>
												<th scope="col">Dự Án</th>
												<th scope="col">Tên Nhân Viên</th>
												<th scope="col">Vai Trò</th>
												<th scope="col">Phòng Ban</th>
												<th scope="col">Công Việc</th>
												<th scope="col">Trạng Thái</th>
												<th scope="col">Action</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="lg" items="${listMonth}">
												<tr>
													<td>${lg.id}</td>
													<td>${lg.maDuAn.tenDuAn}</td>
													<td>${lg.maNhanVien.hoDem}${lg.maNhanVien.ten}</td>
													<td>${lg.maVaiTroDuAn.tenVaiTro}</td>
													<td>${lg.maPhongBan.tenPhongBan}</td>
													<td>${lg.tenCongViec}</td>
													<td>${lg.trangThaiLogwork.tenTrangThai}</td>
													<td><a
														href="/FBMS/QuanLyThoiGian/Logwork/view/${lg.id }"><i
															class="fa fa-eye"></i></a> <c:if
															test="${lg.trangThaiLogwork.maTrangThai != 2 }">
															<a href="edit/${lg.id }"><i class="fa fa-pencil"></i></a>
														</c:if> <c:if test="${lg.trangThaiLogwork.maTrangThai == 4 }">
															<a href="delete/${lg.id }"
																onclick="return confirm('Bạn có muốn xóa sinh viên này?');"><i
																class="fa fa-trash"></i></a>
														</c:if></td>
												</tr>
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
															<h4 class="modal-title" id="myModalLabel">Bạn có
																chắc muốn xóa</h4>
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
						<div class="card-header">
							<nav aria-label="Page navigation example">
								<ul class="pagination">
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
								</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	window.onload = function() {
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});

		$('#datatable').dataTable().fnDestroy();

		$("#datatable").dataTable({
			responsive : true,
			"order" : [ [ 1, "asc" ], [ 0, "desc" ] ],
			"bServerSide" : true,
			"sAjaxSource" : "/FBMS/QuanLyThoiGian/Logwork/list",
		});
	};

	window.setTimeout(function() {
		$(".alert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2500);
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />