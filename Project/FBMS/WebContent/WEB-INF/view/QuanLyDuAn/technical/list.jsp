<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="container">

		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-6 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">Danh sách Technical</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item active">Quản lý dự án</li>
								<li class="breadcrumb-item active">Quản lý danh mục</li>
								<li class="breadcrumb-item"><a
									href='<c:url value="/Quan_Ly_Du_An/List_Technical/1" />'>Technical</a></li>
								<li class="breadcrumb-item active">Danh sách Technical</li>
							</ol>
						</div>
					</div>
				</div>
			</div>
			<!-- End Path -->
		</div>
		<nav aria-label="Page navigation example">
			<ul class="pagination">

				<c:if test="${indexPage > 1}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Technical/1" class="page-link">First</a></li>
				</c:if>


				<c:if test="${indexPage > 1}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Technical/${indexPage-1}"
						class="page-link">${indexPage-1}</a></li>
				</c:if>


				<li class="page-item"><a
					href="/FBMS/Quan_Ly_Du_An/List_Technical/${indexPage}"
					class="page-link">${indexPage}</a></li>


				<c:if test="${indexPage < allPage}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Technical/${indexPage+1}"
						class="page-link">${indexPage+1}</a></li>
				</c:if>

				<c:if test="${indexPage < allPage}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Technical/${allPage}"
						class="page-link">Last</a></li>
				</c:if>

			</ul>
		</nav>
		<div class="content-header-right ">
			<div role="group" aria-label="Button group with nested dropdown"
				class="btn-group float-md-right" id="add-new">
				<a href="<c:url value = "/Quan_Ly_Du_An/Add_Technical"/>"
					class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
					mới</a>
			</div>
		</div>

		<table class="table table-striped">
			<tr>
				<th>Tên Technical</th>
				<th>Mã Technical</th>
				<th>Ghi chú</th>
				<th>Action</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.tenTechnical}</td>
					<td>${emp.maTechnical}</td>
					<td>${emp.ghiChu}</td>
					<td><a href="/FBMS/Quan_Ly_Du_An/Edit_Technical/${emp.maTechnical}"
						class="btn btn-primary">edit</a> <a
						href="/FBMS/Quan_Ly_Du_An/Delete_Technical/${emp.maTechnical}"
						class="btn btn-danger">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />