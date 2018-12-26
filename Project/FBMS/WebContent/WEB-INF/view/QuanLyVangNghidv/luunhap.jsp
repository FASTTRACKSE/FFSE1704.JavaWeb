<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
/*By DjelalEddine@gmail.com*/
/*Card*/
#user .panel-thumb {
	text-align: center;
}
/* table*/
#user .panel-table {
	animation-duration: 2s;
}
#user .panel-table .panel-body .table {
	margin: 0px;
}
#user .panel-table .panel-body {
	padding: 0px;
}
#user .panel-table .panel-body .table-bordered>thead>tr>th {
	text-align: center;
}
td {
	padding: 5px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<div class="container" style="margin-top: 20px;">
				<div class="row">
					<div id="user" class="col-md-12">
						<div class="panel panel-primary panel-table animated slideInDown">
							<div class="panel-heading " style="padding: 5px;">
								<div class="row">
									<div class="col col-xs-3 text-left"></div>
									<div class="col col-xs-5 text-center">
										<h3 class="panel-title">
											<b>Danh Sách Lưu Nháp</b>
										</h3>
									</div>
									<div class="col col-xs-2 well text-center"
										style="padding: 1px;">
										<button type="button" class="btn  btn-warning ">DANH
											SÁCH</button>
									</div>
									<div class="col col-xs-2 text-right ">
										<a href="donxinnghi">
											<button type="button" class="btn  btn-success ">
												Thêm Mới <i class="fa fa-plus-square"></i>
											</button>
										</a>

									</div>
								</div>
							</div>
							<div class="panel-body">
								<div class="tab-content">
									<div role="tabpanel" class="tab-pane active" id="list">
										<table class=" table-striped table-bordered table-list">
											<thead>
												<tr>
													<th>Mã Nhân Viên</th>
													<th>Tên Nhân Viên</th>
													<th>Lý Do</th>
													<th>Phòng Ban</th>
													<th>Ngày Bắt Đầu</th>
													<th>Ngày Kết Thúc</th>
													<th>Ghi Chú</th>
													<th>Chức năng</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach var="dn" varStatus="counter" items="${list}">
													<tr>
														<td>${dn.getIdnv()}</td>
														<td>${dn.getTennv()}</td>
														<td>${dn.getLydo()}</td>
														<td>${dn.getPhongban()}</td>
														<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dn.getTgbatdau()}" /></td>
														<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dn.getTgketthuc()}" /></td>
														<td>${dn.getGhichu()}</td>

														<td><a href="edit/${dn.getIddon()}"><button
																	type="button" class="btn btn-warning btn-circle">Sửa</button></a>
															<a href="delete/${dn.getIddon()}"><button
																	type="button" class="btn btn-danger btn-circle">Xoá</button></a>
															<a href="savechoduyetnhap/${dn.getIddon()}"><button
																	type="button" class="btn btn-danger btn-circle">Gửi
																	Đơn</button></a></td>
													</tr>
												</c:forEach>
											</tbody>


										</table>
										<br>
										<center><a href="donxinnghi">
													<button type="button" class="btn btn-warning mr-1">
														<i class="fa fa-arrow-circle-left"></i> Quay lại
													</button>
												</a></center>
									</div>
									<!-- END id="list" -->



								</div>
								<!-- END tab-content -->
							</div>
						</div>
						<!--END panel-table-->
					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>