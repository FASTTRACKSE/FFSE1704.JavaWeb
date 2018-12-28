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
				<h3 class="content-header-title mb-0">Sửa Nhân sự</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriNhanSu/danhsach_nhansu/" />'>Danh
									sách Nhân sự </a></li>
							<li class="breadcrumb-item active">Sửa Thông tin nhân sư</li>
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
						action="/FBMS/QuanTriNhanSu/danhsach_nhansu/update"
						modelAttribute="nhanSu">

						<div class="form-group">

							<form:hidden path="id" />
							<br>

						</div>
						<div class="form-group col-md-6">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien" />

							<br>
						</div>
						<div class="form-group col-md-6">
							<label>Phòng Ban:</label>
							<form:select path="maPhongBan"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${listPhongBan}" var="lpb">
									<form:option value="${lpb.maPhongBan}" label="${lpb.tenPhongBan}" />
								</c:forEach>
							</form:select>

							<br>
						</div>
						<div class="form-group col-md-6">
							<label>Chức Danh</label>
							<form:select path="maChucDanh"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${listChucDanh}" var="lcd">
									<form:option value="${lcd.maChucDanh}" label="${lcd.tenChucDanh}" />
								</c:forEach>
							</form:select>
							<br>
						</div>
							<div class="form-group col-md-6">
							<label>Tinh thanh</label>
							
							 <form:select path="tinhThanhPho"
								class="custom-select block round" id="idThanhPho" onchange="selectThanhPho()">
								<c:forEach items="${listTinhThanh}" var="ltt">
									<form:option value="${ltt.matp}" label="${ltt.name}" />
								</c:forEach>
							</form:select> 

						</div>
						
						<div class="form-group col-sm-6">
							<label>Quan Huyen</label>
							
							 <form:select path="maQuanHuyen"
								class="custom-select block round" id="idQuanHuyen" onchange="selectQuan()">
								<option value="" selected="selected" disabled="disabled">Chon quan huyen</option>
							</form:select>

						</div>
						
						<div class="form-group col-sm-6">
							<label>Xa Phuong</label>
							
							 <form:select path="maXaPhuong"
								class="custom-select block round" id="idPhuongXa" >
								<option value="" selected="selected" disabled="disabled">Chon xa phuong</option>
							</form:select> 

						</div>
						<div class="form-group col-sm-6">
							<label>Họ đệm</label>
							<form:input class="form-control" type="text" path="hoLot" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Tên</label>
							<form:input class="form-control" type="text" path="ten" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Ảnh</label> <input id="upload" type="file"
								class="form-control-file" name="file"> <br>
						</div>
						<div class="form-group col-sm-6">
							<label>Năm Sinh</label>
							<form:input class="form-control" type="Date" path="namSinh" />
							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Giới tính:</label>
							<%-- <form:input class="form-control" type="text" path="gioiTinh" /> --%>

							Male
							<form:radiobutton path="gioiTinh" value="1" />
							Female
							<form:radiobutton path="gioiTinh" value="2" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Quê quán</label>
							<form:input class="form-control" type="text" path="queQuan" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Dân tộc</label>
							<form:input class="form-control" type="text" path="danToc" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Quốc Tịch</label>
							<form:input class="form-control" type="text"
								path="quocTich.maQuocTich" />
							<br>
						</div>

						<div class="form-group col-sm-6">
							<label>Tạm trú</label>
							<form:input class="form-control" type="text" path="noiTamTru" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Điện thoại</label>
							<form:input class="form-control" type="text" path="soDienThoai" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Email</label>
							<form:input class="form-control" type="text" path="email" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Chứng minh</label>
							<form:input class="form-control" type="text" path="soCMND" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Nơi cấp</label>
							<form:input class="form-control" type="text" path="noiCap" />

							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Ngày cấp</label>
							<form:input class="form-control" type="Date" path="ngayCap" />
							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Trạng thái</label>
							<form:input class="form-control" type="text" path="trangThai" />
							<br>
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
<script type="text/javascript">
	 function selectThanhPho(){
    	 var maThanhPho = $("#idThanhPho").val(); /* when click thanh pho */
    	 $('#idQuanHuyen option').remove();
    	 $('#idPhuongXa option').remove();
    		
         $.ajax({
        	 url: "/FBMS/QuanTriNhanSu/chonquan/" + maThanhPho, 
        	 dataType: "json",
        	 success: function(data){
        		 alert('Hello');
        		$('#idQuanHuyen').append($('<option>', { // insert default data in quan huyen
             		    value: 'noQuanHuyen',
             		    text: 'Chọn Quận Huyện'
             		}));
        		$('#idQuanHuyen option[value=noQuanHuyen]').attr('disabled', true);
        		
        		for (var i = 0; i < data.length; i++) { // insert new data in quan huyen
        			$('#idQuanHuyen').append($('<option>', {
             		    value: data[i].maQuanHuyen,
             		    text: data[i].tenQuanHuyen
             		}));
				}
        		
        		$('#idPhuongXa').append($('<option>', { // insert default data in quan huyen
         		    value: 'quanHuyen',
         		    text: 'Chọn Xã Phường'
         		}));
    		$('#idPhuongXa option[value=quanHuyen]').attr('disabled', true);
        		
        	
         }});
     };
	 </script>
	 
	 <!-- chon quan huyen ra xa phuong -->
	 
	  <script type="text/javascript">
	 function selectQuan(){
    	 var maThanhPho = $("#idQuanHuyen").val(); /* when click thanh pho */
    	 $('#idPhuongXa option').remove();
    		
         $.ajax({
        	 url: "/FBMS/QuanTriNhanSu/chonXaPhuong/" + maThanhPho, 
        	 dataType: "json",
        	 success: function(data){
        		 alert('Hello');
        		$('#idPhuongXa').append($('<option>', { // insert default data in quan huyen
             		    value: 'phuongxa',
             		    text: 'Chọn Xã Phường'
             		}));
        		$('#idPhuongXa option[value=phuongxa]').attr('disabled', true);
        		
        		for (var i = 0; i < data.length; i++) { // insert new data in quan huyen
        			$('#idPhuongXa').append($('<option>', {
             		    value: data[i].maXaPhuong,
             		    text: data[i].tenXaPhuong
             		}));
				}
        		
        	
         }});
     };
	 </script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />

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


