package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class main {

	public static void main(String[] args) {
		HocSinh hsTruongQuangMinh = new HocSinh("Trương Quang Minh ", 1996, "Quảng Bình", "01669938191",
				"Minh@gmail.com", new HeDaoTaoDaiHan(), new LoaiHinhDaoTaoOnLine(), new LapTrinhJavaWeb(),
				new GiangVienJava());

		HocSinh hsTranXuanKy = new HocSinh("Trần Xuân Kỳ", 1998, "Quảng Nam", "01685545184212", "kybody@gmail.com",
				new HeDaoTaoDaiHan(), new LoaiHinhDaoTaoOnLine(), new LapTrinhJavaWeb(), new GiangVienPHP());

		HocSinh hsLeKhaHongNhat = new HocSinh("Lê Khả Hồng Nhật", 1998, "Thanh Hoá", "01685112021512", "LKHN@gmail.com",
				new HeDaoTaoDaiHan(), new LoaiHinhDaoTaoOnLine(), new LapTrinhJavaWeb(), new GiangVienLapTrinhCanBan());

		System.out.println("Thông tin của học sinh 1");
		System.out.println("-" + hsTruongQuangMinh.getThongTinHocSinh());
		System.out.println("-" + hsTruongQuangMinh.getThongTinHeDaoTao());
		System.out.println("\n");
		System.out.println("Thông tin của học sinh 2");
		System.out.println("-" + hsTranXuanKy.getThongTinHocSinh());
		System.out.println("-" + hsTranXuanKy.getThongTinHeDaoTao());
		System.out.println("\n");
		System.out.println("Thông tin của học sinh 3");
		System.out.println("-" + hsLeKhaHongNhat.getThongTinHocSinh());
		System.out.println("-" + hsLeKhaHongNhat.getThongTinHeDaoTao());

	}

}
