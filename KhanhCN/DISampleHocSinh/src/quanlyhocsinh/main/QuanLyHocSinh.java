package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		HocSinh hskhanhcn= new HocSinh("Cao Ngọc Khánh", 1996, "Quảng Ninh, Quảng Bình", "0968686868",
				"caongockhanh@gmail.com", new HeDaoTaoDaiHan(),new LoaiHinhHocOffline(), new GiangVienAnh());
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hskhanhcn.getThongTinSinhVien());
		System.out.println("   - " + hskhanhcn.getThongTinHeDaoTao());

		

	}

}