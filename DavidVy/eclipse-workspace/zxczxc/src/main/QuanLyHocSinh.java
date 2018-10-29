package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.HeDaoTao;
import entity.HocSinh;
import monhoc.MonHoc;

public class QuanLyHocSinh {
	 
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HocSinh sinhvien1 = context.getBean("sinhvien1", HocSinh.class);
		HocSinh sinhvien2 = context.getBean("sinhvien2", HocSinh.class);

		
		System.out.println(sinhvien1.getthongtinsinhvien());
		System.out.println(sinhvien1.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
		}
		
		System.out.println(sinhvien2.getthongtinsinhvien());
		System.out.println(sinhvien2.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
		}
		
		
		context.close();


	}

}
