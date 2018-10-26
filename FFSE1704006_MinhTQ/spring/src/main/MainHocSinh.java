package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh;

public class MainHocSinh {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Tạo bean từ spring containner
		HocSinh sinhvien1 = context.getBean("sinhvien1", HocSinh.class);
		HocSinh sinhvien2 = context.getBean("sinhvien2", HocSinh.class);
		HocSinh sinhvien3 = context.getBean("sinhvien3", HocSinh.class);
	
		
		System.out.println("Thông tin của  sinh viên 1");
		System.out.println( sinhvien1.getThongTinHocSinh());
		System.out.println( sinhvien1.getThongTinHeDaoTao());
//		for (MonHoc c : sinhvien1.getHeDaoTao().getDanhsachmonhoc()) {
//			System.out.println("*Môn học:" + c.getThongTinMonHoc() +  "\n"
//					+ "*Giảng Viên: " + c.getTenGiangVien() + "\n" + c.getEmailGiangVien());
//		}
//		
		System.out.println("\n");
		
		
		System.out.println("Thông tin của  sinh viên 2");
		System.out.println( sinhvien2.getThongTinHocSinh());
		System.out.println( sinhvien2.getThongTinHeDaoTao());
//		for (MonHoc c : sinhvien1.getHeDaoTao().getDanhsachmonhoc()) {
//			System.out.println("*Môn học:" + c.getThongTinMonHoc() +  "\n"
//					+ "*Giảng Viên: " + c.getTenGiangVien() + "\n" + c.getEmailGiangVien());
//		}
//		
		System.out.println("\n");
		
		
		System.out.println("Thông tin của  sinh viên 3");
		System.out.println( sinhvien3.getThongTinHocSinh());
		System.out.println( sinhvien3.getThongTinHeDaoTao());
//		for (MonHoc c : sinhvien1.getHeDaoTao().getDanhsachmonhoc()) {
//			System.out.println("*Môn học:" + c.getThongTinMonHoc() +  "\n"
//					+ "*Giảng Viên: " + c.getTenGiangVien() + "\n" + c.getEmailGiangVien());
//		}
//		
		System.out.println("\n");
		
		context.close();

	}

}
