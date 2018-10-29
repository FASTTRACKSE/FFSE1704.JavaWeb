package quanlihocsinh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlihocsinh.entity.HocSinh;
import quanlihocsinh.entity.monhoc.MonHoc;

public class QuanLiHocSinh {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("QuanLiHocSinh.xml");
		// Tạo bean từ spring containner
		HocSinh sinhVien2 = context.getBean("sinhvien2", HocSinh.class);
		System.out.println(sinhVien2.getThongTinSinhVien());
		System.out.println(sinhVien2.getThongTinHeDaoTao());
		for(MonHoc monHoc : sinhVien2.getHeDaoTao().dsMonHoc()) {
			System.out.println("Môn Học: "+monHoc.gettenMonHoc());
			System.out.println("Giảng Viên: "+monHoc.getTenGiangVien());
		}
		System.out.println("---");
		HocSinh sinhVien1 = context.getBean("sinhvien1", HocSinh.class);
		System.out.println(sinhVien1.getThongTinSinhVien());
		System.out.println(sinhVien1.getThongTinHeDaoTao());
		for(MonHoc monHoc : sinhVien1.getHeDaoTao().dsMonHoc()) {
			System.out.println("Môn Học: "+monHoc.gettenMonHoc());
			System.out.println("Giảng Viên: "+monHoc.getTenGiangVien());
		}
		context.close();
	}

}
