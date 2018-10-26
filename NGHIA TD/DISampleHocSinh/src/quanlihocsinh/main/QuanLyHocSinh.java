package quanlihocsinh.main;

import java.util.ArrayList;
import java.util.List;

import giangvien.GiangVien;

import quanlihocsinh.entity.DaoTaoOffLine;
import quanlihocsinh.entity.DaoTaoOnline;
import quanlihocsinh.entity.HeDaoTaoDaiHan;
import quanlihocsinh.entity.HeDaoTaoNganHanJaVa;
import quanlihocsinh.entity.HeDaoTaoNganHanPHP;
import quanlihocsinh.entity.HocSinh;
import quanlihocsinh.monhoc.LapTrinhCoBan;
import quanlihocsinh.monhoc.LapTrinhJaVaCoBan;
import quanlihocsinh.monhoc.LapTrinhJaVaWeb;
import quanlihocsinh.monhoc.LapTrinhPHPMySQL;
import quanlihocsinh.monhoc.LapTrinhWebFrontEnd;
import quanlihocsinh.monhoc.MonHoc;
import quanlihocsinh.monhoc.QuyTrinhDuAn;
import quanlihocsinh.monhoc.TinHocVanPhong;

public class QuanLyHocSinh {

	public static void main(String[] args) {

		GiangVien gv1 = new GiangVien("Trần Minh Thắng", "thangkute@gmail.com");
		GiangVien gv2 = new GiangVien("Cao Lê Thành", "ThanhHong@gmail.com");
		GiangVien gv3 = new GiangVien("LỆ Quyên", "LeQuyen@gmail.com");
		GiangVien gv4 = new GiangVien("Trân thanh Lâm", "ThanhLam@gmail.com");
		// TODO Auto-generated method stub
		List<MonHoc> dtDaiHan = new ArrayList<MonHoc>();
		dtDaiHan.add(new TinHocVanPhong(gv1));
		dtDaiHan.add(new LapTrinhCoBan(gv2));
		dtDaiHan.add(new LapTrinhWebFrontEnd(gv4));
		dtDaiHan.add(new LapTrinhPHPMySQL(gv3));
		dtDaiHan.add(new LapTrinhJaVaCoBan(gv4));
		dtDaiHan.add(new LapTrinhJaVaWeb(gv1));
		dtDaiHan.add(new QuyTrinhDuAn(gv3));

		List<MonHoc> dtNganHanJaVa = new ArrayList<MonHoc>();
		dtNganHanJaVa.add(new LapTrinhJaVaCoBan(gv4));
		dtNganHanJaVa.add(new LapTrinhJaVaWeb(gv1));

		List<MonHoc> dtNganHanPHP = new ArrayList<MonHoc>();
		dtNganHanPHP.add(new LapTrinhWebFrontEnd(gv4));
		dtNganHanPHP.add(new LapTrinhPHPMySQL(gv3));

		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHanJaVa heDaoTaoNganHanJaVa = new HeDaoTaoNganHanJaVa();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP = new HeDaoTaoNganHanPHP();

		heDaoTaoDaiHan.setDsMonHoc(dtDaiHan);
		heDaoTaoNganHanJaVa.setDsMonHoc(dtNganHanJaVa);
		heDaoTaoNganHanPHP.setDsMonHoc(dtNganHanPHP);

		HocSinh hsNghia = new HocSinh("Trương Đại Nghĩa", 1993, "Duy Xuyên ,Quảng Nam", "090000999", "Nghia@gmail.com",
				heDaoTaoNganHanJaVa, new DaoTaoOffLine());
		HocSinh hsVy = new HocSinh("Ngô Gia Vỹ", 1995, "Sơn Trà ,DN", "090994999", "vi@gmail.com",
				new HeDaoTaoNganHanJaVa(), new DaoTaoOffLine());
		HocSinh hsMy = new HocSinh("Du Học Sinh", 1991, "Quế Sơn ,Quảng Nam", "090676767", "hihihihi@gmail.com",
				new HeDaoTaoNganHanJaVa(), new DaoTaoOnline());

		System.out.println("thông tin sinh viên 1:");
		System.out.println("  - " + hsNghia.getThongTinSinhVien());

		System.out.println("Loại hình đào tạo:");
		System.out.println("  - " + hsNghia.getLoaiDaoTao().getThongTinLoaiDaoTao());
		System.out.println("  - " + hsNghia.getThongTinHeDaoTao());

		System.out.println("Môn Học");
		for (MonHoc monHoc : hsNghia.getHeDaoTao().getDsMonHoc()) {
			System.out.println( monHoc.gettenMonHoc());
		}

	}

}
