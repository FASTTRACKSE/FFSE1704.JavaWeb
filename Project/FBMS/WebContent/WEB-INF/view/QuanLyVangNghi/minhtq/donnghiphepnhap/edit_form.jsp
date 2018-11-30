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
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
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
					<form:form method="POST" modelAttribute="command" action="">
						<div class="form-group col-sm-6">
							<label>Mã nhân viên</label>
							<form:input class="form-control" path="maNhanVien"
								placeholder="nhập mã nhân viên" />
							<form:errors path="maNhanVien" cssClass="error" />
						</div>
						
						<div class="form-group col-sm-6">
							<label>Số lượng </label>
							<form:input class="form-control" path="soLuong"
								placeholder="số lượng" />
							<form:errors path="soLuong" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu </label>
							<form:input class="form-control" type="date"
								path="thoiGianBatDau" placeholder="" />
							<form:errors path="thoiGianBatDau" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian kết thúc </label>
							<form:input class="form-control" type="date"
								path="thoiGianKetThuc" placeholder="" />
							<form:errors path="thoiGianKetThuc" cssClass="error" />

						</div>

						<div class="form-group col-md-6">
							<label for="location1">Loại ngày nghỉ </label>
							<form:select path="loaiNgayNghi"
								class="custom-select form-control" id="location1"
								name="location" items="${countryList}"
								itemValue="tenLoaiNgayNghi" itemLabel="maLoaiNgayNghi">
								
							</form:select>
						</div>


						<div class="row">
							<div class="col-md-7"></div>
							<div class="col-md-3">
								<button type="submit"
									class="btn btn-outline-danger round  mr-1 mb-1"
									formaction="<%=request.getContextPath()%>/">lưu nháp</button>
								<button type="submit"
									class="btn btn-outline-success round  mr-1 mb-1"
									formaction="<%=request.getContextPath()%>/">gửi</button>

							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
