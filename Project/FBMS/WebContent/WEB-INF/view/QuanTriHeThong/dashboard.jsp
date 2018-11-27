<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.dash-board-item {
	margin-bottom: 50px;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.QuanTriHeThong" /></h3>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="row">
				<div class="col-xs-12">
					<div class="card">
						<div class="col-md-3 dash-board-item">
							<a
								href="<c:url value="/QuanTriHeThong/phong_ban/view/danhSachPhongBan" />"
								title=""> <img
								src="<c:url value="/resources/images/icon_category.gif" />"
								alt="" />
							</a>
							<div><spring:message code="label.QuanTriHeThong.PhongBan" /></div>
						</div>
						<div class="col-md-3 dash-board-item">
							<a
								href="<c:url value="/QuanTriHeThong/chuc_danh/view/danhSachChucDanh" />"
								title=""> <img
								src="<c:url value="/resources/images/icon_category.gif" />"
								alt="" />
							</a>
							<div><spring:message code="label.QuanTriHeThong.ChucDanh" /></div>
						</div>
						<div class="col-md-3 dash-board-item">
							<a href="<c:url value="/QuanTriHeThong/tai-khoan/" />" title=""> <img
								src="<c:url value="/resources/images/icon_category.gif" />"
								alt="" />
							</a>
							<div><spring:message code="label.QuanTriHeThong.TaiKhoan" /></div>
						</div>
						<div class="col-md-3 dash-board-item">
							<a href="<c:url value="/QuanTriHeThong/chuc-nang-phong-ban" />" title=""> <img
								src="<c:url value="/resources/images/icon_category.gif" />"
								alt="" />
							</a>
							<div><spring:message code="label.QuanTriHeThong.PhanQuyenBoSung" /></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />