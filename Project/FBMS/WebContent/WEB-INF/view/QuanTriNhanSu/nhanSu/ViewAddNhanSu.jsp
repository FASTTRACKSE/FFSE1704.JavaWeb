<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/daterange/daterangepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/datetime/bootstrap-datetimepicker.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/vendors/css/pickers/pickadate/pickadate.css"/>">

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/plugins/pickers/daterange/daterange.css"/>">
<!-- ////////////////////////////////////////////////////////////////////////////-->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới nhân sự</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanLyNhiemVu/congviec/" />'>Danh sách
									nhân sự</a></li>
							<li class="breadcrumb-item active">Thêm mới nhân sự</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post" enctype="multipart/form-data"
						action="saveNhanSu" modelAttribute="nhanSu">
						<div class="form-group col-sm-6">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien" />
							<form:errors path="maNhanVien" cssClass="error"
								style="color:pink" />
							<p style="color: red">${attenion}</p>

						</div>
						<div class="form-group col-sm-6">
							<label>Mã Phòng Ban:</label>
							<form:select path="maPhongBan" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listPhongBan}" var="lpb">
									<form:option value="${lpb.maPhongBan}"
										label="${lpb.tenPhongBan}" />
								</c:forEach>
							</form:select>
						</div>


						<div class="form-group col-sm-6">
							<label>Mã Chức Danh</label>
							<form:select path="maChucDanh" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listChucDanh}" var="lcd">
									<form:option value="${lcd.maChucDanh}"
										label="${lcd.tenChucDanh}" />
								</c:forEach>
							</form:select>

						</div>

						<div class="form-group col-sm-6">
							<label for="thanhPhoId">Tinh thanh</label>

							<form:select path="tinhThanhPho" type="text" id="thanhPhoId"
								class="custom-select block round" name="thanhPhoSelect"
								onchange="clickComboboxThanhPho()">
								<option value="" selected="selected" disabled>Chọn
									Thành phố</option>
								<c:forEach items="${listTinhThanh}" var="ltt">
									<form:option value="${ltt.matp}" label="${ltt.name}" />
								</c:forEach>
							</form:select>

						</div>

						<div class="form-group col-sm-6">
							<label for="quanHuyenId">Quận/Huyện</label>
							<form:select path="maQuanHuyen" id="quanHuyenId" name="quanHuyen"
								type="text" class="form-control" onchange="clickComboboxQuan()">
								<option value="" selected="selected" disabled>Chọn Quận/Huyện</option>
							</form:select>

						</div>

						<div class="form-group col-sm-6">
							<label for="phuongXaId">Xã/Phường</label>
							<form:select path="maXaPhuong" type="text" id="phuongXaId"
								class="form-control" name="phuongXaSelect" >
								<option value="noPhuongXa" selected="selected">Chọn Xã/Phường</option>

							</form:select>

						</div>
						<div class="form-group col-sm-6">
							<label>Họ đệm</label>
							<form:input class="form-control" type="text" path="hoLot" />
							<form:errors path="hoLot" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Tên</label>
							<form:input class="form-control" type="text" path="ten" />
							<form:errors path="ten" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Ảnh</label> <input id="upload" type="file"
								class="form-control-file" name="file"> <br>
						</div>
						<div class="form-group col-sm-6">
							<label>Năm Sinh</label>
							<form:input class="form-control" type="Date" path="namSinh" />

						</div>
						<div class="form-group col-sm-6">
							<label>Giới tính:</label>
							<%-- <form:input class="form-control" type="text" path="gioiTinh" /> --%>

							Male
							<form:radiobutton path="gioiTinh" value="1" />
							Female
							<form:radiobutton path="gioiTinh" value="2" />


						</div>
						<div class="form-group col-sm-6">
							<label>Quê quán</label>
							<form:input class="form-control" type="text" path="queQuan" />
							<form:errors path="queQuan" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Dân tộc</label>
							<form:input class="form-control" type="text" path="danToc" />
							<form:errors path="danToc" cssClass="error" style="color:pink" />
							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Quốc Tịch</label>
							<form:input class="form-control" type="text"
								path="quocTich.maQuocTich" />

						</div>

						<div class="form-group col-sm-6">
							<label>Tạm trú</label>
							<form:input class="form-control" type="text" path="noiTamTru" />
							<form:errors path="noiTamTru" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Điện thoại</label>
							<form:input class="form-control" type="text" path="soDienThoai" />
							<form:errors path="soDienThoai" cssClass="error"
								style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Email</label>
							<form:input class="form-control" type="text" path="email" />
							<form:errors path="email" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Chứng minh</label>
							<form:input class="form-control" type="text" path="soCMND" />
							<form:errors path="soCMND" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Nơi cấp</label>
							<form:input class="form-control" type="text" path="noiCap" />
							<form:errors path="noiCap" cssClass="error" style="color:pink" />

						</div>
						<div class="form-group col-sm-6">
							<label>Ngày cấp</label>
							<form:input class="form-control" type="Date" path="ngayCap" />

						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:input class="form-control" type="text" path="trangThai" />

						</div>
						<tr>
							<td></td>
							<td><input type="submit" value="Save" /></td>
						</tr>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Ajax Select City from Quanlt -->
<script type="text/javascript">

	function clickComboboxThanhPho() {
		var maThanhPho = $("#thanhPhoId").val(); //click thanh pho

		$('#quanHuyenId option').remove(); // delete old data
		$('#phuongXaId option').remove();

		$.ajax({
			url : "/FBMS/selectQuanHuyen/" + maThanhPho,
			dataType : "json",
			success : function(data) {
				$('#quanHuyenId').append($('<option>', {
					value : 'noQuanHuyen',
					text : 'Chọn Quận/Huyện'
				}));
				$('#quanHuyenId option[value=noQuanHuyen]').attr('disabled',
						true);

				for (var i = 0; i < data.length; i++) {
					$('#quanHuyenId').append($('<option>', {
						value : data[i].maQuanHuyen,
						text : data[i].tenQuanHuyen
					}));
				}

				$('#phuongXaId').append($('<option>', {
					value : 'noPhuongXa',
					text : 'Chọn Phường/Xã'
				}));
				$('#phuongXaId option[value=noPhuongXa]')
						.attr('disabled', true);

			}
		});
	};
</script>
<!-- Ajax Select QuanHuyen from Quanlt -->
<script type="text/javascript">
	function clickComboboxQuan() { //click quan huyen
		var maQuanHuyen = $("#quanHuyenId").val();

		$('#phuongXaId option').remove(); // xoa old data

		$.ajax({
			url : "/FBMS/selectXaPhuong/" + maQuanHuyen,
			dataType : "json",
			success : function(data) {

				$('#phuongXaId').append($('<option>', {//default data
					value : 'noPhuongXa',
					text : 'Chọn Phường/Xã'
				}));
				$('#phuongXaId option[value=noPhuongXa]')
						.attr('disabled', true);

				for (var i = 0; i < data.length; i++) {//new data
					$('#phuongXaId').append($('<option>', {
						value : data[i].maXaPhuong,
						text : data[i].tenXaPhuong
					}));
				}

			}
		});
	};
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
<!-- ////////////////////////////////////////////////////////////////////////////-->

<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/dateTime/bootstrap-datetimepicker.min.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.date.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/picker.time.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/pickadate/legacy.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/vendors/js/pickers/daterange/daterangepicker.js"/> "></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/scripts/pickers/dateTime/picker-date-time.js"/> "></script>

