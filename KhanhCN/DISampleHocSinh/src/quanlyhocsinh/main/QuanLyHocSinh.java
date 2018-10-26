package quanlyhocsinh.main;

import java.util.ArrayList;
import java.util.List;

import quanlyhocsinh.entity.*;
import quanlyhocsinh.giangvien.GiangVien;
import quanlyhocsinh.monhoc.LapTrinhCoBan;
import quanlyhocsinh.monhoc.LapTrinhJavaWeb;
import quanlyhocsinh.monhoc.LapTrinhWeb;
import quanlyhocsinh.monhoc.MonHoc;
import quanlyhocsinh.monhoc.QuyTrinhDuAn;
import quanlyhocsinh.monhoc.TinHocVanPhong;
import quanlyhocsinh.monhoc.WebPHP;

public class QuanLyHocSinh {

	public static void main(String[] args) {

		// Khởi tạo hệ đào tạo
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHan heDaoTaoNganHan = new HeDaoTaoNganHan();

		// Khởi tạo giảng viên
		GiangVien thanhCL = new GiangVien("Cao Lê Thành ", "thanhcl@gmail.com");
		GiangVien lamNV = new GiangVien("Nguyễn Văn Lâm  ", "lamnvn@gmail.com");
		GiangVien thangTM = new GiangVien("Trần Minh Thắng ", "thangmt@gmail.com");

		// List môn học dài hạn
		List<MonHoc> monHocDaiHan = new ArrayList<>();
		monHocDaiHan.add(new LapTrinhJavaWeb(thanhCL));
		monHocDaiHan.add(new LapTrinhCoBan(lamNV));
		monHocDaiHan.add(new TinHocVanPhong(lamNV));
		monHocDaiHan.add(new QuyTrinhDuAn(thanhCL));
		monHocDaiHan.add(new WebPHP(lamNV));
		monHocDaiHan.add(new LapTrinhCoBan(thanhCL));
		monHocDaiHan.add(new LapTrinhWeb(lamNV));

		// List môn học ngắn hạn
		List<MonHoc> monHocNganHan = new ArrayList<>();
		monHocNganHan.add(new LapTrinhCoBan(thangTM));
		monHocNganHan.add(new LapTrinhJavaWeb(thangTM));

		heDaoTaoDaiHan.setDanhSachMonHoc(monHocDaiHan);
		heDaoTaoNganHan.setDanhSachMonHoc(monHocNganHan);

		HocSinh hskhanhcn = new HocSinh("Cao Ngọc Khánh", 1996, "Quảng Ninh, Quảng Bình", "0968686868",
				"caongockhanh@gmail.com", heDaoTaoDaiHan, new LoaiHinhHocOffline());

		HocSinh hshoaitt = new HocSinh("Trần Thị Hoài", 1996, "Quảng Ninh, Quảng Bình", "0327332733",
				"tranthihoai@gmail.com", heDaoTaoNganHan, new LoaiHinhHocOnline());

		System.out.println("Sinh viên 1 : ");
		System.out.println("                            ");
		System.out.println("-----***---THÔNG TIN HỌC SINH ---***----");
		System.out.println("                              ");
		System.out.println("   - " + hskhanhcn.getThongTinSinhVien());
		System.out.println("   - " + hskhanhcn.getThongTinHeDaoTao());

		System.out.println("                                  ");
		System.out.println("----****---THÔNG TIN GIÁO VIÊN VÀ MÔN HỌC ---****----");
		System.out.println("                                  ");

		for (MonHoc hs : hskhanhcn.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("   - " + "Môn học : " + hs.getTenMonHoc() + "\n" + "   -" + "Giao viên : "
					+ hs.getTenGiangVien() + "\n" + "   -" + "EmailGV :  " + hs.getEmail());
			System.out.println("                                     ");
		}
		System.out.println("******************************************************");
		System.out.println("Sinh viên 2 : ");
		System.out.println("                            ");
		System.out.println("-----***---THÔNG TIN HỌC SINH ---***----");
		System.out.println("                              ");
		System.out.println("   - " + hshoaitt.getThongTinSinhVien());
		System.out.println("   - " + hshoaitt.getThongTinHeDaoTao());

		System.out.println("                                  ");
		System.out.println("----****---THÔNG TIN GIÁO VIÊN VÀ MÔN HỌC ---****----");
		System.out.println("                                  ");

		for (MonHoc hs : hshoaitt.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("   - " + "Môn học : " + hs.getTenMonHoc() + "\n" + "   -" + "Giao viên : "
					+ hs.getTenGiangVien() + "\n" + "   -" + "EmailGV :  " + hs.getEmail());
			System.out.println("                                     ");
		}
	}

}