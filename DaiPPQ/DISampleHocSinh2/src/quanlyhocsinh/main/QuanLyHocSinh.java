package quanlyhocsinh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlyhocsinh.entity.SinhVien;
import quanlyhocsinh.entity.monhoc.MonHoc;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		// Nạp file config spring từ applicationContext.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Tạo bean từ spring containner
		SinhVien sinhVien1 = context.getBean("sinhvien1", SinhVien.class);
		SinhVien sinhVien2 = context.getBean("sinhvien2", SinhVien.class);
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("	" + sinhVien1.getThongTinSinhVien());
		System.out.println("	" + sinhVien1.getThongTinLoaiHinhDaoTao());
		System.out.println("	" + sinhVien1.getThongTinHeDaoTao());
		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("			* " + monHoc.getThongTinMonHoc());
			System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
		}
		
		System.out.println("--------------------------------------------------------------------------------------------- ");
		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("	" + sinhVien2.getThongTinSinhVien());
		System.out.println("	" + sinhVien2.getThongTinLoaiHinhDaoTao());
		System.out.println("	" + sinhVien2.getThongTinHeDaoTao());
		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("			* " + monHoc.getThongTinMonHoc());
			System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("				Địa Điểm  : " + monHoc.getEmailGiangVien());
		}
		
		context.close();

	}

}
