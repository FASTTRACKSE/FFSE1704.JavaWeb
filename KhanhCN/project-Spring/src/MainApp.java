import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh;
import quanlyhocsinh.monhoc.MonHoc;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Tạo bean từ spring containner
		HocSinh sinhVien1 = context.getBean("sinhvien1", HocSinh.class);

		System.out.println(sinhVien1.getThongTinSinhVien());
		System.out.println(sinhVien1.getThongTinHeDaoTao());

		System.out.println("                                  ");
		System.out.println("----****---THÔNG TIN GIÁO VIÊN VÀ MÔN HỌC  ---****----");
		System.out.println("                                  ");

		

		context.close();

	}

}
