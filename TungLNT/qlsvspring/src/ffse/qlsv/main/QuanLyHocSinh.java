package ffse.qlsv.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ffse.qlsv.entity.monhoc.MonHoc;
import ffse.qlsv.entity.sinhvien.HocSinh;

public class QuanLyHocSinh {
	public static void main(String[] args) {
		
		// Nạp file config spring từ applicationContext.xml
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				
				
				// Tạo bean từ spring containner
				HocSinh sv1 = context.getBean("sv1", HocSinh.class);
				HocSinh sv2 = context.getBean("sv2", HocSinh.class);
				HocSinh sv3 = context.getBean("sv3", HocSinh.class);
		
		
				System.out.println("Thông tin sinh viên 1   ");
				System.out.println(sv1.getThongTinSinhVien());
				System.out.println("-----" + sv1.getCheDoHoc());
				System.out.println("-----" + sv1.getThongTinHeDaoTao());
				System.out.println("Môn Học:");
				for (MonHoc monHoc : sv1.getHeDaoTao().getDanhSachMonHoc()) {
					System.out.println("     - "  + monHoc.getTenMonHoc() + " \n 	"
							+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
				}
		
				System.out.println("---------------------------------------------------------------");
				
				System.out.println("Thông tin sinh viên 2  ");
				System.out.println(sv2.getThongTinSinhVien());
				System.out.println("-----" + sv2.getCheDoHoc());
				System.out.println("-----" + sv2.getThongTinHeDaoTao());
				System.out.println("Môn Học:");
				for (MonHoc monHoc : sv2.getHeDaoTao().getDanhSachMonHoc()) {
					System.out.println("     - "  + monHoc.getTenMonHoc() + " \n 	"
							+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
				}
				System.out.println("---------------------------------------------------------------");
				
				System.out.println("Thông tin sinh viên 3   ");
				System.out.println(sv3.getThongTinSinhVien());
				System.out.println("-----" + sv3.getCheDoHoc());
				System.out.println("-----" + sv3.getThongTinHeDaoTao());
				System.out.println("Môn Học:");
				for (MonHoc monHoc : sv3.getHeDaoTao().getDanhSachMonHoc()) {
					System.out.println("     - "  + monHoc.getTenMonHoc() + " \n 	"
							+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
				}
				context.close();
	}
	

	
	
	
	

}