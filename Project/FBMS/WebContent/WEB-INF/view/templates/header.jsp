<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
<meta name="description"
	content="FastTrackSE Bunisess Management System.">
<meta name="keywords"
	content="human resource, document, project, working log, leave management">
<meta name="author" content="FFSE1704">
<title>FastTrackSE - The Business Management System</title>
<link rel="apple-touch-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/09/fasttrackselogo.png"/>">
<link rel="shortcut icon" type="image/x-icon"
	href="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i%7COpen+Sans:300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet" />
<!-- BEGIN VENDOR CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/feather/style.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/font-awesome/css/font-awesome.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/flag-icon-css/css/flag-icon.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/pace.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/tables/datatable/dataTables.bootstrap4.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/extensions/unslider.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/weather-icons/climacons.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/meteocons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/charts/morris.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/calendars/fullcalendar.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/calendars/fullcalendar.min.css"/>">

<!-- END VENDOR CSS-->
<!-- BEGIN STACK CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap-extended.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/app.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/colors.css"/>">
<!-- END STACK CSS-->
<!-- BEGIN Page Level CSS-->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/menu/menu-types/vertical-overlay-menu.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-gradient.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/core/colors/palette-callout.min.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/forms/extended/form-extended.min.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/fonts/simple-line-icons/style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/pages/timeline.css"/>">
<!-- END Page Level CSS-->
<style>
.invalid-feedback {
	color: #DC3545;
	padding-top: 10px;
}

