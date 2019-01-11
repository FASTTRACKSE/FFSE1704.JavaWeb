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
				<h3 class="content-header-title mb-0">Danh sách nhân sự</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active"><a
								href='<c:url value="/QuanTriNhanSu/danhsach_nhansu" />'>Danh
									Sách Nhân Sự</a></li>
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
								Danh sách nhân sự Theo Trình Độ: <a style="color: red">${trinhdo.tenTrinhDo}</a>
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
							<%-- <div class="main-content">
								<div class="row">
									<div class="form-group col-md-12">
										<p style="text-align: center;">
											<a
												style="text-align: center; color: blue; font-size: 20px; font-family: Arial, Helvetica, sans-serif">Ảnh
												đại diện</a> </br> <img style="width: 200px;hight=150px;"
												src='<c:url value="/uploads/${dsTrinhDoId.anhDaiDien}" />'>
										</p>
									</div>
									<div class="form-group col-md-12">
										<h1 style="text-align: center; color: green">
											<p style="text-align: center">${dsTrinhDoId.hoLot}
												${dsTrinhDoId.ten}</p>
											</a>
										</h1>
										<p style="text-align: center;">
											<a style="text-align: center; color: blue">Mã nhân viên:</a>
											${dsTrinhDoId.maNhanVien}
										</p>
										<p style="text-align: center;">
											<a style="text-align: center; color: blue">Ngày sinh:</a>
											${dsTrinhDoId.namSinh}
										</p>
									</div>
								</div>
							</div> --%>
							<div class="col-md-3">
								<p>
									Option: <br> Xem theo: <a style="color: red">Phòng ban</a>
								</p>
								<form method="GET" action="/FBMS/listTTfindbyMaPhongBan"
									style="width: 150px;">

									<select class="form-control" name="dsPhongBanId">
										<option disabled="disabled">Chọn phòng ban</option>
										<c:forEach items="${dsPhongBan}" var="pb">
											<option value="${pb.maPhongBan}">${pb.tenPhongBan}</option>
										</c:forEach>
									</select> <input class="btn btn-success" type="submit" value="Xem">
								</form>
							</div>
							<div class="col-md-3">
								<p>
									<br> Xem theo: <a style="color: red">Trình độ</a>
								</p>
								<form method="GET" action="/FBMS/listBCfindbyMaBangCap"
									style="width: 150px;">
									<select class="form-control" name="dsTrinhDoId">
										<option disabled="disabled">Chọn trình độ</option>
										<c:forEach items="${dsTrinhDo}" var="td">
											<option value="${td.id}">${td.tenTrinhDo}</option>
										</c:forEach>
									</select> <input class="btn btn-success" type="submit" value="Xem">
								</form>
							</div>
							<div class="col-md-3">
								<p>
									<br> Xem theo: <a style="color: red">Hợp đồng</a>
								</p>
								<form method="GET" action="/FBMS/listTTfindbyMaHopDong"
									style="width: 150px;">
									<select class="form-control" name="dsHopDongId">
										<option disabled="disabled">Chọn hợp đồng</option>
										<c:forEach items="${dsHopDong}" var="hd">
											<option value="${hd.maHopDong}">${hd.tenHopDong}</option>
										</c:forEach>
									</select> <input class="btn btn-success" type="submit" value="Xem">
								</form>
							</div>
							<div class="col-md-3">
								<p>
									<br> Xem theo: <a style="color: red">Trạng thái</a>
								</p>
								<form method="GET" action="/FBMS/listTTfindbyMaTrangThai"
									style="width: 150px;">
									<select class="form-control" name="dsTrangThaiID">
										<option disabled="disabled">Chọn Trạng Thái</option>
										<c:forEach items="${dsTrangThai}" var="tt">
											<option value="${tt.idTrangThai}">${tt.name}</option>
										</c:forEach>
									</select> <input class="btn btn-success" type="submit" value="Xem">
								</form>
							</div>
						</div>
						<div class="card-body collapse in">
							<div class="card-block card-dashboard">
								<div class="table-responsive">
									<table id="datatable"
										class="table table-striped table-bordered dataex-res-constructor">
										<thead>
											<tr>
												<th scope="col">ID</th>
												<th>Mã Nhân Viên</th>
												<th>Tên Nhân Viên</th>
												<th>Ngày Sinh</th>
												<th>Ảnh đại diện</th>
												<th>Tên trình Độ</th>
												<th>Tên trạng thái</th>
												<th>Gia đình</th>
												<th>Trình độ</th>
												<th>Hợp đồng/Chế độ TH</th>
												<th></th>
											</tr>
										</thead>
										<c:forEach var="bc" items="${trangThai}">
											<tr>
												<td>${bc.id}</td>
												<td>${bc.maNhanVien}</td>
												<td>${bc.nhanSuBC.hoLot} ${bc.nhanSuBC.ten}</td>
												<td><fmt:formatDate value="${bc.nhanSuBC.namSinh}"
														pattern="dd-MM-yyyy" /></td>
												<td><img style="width: 70px;hight=70px;"
													src="<c:url value="/uploads/${bc.nhanSuBC.anhDaiDien}"/>"></td>
												<td>${bc.trinhDo.tenTrinhDo}</td>
												<td><c:choose>
														<c:when test="${bc.nhanSuBC.idTrangThai == 1}">
						    Còn Làm
						  </c:when>
														<c:when test="${bc.nhanSuBC.idTrangThai == 2}">
						   Nghỉ
						  </c:when>
														<c:otherwise>
						  ...
						  </c:otherwise>
													</c:choose></td>
												<td><a href="/FBMS/thongTinNhanVien/${bc.maNhanVien}"
													class="btn btn-success">Xem TT Chi Tiết</a></td>
												<td><a href="/FBMS/ViewTT/${bc.maNhanVien}"
													class="btn btn-info">Gia Đình</a></td>

												<td><a href="/FBMS/ViewBC/${bc.maNhanVien}"
													class="btn btn-warning">Bằng Cấp</a> <a
													href="/FBMS/ViewCC/${bc.maNhanVien}"
													class="btn btn-primary">Chứng chỉ</a></td>

												<td><a href="/FBMS/thongTinHopDong/${bc.maNhanVien}"
													class="btn btn-warning">Hợp đồng</a> <a
													href="/FBMS/thongTinKinhNghiem/${bc.maNhanVien}"
													class="btn btn-primary">DS Kinh nghiệm DA</a></td>
												<td></td>
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