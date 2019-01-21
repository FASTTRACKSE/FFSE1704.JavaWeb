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
						</div>
						<div class="form-group col-md-4">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien" />
						</div>
						
							<div class="form-group col-md-4">
							<label>Tỉnh thành</label>
							
							 <form:select path="tinhThanhPho"
								class="custom-select block round" id="idThanhPho" onchange="selectThanhPho()">
								<c:forEach items="${listTinhThanh}" var="ltt">
									<form:option value="${ltt.matp}" label="${ltt.name}" />
								</c:forEach>
							</form:select> 
						</div>
						<div class="form-group col-sm-4">
							<label>Quận Huyện</label>
							 <form:select path="maQuanHuyen"
								class="custom-select block round" id="idQuanHuyen" onchange="selectQuan()">
								<option value="" selected="selected" disabled="disabled">Chọn quận huyện</option>
								<c:forEach items="${listQuanHuyen}" var="lqh">
									<form:option value="${lqh.maqh}" label="${lqh.name}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-4">
							<label>Xã Phường</label>
							 <form:select path="maXaPhuong"
								class="custom-select block round" id="idPhuongXa" >
								<option value="" selected="selected" disabled="disabled">Chọn xã phường</option>
								<c:forEach items="${listXaPhuong}" var="lxp">
									<form:option value="${lxp.xaid}" label="${lxp.name}" />
								</c:forEach>
							</form:select> 
						</div>
						<div class="form-group col-sm-4">
							<label>Họ đệm</label>
							<form:input class="form-control" type="text" path="hoLot" />

						</div>
						<div class="form-group col-sm-4">
							<label>Tên</label>
							<form:input class="form-control" type="text" path="ten" />
						</div>
						<div class="form-group col-sm-4">
							<label>Ảnh</label> <input id="imgUrl" class="form-control"
						type="file" name="file" /> <br>
						<form:hidden path="anhDaiDien" />
						 <img src="<c:url value="/uploads/${nhanSu.anhDaiDien}" />"
						width="100" height="150">
						<img id="img" src="#"
						alt="your image" width="100" height="150" />
						</div>
						<div class="form-group col-sm-4">
							<label>Năm Sinh</label>
							<form:input class="form-control" type="Date" path="namSinh" />
						</div>
						<div class="form-group col-sm-4">
							<label>Giới tính:</label>
							Male
							<form:radiobutton path="gioiTinh" value="1" />
							Female
							<form:radiobutton path="gioiTinh" value="2" />

						</div>
						<div class="form-group col-sm-4">
							<label>Quê quán</label>
							<form:input class="form-control" type="text" path="queQuan" />

						</div>
						<div class="form-group col-sm-4">
							<label>Dân tộc</label>
							<form:input class="form-control" type="text" path="danToc" />
						</div>
						<div class="form-group col-sm-4">
							<label>Quốc Tịch</label>
							<form:select path="maQuocTich"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${listQuocTich}" var="lqt">
									<form:option value="${lqt.maQuocTich}" label="${lqt.tenQuocTich}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-4">
							<label>Tạm trú</label>
							<form:input class="form-control" type="text" path="noiTamTru" />
						</div>
						<div class="form-group col-sm-4">
							<label>Điện thoại</label>
							<form:input class="form-control" type="text" path="soDienThoai" />
						</div>
						<div class="form-group col-sm-4">
							<label>Email</label>
							<form:input class="form-control" type="text" path="email" />
						</div>
						<div class="form-group col-sm-4">
							<label>Chứng minh</label>
							<form:input class="form-control" type="text" path="soCMND" />
						</div>
						<div class="form-group col-sm-4">
							<label>Nơi cấp</label>
							<form:input class="form-control" type="text" path="noiCap" />
						</div>
						<div class="form-group col-sm-4">
							<label>Ngày cấp</label>
							<form:input class="form-control" type="Date" path="ngayCap" />
						</div>
						<div class="form-group col-sm-4">
							<label>Trạng thái</label>
							<form:select path="idTrangThai"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${listTrangThai}" var="ltt">
									<form:option value="${ltt.idTrangThai}" label="${ltt.name}" />
								</c:forEach>
							</form:select>
						</div>
						
							<input class="btn btn-primary" type="submit" value="Save" />
							<a class="btn btn-danger" href="/FBMS/QuanTriNhanSu/danhsach_nhansu/" >Back</a>
						
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


