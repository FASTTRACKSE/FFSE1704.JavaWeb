<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
	box-sizing: border-box
}

/* Set height of body and the document to 100% */
body, html {
	height: 100%;
	margin: 0;
	font-family: Arial;
}

/* Style tab links */
.tablink {
	background-color: #555;
	color: black;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	font-size: 16px;
	width: 14%;
}

.tablink:hover {
	background-color: #777;
}

/* Style the tab content (and add height:100% for full page content) */
.tabcontent {
	color: black;
	display: none;
	padding: 100px 20px;
	height: 100%;
}

#Home {
	background-color: white;
}

#News {
	background-color: white;
}

#Contact {
	background-color: white;
}

#About {
	background-color: white;
}
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="text-align: center; color: green">Xem thông tin hồ sơ
		nhân viên</h1>
	<p style="text-align: center;">Nhân viên:</p>
	<p>
		<img
			src="http://sohanews.sohacdn.com/thumb_w/660/2018/2/1/photo1517500807502-15175008075031371499104.jpg"
			style="border-radius: 50%; -moz-border-radius: 50%; -webkit-border-radius: 50%; width: 200px; display: block; margin-left: auto; margin-right: auto;">
	</p>

	<h2 style="text-align: center;">${thongTinNhanVien.hoLot}<a>
			${thongTinNhanVien.ten}</a>
	</h2>
	<p style="text-align: center;">
		Phòng ban:<a>${thongTinNhanVien.phongBan.tenPhongBan}</a> - Chức vụ:<a>${thongTinNhanVien.chucDanh.tenChucDanh}</a>
	</p>
	<button class="tablink" onclick="openPage('Home', this, 'red')">Thông
		tin hồ sơ</button>
	<button class="tablink" onclick="openPage('News', this, 'green')"
		id="defaultOpen">TT liên hệ</button>
	<button class="tablink" onclick="openPage('Family', this, 'green')">TT
		gia đình</button>
	<button class="tablink" onclick="openPage('Contact', this, 'blue')">TT
		bằng cấp</button>
	<button class="tablink" onclick="openPage('About', this, 'orange')">TT
		CC CH môn</button>
	<button class="tablink" onclick="openPage('Project', this, 'black')">TT
		dự án</button>
	<button class="tablink" onclick="openPage('Contract', this, 'green')">TT
		hợp đồng</button>

	<div id="Home" class="tabcontent">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Mã NV</th>
					<th scope="col">Họ đệm</th>
					<th scope="col">Tên</th>
					<th scope="col">Năm sinh</th>
					<th scope="col">Giới tính</th>
					<th scope="col">Dân tộc</th>
					<th scope="col">Số CMND</th>
					<th scope="col">Ngày cấp</th>
					<th scope="col">Nơi cấp</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">${thongTinNhanVien.maNhanVien}</th>
					<td>${thongTinNhanVien.hoLot}</td>
					<td>${thongTinNhanVien.ten}</td>
					<td>${thongTinNhanVien.namSinh}</td>
					<td>${thongTinNhanVien.gioiTinh}</td>
					<td>${thongTinNhanVien.danToc}</td>
					<td>${thongTinNhanVien.soCMND}</td>
					<td>${thongTinNhanVien.ngayCap}</td>
					<td>${thongTinNhanVien.noiCap}</td>
				</tr>

			</tbody>
		</table>
	</div>

	<div id="News" class="tabcontent">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Quê quán</th>
					<th scope="col">Quốc tịch</th>
					<th scope="col">Nơi tạm trú</th>
					<th scope="col">Số điện thoại</th>
					<th scope="col">Email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${thongTinNhanVien.queQuan}</td>
					<td>${thongTinNhanVien.quocTich.tenQuocTich}</td>
					<td>${thongTinNhanVien.noiTamTru}</td>
					<td>@${thongTinNhanVien.soDienThoai}</td>
					<td>@${thongTinNhanVien.email}</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div id="Family" class="tabcontent">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Họ và tên</th>
					<th scope="col">Quan hệ</th>
					<th scope="col">Năm sinh</th>
					<th scope="col">Nghề nghiệp</th>
					<th scope="col">Địa chỉ</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="ttGiaDinh" items="${thongTinNhanVien.listGiaDinh}">
						<td>${ttGiaDinh.hoVaTen}</td>
						<td>${ttGiaDinh.quanHe}</td>
						<td>${ttGiaDinh.namSinh}</td>
						<td>${ttGiaDinh.ngheNghiep}</td>
						<td>${ttGiaDinh.diaChi}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>

	<div id="Contact" class="tabcontent">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Trình độ</th>
					<th scope="col">Ngành</th>
					<th scope="col">Thời gian</th>
					<th scope="col">Xếp loại</th>
					<th scope="col">Nơi cấp</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="bangCap" items="${thongTinNhanVien.listBangCap}">
						<td>${bangCap.trinhDo.tenTrinhDo}</td>
						<td>${bangCap.tenNganh}</td>
						<td>${bangCap.thoiGian}</td>
						<td>${bangCap.xepLoai}</td>
						<td>${bangCap.noiCap}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>
	<div id="Contract" class="tabcontent">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Loại hợp đồng</th>
					<th scope="col">Ngày bắt đầu</th>
					<th scope="col">Ngày kết thúc</th>
					<th scope="col">Lương tháng 13</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="hopDong" items="${thongTinNhanVien.listHopDong}">
						<td>${hopDong.loaihopDong.tenHopDong}</td>
						<td>${hopDong.ngayBatDau}</td>
						<td>${hopDong.ngayKetThuc}</td>
						<td>${hopDong.luongThang13}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>


	</div>


	<div id="About" class="tabcontent">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">Tên chứng chỉ</th>
					<th scope="col">Ngày cấp</th>
					<th scope="col">Nơi cấp</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach var="chungChi" items="${thongTinNhanVien.listChungChi}">
						<td>${chungChi.tenChungChi}</td>
						<td>${chungChi.ngayCap}</td>
						<td>${chungChi.donViCap}</td>
					</c:forEach>
				</tr>
			</tbody>
		</table>
	</div>

	<div id="Project" class="tabcontent">
		<table class="table table-hover">
			<c:forEach var="hopDong"
				items="${thongTinNhanVien.listPhanCongNhiemVuNS}">
				<td>${hopDong.maDuAn}</td>
			</c:forEach>

			</tbody>
		</table>
		<a href="/FBMS/excelfile/${thongTinNhanVien.maNhanVien}"><button
				class="btn btn-success">Xuất file Excel</button></a>
	</div>




	<script>
		function openPage(pageName, elmnt, color) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablink");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].style.backgroundColor = "";
			}
			document.getElementById(pageName).style.display = "block";
			elmnt.style.backgroundColor = color;

		}
		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>

</body>
</html>