.invalid-feedback::before {
	content: "•";
	padding-left: 10px;
	padding-right: 10px;
}
</style>

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<script>
	$(document).ready(
			function() {
				listClass = [ "phong_ban", "chuc_danh" ];
				url = window.location.href;
				selector = '.'
						+ url.substring(url.lastIndexOf("ffse-fbms") + 10);
				selector = selector.replace(/\//g, '').replace(/[0-9]/g, '');
				$(selector).addClass('active open');

				var i;
				for (i = 0; i < listClass.length; i++) {
					if (selector.includes(listClass[i])) {
						$("." + listClass[i]).addClass('open');
					}
				}
				console.log(selector);
				if (selector.includes('ho_so')
						&& !selector.includes('viewho_so')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('ho_soedit')) {
					$(".pbho_so").addClass('open');
				}
				if (selector.includes('hop_dong')
						&& !selector.includes('viewhop_dong')
						&& !selector.includes('qlnsnv')
						&& !selector.includes('hop_dongedit')) {
					$(".pbhop_dong").addClass('open');
				}
			});
</script>

</head>

<body data-open="click" data-menu="vertical-menu" data-col="2-columns"
	class="vertical-layout vertical-menu 2-columns   menu-expanded fixed-navbar">

	<nav
		class="header-navbar navbar navbar-with-menu navbar-fixed-top navbar-semi-light bg-gradient-x-grey-blue">
		<div class="continer">

			<!-- Show message -->
			<c:if test="${messageSC ne null}">
				<div class="alert alert-success  btn-min-width mr-1 mb-1"
					role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageSC}
				</div>
			</c:if>
			<c:if test="${messageER ne null}">
				<div class="alert alert-danger alert-dismissable" role="alert">
					<button type="button" class="close" data-dismiss="alert">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					${messageER}
				</div>
			</c:if>
		</div>
		<div class="navbar-wrapper">
			<div class="navbar-header">
				<ul class="nav navbar-nav">
					<li class="nav-item mobile-menu hidden-md-up float-xs-left"><a
						href="#" class="nav-link nav-menu-main menu-toggle hidden-xs"><i
							class="ft-menu font-large-1"></i></a></li>
					<li class="nav-item"><a href="/FBMS/home" class="navbar-brand"><img
							src="<c:url value="https://www.fasttrack.edu.vn/wp-content/uploads/2018/03/favicon.png"/>"
							alt="FastTrackSE logo" class="brand-logo" />
							<h2 class="brand-text">FBMS</h2></a></li>
					<li class="nav-item hidden-md-up float-xs-right"><a
						data-toggle="collapse" data-target="#navbar-mobile"
						class="nav-link open-navbar-container"><i
							class="fa fa-ellipsis-v"></i></a></li>
				</ul>
			</div>
			<div class="navbar-container content container-fluid">
				<div id="navbar-mobile" class="collapse navbar-toggleable-sm">
					<ul class="nav navbar-nav">
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-menu-main menu-toggle hidden-xs"><i
								class="ft-menu"></i></a></li>
						<li class="nav-item hidden-sm-down"><a href="#"
							class="nav-link nav-link-expand"><i class="ficon ft-maximize"></i></a></li>
					</ul>
					<ul class="nav navbar-nav float-xs-right">
						<li class="dropdown dropdown-language nav-item"><a
							class="dropdown-toggle nav-link" id="dropdown-flag" href="#"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i
								class="flag-icon <spring:message code="label.QuanTriHeThong.NgonNgu" />"></i><span
								class="selected-language"></span></a>
							<div class="dropdown-menu" aria-labelledby="dropdown-flag">
								<a class="dropdown-item" href="?lang=en"><i
									class="flag-icon flag-icon-gb"></i> English</a> <a
									class="dropdown-item" href="?lang=vi"><i
									class="flag-icon flag-icon-vn"></i> Tiếng Việt</a>
							</div></li>
						<li class="dropdown dropdown-user nav-item"><a href="#"
							data-toggle="dropdown"
							class="dropdown-toggle nav-link dropdown-user-link"><span
								class="avatar avatar-online"><img
									src="<c:url value="/resources/images/portrait/small/avatar-s-1.png"/>"
									alt="avatar"><i></i></span><span class="user-name">${pageContext.request.userPrincipal.name}</span></a>
							<div class="dropdown-menu dropdown-menu-right">
								<a href="#" class="dropdown-item"><i class="ft-user"></i> <spring:message
										code="label.QuanTriHeThong.suaHoSo" /></a> <a href="#"
									class="dropdown-item"><i class="ft-mail"></i> <spring:message
										code="label.QuanTriHeThong.hopThu" /></a> <a href="#"
									class="dropdown-item"><i class="ft-check-square"></i> <spring:message
										code="label.QuanTriHeThong.nhiemVu" /></a> <a href="#"
									class="dropdown-item"><i class="ft-message-square"></i> <spring:message
										code="label.QuanTriHeThong.tinNhan" /></a>
								<div class="dropdown-divider"></div>
								<form class="dropdown-item"
									action="<c:url value="/j_spring_security_logout" />"
									method="post">
									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <a href="#"
										onclick="$(this).closest('form').submit()"><i
										class="ft-power"></i> <spring:message
											code="label.QuanTriHeThong.dangXuat" /></a>
								</form>
							</div></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>

	<!-- ////////////////////////////////////////////////////////////////////////////-->
	<div data-scroll-to-active="true"
		class="main-menu menu-fixed menu-light menu-accordion menu-shadow">
		<div class="main-menu-content">
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">

				<!-- --------------------------Quản trị hệ thống-------------------------- -->
				<li class=" navigation-header"><span><spring:message
							code="label.QuanTriHeThong" /></span> <i data-toggle="tooltip"
					data-placement="right" data-original-title="Apps" class=" ft-minus"></i>
				</li>
				<li class=" nav-item QuanTriHeThongphong_ban"><a
					href="<c:url value = "/QuanTriHeThong/phong_ban/"/>"> <i
						class="fa fa-building"></i> <span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.PhongBan" /></span>
				</a></li>
				<li class=" nav-item QuanTriHeThongchuc_danh"><a
					href="<c:url value = "/QuanTriHeThong/chuc_danh/"/>"> <i
						class="fa fa-id-card-o"></i> <span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.ChucDanh" /></span>
				</a></li>
				<li class=" nav-item QuanTriHeThongtai-khoan"><a
					href="<c:url value = "/QuanTriHeThong/tai-khoan/"/>"> <i
						class="fa fa-id-card-o"></i> <span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.TaiKhoan" /></span>
				</a></li>
				<li class=" nav-item QuanTriHeThongphan-quyen"><a
					href="<c:url value = "/QuanTriHeThong/phan-quyen/"/>"> <i
						class="fa fa-id-card-o"></i> <span data-i18n="" class="menu-title"><spring:message
								code="label.QuanTriHeThong.PhanQuyen" /></span>
				</a></li>
				<!-- --------------------------End Quản trị hệ thống-------------------------- -->




				<!-- ************************* Quản Lý Dự Án********************************** -->
				<ul id="main-menu-navigation" data-menu="menu-navigation"
					class="navigation navigation-main">
					<li class=" navigation-header"><span>Quản Lý Dự Án</span><i
						data-toggle="tooltip" data-placement="right"
						data-original-title="Joker" class=" ft-minus"></i></li>
					<li class=" nav-item"><a href="/FBMS/quanlytailieu/index"><i
							class="ft-bookmark"></i> Quản Lý Danh Mục</a>

						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/FBMS/quanlytailieu/index"><i class="icon-user"></i>Khách
									Hàng</a></li>

							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/Quan_Ly_Du_An/List_VaiTroThanhVien/1"/>"><i
									class="icon-puzzle"></i>Vai Trò Thành Viên</a></li>

							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/Quan_Ly_Du_An/List_Domain/1"/>"><i
									class="icon-globe"></i>Domain</a></li>

							<li class="nav-item"><a class="nav-link"
								href="/FBMS/quanlytailieu/index"><i class="ft-layers"></i>Database</a></li>

							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/Quan_Ly_Du_An/List_Framework/1"/>"><i
									class="icon-wrench"></i>Framework</a></li>

							<li class=" nav-item"><a class="nav-link"
								href="/FBMS/quanlytailieu/index"><i class="icon-link"></i>Vendor</a></li>

							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/Quan_Ly_Du_An/List_ProgrammingLanguage/1"/>"><i
									class="icon-book-open"></i>Programming Language</a></li>

							<li class="nav-item"><a class="nav-link"
								href="<c:url value="/Quan_Ly_Du_An/List_Technical/1"/>"><i
									class="icon-magic-wand"></i>Technical</a></li>

							<li class="nav-item"><a class="nav-link"
								href="/FBMS/quanlytailieu/index"><i class="icon-refresh"></i>Trạng
									Thái Dự Án</a></li>
						</ul></li>
					<li class=" nav-item"><a href="/FBMS/quanlytailieu/index"><i
							class="ft-bookmark"></i> Quản Lý Thông Tin Dự Án</a>

						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="/FBMS/quanlytailieu/index"><i class="icon-compass"></i>Thông
									Tin Dự Án</a></li>

							<li class="nav-item"><a class="nav-link"
								href="/FBMS/quanlytailieu/index"><i class="icon-users"></i>Nhân
									Viên Dự Án</a></li>

						</ul></li>
				</ul>
				<!-- **********************End Quản Lý Dự Án************************************* -->




				<!-- ************************* Quản Lý Nhân Sự********************************** -->

				<ul id="main-menu-navigation" data-menu="menu-navigation"
					class="navigation navigation-main">
					<li class=" navigation-header"><span><spring:message
								code="label.QuanTriNhanSu.qlns" /></span><i data-toggle="tooltip"
						data-placement="right" data-original-title="Joker"
						class=" ft-minus"></i></li>
					<li class=" nav-item"><a href="/FBMS/pheDuyetHopDong"><i
							class="ft-bookmark"></i> <spring:message
								code="label.QuanTriNhanSu.dspb" /></a></li>
					<li class=" nav-item"><a
						href="/FBMS/QuanTriNhanSu/danhsach_nhansu/"><i
							class="ft-bookmark"></i> <spring:message
								code="label.QuanTriNhanSu.dsnv" /></a></li>
				</ul>


				<!-- **********************End Quản Lý Nhân Sự************************************** -->









				<!-- --------------------------Quản lý thời gian-------------------------- -->

				<ul id="main-menu-navigation" data-menu="menu-navigation"
					class="navigation navigation-main">
					<li class=" navigation-header"><span>Quản Lí Thời
							Gian(Kỳ)</span><i data-toggle="tooltip" data-placement="right"
						data-original-title="Xuân Kỳ" class=" ft-minus"></i></li>
					<li class=" nav-item"><a
						href="<c:url value = "/QuanLyThoiGian/Logwork/list"/>"><i
							class="ft-book"></i> Danh Sách Logwork</a></li>
					<li class=" nav-item">
						<!--  --> <script type="text/javascript">
							var today = new Date();

							var m = today.getMonth() + 1;
							document.write(" <a href = ' ");
							document
									.write("/FBMS/QuanLyThoiGian/Logwork/listMonth/"
											+ m);
							document.write("' >");
							document.write("<i class='ft-book'></i>");
							document.write("Logwork theo tháng");
							document.write("</a>");
						</script>
					</li>
				</ul>
				<!-- --------------------------End Quản lý thời gian-------------------------- -->


				<!--  Quản lí Vắng nghỉ minhtq -->

				<li class="navigation-header"><span>quản lý vắng nghỉ</span><i
					class=" ft-minus" data-toggle="tooltip" data-placement="right"
					data-original-title="Components"></i></li>
				<li><a
					href="<c:url value="/QuanLyVangNghi/minhtq/addDonNghiPhepMoi"/>"
					class="menu-item"><i class='fa fa-pencil'></i> soạn đơn mới</a></li>
				<li class=" nav-item pbho_so"><a href="#"><i
						class="ft-users"></i><span data-i18n="" class="menu-title">thống
							kê danh sách</span></a>
					<ul class="menu-content">
						<li><a
							href="<c:url value="/QuanLyVangNghi/minhtq/listDonNghiPhep/TT1"/>"
							class="menu-item">danh sách nháp</a></li>
						<li><a
							href="<c:url value="/QuanLyVangNghi/minhtq/listDonNghiPhep/TT2"/>"
							class="menu-item">danh sách chờ duyệt</a></li>
						<li><a
							href="<c:url value="/QuanLyVangNghi/minhtq/listDonNghiPhep/TT3"/>"
							class="menu-item">danh sách duyệt</a></li>
						<li><a
							href="<c:url value="/QuanLyVangNghi/minhtq/listDonNghiPhep/TT4"/>"
							class="menu-item">danh sách từ chối</a></li>
					</ul></li>
				<li class=" nav-item pbho_so"><a href="#"><i
						class="ft-users"></i><span data-i18n="" class="menu-title">danh
							mục</span></a>
					<ul class="menu-content">
						<li><a
							href="<c:url value="/QuanLyVangNghi/minhtq/listLoaiNgayNghi"/>"
							class="menu-item">danh sách loại ngày nghỉ</a></li>
					</ul>
					<ul class="menu-content">
						<li><a
							href="<c:url value="/QuanLyVangNghi/minhtq/listTrangThai"/>"
							class="menu-item">danh sách trạng thái</a></li>
					</ul></li>





				<!--  ----------------------------Quản lí tài liệu-------------------------------  -->
				<li class="navigation-header"><span class="menu-title"
					data-i18n="">QUẢN LÍ TÀI LIỆU</span></li>
				<!--  DoanhNT -->
				<li class="has-sub is-shown"><a class="menu-item" href="#">DoanhNT</a>
					<ul class="menu-content" style="">
						<li class=""><a class="menu-item"
							href="FBMS/DoanhntQLTL/DanhMuc/">● Danh mục tài liệu</a></li>
						<li class=""><a class="menu-item"
							href="FBMS/DoanhntQLTL/TaiLieu/">● Quản lý tài liệu</a></li>
						<li class=""><a class="menu-item"
							href="FBMS/DoanhntQLTL/TrangThai/">● Quản lý trạng thái</a></li>
					</ul></li>
				<!-- Dũng -->
				<li class="has-sub is-shown"><a class="menu-item" href="#">Dũng</a>
					<ul class="menu-content" style="">
						<li class=""><a class="menu-item"
							href="<%=request.getContextPath()%>/quanlytailieu/documentInsert"">
								Thêm Tài Liệu</a></li>
						<li class=""><a class="menu-item"
							href="<%=request.getContextPath()%>/quanlytailieu/danhmuc">Danh
								Mục</a>
						<li class=""><a class="menu-item" href="#"> Tài liệu của
								tôi</a>
							<ul class="menu-content" style="">
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/MyDocumentPendingAccept">●
										Đã được phê duyệt</a></li>
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/MyDocumentPendingApprove">●
										Chưa được phê duyệt</a></li>
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/draft">●
										Tài liệu nháp</a></li>
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/documentRefuse">●
										Tài liệu bị từ chối</a></li>
							</ul></li>
						<li class=""><a class="menu-item" href="<%=request.getContextPath()%>/quanlytailieu/PhongBan"> Theo Phòng
								Ban</a>
							</li>
						<li class=""><a class="menu-item"
							href="<%=request.getContextPath()%>/quanlytailieu/pendingApprove">●
								Phê duyệt tài liệu</a></li>

					</ul></li>
				<!-- SyNV -->
				<li class="has-sub is-shown"><a class="menu-item" href="#">SyNV</a>
					<ul class="menu-content" style="">
						<li class=""><a class="menu-item" href="#"> Tài liệu của
								tôi</a>
							<ul class="menu-content" style="">
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/">● Đã
										được phê duyệt</a></li>
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/">● Chưa
										được phê duyệt</a></li>
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/">● Tài
										liệu nháp</a></li>
								<li class=""><a class="menu-item"
									href="<%=request.getContextPath()%>/quanlytailieu/">● Tài
										liệu bị từ chối</a></li>
							</ul></li>
					</ul></li>
			</ul>

			<!--  ----------------------------End Quản lí vắng nghỉ-------------------------------  -->

			<!-- Quản Lí Nhiệm Vụ -->
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span>Quản Lí Nhiệm Vụ</span><i
					data-toggle="tooltip" data-placement="right"
					data-original-title="Tunglnt" class=" ft-minus"></i></li>

				<!-- TùngLNT -->
				<li class="has-sub is-shown"><a class="menu-item" href="#">TùngLNT</a>
					<ul class="menu-content" style="">
						<li class=""><a class="menu-item"
							href="/FBMS/TunglntQuanLyNhiemVu/CongViec/ListCongViec">●
								List Công Việc</a></li>
					</ul></li>
			</ul>
			<!--END Quản Lí Nhiệm Vụ -->


			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span>Quản Lí Thời Gian</span><i
					data-toggle="tooltip" data-placement="right"
					data-original-title="Bùi Vũ" class=" ft-minus"></i></li>

				<li class=" nav-item"><a
					href="<c:url value = "/logwork/listChoPheDuyetPM"/>"><i
						class="ft-book"></i> Danh Sách Chờ Phê Duyệt</a></li>
				<li class=" nav-item pbho_so"><a href="#"><i
						class="ft-users"></i><span data-i18n="" class="menu-title">Danh
							Sách Logwork Nhân Viên</span></a>
					<ul class="menu-content">
						<li><a href="<c:url value="/logwork/list/4"/>"
							class="ft-book">Logwork Lưu Nháp</a></li>
						<li><a href="<c:url value="/logwork/list/3"/>"
							class="ft-book">Logwork Bị Từ Chối</a></li>

						<li><a href="<c:url value="/logwork/list/1"/>"
							class="ft-book">Logwork Chờ TPP Phê Duyệt</a></li>
						<li><a href="<c:url value="/logwork/list/5"/>"
							class="ft-book">Logwork Chờ PM Phê Duyệt</a></li>
						<li><a href="<c:url value="/logwork/list/2"/>"
							class="ft-book">Logwork Đã Phê Duyệt</a></li>
					</ul></li>
				<li class=" nav-item"><a
					href="<c:url value = "/logwork/listChoPheDuyetPM"/>"><i
						class="ft-book"></i> Báo Cáo Thời Gian Làm Việc Phòng Ban</a></li>

			</ul>
			<ul id="main-menu-navigation" data-menu="menu-navigation"
				class="navigation navigation-main">
				<li class=" navigation-header"><span>Quản Lý Vắng Nghỉ</span><i
					data-toggle="tooltip" data-placement="right"
					data-original-title="Bét Daxua" class=" ft-minus"></i></li>
				<li class=" nav-item"><a
					href="<c:url value = "/quanlyvangnghi/khoann/list"/>"><i
						class="ft-bookmark"></i> Danh Sách</a></li>
			</ul>
		</div>
	</div>