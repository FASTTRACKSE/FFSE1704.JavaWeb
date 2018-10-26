package quanlihocsinh.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import quanlihocsinh.entity.HocSinh;
import quanlihocsinh.entity.hedaotao.HeDaoTao;

public class QuanLiHocSinh {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("QuanLiHocSinh.xml");
		// Tạo bean từ spring containner
		HocSinh sinhVien2 = context.getBean("sinhvien2", HocSinh.class);
		System.out.println(sinhVien2.getThongTinSinhVien());
		System.out.println(sinhVien2.getThongTinHeDaoTao());
		context.close();
	}

}
