package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import monhoc.MonHoc;
import quanlyhocsinh.entity.HocSinh;

public class MainHocSinh {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Tạo bean từ spring containner
		HocSinh sinhVien1 = context.getBean("sinhVien1", HocSinh.class);
		HocSinh sinhVien2 = context.getBean("sinhVien2", HocSinh.class);
		HocSinh sinhVien3 = context.getBean("sinhVien3", HocSinh.class);

		System.out.println("Sinh viên 1:");
		System.out.println("*Thông tin cá nhân: " + sinhVien1.getThongTinHocSinh());
		System.out.println("*Thông tin về hệ đào tạo: " + sinhVien1.getThongTinHeDaoTao());
		System.out.println("*Thông tin về loại hình đào tạo: " + sinhVien1.getThongTinLoaiHinhDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("*" + monHoc.getThongTinMonHoc()+"Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("\n");

		
		
		
		System.out.println("Sinh viên 2:");
		System.out.println("*Thông tin cá nhân: " + sinhVien2.getThongTinHocSinh());
		System.out.println("*Thông tin về hệ đào tạo: " + sinhVien2.getThongTinHeDaoTao());
		System.out.println("*Thông tin về loại hình đào tạo: " + sinhVien1.getThongTinLoaiHinhDaoTao());
		System.out.println("Môn Học:");
		
		for (MonHoc monHoc : sinhVien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("*" + monHoc.getThongTinMonHoc()+"Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("\n");

		
		
		
		
		
		System.out.println("Sinh viên 3:");
		System.out.println("*Thông tin cá nhân: " + sinhVien3.getThongTinHocSinh());
		System.out.println("*Thông tin về hệ đào tạo: " + sinhVien3.getThongTinHeDaoTao());
		System.out.println("*Thông tin về loại hình đào tạo: " + sinhVien1.getThongTinLoaiHinhDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : sinhVien3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("*" + monHoc.getThongTinMonHoc()+"Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("\n");
		context.close();

	}

}
