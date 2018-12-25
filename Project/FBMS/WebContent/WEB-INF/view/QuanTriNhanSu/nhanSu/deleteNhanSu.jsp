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
				<h3 class="content-header-title mb-0">Xóa nhân sự</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriNhanSu/danhsach_nhansu/" />'>Danh
									sách Nhân sự </a></li>
							<li class="breadcrumb-item active">Xóa Thông tin nhân sư</li>
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
							<label>Phòng Ban:</label>
							<form:select path="maPhongBan" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listPhongBan}" var="lpb">
									<form:option value="${lpb.maPhongBan}"
										label="${lpb.tenPhongBan}" />
								</c:forEach>
							</form:select>

							<br>
						</div>
						<div class="form-group">
							<label>Chức Danh</label>
							<form:select path="maChucDanh" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listChucDanh}" var="lcd">
									<form:option value="${lcd.maChucDanh}"
										label="${lcd.tenChucDanh}" />
								</c:forEach>
							</form:select>
							<br>
						</div>
						<div class="form-group col-sm-6">
							<label>Tinh thanh</label>

							<form:select path="tinhThanhPho"
								class="custom-select block round" id="customSelect">
								<c:forEach items="${listTinhThanh}" var="ltt">
									<form:option value="${ltt.matp}" label="${ltt.name}" />
								</c:forEach>
							</form:select>

						</div>

						<div class="form-group col-sm-6">
							<label>Quan Huyen</label>

							<form:select path="maQuanHuyen" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listQuanHuyen}" var="lqh">
									<form:option value="${lqh.maqh}" label="${lqh.name}" />
								</c:forEach>
							</form:select>

						</div>

						<div class="form-group col-sm-6">
							<label>Xa Phuong</label>

							<form:select path="maXaPhuong" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${listXaPhuong}" var="lxp">
									<form:option value="${lxp.xaid}" label="${lxp.name}" />
								</c:forEach>
							</form:select>

						</div>
						<br>
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
							<td><input type="submit" class="btn btn-success"
								name="delete" /></td>
							<td><input type="submit" class="button" name="cancel"
								value="Cancel" /></td>
						</tr>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
