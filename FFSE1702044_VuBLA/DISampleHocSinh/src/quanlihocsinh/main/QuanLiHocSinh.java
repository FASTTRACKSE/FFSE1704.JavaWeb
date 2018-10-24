package quanlihocsinh.main;

import quanlihocsinh.entity.DaoTaoOffline;
import quanlihocsinh.entity.DaoTaoOnline;
import quanlihocsinh.entity.HeDaoTaoDaiHan;
import quanlihocsinh.entity.HeDaoTaoNganHanJava;
import quanlihocsinh.entity.HeDaoTaoNganHanPHP;
import quanlihocsinh.entity.HocSinh;

public class QuanLiHocSinh {

	public static void main(String[] args) {
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com",
				new HeDaoTaoDaiHan(), new DaoTaoOnline());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com",
				new HeDaoTaoNganHanJava(), new DaoTaoOffline());
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com",
				new HeDaoTaoNganHanPHP(), new DaoTaoOnline());
		
		
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getThongTinSinhVien());
		System.out.println("   - " + hsKyBody.getThongTinHeDaoTao());
		System.out.println("   - " + hsKyBody.getThongTinBuoiHoc());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getThongTinBuoiHoc());

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getThongTinSinhVien());
		System.out.println("   - " + hsDavidVy.getThongTinHeDaoTao());
		System.out.println("   - " + hsDavidVy.getThongTinBuoiHoc());
	}

}
