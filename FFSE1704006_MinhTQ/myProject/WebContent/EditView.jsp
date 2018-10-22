<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="ffse1704.jsfstaff.dao.SinhVien"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Contact V15</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="asset/form/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="asset/form/css/util.css">
<link rel="stylesheet" type="text/css" href="asset/form/css/main.css">
<!--===============================================================================================-->
</head>
<body>


	<div class="container-contact100">
		<div class="contact100-map" id="google_map" data-map-x="40.722047"
			data-map-y="-73.986422" data-pin="images/icons/map-marker.png"
			data-scrollwhell="0" data-draggable="1"></div>

		<div class="wrap-contact100">
			<div class="contact100-form-title"
				style="background-image: url(images/bg-01.jpg);">
				<span class="contact100-form-title-1"> EditUser </span>


			</div>



			<form class="contact100-form validate-form" action="EditSevlet" method="post">


				<div class="wrap-input100 validate-input">
					<span class="label-input100">Mã sinh viên</span> <input
						class="input100" type="text" name="maSV" value="${SV.maSinhVien }">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input">
					<span class="label-input100">Tên sinh viên:</span> <input
						class="input100" type="text" name="tenSV"
						value="${SV.tenSinhVien }"> <span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input">
					<span class="label-input100">Tuổi sinh viên:</span> <input
						class="input100" type="text" name="tuoiSV"
						value="${SV.tuoiSinhVien }"> <span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input">
					<span class="label-input100">Lớp học:</span> <input
						class="input100" type="text" name="lophoc" value="${SV.lopHoc }">
					</input> <span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input">
					<span class="label-input100">Địa chỉ:</span> <input
						class="input100" type="text" name="diachi" value="${SV.diaChi}"></input>
					<span class="focus-input100"></span>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span> Submit <i class="fa fa-long-arrow-right m-l-7"
							aria-hidden="true"></i>
						</span>
					</button>
				</div>


			</form>


		</div>
	</div>



	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="asset/form/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="asset/form/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="asset/form/vendor/bootstrap/js/popper.js"></script>
	<script src="asset/form/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="asset/form/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="asset/form/vendor/daterangepicker/moment.min.js"></script>
	<script src="asset/form/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="asset/form/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
	<script src="asset/form/js/map-custom.js"></script>
	<!--===============================================================================================-->
	<script src="asset/form/js/main.js"></script>

	<!-- Global site tag (gtag.js) - Google Analytics -->
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag() {
			dataLayer.push(arguments);
		}
		gtag('js', new Date());

		gtag('config', 'UA-23581568-13');
	</script>

</body>
</html>
