package quanlyhocsinh.main;

import java.util.ArrayList;
import java.util.List;

import quanlyhocsinh.entity.*;
import quanlyhocsinh.entity.hedaotao.*;
import quanlyhocsinh.entity.loaihinhdaotao.*;
import quanlyhocsinh.entity.monhoc.*;
import quanlyhocsinh.entity.giangvien.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		
		List<MonHoc> dtDaiHan = new ArrayList<MonHoc>();
		dtDaiHan.add(new TinHocVanPhong(new ThayThanh()));
		dtDaiHan.add(new LapTrinhCoBan(new ThayThanh()));
		dtDaiHan.add(new LapTrinhWebFrontend(new ThayLam()));
		dtDaiHan.add(new LapTrinhWebPHPMySQL(new ThayThang()));
		dtDaiHan.add(new LapTrinhJavaCoBan(new ThayThang()));
		dtDaiHan.add(new LapTrinhJavaWeb(new ThayThanh()));
		dtDaiHan.add(new QuyTrinhDuAn(new ThayThang()));
		
		List<MonHoc> dtNganHanPHP = new ArrayList<MonHoc>();
		dtNganHanPHP.add(new LapTrinhWebFrontend(new ThayLam()));
		dtNganHanPHP.add(new LapTrinhWebPHPMySQL(new ThayThang()));
		
		List<MonHoc> dtNganHanJava = new ArrayList<MonHoc>();
		dtNganHanJava.add(new LapTrinhJavaCoBan(new ThayThang()));
		dtNganHanJava.add(new LapTrinhJavaWeb(new ThayThanh()));
		
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP = new HeDaoTaoNganHanPHP();
		HeDaoTaoNganHanJava heDaoTaoNganHanJava = new HeDaoTaoNganHanJava();
		
		heDaoTaoDaiHan.setDsMonHoc(dtDaiHan);
		heDaoTaoNganHanPHP.setDsMonHoc(dtNganHanPHP);
		heDaoTaoNganHanJava.setDsMonHoc(dtNganHanJava);
		
		HocSinh hsky = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new DaoTaoOffline(), heDaoTaoDaiHan);
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new DaoTaoOffline(), heDaoTaoNganHanJava);
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new DaoTaoOffline(), heDaoTaoNganHanPHP);
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsky.getThongTinSinhVien());
		System.out.println("   - " + hsky.getThongTinLoaiHinhDaoTao());
		System.out.println("   - " + hsky.getThongTinHeDaoTao());
		System.out.println("   - Môn Học: ");
		for (MonHoc monHoc : hsky.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getThongTinMonHoc() + " \n 	" + monHoc.getThongTinGiangVien());
		}
		
		System.out.println(" --------------------------------------------------------------------------------------------- ");
		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinLoaiHinhDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - Môn Học: ");
		for (MonHoc monHoc : hsky.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getThongTinMonHoc() + " \n 	" + monHoc.getThongTinGiangVien());
		}
		
		System.out.println(" --------------------------------------------------------------------------------------------- ");
		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinLoaiHinhDaoTao());
		System.out.println("   - " + hsDavidVy.getThongTinHeDaoTao());
		System.out.println("   - Môn Học: ");
		for (MonHoc monHoc : hsky.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getThongTinMonHoc() + " \n 	" + monHoc.getThongTinGiangVien());
		}
	}

}
