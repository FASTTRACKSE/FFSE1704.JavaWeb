package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {
	public static void main(String[] args) {
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Quảng Nam", "009846512", "kybody@gail.com",
				new HeDaoTaoDaiHan(), new DaoTaoOnline(), new LapTrinhJavaWed(), new GiangVienJava());
		HocSinh hsTungo = new HocSinh("Ngô Văn Tứ", 1945, "Đà Nẵng", "009846512", "kybody@gail.com",
				new HeDaoTaoNganHanJava(), new DaoTaoOffline(), new LapTrinhWedPHPMySQL(), new GiangVienJavaWedPHP());
		HocSinh hsTeonguyen = new HocSinh("Nguyễn Văn Tèo", 1989, "Tam Kỳ Quảng Nam", "009846512", "teobody@gail.com",
				new HeDaoTaoHavardFastTrack(), new DaoTaoOnline(), new LapTrinhJavaCoBan(), new GiangVienWedFronted());

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println(" -  " + hsKyBody.getThongTinSinhVien());
		System.out.println(" -  " + hsKyBody.getThongTinHeDaoTao());
		System.out.println(" -  " + hsKyBody.getThongTinLoaiHinh());
		System.out.println(" -  " + hsKyBody.getMonHoc());
		System.out.println(" -  " + hsKyBody.getGiangVien());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println(" -  " + hsTungo.getThongTinSinhVien());
		System.out.println(" -  " + hsTungo.getThongTinHeDaoTao());
		System.out.println(" -  " + hsTungo.getThongTinLoaiHinh());
		System.out.println(" -  " + hsTungo.getMonHoc());
		System.out.println(" -  " + hsTungo.getGiangVien());

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println(" -  " + hsTeonguyen.getThongTinSinhVien());
		System.out.println(" -  " + hsTeonguyen.getThongTinHeDaoTao());
		System.out.println(" -  " + hsTeonguyen.getThongTinLoaiHinh());
		System.out.println(" -  " + hsTeonguyen.getMonHoc());
		System.out.println(" -  " + hsTeonguyen.getGiangVien());
	}

}
