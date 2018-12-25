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
				<h3 class="content-header-title mb-0">Sửa Bằng cấp</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh
									bằng cấp </a></li>
							<li class="breadcrumb-item active">Sửa bằng cấp</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="post" 
						action="/FBMS/ViewBC/update"
						modelAttribute="bangCap">

						<div class="form-group">

							<form:hidden path="id" />
							<br>

						</div>
						<div class="form-group">
							<label>Mã Nhân Viên:</label>
							<form:input class="form-control" type="text" path="nhanSu.maNhanVien" />

							<br>
						</div>
						
						<div class="form-group">
							<label>Trình độ:</label>
							<form:input class="form-control" type="text" path="trinhDo.id" />

							<br>
						</div>
						<div class="form-group">
							<label>Tên ngành:</label>
							<form:input class="form-control" type="text" path="tenNganh" />

							<br>
						</div>
						<div class="form-group">
							<label>Thời gian:</label>
							<form:input class="form-control" type="Date" path="thoiGian" />

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
