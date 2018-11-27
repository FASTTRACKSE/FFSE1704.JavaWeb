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
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách tài khoản</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách tài khoản</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<!-- Form search -->
			<div class="row mb-2">
				<form class="col-xs-12" action='<c:url value="/tai-khoan/"></c:url>'
					method="get" enctype="multipart/form-data">
					<!-- <div class="frm-search-box form-inline pull-left">
						<label class="mr-sm-2" for="">Từ khóa: </label> <input
							class="form-control" type="text" value="" name="q"
							id="txtkeyword" placeholder="Keyword">&nbsp;
						<button type="submit" id="button" class="btn btn-success">Tìm
							kiếm</button>
					</div> -->
					<div class="pull-right">
						<a href="<c:url value="/tai-khoan/them-moi"></c:url>"
							class="btn btn-success button"><i class="fa fa-plus"
							aria-hidden="true"></i> Thêm mới</a>
					</div>
				</form>
			</div>
			<!-- End Form search -->

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
							<h4 class="card-title">Danh sách tài khoản</h4>
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
								<table class="table mb-0">
									<thead class="bg-success">
										<tr>
											<th>STT</th>
											<th>Tên đăng nhập</th>
											<!-- <th>Reset password</th> -->
											<th>Trạng thái</th>
											<th>Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty listTaiKhoan}">
											<c:forEach var="item" items="${listTaiKhoan}" begin="0"
												varStatus="counter">
												<tr>
													<td>${counter.index + 1}</td>
													<td>${item.tenDangNhap}</td>
													<%-- <td class="tbl_actions"><a
														href="<c:url value="/tai-khoan/resetPassword/${item.tenDangNhap}" />"
														title="Reset Password"> <i class="fa fa-check green" aria-hidden="true"></i>Reset password
													</a></td> --%>
													<td class="tbl_actions"><a
														href="<c:url value="/tai-khoan/kich-hoat/${item.tenDangNhap}" />"
														title="Hiển thị"> <c:choose>
																<c:when test="${item.trangThai == 1}">
																	<i class="fa fa-check green" aria-hidden="true"></i>Hiển thị
																</c:when>
																<c:otherwise>
																	<i class="fa fa-times red" aria-hidden="true"></i>Ẩn
																</c:otherwise>
															</c:choose>
													</a></td>
													<td class="tbl_actions"><a
														href="<c:url value="/tai-khoan/xoa/${item.tenDangNhap}" />"
														title="Xóa"
														onclick="return confirm('Bạn có chắc muốn xóa ?')"> <i
															class="fa fa-trash red" aria-hidden="true"></i>Delete
													</a></td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>

								<nav aria-label="Page navigation example">
									<ul class="pagination">
										<li class="page-item"><a class="page-link" href="?page=1">First
												Page</a></li>
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
											href="?page=${lastPage }">Last Page</a></li>
									</ul>
								</nav>
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
