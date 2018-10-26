package controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.SinhVien;
import ffse1704.spring.entity.monhoc.MonHoc;


public class Main {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// Tạo bean từ spring containner
		SinhVien sinhVien1 = context.getBean("sinhvien1", SinhVien.class);
		SinhVien sinhVien2 = context.getBean("sinhvien2", SinhVien.class);
		SinhVien sinhVien3 = context.getBean("sinhvien3", SinhVien.class);
		
		
		
		System.out.println("Thông tin sinh viên:   ");
		System.out.println(sinhVien1.getThongTinSinhVien());
		System.out.println("-----" + sinhVien1.getThongTinHLoaiHinhDaoTao());
		System.out.println("-----" + sinhVien1.getThongTinHeDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getMaMonHoc() + " \n 	" + monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		
		System.out.println("********************************************************");
		
		System.out.println("Thông tin sinh viên:   ");
		System.out.println(sinhVien2.getThongTinSinhVien());
		System.out.println("-----" + sinhVien2.getThongTinHLoaiHinhDaoTao());
		System.out.println("-----" + sinhVien2.getThongTinHeDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : sinhVien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getMaMonHoc() + " \n 	" + monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("********************************************************");
		
		System.out.println("Thông tin sinh viên:   ");
		System.out.println(sinhVien3.getThongTinSinhVien());
		System.out.println("-----" + sinhVien3.getThongTinHLoaiHinhDaoTao());
		System.out.println("-----" + sinhVien3.getThongTinHeDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : sinhVien3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getMaMonHoc() + " \n 	" + monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("********************************************************");
		context.close();
	}

}
