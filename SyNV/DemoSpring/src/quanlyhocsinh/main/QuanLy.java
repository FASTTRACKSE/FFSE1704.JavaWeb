package quanlyhocsinh.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh.*;
import quanlyhocsinh.entity.MonHoc.*;


public class QuanLy {
	
	public static void main(String[] args) {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// Táº¡o bean tá»« spring containner
	HocSinh hocSinh1 = context.getBean("hocSinh1",HocSinh.class);
	HocSinh hocSinh2 = context.getBean("hocSinh2",HocSinh.class);
	HocSinh hocSinh3 = context.getBean("hocSinh3",HocSinh.class);
	
	System.out.println("Thông tin sinh viên 1: ");
	System.out.println("	" + hocSinh1.getThongTinSinhVien());
	System.out.println("    " + hocSinh1.getphuongThucDaoTao());
	System.out.println("	" + hocSinh1.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh1.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Email  : " + monHoc.getEmailGiangVien());
	}
	
	System.out.println("Thông tin sinh viên 2: ");
	System.out.println("	" + hocSinh2.getThongTinSinhVien());
	System.out.println("    " + hocSinh2.getphuongThucDaoTao());
	System.out.println("	" + hocSinh2.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh2.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Email  : " + monHoc.getEmailGiangVien());
	}
	
	System.out.println("Thông tin sinh viên 3: ");
	System.out.println("	" + hocSinh3.getThongTinSinhVien());
	System.out.println("    " + hocSinh3.getphuongThucDaoTao());
	System.out.println("	" + hocSinh3.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh3.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Email  : " + monHoc.getEmailGiangVien());
	}
	
	
	context.close();
	}
	
	
}
