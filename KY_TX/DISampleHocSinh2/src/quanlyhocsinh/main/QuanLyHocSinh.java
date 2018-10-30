package quanlyhocsinh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.HocSinh;
import quanlymonhoc.entity.MonHoc;

public class QuanLyHocSinh {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HocSinh sinhVien1 = context.getBean("sinhVien1", HocSinh.class);
		HocSinh sinhVien2 = context.getBean("sinhVien2", HocSinh.class);
		HocSinh sinhVien3 = context.getBean("sinhVien3", HocSinh.class);
		System.out.println(sinhVien1.getThongTinSinhVien());
		System.out.println(sinhVien1.getThongTinHeDaoTao());
		System.out.println(sinhVien1.getThongTinLoaiHinhDaoTao());
		for(MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
		}
		System.out.println("Sinh viên 2:");
		System.out.println(sinhVien2.getThongTinSinhVien());
		System.out.println(sinhVien2.getThongTinHeDaoTao());
		System.out.println(sinhVien2.getThongTinLoaiHinhDaoTao());
		for(MonHoc monHoc : sinhVien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
		}
		System.out.println("Sinh viên 3:");
		System.out.println(sinhVien3.getThongTinSinhVien());
		System.out.println(sinhVien3.getThongTinHeDaoTao());
		System.out.println(sinhVien3.getThongTinLoaiHinhDaoTao());
		for(MonHoc monHoc : sinhVien3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
		}
		context.close();

	}

}
