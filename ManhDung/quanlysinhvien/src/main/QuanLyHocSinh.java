package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
		
		HeDaoTaoDaiHan heDaoTaoDaiHan =new HeDaoTaoDaiHan();
		HeDaoTaoNganHanJava heDaoTaoNganHanJava= new HeDaoTaoNganHanJava();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP=new HeDaoTaoNganHanPHP();
		
		List<MonHoc> daoTaoDaiHan= new ArrayList<>();
		 daoTaoDaiHan.add(new MonHocLapTrinhCoBan());
		 daoTaoDaiHan.add(new MonHocLapTrinhJavaCoBan());
		 daoTaoDaiHan.add(new MonHocLapTrinhJavaWeb());
		 daoTaoDaiHan.add(new MonHocLapTrinhWeb());
		 daoTaoDaiHan.add(new MonHocLapTrinhWebPHP());
		 daoTaoDaiHan.add(new MonHocQuyTrinhDuAn());
		 daoTaoDaiHan.add(new MonHocTinHocVanPhong());
		 
		List<MonHoc> daoTaoNganHanJava= new ArrayList<>();
		daoTaoNganHanJava.add(new MonHocLapTrinhCoBan());
		daoTaoNganHanJava.add(new MonHocLapTrinhJavaCoBan());
		daoTaoNganHanJava.add(new MonHocLapTrinhWeb());
		
		List<MonHoc> daoTaoNganHanPHP = new ArrayList<>();
		daoTaoNganHanPHP.add(new MonHocLapTrinhCoBan());
		daoTaoNganHanPHP.add(new MonHocLapTrinhWebPHP());
		daoTaoNganHanPHP.add(new MonHocLapTrinhWeb());


		heDaoTaoDaiHan.setDanhsachmonhoc(daoTaoNganHanPHP);
		heDaoTaoNganHanJava.setDanhsachmonhoc(daoTaoNganHanJava);
		heDaoTaoNganHanPHP.setDanhsachmonhoc(daoTaoNganHanPHP);
		
	
		
		
		
		
		
		
		
		
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com",  heDaoTaoDaiHan ,new LoTrinhHocOnline(), new GiangVienThanh());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", heDaoTaoNganHanJava,new LoTrinhHocOffline(), new GiangVienLam());
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", heDaoTaoNganHanPHP,new LoTrinhHocOnline(), new GiangVienThang());

		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsKyBody.getThongTinSinhVien());
		System.out.println("   - " + hsKyBody.getThongTinHeDaoTao());
		System.out.println("   - " + hsKyBody.getThongTinLoTrinhHoc());
		for (MonHoc hs : hsKyBody.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc() ); }
		System.out.println("   - "+"Tên giảng viên: " + hsKyBody.getTenGiangVien()+ "\n" +"   - "+ "Email: "  + hsKyBody.getEmailGiangVien());

		System.out.println("Thông tin sinh viên 2: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - " + hsHoQuanHieu.getThongTinLoTrinhHoc());
		for (MonHoc hs : hsHoQuanHieu.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc() ); }
		System.out.println("   - "+"Tên giảng viên: " + hsHoQuanHieu.getTenGiangVien()+ "\n" +"   - "+ "Email: "  + hsHoQuanHieu.getEmailGiangVien());
		
		
		System.out.println("Thông tin sinh viên 3: ");
		System.out.println("   - " + hsDavidVy.getThongTinSinhVien());
		System.out.println("   - " + hsDavidVy.getThongTinHeDaoTao());
		System.out.println("   - " + hsDavidVy.getThongTinLoTrinhHoc());
		for (MonHoc hs : hsDavidVy.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("   - " + "Môn học : " + hs.getThongTinMonHoc() ); }
		System.out.println("   - "+"Tên giảng viên: " + hsDavidVy.getTenGiangVien()+ "\n" +"   - "+ "Email: "  + hsDavidVy.getEmailGiangVien());
		
	}

}
