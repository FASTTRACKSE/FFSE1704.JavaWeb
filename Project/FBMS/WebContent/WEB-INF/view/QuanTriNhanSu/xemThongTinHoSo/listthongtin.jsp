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
* {
	box-sizing: border-box
}

/* Set height of body and the document to 100% */
body, html {
	height: 100%;
	margin: 0;
	font-family: Arial;
}

/* Style tab links */
.tablink {
	background-color: #555;
	color: black;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 16px;
	width: 14%;
}

.tablink:hover {
	background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: black;
	display: none;
	padding: 100px 20px;
	height: 100%;
}

#Home {
	background-color: white;
}

#News {
	background-color: white;
}

#Contact {
	background-color: white;
}

#About {
	background-color: white;
}
</style>
<style>

/* Style tab links */
.tablink {
	background-color: #555;
	color: black;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 16px;
	width: 14%;
}

.tablink:hover {
	background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: black;
	display: none;
	padding: 100px 20px;
	height: 100%;
}

#Home {
	background-color: white;
}

#News {
	background-color: white;
}

#Contact {
	background-color: white;
}

#About {
	background-color: white;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách phòng ban</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>

							<li class="breadcrumb-item"><a
								href='<c:url value="/dsphongban" />'>Danh sách phòng ban</a></li>

							<li class="breadcrumb-item active">Thông tin chi tiết nhân
								viên</li>
						</ol>
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
							<h4 class="card-title">Thông tin nhân viên</h4>
							<a href="/FBMS/excelfile/${thongTinNhanVien.maNhanVien}"><button
									class="btn btn-success">Xuất thông tin ra file Excel</button></a> <a
								class="heading-elements-toggle"><i
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
									<h1 style="text-align: center; color: green">Xem thông tin
										hồ sơ nhân viên</h1>
									<p style="text-align: center;">Nhân viên:</p>
									<p>
											<img
												src="<c:url value="/uploads/${thongTinNhanVien.anhDaiDien}"/>"
												style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; height: 150px; display: block; margin-left: auto; margin-right: auto;">
										</p>

									<h2 style="text-align: center;">${thongTinNhanVien.hoLot}<a>
											${thongTinNhanVien.ten}</a>
									</h2>
									<p style="text-align: center;">
											Phòng ban:<a>${pbcd.phongBan.tenPhongBan}</a> - Chức vụ:<a>${pbcd.chucDanh.tenChucDanh}</a>
										</p>
									<button class="tablink" onclick="openPage('Home', this, 'red')">Hồ
										sơ</button>
									<button class="tablink"
										onclick="openPage('News', this, 'green')" id="defaultOpen">Liên
										hệ</button>
									<button class="tablink"
										onclick="openPage('Family', this, 'green')">Gia đình</button>
									<button class="tablink"
										onclick="openPage('Contact', this, 'blue')">Bằng cấp</button>
									<button class="tablink"
										onclick="openPage('About', this, 'orange')">Chứng chỉ</button>
									<button class="tablink"
										onclick="openPage('Project', this, 'black')">Dự án</button>
									<button class="tablink"
										onclick="openPage('Contract', this, 'green')">Hợp
										đồng</button>
									<div id="Home" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Mã NV</th>
													<th scope="col">Họ đệm</th>
													<th scope="col">Tên</th>
													<th scope="col">Năm sinh</th>
													<th scope="col">Giới tính</th>
													<th scope="col">Dân tộc</th>
													<th scope="col">Số CMND</th>
													<th scope="col">Ngày cấp</th>
													<th scope="col">Nơi cấp</th>

												</tr>
											</thead>
											<tbody>
												<tr>
													<th scope="row">${thongTinNhanVien.maNhanVien}</th>
													<td>${thongTinNhanVien.hoLot}</td>
													<td>${thongTinNhanVien.ten}</td>
													<td>${thongTinNhanVien.namSinh}</td>
													<td>${thongTinNhanVien.gioiTinh}</td>
													<td>${thongTinNhanVien.danToc}</td>
													<td>${thongTinNhanVien.soCMND}</td>
													<td>${thongTinNhanVien.ngayCap}</td>
													<td>${thongTinNhanVien.noiCap}</td>
												</tr>

											</tbody>
										</table>
									</div>

									<div id="News" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Địa chỉ</th>
													<th scope="col">Quận/Huyện</th>
													<th scope="col">Phường/Xã</th>
													<th scope="col">Tỉnh/Thành phố</th>
													<th scope="col">Quốc tịch</th>
													<th scope="col">Nơi tạm trú</th>
													<th scope="col">Số điện thoại</th>
													<th scope="col">Email</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>${thongTinNhanVien.queQuan}</td>
													<td>${thongTinNhanVien.quanHuyen.name}</td>
													<td>${thongTinNhanVien.xaPhuong.name}</td>
													<td>${thongTinNhanVien.thanhPho.name}</td>
													<td>${thongTinNhanVien.quocTich.tenQuocTich}</td>
													<td>${thongTinNhanVien.noiTamTru}</td>
													<td>${thongTinNhanVien.soDienThoai}</td>
													<td>${thongTinNhanVien.email}</td>
												</tr>
											</tbody>
										</table>
									</div>

									<div id="Family" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Họ và tên</th>
													<th scope="col">Quan hệ</th>
													<th scope="col">Năm sinh</th>
													<th scope="col">Nghề nghiệp</th>
													<th scope="col">Địa chỉ</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<c:forEach var="ttGiaDinh"
														items="${thongTinNhanVien.listGiaDinh}">
														<td>${ttGiaDinh.hoVaTen}</td>
														<td>${ttGiaDinh.quanHe}</td>
														<td>${ttGiaDinh.namSinh}</td>
														<td>${ttGiaDinh.ngheNghiep}</td>
														<td>${ttGiaDinh.diaChi}</td>
													</c:forEach>
												</tr>
											</tbody>
										</table>
									</div>

									<div id="Contact" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Trình độ</th>
													<th scope="col">Ngành</th>
													<th scope="col">Thời gian bắt đầu</th>
													<th scope="col">Thời gian kết thúc</th>
													<th scope="col">Xếp loại</th>
													<th scope="col">Nơi cấp</th>
												</tr>
											</thead>
											<tbody>
												
													<c:forEach var="bangCap"
														items="${thongTinNhanVien.listBangCap}">
														<tr>
														<td>${bangCap.trinhDo.tenTrinhDo}</td>
														<td>${bangCap.tenNganh}</td>
														<td>${bangCap.batDau}</td>
														<td>${bangCap.ketThuc}</td>
														<td>${bangCap.xepLoai}</td>
														<td>${bangCap.noiCap}</td>
															</tr>
													</c:forEach>
											
											</tbody>
										</table>
									</div>
									<div id="Contract" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Loại hợp đồng</th>
													<th scope="col">Tổng số ngày nghỉ</th>
													<th scope="col">Số ngày nghỉ còn lại</th>
													<th scope="col">Ngày bắt đầu</th>
													<th scope="col">Ngày kết thúc</th>
													<th scope="col">Loại công việc</th>
													<th scope="col">Địa điểm làm việc</th>
													<th scope="col">Thời gian làm việc</th>
													<th scope="col">Mức lương ban đầu</th>
													<th scope="col">Lương tháng 13</th>
													<th scope="col">Các loại ngày nghỉ đặc biệt</th>
													<th scope="col">Hình thức thanh toán lương</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="hopDong"
													items="${thongTinNhanVien.listHopDong}">
													<tr>
														<td>${hopDong.loaihopDong.tenHopDong}</td>
														<c:forEach var="ngayNghi"
															items="${thongTinNhanVien.listNgayNghi}">
															<td>${hopDong.soNgayNghiTrongNam}</td>
															<td>${ngayNghi.soNgayNghiConLai}</td>
														</c:forEach>
														<td>${hopDong.ngayBatDau}</td>
														<td>${hopDong.ngayKetThuc}</td>
														<td>${hopDong.congViec.tenCongViec}</td>
														<td>${hopDong.diaDiem.tenDiaDiem}</td>
														<td>${hopDong.thoiGianBatDauLamViec}  đến
															${hopDong.thoiGianKetThucLamViec}</td>
														<td>${hopDong.mucLuongBanDau}</td>
														<td>${hopDong.cheDoHuong.luong}</td>
														<td>${hopDong.ngayNghiDacBiet}</td>
														<td><c:choose>
																<c:when test="${hopDong.hinhThucTraLuong == 1}"> Tiền mặt</c:when>
																<c:when test="${hopDong.hinhThucTraLuong == 2}">Ngân hàng</c:when>
																<c:otherwise></c:otherwise>
															</c:choose></td>
													</tr>
												</c:forEach>

											</tbody>
										</table>


									</div>


									<div id="About" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Tên chứng chỉ</th>
													<th scope="col">Ngày cấp</th>
													<th scope="col">Nơi cấp</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<c:forEach var="chungChi"
														items="${thongTinNhanVien.listChungChi}">
														<td>${chungChi.tenChungChi}</td>
														<td>${chungChi.ngayCap}</td>
														<td>${chungChi.donViCap}</td>
													</c:forEach>
												</tr>
											</tbody>
										</table>
									</div>

									<div id="Project" class="tabcontent">
										<table class="table table-hover">
											<thead>
												<tr>
													<th scope="col">Mã dự án</th>
													<th scope="col">Tên dự án</th>
													<th scope="col">Vai trò</th>
													<th scope="col">Trạng thái</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach var="hopDong"
													items="${thongTinNhanVien.listPhanCongNhiemVuNS}">
													<tr>
														<td>${hopDong.thongTinDuAn.maDuAn}</td>
														<td>${hopDong.thongTinDuAn.tenDuAn}</td>

														<td>${hopDong.vaiTro.tenVaiTro}</td>
														<td>${hopDong.thongTinDuAn.trangThaiDuAnNS.tenTrangThai}</td>


													</tr>
												</c:forEach>

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
</div>
<script>
	function openPage(pageName, elmnt, color) {
		var i, tabcontent, tablinks;
		tabcontent = document.getElementsByClassName("tabcontent");
		for (i = 0; i < tabcontent.length; i++) {
			tabcontent[i].style.display = "none";
		}
		tablinks = document.getElementsByClassName("tablink");
		for (i = 0; i < tablinks.length; i++) {
			tablinks[i].style.backgroundColor = "";
		}
		document.getElementById(pageName).style.display = "block";
		elmnt.style.backgroundColor = color;

	}
	// Get the element with id="defaultOpen" and click on it
	document.getElementById("defaultOpen").click();
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
















