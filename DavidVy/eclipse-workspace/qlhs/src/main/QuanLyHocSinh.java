package main;

import entity.HeDaoTaoDaiHan;
import entity.HeDaoTaoHavardFastTrack;
import entity.HeDaoTaoNganHan;
import entity.HocSinh;

public class QuanLyHocSinh {
	
	public static void main(String[] args) {
		
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new HeDaoTaoDaiHan());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new HeDaoTaoNganHan());
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new HeDaoTaoHavardFastTrack());

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getthongtinsinhvien());
		System.out.println("   - " + hsKyBody.getthongtinhedaotao());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getthongtinsinhvien());
		System.out.println("   - " + hsHoQuanHieu.getthongtinhedaotao());

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getthongtinsinhvien());
		System.out.println("   - " + hsDavidVy.getthongtinhedaotao());
	}

}
