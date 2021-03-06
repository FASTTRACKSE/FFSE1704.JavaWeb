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
		HocSinh sinhVien2 = context.getBean("sinhvien2", HocSinh.class);
		
		System.out.println("Sinh viên 1 :");
		System.out.println(sinhVien1.getThongTinSinhVien());
		System.out.println(sinhVien1.getThongTinHeDaoTao());
		System.out.println(sinhVien1.getLoaiHinhDaoTao());

		

		System.out.println("                                  ");
		System.out.println("----****---THÔNG TIN GIÁO VIÊN VÀ MÔN HỌC  ---****----");
		System.out.println("                                  ");

		for (MonHoc monHoc : sinhVien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " +  monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmail());
		}
		
		System.out.println("                      ");
		
		System.out.println("Sinh viên 2 :");
		System.out.println(sinhVien2.getThongTinSinhVien());
		System.out.println(sinhVien2.getThongTinHeDaoTao());
		System.out.println(sinhVien2.getLoaiHinhDaoTao());

		

		System.out.println("                                  ");
		System.out.println("----****---THÔNG TIN GIÁO VIÊN VÀ MÔN HỌC  ---****----");
		System.out.println("                                  ");

		for (MonHoc monHoc : sinhVien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " +  monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmail());
		}
		System.out.println("                        ");
		System.out.println("**************************Kết thúc****************************");

		context.close();

	}

}
