package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;
import quanlyhocsinh.entity.GiangVien.GiangVienEL;
import quanlyhocsinh.entity.GiangVien.GiangVienIT;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoDaiHan;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoHavardFastTrack;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoNganHanJava;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoNganHanPHP;
import quanlyhocsinh.entity.LoaiHinhDaoTao.DaoTaoOffline;
import quanlyhocsinh.entity.LoaiHinhDaoTao.DaoTaoOnline;
import quanlyhocsinh.entity.MonHoc.LapTrinhCoBan;
import quanlyhocsinh.entity.MonHoc.LapTrinhJavaCoBan;
import quanlyhocsinh.entity.MonHoc.LapTrinhJavaWeb;
import quanlyhocsinh.entity.MonHoc.LapTrinhWebPHPMySQL;


public class QuanLy {
	public static void main(String[] args) {
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com",
				new HeDaoTaoDaiHan(), new DaoTaoOnline(), new GiangVienEL(), new LapTrinhCoBan());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com",
				new HeDaoTaoNganHanJava(), new DaoTaoOffline() , new GiangVienIT(), new LapTrinhJavaCoBan());
		

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getThongTinSinhVien());
		System.out.println("   - " + hsKyBody.getThongTinHeDaoTao());
		System.out.println("   - " + hsKyBody.getphuongThucDaoTao());
		System.out.println("   - " + hsKyBody.getthongTinGiangVien());
		System.out.println("   - " + hsKyBody.getmonHoc());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getphuongThucDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getthongTinGiangVien());
		System.out.println("   - " + hsHoQuanHieu.getmonHoc());

		
		
		
	}

}
