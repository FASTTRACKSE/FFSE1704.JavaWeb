package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new HeDaoTaoDaiHan(), new DaoTaoOffline());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new HeDaoTaoNganHanJava(), new DaoTaoOnline());
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new HeDaoTaoHavardFastTrack(), new DaoTaoOffline());

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getThongTinSinhVien());
		System.out.println("   - " + hsKyBody.getThongTinHeDaoTao());
		System.out.println("   - " + hsKyBody.getLoaiHinhDaoTao());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getLoaiHinhDaoTao());

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getThongTinSinhVien());
		System.out.println("   - " + hsDavidVy.getThongTinHeDaoTao());
		System.out.println("   - " + hsDavidVy.getLoaiHinhDaoTao());
	}
	

}