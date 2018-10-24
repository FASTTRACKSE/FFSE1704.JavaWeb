package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;
import quanlyhocsinh.entity.hedaotao.*;
import quanlyhocsinh.entity.loaihinhdaotao.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		HocSinh hsky = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new HeDaoTaoDaiHan(), new DaoTaoOnline());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new HeDaoTaoNganHanJava(), new DaoTaoOffline());
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new HeDaoTaoHavardFastTrack(), new DaoTaoOffline());
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsky.getThongTinSinhVien());
		System.out.println("   - " + hsky.getThongTinLoaiHinhDaoTao());
		System.out.println("   - " + hsky.getThongTinHeDaoTao());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinLoaiHinhDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		
		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinLoaiHinhDaoTao());
		System.out.println("   - " + hsDavidVy.getThongTinHeDaoTao());
	}

}
