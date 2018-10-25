package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		HocSinh hsQuanLT = new HocSinh("Le Trong Quan", 1998, "HTC", "0925808838", "quanltofficial@gmail.com", new HeDaoTaoDaiHan());
		HocSinh hsHoQuanHieu = new HocSinh("Ho Quang Hieu", 1986, "Dak Lak", "0877466556", "hieuho@gmail.com", new HeDaoTaoNganHanJava());
		HocSinh hsSonTungMTP = new HocSinh("Nguyen Thanh Tung", 1993, "TBC", "0866555666", "tungsky@gmail.com", new HeDaoTaoHavardFastTrack());

		System.out.println("Info Student 1: ");
		System.out.println("****" + hsQuanLT.getThongTinSinhVien());
		System.out.println("****" + hsQuanLT.getThongTinHeDaoTao());

		System.out.println("Info Student 2: ");
		System.out.println("****" + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("****" + hsHoQuanHieu.getThongTinHeDaoTao());

		System.out.println("Info Student 3: ");
		System.out.println("****" + hsSonTungMTP.getThongTinSinhVien());
		System.out.println("****" + hsSonTungMTP.getThongTinHeDaoTao());
	}

}
