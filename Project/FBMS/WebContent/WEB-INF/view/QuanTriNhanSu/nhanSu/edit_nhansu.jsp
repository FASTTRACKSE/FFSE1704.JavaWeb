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
				<h3 class="content-header-title mb-0">Sửa công việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									sách công việc </a></li>
							<li class="breadcrumb-item active">Sửa công việc</li>
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
						<div class="form-group">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="maNhanVien" />

							<br>
						</div>
						<div class="form-group">
							<label>Mã Phòng Ban:</label>
							<form:input class="form-control" type="text"
								path="phongBan.maPhongBan" />

							<br>
						</div>
						<div class="form-group">
							<label>Mã Chức Danh</label>
							<form:input class="form-control" type="text"
								path="chucDanh.maChucDanh" />
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
							<label>Ảnh</label> <input id="upload" type="file"
								class="form-control-file" name="file"> <br>
						</div>
						<div class="form-group">
							<label>Năm Sinh</label>
							<form:input class="form-control" type="Date" path="namSinh" />
							<br>
						</div>
						<div class="form-group">
							<label>Giới tính:</label>
							<%-- <form:input class="form-control" type="text" path="gioiTinh" /> --%>

							Male
							<form:radiobutton path="gioiTinh" value="1" />
							Female
							<form:radiobutton path="gioiTinh" value="2" />

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
							<form:input class="form-control" type="text"
								path="quocTich.maQuocTich" />
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
							<td><input type="submit" value="Save" /></td>
						</tr>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
