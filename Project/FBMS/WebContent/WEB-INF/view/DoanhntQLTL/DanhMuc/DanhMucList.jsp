<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh Sách Danh Mục</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh Sách Danh Mục</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new">
					<a class="btn btn-primary"
						href='<c:url value = "/DoanhntQLTL/DanhMuc/add" />'>Thêm Mới<span
						data-i18n="" class="ft-plus-square"></span></a>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
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
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="card-header">
							<h4 class="card-title">Danh Sách Danh Mục</h4>
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
												<th>ID</th>
												<th>Mã Danh Mục</th>
												<th>Tên Danh Mục</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<c:if test="${not empty ListDanhMuc}">
												<c:forEach var="item" items="${ListDanhMuc}" begin="0"
													varStatus="counter">
													<tr>
														<td>${counter.index+1}</td>
														<td>${item.maDM}</td>
														<td>${item.tenDM}</td>
														<td class="tbl_actions"><a
															href="<c:url value="/DoanhntQLTL/DanhMuc/view/${item.maDM}" />"
															title="Xem"> <i class="fa fa-eye" aria-hidden="true"></i>
														</a> <a
															href="<c:url value="/DoanhntQLTL/DanhMuc/sua/${item.maDM}" />"
															title="Sửa"> <i class="fa fa-pencil-square-o blue"
																aria-hidden="true"></i>
														</a> <a
															href="<c:url value="/DoanhntQLTL/DanhMuc/xoa/${item.maDM}" />"
															title="Xóa"
															onclick="return confirm('Bạn có chắc muốn xóa ?')"> <i
																class="fa fa-trash red" aria-hidden="true"></i>
														</a></td>
													</tr>
												</c:forEach>
											</c:if>
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
</div>
<script type="text/javascript">
	window.setTimeout(function() {
		$(".alert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2500);
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />