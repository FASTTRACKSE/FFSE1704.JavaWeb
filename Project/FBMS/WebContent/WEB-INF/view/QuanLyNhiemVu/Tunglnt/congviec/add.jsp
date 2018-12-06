<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Tạo Mới Công Việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item active">Tạo mới công việc</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

	
	
			<form class="form">
			<form:form class="form" method="POST" modelAttribute="CongViec"
						action="/FBMS/TunglntQuanLyNhiemVu/CongViec/AddCongViec">
						
							<div class="form-body">
							
								
                                <div class="form-group">
									<label for="issueinput5">Dự Án</label>
									<select id="issueinput5" name="priority" class="form-control" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Priority" data-original-title="" title="">
										<option value="low">Low</option>
										<option value="medium">Medium</option>
										<option value="high">High</option>
									</select>
								</div>                                
                        
								<div class="form-group">
									<label for="issueinput1">Tên Công Việc</label>
									<input type="text" id="issueinput1" class="form-control" placeholder="Tên Công Việc" name="issuetitle" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Tên Công Việc" data-original-title="" title="">
								</div>
								
								<div class="form-group">
									<label for="issueinput8">Mô Tả</label>
									<textarea id="issueinput8" rows="5" class="form-control" name="comments" placeholder="Thêm Mô Tả" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Mô Tả" data-original-title="" title=""></textarea>
								</div>
								
								<div class="form-group">
									<label for="issueinput5">Loại Công Việc</label>
									<select id="issueinput5" name="priority" class="form-control" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Priority" data-original-title="" title="">
										<option value="low">Low</option>
										<option value="medium">Medium</option>
										<option value="high">High</option>
									</select>
								</div>
								

								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="issueinput3">Thời Gian Bắt Đầu</label>
											<input type="date" id="issueinput3" class="form-control" name="dateopened" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Date Opened" data-original-title="" title="">
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="issueinput4">Thời Gian Kết Thúc</label>
											<input type="date" id="issueinput4" class="form-control" name="datefixed" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Date Fixed" data-original-title="" title="">
										</div>
									</div>
								</div>


								<div class="form-group">
									<label for="issueinput5">Phân Công Cho</label>
									<select id="issueinput5" name="priority" class="form-control" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Priority" data-original-title="" title="">
										<option value="low">Low</option>
										<option value="medium">Medium</option>
										<option value="high">High</option>
									</select>
								</div>

								<div class="form-group">
									<label for="issueinput6">Trạng Thái</label>
									<select id="issueinput6" name="status" class="form-control" data-toggle="tooltip" data-trigger="hover" data-placement="top" data-title="Status" data-original-title="" title="">
										<option value="not started">Not Started</option>
										<option value="started">Started</option>
										<option value="fixed">Fixed</option>
									</select>
								</div>

								

							</div>

							<div class="form-actions">
								<button type="button" class="btn btn-warning mr-1">
									<i class="ft-x"></i> Cancel
								</button>
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-check-square-o"></i> Save
								</button>
							</div>
							</form:form>
						</form>
	
	
	
	
	
	
	
</div>
</div>

<script type="text/javascript">
	window.onload = function() {
		$('#confirm-delete').on(
				'show.bs.modal',
				function(e) {
					$(this).find('.btn-ok').attr('href',
							$(e.relatedTarget).data('href'));
				});
		$('#datatable').dataTable().fnDestroy();
		$("#datatable").dataTable({
			responsive : true,
			"order" : [ [ 1, "asc" ], [ 0, "desc" ] ],
			"bServerSide" : true,
			"sAjaxSource" : "/FBMS/TunglntQuanLyNhiemVu/CongViec/ListCongViec",
		});
	};
	window.setTimeout(function() {
		$(".alert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2500);
</script>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />