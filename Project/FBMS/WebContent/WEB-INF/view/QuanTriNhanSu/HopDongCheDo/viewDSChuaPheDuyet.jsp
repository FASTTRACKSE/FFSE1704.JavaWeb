
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách nhân sự</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Danh sách nhân sự cần phê duyệt hợp đồng</li>
						</ol>
					</div>
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
							<h4 class="card-title">
								<a style="color: red">Danh sách nhân sự có hợp đồng đang đợi duyệt</a>
							</h4>
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
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>
												<th>Mã nhân viên</th>
												<th>Họ tên</th>
												<th>Ngày sinh</th>
												<th>Ảnh đại diện</th>
												<th>Trạng thái</th>
												<th>Xem</th>
											</tr>
										</thead>
										<c:forEach var="ns" items="${listHDPD}">
											<tr>
												<td>${ns.maNhanVien}</td>
												<td>${ns.nhanSuFindByHD.hoLot} ${ns.nhanSuFindByHD.ten}</td>
												<td>
												<fmt:formatDate value="${ns.nhanSuFindByHD.namSinh}"
														pattern="dd-MM-yyyy" />
												</td>
												<td><img style="width: 70px;hight=70px;"
													src="<c:url value="/uploads/${ns.nhanSuFindByHD.anhDaiDien}"/>"></td>



												<td><c:choose>
														<c:when test="${ns.nhanSuFindByHD.idTrangThai == 1}">
						    Còn Làm
						  </c:when>
														<c:when test="${ns.nhanSuFindByHD.idTrangThai == 2}">
						   Nghỉ
						  </c:when>
														<c:otherwise>
						  ...
						  </c:otherwise>
													</c:choose></td>


												<td><a href="/FBMS/thongTinChiTietHopDongPheDuyet/${ns.maNhanVien}&${ns.id}"
													class="btn btn-success">Xem hợp đồng</a></td>

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