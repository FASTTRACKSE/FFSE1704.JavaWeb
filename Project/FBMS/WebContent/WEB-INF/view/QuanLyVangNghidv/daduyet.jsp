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
.ques {
	color: darkslateblue;
}
.switch {
	position: relative;
	display: inline-block;
	width: 130px;
	height: 50px;
}
.switch input {
	display: none;
}
.slider {
	position: absolute;
	cursor: pointer;
	overflow: hidden;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: #f2f2f2;
	-webkit-transition: .4s;
	transition: .4s;
}
.slider:before {
	position: absolute;
	z-index: 2;
	content: "";
	height: 48px;
	width: 48px;
	left: 2px;
	bottom: 2px;
	background-color: darkslategrey;
	-webkit-box-shadow: 0 2px 5px rgba(0, 0, 0, 0.22);
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.22);
	-webkit-transition: .4s;
	transition: all 0.4s ease-in-out;
}
.slider:after {
	position: absolute;
	left: 0;
	z-index: 1;
	content: "Đã duyệt";
	font-size: 15px;
	text-align: left !important;
	line-height: 47px;
	padding-left: 0;
	width: 130px;
	color: #fff;
	height: 50px;
	border-radius: 50px;
	background-color: #ff6418;
	-webkit-transform: translateX(-80px);
	-ms-transform: translateX(-80px);
	transform: translateX(-80px);
	transition: all 0.4s ease-in-out;
}
input:checked+.slider:after {
	-webkit-transform: translateX(0px);
	-ms-transform: translateX(0px);
	transform: translateX(0px);
	/*width: 120px;*/
	padding-left: 13px;
}
input:checked+.slider:before {
	background-color: #fff;
}
input:checked+.slider:before {
	-webkit-transform: translateX(80px);
	-ms-transform: translateX(80px);
	transform: translateX(80px);
}
/* Rounded sliders */
.slider.round {
	border-radius: 50px;
}
.slider.round:before {
	border-radius: 50%;
}
.absolute-no {
	position: absolute;
	left: 0;
	color: darkslategrey;
	text-align: right !important;
	font-size: 12px;
	width: calc(100% - 13px);
	height: 50px;
	line-height: 47px;
	cursor: pointer;
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
									<center>
										<h3 class="panel-title">
											<b>Danh Sách Đơn Phê Duyệt</b>
										</h3>
									</center>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<div class="tab-content">
								<div class="tab-pane active" id="list">
									<table class=" table-striped table-bordered table-list">
										<thead>
											<tr>
												<th>Mã Nhân Viên</th>
												<th>Họ Và Tên</th>
												<th>Lý Do</th>
												<th>Ghi Chú</th>
												<th>Phòng Ban</th>
												<th>Thời gian Từ</th>
												<th>Đến Thời gian</th>
												<th>Tình Trạng</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="dn" varStatus="counter" items="${list}">
												<tr>
													<td>${dn.getIdnv()}</td>
													<td>${dn.getTennv()}</td>
													<td>${dn.getLydo()}</td>
													<td>${dn.getGhichu()}</td>
													<td>${dn.getPhongban()}</td>
													<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dn.getTgbatdau()}" /></td>
													<td><fmt:formatDate pattern="yyyy-MM-dd" value="${dn.getTgketthuc()}" /></td>
													<td>Đã Được Duyệt</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<!-- END id="list" -->



							</div>
							<!-- END tab-content -->
						</div>
					</div>
					<!--END panel-table-->
					<center>
						

							<c:if test="${page gt 1}">
									<a href="/ffse-fbms/QuanLyVangNghi/daduyet/1"><button type="button"
											class="btn btn-warning btn-circle">first</button></a>
									<a href="/ffse-fbms/QuanLyVangNghi/daduyet/${page-1}"><button type="button"
											class="btn btn-warning btn-circle">${page -1}</button></a>
								</c:if>
							<a><button type="button"
										class="btn btn-sucess btn-circle">${page}</button></a>
							<c:if test="${page lt soTrang}">

									<a href="/ffse-fbms/QuanLyVangNghi/daduyet/${page+1}"><button type="button"
											class="btn btn-warning btn-circle">${page +1}</button></a>
									<a href="/ffse-fbms/QuanLyVangNghi/daduyet/${soTrang}"><button type="button"
											class="btn btn-warning btn-circle">last</button></a>
								</c:if>
						
					</center>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>