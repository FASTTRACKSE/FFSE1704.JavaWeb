package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		HocSinh xuanKy = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0375168778",
				"xuanky290898@gmail.com", new HeDaoTaoDaiHan());
		HocSinh xuanKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0375168778",
				"xuanky290898@gmail.com", new HeDaoTaoDaiHan(), new LoaiHinhHocOffLine(), new GiangVienIT());
		System.out.println("Thông tin sinh viên");
		System.out.println("---" + xuanKy.getThongTinSinhVien());
		System.out.println("---" + xuanKy.getThongTinHeDaoTao());
		System.out.println("Thông tin sinh viên thứ 2:");
		System.out.println("---" + xuanKyBody.getThongTinSinhVien());
		System.out.println("---" + xuanKyBody.getThongTinHeDaoTao());
		System.out.println("---" + xuanKyBody.getThongTinLoaiHinhHoc());
		System.out.println("---" + xuanKyBody.getThongTinGiangVien());

	}

}
