package quanlyhocsinh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hocsinh.entity.HocSinh;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Tạo bean từ spring containner
		HocSinh sinhVien1 = context.getBean("sinhvien1", HocSinh.class);
//		HocSinh sinhVien2 = context.getBean("sinhvien2", HocSinh.class);
		System.out.println(sinhVien1.getHoTen());
		System.out.println(sinhVien1.getEmail());
		System.out.println(sinhVien1.getLoaiHinhDaoTao());
		System.out.println(sinhVien1.getThongTinHeDaoTao());
		context.close();

	}

}
