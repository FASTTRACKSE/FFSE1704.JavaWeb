<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<!-- code here -->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					 Tài Liệu
					<h3>
						<div class="row breadcrumbs-top">
							<div class="breadcrumb-wrapper col-xs-12">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a
										href="/FBMS/quanlytailieu/">Home</a></li>
									<li class="breadcrumb-item active">Tài Liệu</li>
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
			<h1>Tài Liệu</h1>
			<a href="/FBMS/add/">Thêm</a>
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
							<table class="table mb-0" id="table_id">
								<thead>
									<tr class="border-bottom-active border-custom-color">
										<th>ID</th>
										<th>Tên Tài Liệu</th>
										<th>Mô Tả</th>
										<th>Danh Mục</th>
										<th>Trạng Thái</th>
										<th>Phòng Ban</th>
										<th>Chức Năng</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="sv" items="${list}">
										<tr>
											<td>${sv.id}</td>
											<td>${sv.tenTaiLieu}</td>
											<td>${sv.moTa}</td>
											<td>${sv.maDanhMuc.tenDanhMuc}</td>
											<td>${sv.maTrangThai.tenTrangThai}</td>
											<td>${sv.phongBan.tenPhongBan}</td>


											<td><a
												href="/FBMS/edit/${sv.id}"
												data-toggle="tooltip" title="edit">
													<button type="button"
														class="btn btn-icon btn-outline-warning">
														<i class="fa fa-pencil"></i>
													</button>
											</a> <a
												href="/FBMS/delete/${sv.id}">
													<button type="button"
														onclick="if (!confirm('Are you sure you want to delete this database?')) return false"
														class="btn btn-outline-danger btn-icon checkid"
														data-toggle="modal" title="delete" data-target="#danger">
														<i class="fa fa-trash-o"></i>
													</button>
											</a></td>
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
	$(function() {
		$("#table_id").dataTable();
	})
</script>
