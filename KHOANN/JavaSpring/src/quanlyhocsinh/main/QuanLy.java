package quanlyhocsinh.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh;
import quanlyhocsinh.entity.MonHoc.MonHoc;


public class QuanLy {
	
	public static void main(String[] args) {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// Tạo bean từ spring containner
	HocSinh hocSinh1 = context.getBean("hocSinh1",HocSinh.class);
	
	System.out.println("Thông tin sinh viên 1: ");
	System.out.println("	" + hocSinh1.getThongTinSinhVien());
	
	System.out.println("	" + hocSinh1.getThongTinHeDaoTao());
	for (MonHoc monHoc : hocSinh1.getHeDaoTao().getDanhSachMonHoc()) {
		System.out.println("			* " + monHoc.getTenMonHoc());
		System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
		System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
	}
	
	
	
	context.close();
	}
}
