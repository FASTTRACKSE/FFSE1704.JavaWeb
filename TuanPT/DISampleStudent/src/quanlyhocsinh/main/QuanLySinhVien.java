package quanlyhocsinh.main;


import java.util.ArrayList;
import java.util.List;

import quanlyhocsinh.entity.*;
import quanlyhocsinh.entity.hedaotao.*;
import quanlyhocsinh.entity.loaihinhdaotao.*;
import quanlyhocsinh.entity.monhoc.*;
import quanlyhocsinh.entity.giangvien.*;

public class QuanLySinhVien {

	public static void main(String[] args) {
		GiangVien gv1 = new GiangVien("Cao Lê Thành", "ThanhCL@fasttrack.edu.vn");
		GiangVien gv2 = new GiangVien("Trần Minh Thắng", "ThangTM@fasttrack.edu.vn");
		GiangVien gv3 = new GiangVien("Nguyễn Thành Lâm", "LamNT@fasttrack.edu.vn");
		
		// Add ds mom hoc vao list dao tao dai han
		List<MonHoc> dtDaiHan = new ArrayList<MonHoc>();
		dtDaiHan.add(new TinHocVanPhong(gv1));
		dtDaiHan.add(new LapTrinhCoBan(gv3));
		dtDaiHan.add(new LapTrinhWebFontEnd(gv3));
		dtDaiHan.add(new LapTrinhWebPHPvaMySQL(gv2));
		dtDaiHan.add(new LapTrinhJavaCoBan(gv2));
		dtDaiHan.add(new LapTrinhJavaWeb(gv1));
		dtDaiHan.add(new QuiTrinhDuAn(gv1));
		
		// Add ds mom hoc vao list dao tao ngan han PHP
		List<MonHoc> dtNganHanPHP = new ArrayList<MonHoc>();
		dtDaiHan.add(new LapTrinhWebFontEnd(gv3));
		dtDaiHan.add(new LapTrinhWebPHPvaMySQL(gv2));
		
		// Add ds mom hoc vao list dao tao ngan han Java
		List<MonHoc> dtNganHanJava = new ArrayList<MonHoc>();
		dtDaiHan.add(new LapTrinhJavaCoBan(gv2));
		dtDaiHan.add(new LapTrinhJavaWeb(gv1));
		
		
		DaoTaoDaiHan daoTaoDaiHan = new DaoTaoDaiHan();
		DaoTaoCapTocPHP daoTaoCapTocPHP = new DaoTaoCapTocPHP();
		DaoTaoCapTocJava daoTaoCapTocJava = new DaoTaoCapTocJava();
		
		daoTaoDaiHan.setDsMonHoc(dtDaiHan);
		daoTaoCapTocPHP.setDsMonHoc(dtNganHanPHP);
		daoTaoCapTocJava.setDsMonHoc(dtNganHanJava);
		
		SinhVien sv1 = new SinhVien("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new DaoTaoOffline(), daoTaoDaiHan);
		SinhVien sv2 = new SinhVien("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new DaoTaoOffline(), daoTaoCapTocJava);
		SinhVien sv3 = new SinhVien("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new DaoTaoOnline(), daoTaoCapTocPHP);
		
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