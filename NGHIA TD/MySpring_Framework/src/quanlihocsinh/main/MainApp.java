package quanlihocsinh.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlihocsinh.entity.HocSinh;

public class MainApp {

	public static void main(String[] args) {
		// Nạp cái file con fig spring từ cái applicationContext.next nè
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		// bây giờ là tạo bean từ container
		HocSinh sinhVien1 = context.getBean("sinhVien1	", HocSinh.class);
		HocSinh sinhVien2 = context.getBean("sinhvien2", HocSinh.class);
		
		
		System.out.println(sinhVien1.getThongTinSinhVien());
		System.out.println(sinhVien2.getThongTinSinhVien());
		context.close();
	}

}
