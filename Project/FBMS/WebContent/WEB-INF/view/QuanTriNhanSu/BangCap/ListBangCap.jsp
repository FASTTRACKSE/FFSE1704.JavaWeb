
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
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Bằng Cấp</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Quản lý bằng cấp</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a href="/FBMS/addBC/${bangCap.maNhanVien}"> <span class="fa fa-plus"></span> Thêm mới
					</a>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">

			<!-- Show message -->
			<c:if test="${messageSuccess ne null}">
				<div class="alert alert-success alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSuccess}
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
							<h4 class="card-title">Danh sach bằng cấp</h4>
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
						<p style="text-align: center ;color:red">Mã nhân viên:</p>
						<p style="text-align: center">${bangCap.maNhanVien}</p>
						<p style="text-align: center ;color:red">Tên nhân viên:</p>
						<p style="text-align: center">${bangCap.hoLot} ${bangCap.ten}</p>
						
						
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>

												<th>Thứ tự</th>
												
												<th>Trình độ</th>
												<th>Tên Ngành</th>
												<th>Thời gian</th>
												<th>Xếp loại</th>
												<th>Nơi cấp</th>
												<th>Chức Năng</th>
											</tr>
										</thead>
										
										<c:forEach var="bc" items="${bangCap.listBangCap}">
											<tr>
												<td>${bc.id}</td>
												
											 <td>${bc.trinhDo.tenTrinhDo}</td> 
												<td>${bc.tenNganh}</td>
												<td>${bc.thoiGian}</td>
												<td>${bc.xepLoai}</td>
												<td>${bc.noiCap}</td>
	
												<td><a href="/FBMS/editBC/${bc.id}&${bangCap.maNhanVien}"><button>sửa</button></a>

													<a href="DeleteBC/${bc.id}"><button>Xoa</button></a></td>

											</tr>
										</c:forEach>
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
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container" style="float: right">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${page > 1 }">
					<li class="page-item"><a class="page-link" href="1">First</a></li>
					<li class="page-item"><a class="page-link" href="${page -1 }">${page -1 }</a></li>
				</c:if>

				<li class="page-item"><a class="page-link" href="${page }">${page }</a></li>

				<c:if test="${page < totalPage}">
					<li class="page-item"><a class="page-link" href="${page +1 }">${page +1 }</a></li>
					<li class="page-item"><a class="page-link"
						href="${totalPage }">Last</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
</div>




<jsp:include page="/WEB-INF/view/templates/footer.jsp" />