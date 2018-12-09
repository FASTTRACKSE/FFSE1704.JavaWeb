<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SỬA NHÂN SỰ</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">
		<h1 style="text-align: center;">DELETE NHAN SU</h1>
		<form:form method="post"  action="" modelAttribute="nhanSu">
			
			<div class="form-group">
				
				<form:hidden path="id" />
				<br>

			</div>
			<div class="form-group">
				<label>Mã Nhân Viên:</label>
				<form:input class="form-control" type="text" path="maNhanVien" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Mã Phòng Ban:</label>
				<form:input class="form-control" type="text" path="phongBan.maPhongBan" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Mã Chức Danh</label>
				<form:input class="form-control" type="text" path="chucDanh.maChucDanh" />
				<br>
			</div>
			<div class="form-group">
				<label>Họ đệm</label>
				<form:input class="form-control" type="text" path="hoLot" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Tên</label>
				<form:input class="form-control" type="text" path="ten" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Ảnh</label>
				<input id="upload" type="file"
					class="form-control-file" name="file">
				<br>
			</div>
			<div class="form-group">
				<label>Năm Sinh</label>
				<form:input class="form-control" type="Date" path="namSinh" />
				<br>
			</div>
			<div class="form-group">
				<label>Giới tính:</label>
				<%-- <form:input class="form-control" type="text" path="gioiTinh" /> --%>
				
				Male <form:radiobutton path="gioiTinh" value="1"/>  
       			Female <form:radiobutton path="gioiTinh" value="2"/>  
				
				<br>
			</div>
			<div class="form-group">
				<label>Quê quán</label>
				<form:input class="form-control" type="text" path="queQuan" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Dân tộc</label>
				<form:input class="form-control" type="text" path="danToc" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Quốc Tịch</label>
				<form:input class="form-control" type="text" path="quocTich.maQuocTich" />
				<br>
			</div>
			
			<div class="form-group">
				<label>Tạm trú</label>
				<form:input class="form-control" type="text" path="noiTamTru" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Điện thoại</label>
				<form:input class="form-control" type="text" path="soDienThoai" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input class="form-control" type="text" path="email" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Chứng minh</label>
				<form:input class="form-control" type="text" path="soCMND" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Nơi cấp</label>
				<form:input class="form-control" type="text" path="noiCap" />
				
				<br>
			</div>
			<div class="form-group">
				<label>Ngày cấp</label>
				<form:input class="form-control" type="Date" path="ngayCap" />
				<br>
			</div>
			<div class="form-group">
				<label>Trạng thái</label>
				<form:input class="form-control" type="text" path="trangThai" />
				<br>
			</div>
			<tr>
				<td></td>
				<td><input type="submit" class="btn btn-success"  name="delete" /></td>
				<td><input type="submit" class="button" name="cancel"
				value="Cancel" /></td>
			</tr>
		</form:form>
	</div>
</body>
</html>