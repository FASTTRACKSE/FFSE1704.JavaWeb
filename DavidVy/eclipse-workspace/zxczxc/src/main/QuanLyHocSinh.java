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
		HocSinh sinhvien3 = context.getBean("sinhvien3", HocSinh.class);
		HocSinh sinhvien4 = context.getBean("sinhvien4", HocSinh.class);
		HocSinh sinhvien5 = context.getBean("sinhvien5", HocSinh.class);

		
		System.out.println(sinhvien1.getthongtinsinhvien());
		System.out.println(sinhvien1.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien1.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
			System.out.println(monHoc.getTenGiangVien());
		}
		
		System.out.println(sinhvien2.getthongtinsinhvien());
		System.out.println(sinhvien2.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien2.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
			System.out.println(monHoc.getTenGiangVien());
		}
		
		System.out.println(sinhvien3.getthongtinsinhvien());
		System.out.println(sinhvien3.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien3.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
			System.out.println(monHoc.getTenGiangVien());
		}
		
		System.out.println(sinhvien4.getthongtinsinhvien());
		System.out.println(sinhvien4.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien4.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
			System.out.println(monHoc.getTenGiangVien());
		}
		
		System.out.println(sinhvien5.getthongtinsinhvien());
		System.out.println(sinhvien5.getthongtinhedaotao());
		for (MonHoc monHoc : sinhvien5.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println(monHoc.getTenMonHoc());
			System.out.println(monHoc.getTenGiangVien());
		}
		
		
		context.close();


	}

}
