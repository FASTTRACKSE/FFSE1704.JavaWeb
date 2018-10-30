package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hocsinh.*;
import monhoc.MonHoc;

public class QuanLyHocSinh {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AplicationFile.xml");
		HocSinh sv1 = context.getBean("sv1", HocSinh.class);
		HocSinh sv2 = context.getBean("sv2", HocSinh.class);
		HocSinh sv3 = context.getBean("sv3", HocSinh.class);


		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + sv1.getThongTinSinhVien());
		System.out.println("   - " + sv1.getThongTinHeDaoTao());
		System.out.println("   - " + sv1.getThongTinLoTrinhHoc());
		for (MonHoc hs : sv1.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc());
			System.out.println("   - " + "Giảng viên:" + hs.getTenGiangVien() + " ,Email : " + hs.getEmailGiangVien());
		}
		
		System.out.println("Thông tin sinh viên 2 ");
		System.out.println("   - " + sv2.getThongTinSinhVien());
		System.out.println("   - " + sv2.getThongTinHeDaoTao());
		System.out.println("   - " + sv2.getThongTinLoTrinhHoc());
		for (MonHoc hs : sv2.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc());
			System.out.println("   - " + "Giảng viên:" + hs.getTenGiangVien() + " ,Email : " + hs.getEmailGiangVien());
		}

		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + sv3.getThongTinSinhVien());
		System.out.println("   - " + sv3.getThongTinHeDaoTao());
		System.out.println("   - " + sv3.getThongTinLoTrinhHoc());
		for (MonHoc hs : sv3.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc());
			System.out.println("   - " + "Giảng viên:" + hs.getTenGiangVien() + " ,Email : " + hs.getEmailGiangVien());
		}

		context.close();
	}

}
