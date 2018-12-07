<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="container">
		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">Thêm mới Framework</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb" >
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
									<li class="breadcrumb-item active">Quản lý dự án</li>
									<li class="breadcrumb-item active">Quản lý danh mục</li>
									<li class="breadcrumb-item"><a
									href='<c:url value="/Quan_Ly_Du_An/List_Framework/1" />'>Framework</a></li>
								<li class="breadcrumb-item active">Thêm mới Framework</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- End Path -->
		</div>
		<form:form method="post" action="Save_Framework">
			<div class="form-body">

				<div class="form-group">
					<label for="issueinput1">Mã Framework</label>
					<form:input path="maFramework" class="form-control"
						placeholder="VD: FW01" />
					<form:errors path="maFramework" cssStyle="color: red" />
					<strong style="color:red;">${mess}</strong>
				</div>

				<div class="form-group">
					<label for="issueinput2">Tên Framework</label>
					<form:input path="tenFramework" class="form-control"
						placeholder="VD: Spring" />
					<form:errors path="tenFramework" cssStyle="color: red" />
				</div>

				<div class="form-group">
				<label for="issueinput2">Ghi Chú</label>
					<form:input path="ghiChu" class="form-control"
						placeholder="VD: 1" />
				</div>

				<div class="form-actions">
				
					<button type="button" class="btn btn-warning mr-1">
						<i class="ft-x"></i> Cancel
					</button>
					<button type="submit" class="btn btn-primary">
						<i class="fa fa-check-square-o"></i> Save
					</button>
				</div>
			</div>

		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />