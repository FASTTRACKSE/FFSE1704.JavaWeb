package quanlyhocsinh.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh;
import quanlyhocsinh.entity.monhoc.MonHoc;


public class QuanLy {
	
	public static void main(String[] args) {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// Tạo bean từ spring containner
	HocSinh hocSinh1 = context.getBean("hocSinh1",HocSinh.class);
	HocSinh hocSinh2 = context.getBean("hocSinh2",HocSinh.class);
	HocSinh hocSinh3 = context.getBean("hocSinh3",HocSinh.class);
	
	System.out.println("Thông tin sinh viên 1: ");
	System.out.println("Thông Tin Sinh Viên : " + hocSinh1.getThongTinSinhVien());
	System.out.println("Phương Thức Đào Tạo : " + hocSinh1.getphuongThucDaoTao());
	System.out.println("Thông Tin Đào Tạo   : " + hocSinh1.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh1.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
	}
	
	System.out.println("Thông tin sinh viên 2: ");
	System.out.println("Thông Tin Sinh Viên :	" + hocSinh2.getThongTinSinhVien());
	System.out.println("Phương Thức Đào Tạo :   " + hocSinh2.getphuongThucDaoTao());
	System.out.println("Thông Tin Đào Tạo   :	" + hocSinh2.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh2.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
	}
	
	System.out.println("Thông tin sinh viên 3: ");
	System.out.println("Thông Tin Sinh Viên :	" + hocSinh3.getThongTinSinhVien());
	System.out.println("Phương Thức Đào Tạo :   " + hocSinh3.getphuongThucDaoTao());
	System.out.println("Thông Tin Đào Tạo   :	" + hocSinh3.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh3.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
	}
	
	
	context.close();
	}
	
	
}
