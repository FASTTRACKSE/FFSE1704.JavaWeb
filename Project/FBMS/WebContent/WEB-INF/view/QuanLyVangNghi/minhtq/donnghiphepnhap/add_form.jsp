<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyVangNghi/minhtq/listDonNghiPhepNhap" />'>Danh
									sách </a></li>
							<li class="breadcrumb-item active">Thêm mới chức danh</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
		
			<div class="main-content">
				<div class="row">
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
					<form:form method="POST" modelAttribute="taodonmoi" action="addDonNghiPhepNhap">
						<div class="form-group col-sm-12">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien"
								placeholder="nhập mã nhân viên" />

						</div>

						<div>
							<label>Số ngày nghỉ</label>
							<form:input type="text" class="form-control round" id="total"
								readonly="true" path="soLuong" />

						</div>

						<div class="form-group col-sm-12">
							<label>Thời gian bắt đầu </label>
							<fieldset class="form-group position-relative">
								<form:input type="date" class="form-control round" id="from"
									onchange="myFunction()" path="thoiGianBatDau" />


							</fieldset>
							<script>
								var today = new Date();
								var dd = today.getDate();
								var mm = today.getMonth() + 1; // January is 0!
								var yyyy = today.getFullYear();
								if (dd < 10) {
									dd = '0' + dd
								}
								if (mm < 10) {
									mm = '0' + mm
								}
								today = yyyy + '-' + mm + '-' + dd;
								document.getElementById("from").setAttribute(
										"min", today);
								document.getElementById('from').value = today;
								function myFunction() {
									var today = new Date(document
											.getElementById("from").value);
									var dd = today.getDate();
									var mm = today.getMonth() + 1; // January is 0!
									var yyyy = today.getFullYear();
									if (dd < 10) {
										dd = '0' + dd
									}
									if (mm < 10) {
										mm = '0' + mm
									}
									today = yyyy + '-' + mm + '-' + dd;
									document.getElementById("to").setAttribute(
											"min", today);
									document.getElementById('to').value = new Date(
											document.getElementById("from").value)
											.toISOString().substring(0, 10);
									var iWeeks, iDateDiff, iAdjust = 0;
									var dDate1 = new Date(document
											.getElementById("from").value);
									var dDate2 = new Date(document
											.getElementById("to").value);
									if (dDate2 < dDate1)
										return -1; // error code if dates transposed
									var iWeekday1 = dDate1.getDay(); // day of week
									var iWeekday2 = dDate2.getDay();
									iWeekday1 = (iWeekday1 == 0) ? 7
											: iWeekday1; // change Sunday from 0 to 7
									iWeekday2 = (iWeekday2 == 0) ? 7
											: iWeekday2;
									if ((iWeekday1 > 5) && (iWeekday2 > 5))
										iAdjust = 1; // adjustment if both days on weekend
									iWeekday1 = (iWeekday1 > 5) ? 5 : iWeekday1; // only count weekdays
									iWeekday2 = (iWeekday2 > 5) ? 5 : iWeekday2;
									// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
									iWeeks = Math
											.floor((dDate2.getTime() - dDate1
													.getTime()) / 604800000)
									if (iWeekday1 <= iWeekday2) {
										iDateDiff = (iWeeks * 5)
												+ (iWeekday2 - iWeekday1) + 1
									} else {
										iDateDiff = ((iWeeks + 1) * 5)
												- (iWeekday1 - iWeekday2) + 1
									}
									iDateDiff -= iAdjust
									document.getElementById("total").value = iDateDiff;
								}
							</script>

						</div>
						<div class="form-group col-sm-12">
							<label>Thời gian kết thúc </label>
							<fieldset class="form-group position-relative">
								<form:input type="date" class="form-control round" id="to"
									onchange="count()" path="thoiGianKetThuc" />

							</fieldset>
							<script>
								var today = new Date();
								var dd = today.getDate();
								var mm = today.getMonth() + 1; // January is 0!
								var yyyy = today.getFullYear();
								if (dd < 10) {
									dd = '0' + dd
								}
								if (mm < 10) {
									mm = '0' + mm
								}
								today = yyyy + '-' + mm + '-' + dd;
								document.getElementById("to").setAttribute(
										"min", today);
								function count() {
									var iWeeks, iDateDiff, iAdjust = 0;
									var dDate1 = new Date(document
											.getElementById("from").value);
									var dDate2 = new Date(document
											.getElementById("to").value);
									if (dDate2 < dDate1)
										return -1; // error code if dates transposed
									var iWeekday1 = dDate1.getDay(); // day of week
									var iWeekday2 = dDate2.getDay();
									iWeekday1 = (iWeekday1 == 0) ? 7
											: iWeekday1; // change Sunday from 0 to 7
									iWeekday2 = (iWeekday2 == 0) ? 7
											: iWeekday2;
									if ((iWeekday1 > 5) && (iWeekday2 > 5))
										iAdjust = 1; // adjustment if both days on weekend
									iWeekday1 = (iWeekday1 > 5) ? 5 : iWeekday1; // only count weekdays
									iWeekday2 = (iWeekday2 > 5) ? 5 : iWeekday2;
									// calculate differnece in weeks (1000mS * 60sec * 60min * 24hrs * 7 days = 604800000)
									iWeeks = Math
											.floor((dDate2.getTime() - dDate1
													.getTime()) / 604800000)
									if (iWeekday1 <= iWeekday2) {
										iDateDiff = (iWeeks * 5)
												+ (iWeekday2 - iWeekday1) + 1
									} else {
										iDateDiff = ((iWeeks + 1) * 5)
												- (iWeekday1 - iWeekday2) + 1
									}
									iDateDiff -= iAdjust
									document.getElementById("total").value = iDateDiff;
								}
							</script>


						</div>


						<div class="form-group col-md-12">
							<label for="location1">Loại ngày nghỉ </label>
							<form:select path="loaiNgayNghi"
								class="custom-select form-control" id="location1"
								name="location" items="${listLoaiNgayNghi}"
								itemValue="maNgayNghi" itemLabel="tenLoaiNgayNghi">

							</form:select>

						</div>

						<div class="row">
							<div class="col-md-12" style="padding-left: 3%;">
								<button type="submit"
									class="btn btn-outline-success round  mr-1 mb-1" value="luunhap"
									name="action">lưu nháp</button>
								<button type="submit"
									class="btn btn-outline-success round  mr-1 mb-1" value="chopheduyet"
									name="action">gửi đơn</button>

							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
