package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class QuanLySinhVien {

	public static void main(String[] args) {
		SinhVien hsKyBody = new SinhVien("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new HeDaoTaoDaiHan());
		SinhVien hsHoQuanHieu = new SinhVien("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new HeDaoTaoCapTocJava());
		SinhVien hsDavidVy = new SinhVien("Vy Thiếu Gia", 1995, "�?N", "0999999999", "vy@gmail.com", new HeDaoTaoHavardFastTrack());

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getThongTinSinhVien());
		System.out.println("   - " + hsKyBody.getThongTinHeDaoTao());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getThongTinSinhVien());
		System.out.println("   - " + hsDavidVy.getThongTinHeDaoTao());
	}

}
