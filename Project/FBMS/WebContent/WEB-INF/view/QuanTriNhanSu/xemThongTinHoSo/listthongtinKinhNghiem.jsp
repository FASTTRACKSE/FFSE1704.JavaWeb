<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">THÔNG TIN NHÂN VIÊN</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>

							<li class="breadcrumb-item"><a
								href='<c:url value="/dsphongban" />'>Danh sách nhân sự</a></li>

							<li class="breadcrumb-item active">Thông tin danh sách kinh
								nghiệm dự án</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-header-right col-md-3 col-xs-12">
				<div role="group" aria-label="Button group with nested dropdown"
					class="btn-group float-md-right" id="add-new"></div>
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
								<h4 class="card-title">Thông tin danh sách kinh nghiệm dự
									án</h4>
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
										<h1 style="text-align: center; color: green">${thongTinNhanVien.hoLot}<a>
												${thongTinNhanVien.ten}</a>
										</h1>
										<p style="text-align: center;">
											<a>Mã nhân viên:</a> ${thongTinNhanVien.maNhanVien}
										</p>
										<p style="text-align: center;">
											<a>Ngày sinh:</a> ${thongTinNhanVien.namSinh}
										</p>
										<p style="text-align: center;">
											Phòng ban:<a></a> -
											Chức vụ:<a></a>
										</p>





										<table id="datatable"
											class="table table-striped table-bordered dataex-res-constructor">
											<thead>
												<tr>
													<th scope="col">Mã dự án</th>
													<th scope="col">Tên dự án</th>
													<th scope="col">Vai trò</th>
													<th scope="col">Domain</th>
													<th scope="col">Framework</th>
													<th scope="col">Database</th>
													<th scope="col">Ngôn ngữ</th>
													<th scope="col">Mô tả</th>
													<th scope="col">Trạng thái</th>
												</tr>
											</thead>

											<c:forEach var="hopDong"
												items="${thongTinNhanVien.listPhanCongNhiemVuNS}">
												<tr>
													<td>${hopDong.thongTinDuAn.maDuAn}</td>
													<td>${hopDong.thongTinDuAn.tenDuAn}</td>
													<td>${hopDong.vaiTro.tenVaiTro}</td>
													<td>${hopDong.thongTinDuAn.domainNS.tenDomain}</td>
													<td>${hopDong.thongTinDuAn.frameWorkNS.tenFramework}</td>
													<td>${hopDong.thongTinDuAn.databaseNS.tenDatabase}</td>
													<td>${hopDong.thongTinDuAn.programmingLaguageNS.tenProgrammingLanguage}</td>
													<td>${hopDong.thongTinDuAn.moTa}</td>
													<td>${hopDong.thongTinDuAn.trangThaiDuAnNS.tenTrangThai}</td>
												</tr>
											</c:forEach>
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
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />