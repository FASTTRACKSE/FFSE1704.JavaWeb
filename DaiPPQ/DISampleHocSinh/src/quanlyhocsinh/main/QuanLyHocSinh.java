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
		
		// Add ds mom hoc vao list dao tao dai han
		List<MonHoc> dtDaiHan = new ArrayList<MonHoc>();
		dtDaiHan.add(new TinHocVanPhong(new ThayThanh()));
		dtDaiHan.add(new LapTrinhCoBan(new ThayThanh()));
		dtDaiHan.add(new LapTrinhWebFrontend(new ThayLam()));
		dtDaiHan.add(new LapTrinhWebPHPMySQL(new ThayThang()));
		dtDaiHan.add(new LapTrinhJavaCoBan(new ThayThang()));
		dtDaiHan.add(new LapTrinhJavaWeb(new ThayThanh()));
		dtDaiHan.add(new QuyTrinhDuAn(new ThayThang()));
		
		// Add ds mom hoc vao list dao tao ngan han PHP
		List<MonHoc> dtNganHanPHP = new ArrayList<MonHoc>();
		dtNganHanPHP.add(new LapTrinhWebFrontend(new ThayLam()));
		dtNganHanPHP.add(new LapTrinhWebPHPMySQL(new ThayThang()));
		
		// Add ds mom hoc vao list dao tao ngan han Java
		List<MonHoc> dtNganHanJava = new ArrayList<MonHoc>();
		dtNganHanJava.add(new LapTrinhJavaCoBan(new ThayThang()));
		dtNganHanJava.add(new LapTrinhJavaWeb(new ThayThanh()));
		
		
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP = new HeDaoTaoNganHanPHP();
		HeDaoTaoNganHanJava heDaoTaoNganHanJava = new HeDaoTaoNganHanJava();
		
		heDaoTaoDaiHan.setDsMonHoc(dtDaiHan);
		heDaoTaoNganHanPHP.setDsMonHoc(dtNganHanPHP);
		heDaoTaoNganHanJava.setDsMonHoc(dtNganHanJava);
		
		SinhVien sv1 = new SinhVien("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new DaoTaoOffline(), heDaoTaoDaiHan);
		SinhVien sv2 = new SinhVien("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new DaoTaoOffline(), heDaoTaoNganHanJava);
		SinhVien sv3 = new SinhVien("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new DaoTaoOffline(), heDaoTaoNganHanPHP);
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("	- " + sv1.getThongTinSinhVien());
		
		System.out.println("	- Loại Hình Đào Tạo: " + sv1.getLoaiHinhDaoTao().getThongTinLoaiHinhDaoTao());
		System.out.println("			* Thời Gian: " + sv1.getLoaiHinhDaoTao().getThoiGianDaoTao());
		System.out.println("			* Địa Điểm : " + sv1.getLoaiHinhDaoTao().getDiaDiemDaoTao());
		
		System.out.println("	- " + sv1.getThongTinHeDaoTao());
		
		System.out.println("	- Môn Học: ");
		for (MonHoc monHoc : sv1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("			* " + monHoc.getThongTinMonHoc());
			System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
		}
		
		System.out.println(" --------------------------------------------------------------------------------------------- ");
		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("	- " + sv2.getThongTinSinhVien());
		
		System.out.println("	- Loại Hình Đào Tạo: " + sv2.getLoaiHinhDaoTao().getThongTinLoaiHinhDaoTao());
		System.out.println("			* Thời Gian: " + sv2.getLoaiHinhDaoTao().getThoiGianDaoTao());
		System.out.println("			* Địa Điểm : " + sv2.getLoaiHinhDaoTao().getDiaDiemDaoTao());
		
		System.out.println("	- " + sv2.getThongTinHeDaoTao());
		
		System.out.println("	- Môn Học: ");
		for (MonHoc monHoc : sv2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("			* " + monHoc.getThongTinMonHoc());
			System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
		}
		
		System.out.println(" --------------------------------------------------------------------------------------------- ");
		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("	- " + sv3.getThongTinSinhVien());
		
		System.out.println("	- Loại Hình Đào Tạo: " + sv3.getLoaiHinhDaoTao().getThongTinLoaiHinhDaoTao());
		System.out.println("			* Thời Gian: " + sv3.getLoaiHinhDaoTao().getThoiGianDaoTao());
		System.out.println("			* Địa Điểm : " + sv3.getLoaiHinhDaoTao().getDiaDiemDaoTao());
		
		System.out.println("	- " + sv3.getThongTinHeDaoTao());
		
		System.out.println("	- Môn Học: ");
		for (MonHoc monHoc : sv3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("			* " + monHoc.getThongTinMonHoc());
			System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
		}
	}

}
