package quanlyhocsinh.main;

import java.util.ArrayList;
import java.util.List;

import quanlyhocsinh.entity.HocSinh;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoDaiHan;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoNganHanJava;
import quanlyhocsinh.entity.HeDaoTao.HeDaoTaoNganHanPHP;
import quanlyhocsinh.entity.LoaiHinhDaoTao.DaoTaoOffline;
import quanlyhocsinh.entity.LoaiHinhDaoTao.DaoTaoOnline;
import quanlyhocsinh.entity.MonHoc.LapTrinhCoBan;
import quanlyhocsinh.entity.MonHoc.LapTrinhJavaCoBan;
import quanlyhocsinh.entity.MonHoc.LapTrinhJavaWeb;
import quanlyhocsinh.entity.MonHoc.LapTrinhWebFrontend;
import quanlyhocsinh.entity.MonHoc.LapTrinhWebPHPMySQL;
import quanlyhocsinh.entity.MonHoc.MonHoc;
import quanlyhocsinh.entity.MonHoc.QuyTrinhDuAn;
import quanlyhocsinh.entity.MonHoc.TinHocVanPhong;
import quanlyhocsinh.entity.GiangVien.*;

public class QuanLy {
	public static void main(String[] args) {
		
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP = new HeDaoTaoNganHanPHP();
		HeDaoTaoNganHanJava heDaoTaoNganHanJava = new HeDaoTaoNganHanJava();

		GiangVien ThanhCL = new GiangVien("Cao Lê Thành", "thanhcl@fasttrack.edu.vn");
		GiangVien LamNT = new GiangVien("Nguyễn Thành Lâm", "lamnt@fasttrack.edu.vn");
		GiangVien ThangTM = new GiangVien("Trần Minh Thắng", "thangmt@fasttrack.edu.vn");

		List<MonHoc> dtDaiHan = new ArrayList<MonHoc>();
		dtDaiHan.add(new TinHocVanPhong(LamNT));
		dtDaiHan.add(new LapTrinhCoBan(ThanhCL));
		dtDaiHan.add(new LapTrinhJavaCoBan(ThanhCL));
		dtDaiHan.add(new LapTrinhJavaWeb(ThangTM));
		dtDaiHan.add(new LapTrinhWebFrontend(ThangTM));
		dtDaiHan.add(new LapTrinhWebPHPMySQL(LamNT));
		dtDaiHan.add(new QuyTrinhDuAn(ThanhCL));

		List<MonHoc> dtNganHanPHP = new ArrayList<MonHoc>();
		dtNganHanPHP.add(new LapTrinhWebPHPMySQL(LamNT));
		dtNganHanPHP.add(new LapTrinhWebFrontend(LamNT));

		List<MonHoc> dtNganHanJava = new ArrayList<MonHoc>();
		dtNganHanJava.add(new LapTrinhJavaWeb(ThanhCL));
		dtNganHanJava.add(new LapTrinhJavaCoBan(ThangTM));

		heDaoTaoDaiHan.setDsMonHoc(dtDaiHan);
		heDaoTaoNganHanPHP.setDsMonHoc(dtNganHanPHP);
		heDaoTaoNganHanJava.setDsMonHoc(dtNganHanJava);

		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com",
				heDaoTaoDaiHan, new DaoTaoOnline());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com",
				heDaoTaoNganHanPHP, new DaoTaoOffline());
		HocSinh hsKhoa = new HocSinh("Nguyễn Ngọc Khoa", 1999, "Đà Nẵng", "0909999999", "KhoaKHoa@gmail.com",
				heDaoTaoNganHanJava, new DaoTaoOffline());

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getThongTinSinhVien());
		System.out.println("   - " + hsKyBody.getThongTinHeDaoTao());
		System.out.println("   - " + hsKyBody.getphuongThucDaoTao());
		System.out.println("Môn Học :");
		for (MonHoc monHoc : hsKyBody.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getTenMonHoc());
			System.out.println("		+ Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("		+ Email  : " + monHoc.getEmailGiangVien());
		}
		;

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getphuongThucDaoTao());
		System.out.println("Môn Học :");
		for (MonHoc monHoc : hsHoQuanHieu.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getTenMonHoc());
			System.out.println("		 + Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("		 + Email  : " + monHoc.getEmailGiangVien());
		}
		;

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsKhoa.getThongTinSinhVien());
		System.out.println("   - " + hsKhoa.getThongTinHeDaoTao());
		System.out.println("   - " + hsKhoa.getphuongThucDaoTao());
		System.out.println("Môn Học :");
		for (MonHoc monHoc : hsKhoa.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getTenMonHoc());
			System.out.println("		 + Giảng Viên:  " + monHoc.getTenGiangVien());
			System.out.println("		 + Email  : " + monHoc.getEmailGiangVien());
		}
		;

	}

}
