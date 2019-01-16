<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<!-- code here -->
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">
					<spring:message code="tailieu.phongBan" />
				</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<%=request.getContextPath()%>/home"><spring:message
										code="tailieu.home" /></a></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div style="text-align: center; color: red;">
			<h1>
				<spring:message code="tailieu.phongBan" />
			</h1>
			<form method="GET" action="/FBMS/quanlytailieu/DocumentPB">

				<select class="form-control" name="tlPhongBanId">
					<option disabled="disabled"><spring:message
							code="tailieu.phongBan" /></option>
					<option value="">Tất cả</option>
					<c:forEach items="${listQuyen}" var="pb">

						<option value="${pb.maPhongBan}">${pb.tenPhongBan}</option>
					</c:forEach>
				</select> <input class="btn btn-success" type="submit" value="Xem">
			</form>
		</div>
		<!-- ================-- form nhập dữ liệu --====================== -->

		<!-- ============= kết thúc nhập form dữ liệu ở đây ============= -->
	</div>
</div>
<!-- code here end  -->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
