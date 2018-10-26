package quanlyhocsinh.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh;


public class QuanLy {
	
	public static void main(String[] args) {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// Tạo bean từ spring containner
	HocSinh hocSinh1 = context.getBean("hocSinh1",HocSinh.class);
	
	System.out.println(hocSinh1.getThongTinSinhVien());
	
	
	context.close();
	}
}
