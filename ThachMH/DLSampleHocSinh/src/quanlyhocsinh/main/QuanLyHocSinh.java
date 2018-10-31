package quanlyhocsinh.main;

import java.util.ArrayList;
import java.util.List;

import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {
	public static void main(String[] args) {
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHanJava heDaoTaoNganHanJava = new HeDaoTaoNganHanJava();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP = new HeDaoTaoNganHanPHP();

		GiangVien gvThanhCL = new GiangVien("Cao Le Thanh", "thanhcl@gmail.com");
		GiangVien gvLamNT = new GiangVien("Nguyễn Thành Lâm", "lamnt@gmail.com");
		GiangVien gvThangTM = new GiangVien("Trần Minh Thắng", "thangtm@gmail.com");

		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Quảng Nam", "009846512", "kybody@gail.com",
				heDaoTaoDaiHan, new DaoTaoOnline());
		HocSinh hsTungo = new HocSinh("Ngô Văn Tứ", 1945, "Đà Nẵng", "009846512", "kybody@gail.com",
				heDaoTaoNganHanJava, new DaoTaoOffline());
		HocSinh hsTeonguyen = new HocSinh("Nguyễn Văn Tèo", 1989, "Tam Kỳ Quảng Nam", "009846512", "teobody@gail.com",
				heDaoTaoNganHanPHP, new DaoTaoOnline());

		List<MonHoc> daoTaoDaiHan = new ArrayList<>();
		daoTaoDaiHan.add(new TinHocVanPhong(gvThanhCL));
		daoTaoDaiHan.add(new LapTrinhCoBan(gvLamNT));
		daoTaoDaiHan.add(new LapTrinhWebFronten(gvThangTM));
		daoTaoDaiHan.add(new LapTrinhWebPHPMySQL(gvThanhCL));
		daoTaoDaiHan.add(new LapTrinhJavaCoBan(gvLamNT));
		daoTaoDaiHan.add(new LapTrinhJavaWed(gvThangTM));
		daoTaoDaiHan.add(new QuyTrinhDuAn(gvThanhCL));

		List<MonHoc> daoTaoNganHanJava = new ArrayList<>();
		daoTaoNganHanJava.add(new LapTrinhWebFronten(gvThangTM));
		daoTaoNganHanJava.add(new LapTrinhWebPHPMySQL(gvThanhCL));

		List<MonHoc> daoTaoNganHanPHP = new ArrayList<>();
		daoTaoNganHanPHP.add(new LapTrinhJavaCoBan(gvLamNT));
		daoTaoNganHanPHP.add(new LapTrinhJavaWed(gvThangTM));

		heDaoTaoDaiHan.setDanhSachMonHoc(daoTaoDaiHan);
		heDaoTaoNganHanJava.setDanhSachMonHoc(daoTaoNganHanJava);
		heDaoTaoNganHanPHP.setDanhSachMonHoc(daoTaoNganHanPHP);

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println(" -  " + hsKyBody.getThongTinSinhVien());
		System.out.println(" -  " + hsKyBody.getThongTinHeDaoTao());
		System.out.println(" -  " + hsKyBody.getThongTinLoaiHinh());
		System.out.println("Môn Học: ");
		for (MonHoc monHoc : hsKyBody.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("---" + monHoc.getThongTonMonHoc());
			System.out.println("---Giảng Viên:  " + monHoc.getTenGiangVien());
			System.out.println("---Email Giảng Viên:  " + monHoc.getEmailGV());
		}
		;

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println(" -  " + hsTungo.getThongTinSinhVien());
		System.out.println(" -  " + hsTungo.getThongTinHeDaoTao());
		System.out.println(" -  " + hsTungo.getThongTinLoaiHinh());
		System.out.println("Môn Học: ");
		for (MonHoc monHoc : hsTungo.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("---" + monHoc.getThongTonMonHoc());
			System.out.println("---Giảng Viên:  " + monHoc.getTenGiangVien());
			System.out.println("---Email Giảng Viên:  " + monHoc.getEmailGV());
		}
		;
		System.out.println("Thông tin sinh viên 3: ");
		System.out.println(" -  " + hsTeonguyen.getThongTinSinhVien());
		System.out.println(" -  " + hsTeonguyen.getThongTinHeDaoTao());
		System.out.println(" -  " + hsTeonguyen.getThongTinLoaiHinh());
		System.out.println("Môn Học: ");
		for (MonHoc monHoc : hsTeonguyen.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("---" + monHoc.getThongTonMonHoc());
			System.out.println("---Giảng Viên:  " + monHoc.getTenGiangVien());
			System.out.println("---Email Giảng Viên:  " + monHoc.getEmailGV());
		}
		;
	}

}
