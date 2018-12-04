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
				<h3 class="content-header-title mb-0">Thêm mới chức danh</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									sách chức danh</a></li>
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
					
					
					<form:form method="POST" modelAttribute="themDon"
						action="luunhap">
						<div class="form-group col-sm-6">
							<label>Mã Nhân Viên</label>
							<form:input class="form-control" path="maNhanVien"
								placeholder="Mã Nhân Viên" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời Gian Bắt Đầu</label>
							<form:input type="date" class="form-control" path="tgBatDau"
								placeholder="Thời Gian Bắt Đầu" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời Gian Kết Thúc</label>
							<form:input type="date" class="form-control" path="tgKetThuc"
								placeholder="Thời Gian Kết Thúc" />
						</div>
						<div class="form-group col-sm-6">
							<label>Lý Do</label>
							<form:select path="loaihinhentity" class="custom-select block round"
								id="customSelect" >
								<c:forEach items="${lydo}" var="ld">
									<form:option value="${ld.maNghiPhep}" label="${ld.tenNghiPhep}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>So Ngay Nghi</label>
							<form:input  class="form-control" path="soNgayNghi"
								placeholder="So Ngay Nghi" />
								
						</div>
						
						<div class="form-group col-sm-6">
							<label>Trạng Thái</label>
							<form:input class="form-control" path="trangThai"
								placeholder="Mã Nhân Viên" />
						</div>

						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông
								tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
