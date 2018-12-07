<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="container">
		<nav aria-label="Page navigation example">
			<ul class="pagination">

				<c:if test="${indexPage > 1}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Framework/1" class="page-link">First</a></li>
				</c:if>


				<c:if test="${indexPage > 1}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Framework/${indexPage-1}"
						class="page-link">${indexPage-1}</a></li>
				</c:if>


				<li class="page-item"><a
					href="/FBMS/Quan_Ly_Du_An/List_Framework/${indexPage}"
					class="page-link">${indexPage}</a></li>


				<c:if test="${indexPage < allPage}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Framework/${indexPage+1}"
						class="page-link">${indexPage+1}</a></li>
				</c:if>

				<c:if test="${indexPage < allPage}">
					<li class="page-item"><a
						href="/FBMS/Quan_Ly_Du_An/List_Framework/${allPage}"
						class="page-link">Last</a></li>
				</c:if>

			</ul>
		</nav>
		<div class="content-header-right ">
			<div role="group" aria-label="Button group with nested dropdown"
				class="btn-group float-md-right" id="add-new">
				<a href="<c:url value = "/Quan_Ly_Du_An/Add_Framework"/>"
					class="btn btn-primary"><span class="fa fa-plus"></span> Thêm
					mới</a>
			</div>
		</div>

		<table class="table table-striped">
			<tr>
				<th>Mã Framework</th>
				<th>Tên Framework</th>
				<th>Ghi chú</th>
				<th>Action</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.maFramework}</td>
					<td>${emp.tenFramework}</td>
					<td>${emp.ghiChu}</td>
					<td><a href="/FBMS/Quan_Ly_Du_An/Edit_Framework/${emp.maFramework}"
						class="btn btn-primary">edit</a> <a
						href="/FBMS/Quan_Ly_Du_An/Delete_Framework/${emp.maFramework}"
						class="btn btn-danger">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />