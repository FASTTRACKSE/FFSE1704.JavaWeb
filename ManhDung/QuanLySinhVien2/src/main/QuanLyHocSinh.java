package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import giangvien.GiangVienLam;
import giangvien.GiangVienThang;
import giangvien.GiangVienThanh;
import hedaotao.HeDaoTaoDaiHan;
import hedaotao.HeDaoTaoNganHanJava;
import hedaotao.HeDaoTaoNganHanPHP;
import hocsinh.*;
import lotrinhhoc.LoTrinhHocOffline;
import lotrinhhoc.LoTrinhHocOnline;
import monhoc.MonHoc;
import monhoc.MonHocLapTrinhCoBan;
import monhoc.MonHocLapTrinhJavaCoBan;
import monhoc.MonHocLapTrinhJavaWeb;
import monhoc.MonHocLapTrinhWeb;
import monhoc.MonHocLapTrinhWebPHP;
import monhoc.MonHocQuyTrinhDuAn;
import monhoc.MonHocTinHocVanPhong;

public class QuanLyHocSinh {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("AplicationFile.xml");
		HocSinh sv1 = context.getBean("sv1", HocSinh.class);

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + sv1.getThongTinSinhVien());
		System.out.println("   - " + sv1.getThongTinHeDaoTao());
		System.out.println("   - " + sv1.getThongTinLoTrinhHoc());
		for (MonHoc hs : sv1.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc());
		}
		

		context.close();
	}

}
