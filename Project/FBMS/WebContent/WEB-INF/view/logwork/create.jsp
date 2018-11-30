<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-body">
			<div class="row" id="default">
				<div class="col-xs-12">
					<form:form action="" method="POST" modelAttribute="logwork">
						<div class="form-group">
							<label for="tenCongViec">Tên công việc</label>
							<form:input class="form-control" path="tenCongViec"
								placeholder="Nhập tên công việc" />
						</div>
						<div class="form-group">
							<label for="moTa">Mô tả</label>
							<form:input type="text" class="form-control" path="moTa"
								placeholder="Nhập mô tả công việc" />
						</div>
						<div class="form-group">
							<label for="thoiGianBatDau">Ngày bắt đầu</label>
							<form:input type="text" class="form-control"
								path="thoiGianBatDau" />
						</div>
						<div class="form-group">
							<label for="thoiGianKetThuc">Ngày kết thúc</label>
							<form:input type="text" class="form-control"
								path="thoiGianKetThuc" />
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>

				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />