<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>Insert title here</title>
   <link rel="apple-touch-icon" href="<c:url value="/resources/images/ico/apple-icon-120.png "/>">
   <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/images/ico/favicon.ico "/>">
</head>
<body>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">FastTrackSE Business
						Management System</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="/FBMS/home">Home</a></li>
								<li class="breadcrumb-item"><a href="#">Form</a></li>
								<li class="breadcrumb-item active">Basic Elements</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="content-header-right col-md-6 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="btn-group float-md-right">
						<div role="group" class="btn-group">
							<button id="btnGroupDrop1" type="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								class="btn btn-outline-primary dropdown-toggle dropdown-menu-right">
								<i class="ft-settings icon-left"></i> Settings
							</button>
							<div aria-labelledby="btnGroupDrop1" class="dropdown-menu">
								<a href="card-bootstrap.html" class="dropdown-item">Bootstrap
									Cards</a><a href="component-buttons-extended.html"
									class="dropdown-item">Buttons Extended</a>
							</div>
						</div>
						<a href="calendars-clndr.html" class="btn btn-outline-primary"><i
							class="ft-mail"></i></a><a href="timeline-center.html"
							class="btn btn-outline-primary"><i class="ft-pie-chart"></i></a>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- Inputs Icons start -->
				
                <form:form id="donxinnghi" class="form" method="POST" modelAttribute="donNghi" action="savenhap">
				<div class="row match-height">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="from-actions-top-left">Đơn xin
									nghỉ</h4>
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
								<div class="card-block">

									<div class="card-text">
										<div
											class="alert bg-info alert-icon-right alert-arrow-right alert-dismissible fade in"
											role="alert">
											<button type="button" class="close" data-dismiss="alert"
												aria-label="Close">
												<span aria-hidden="true">×</span>
											</button>

											<strong>Lưu ý: một ngày nghỉ quá ngày được nghỉ sẽ
												bị trừ vào lương.</strong>
										</div>
									</div>
									<div class="form-body">

											<h4 class="form-section">
												<i class="fa fa-address-card-o"></i> Mã nhân viên*
											</h4>
											<div class="row">
												<div class="form-group col-md-12 mb-2">
													<fieldset
														class="form-group position-relative has-icon-left">
														<input id="iconLeft10" type="text"
															class="form-control round"
															value="${nhanVien.getMaNhanVien()}"> 
															<input
															type="hidden" name="idnv"
															value="${nhanVien.getMaNhanVien()}">
														<div class="form-control-position">
															<i class="fa fa-user-circle-o"></i>
														</div>
													</fieldset>
												</div>
											</div>
											<h4 class="form-section">
												<i class="fa fa-address-card-o"></i> Tên nhân viên*
											</h4>
											<div class="row">
												<div class="form-group col-md-12 mb-2">
													<fieldset
														class="form-group position-relative has-icon-left">
														<input id="iconLeft10"
															name ="tennv"
															type="text"
															class="form-control round"
															value="${nhanVien.getHoDem()+=' '+=nhanVien.getTen()} ">
														<div class="form-control-position">
															<i class="fa fa-user-circle-o"></i>
														</div>
													</fieldset>
												</div>
											</div>
											<h4 class="form-section">
												<i class="fa fa-building-o"></i> Phòng ban*
											</h4>
											<div class="row">
												<div class="form-group col-md-12 mb-2">
													<fieldset
														class="form-group position-relative has-icon-left">
														<input id="iconLeft10"
															 type="text" class="form-control round"
															value="${nhanVien.getPhongBan().getTenPhongBan()}">
														<input type="hidden" name="phongban"
															value="${nhanVien.getPhongBan().getTenPhongBan()}">
														<div class="form-control-position">
															<i class="fa fa-users"></i>
														</div>
													</fieldset>
												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-clock"></i> Số ngày đã nghỉ*
											</h4>
											<div class="row">
												<div class="form-group col-md-12 mb-2">
													<fieldset
														class="form-group position-relative has-icon-left">
														<c:if test="${tinhTrang.getNgaydanghi() == null}">
															<input id="iconLeft10" name="ngaydanghi" type="text"
																class="form-control round" readonly="readonly" value="0">

														</c:if>
														<c:if test="${tinhTrang.getNgaydanghi() != null}">
															<input id="iconLeft10" name="ngaydanghi" type="text"
																class="form-control round" readonly="readonly"
																value="${tinhTrang.getNgaydanghi()}">
														</c:if>
														<div class="form-control-position">
															<i class="fa fa-clock-o"></i>
														</div>
													</fieldset>
												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-clock"></i> Số ngày nghỉ còn lại (không bị trừ
												lương)*
											</h4>
											<div class="row">
												<div class="form-group col-md-12 mb-2">
													<fieldset
														class="form-group position-relative has-icon-left">
														<c:if test="${tinhTrang.getNgayconlai() == null}">
															<input id="iconLeft10" name="ngayconlai" type="text"
																class="form-control round" readonly="readonly"
																value="12">
														</c:if>
														<c:if test="${tinhTrang.getNgayconlai() != null}">
															<input id="iconLeft10" name="ngayconlai" type="text"
																class="form-control round" readonly="readonly"
																value="${tinhTrang.getNgayconlai() }">
														</c:if>
														<div class="form-control-position">
															<i class="fa fa-clock-o"></i>
														</div>
													</fieldset>
												</div>
											</div>
											<h4 class="form-section">
												<i class="fa fa-calendar-o"></i> Chọn ngày nghỉ
											</h4>
											<!-- <div class="row">
												<div class="form-group col-md-4 mb-2 has-icon-left">
													<p>Ngày bắt đầu*</p>
													
													<input name="tgbatdau" type="date"
															class="form-control round" id="from" min="2018-10-07" />
													
												</div>
												<div class="form-group col-md-4 mb-2 has-icon-left">
													<p>Ngày kết thúc*</p>

													<fieldset class="form-group position-relative">
														<input id="to" name="tgketthuc" type="date"
															class="form-control round" onchange="count()" value=""
															min="2018-10-08">
														<div class="form-control-position">
															<i class="fa fa-calendar"></i>
														</div>
													</fieldset>


													
												</div>												
											</div> -->

											<h4 class="form-section">
												<i class="fa fa-list-ul"></i> Lý do nghỉ*
											</h4>

											<div class="row">
												<div class="form-group col-md-12 mb-2">
												
													<input  name="lydo" type="text"
																class="form-control round" 	>
												</div>
											</div>


											<h4 class="form-section">
												<i class="fa fa-tags"></i> Ghi chú*
											</h4>

											<div class="row">
												<div class="form-group col-xs-12 mb-2 has-icon-left">
													<input  name="ghichu" type="text"
																class="form-control round" 	>
													<div class="form-control-position">
														<i class="fa fa-keyboard-o"></i>
													</div>
												</div>
											</div> 
											<div class="form-actions">
												<button type="submit" class="btn btn-primary">
													<i class="fa ft-save"></i> Lưu nháp
												</button>
												<button type="submit" class="btn btn-success" formaction="savechoduyet">
													 <i class="fa fa-check-square-o"></i> Gửi đơn chờ phê duyệt
												</button>
												<a href="">
													<button type="button" class="btn btn-warning mr-1">
														<i class="fa fa-arrow-circle-left"></i> Quay lại
													</button>
												</a>
											</div>
										</div>
									</form:form>
								</div>
							</div>
						</div>
					</div>
					<!-- Inputs Icons end -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>