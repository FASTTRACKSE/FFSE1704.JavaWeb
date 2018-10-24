package quanlyhocsinh.main;

import quanlyhocsinh.entity.*;


public class main {

	public static void main(String[] args) {
		HocSinh hsTruongQuangMinh = new HocSinh(
				"TruongQuangMinh " , 1996 , "Quảng Bình" , "01669938191" , "Minh@gmail.com", new HeDaoTaoDaiHan(),new LoaiHinhDaoTaoOnLine());

		System.out.println("Thông tin của học sinh");
		System.out.println("-"+ hsTruongQuangMinh.getThongTinHocSinh());
		System.out.println("-"+ hsTruongQuangMinh.getThongTinHeDaoTao());
		
	}

}
