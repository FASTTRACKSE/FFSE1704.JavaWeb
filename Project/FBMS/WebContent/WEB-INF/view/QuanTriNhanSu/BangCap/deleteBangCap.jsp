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
				<h3 class="content-header-title mb-0">Xóa Bằng cấp</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									bằng cấp </a></li>
							<li class="breadcrumb-item active">Xóa bằng cấp</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
				<div class="form-group col-md-12">

									<div class="main-content">
										<div class="row">
											<p>
												<img src="<c:url value="/uploads/${bangCap.anhDaiDien}"/>"
													style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; height: 150px; display: block; margin-left: auto; margin-right: auto;">
											</p>
											<h1 style="text-align: center; color: green">
												${bangCap.hoLot} ${bangCap.ten}</a>
											</h1>
											<p style="text-align: center;">
												<a>Mã nhân viên:</a> ${bangCap.maNhanVien}
											</p>
											<p style="text-align: center;">
												<a>Ngày sinh:</a> <fmt:formatDate value="${bangCap.namSinh}"
														pattern="dd-MM-yyyy" />
											</p>
											<p style="text-align: center;">
												Phòng ban:<a>${pbcd.phongBan.tenPhongBan}</a> - Chức vụ:<a>${pbcd.chucDanh.tenChucDanh}</a>
											</p>
										</div>
									</div>
								</div>
					<form:form method="post" 
						action="/FBMS/ViewBC/delete/${bangCap2.id}&${bangCap.maNhanVien}"
						modelAttribute="bangCap2">

						<div class="form-group">

							<form:hidden path="id" />
							<br>

						</div>
						<div class="form-group">
							<label>Mã Nhân Viên:</label>
							<form:input  class="form-control" type="hidden" path="maNhanVien"  />

							<br>
						</div>
						
						<div class="form-group">
							<label>Trình độ:</label>
							<form:input class="form-control" type="text" path="IdtrinhDo" />

							<br>
						</div>
						<div class="form-group">
							<label>Tên ngành:</label>
							<form:input class="form-control" type="text" path="tenNganh" />

							<br>
						</div>
						<div class="form-group">
							<label>Thời gian:</label>
							<form:input class="form-control" type="Date" path="batDau" />

							<br>
						</div>
						
						<div class="form-group">
							<label>Thời gian:</label>
							<form:input class="form-control" type="Date" path="ketThuc" />

							<br>
						</div>
						
						<div class="form-group">
							<label>Xếp loại:</label>
							<form:input class="form-control" type="text" path="xepLoai" />

							<br>
						</div>
						
						<div class="form-group">
							<label>Nơi cấp:</label>
							<form:input class="form-control" type="text" path="noiCap" />

							<br>
						</div>
						<tr>
							<td><input class="btn btn-primary" type="submit" value="Save" /></td>
							<td><a class="btn btn-danger" href="/FBMS/ViewBC/${bangCap.maNhanVien}" >Back</a></td>
						</tr>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
