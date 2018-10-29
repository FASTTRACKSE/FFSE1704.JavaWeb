package quanlihocsinh.main;



import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlihocsinh.entity.HocSinh;
import quanlihocsinh.monhoc.MonHoc;

public class MainApp {

	public static void main(String[] args) {
		// Nạp cái file con fig spring từ cái applicationContext.next nè
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
		// bây giờ là tạo bean từ container
		HocSinh sinhvien1 = context.getBean("sinhvien1", HocSinh.class);
		
		
		HocSinh sinhvien2 = context.getBean("sinhvien2", HocSinh.class);
		
		
		System.out.println(sinhvien1.getThongTinSinhVien());
		
		System.out.println("Hệ đào tạo:");
		System.out.println(sinhvien1.getThongTinHeDaoTao());
		
		
		System.out.println("Môn Học:");
		for(MonHoc monHoc : sinhvien1.getHeDaoTao().getDsMonHoc()) {
			System.out.println(monHoc.getGiangVien().getTenGiangVien());
			System.out.println(monHoc.gettenMonHoc());
			System.out.println(monHoc.getGiangVien().getEmail());
		}
		
		System.out.println(sinhvien2.getThongTinSinhVien());
		context.close();
	}

}
