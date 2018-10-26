package ffse.qlsv.main;

import java.util.ArrayList;
import java.util.List;

import ffse.qlsv.entity.giangvien.GiangVien;
import ffse.qlsv.entity.hedaotao.HeDaoTaoDaiHan;
import ffse.qlsv.entity.hedaotao.HeDaoTao;
import ffse.qlsv.entity.hedaotao.HeDaoTaoHavardFastTrack;
import ffse.qlsv.entity.hedaotao.HeDaoTaoNganHanJava;
import ffse.qlsv.entity.hedaotao.HeDaoTaoNganHanPHP;
import ffse.qlsv.entity.loaihinhdaotao.HocOffline;
import ffse.qlsv.entity.loaihinhdaotao.HocOnline;
import ffse.qlsv.entity.monhoc.LapTrinhCoBan;
import ffse.qlsv.entity.monhoc.LapTrinhJavaCoBan;
import ffse.qlsv.entity.monhoc.LapTrinhJavaWeb;
import ffse.qlsv.entity.monhoc.LapTrinhPHPMySQL;
import ffse.qlsv.entity.monhoc.LapTrinhWebFrontend;
import ffse.qlsv.entity.monhoc.MonHoc;
import ffse.qlsv.entity.monhoc.QuiTrinhDuAn;
import ffse.qlsv.entity.monhoc.TinHocVanPhong;
import ffse.qlsv.entity.sinhvien.HocSinh;

public class QuanLyHocSinh {
	public static void main(String[] args) {
		
		HocSinh hsKyBody = new HocSinh("Trần Xuân Kỳ", 1998, "Núi Thành, Quảng Nam", "0909999000", "kybody@gmail.com", new HeDaoTaoDaiHan(), new HocOffline());
		HocSinh hsHoQuanHieu = new HocSinh("Hồ Quang Hiếu", 2000, "TP HCM", "0909999999", "hieuho@gmail.com", new HeDaoTaoNganHanJava(), new HocOffline());
		HocSinh hsDavidVy = new HocSinh("Vy Thiếu Gia", 1995, "ĐN", "0999999999", "vy@gmail.com", new HeDaoTaoNganHanPHP(), new HocOnline());
		// add giang vien 
		GiangVien gvclt = new GiangVien("Cao Lê Thành","thanhcl@gmail.com");
		GiangVien gvntl = new GiangVien("Nguyễn Thành Lâm","lamnt@gmail.com");
		GiangVien gvtmt = new GiangVien("Trần Minh Thắng","thangtm@gmail.com");
		
		// add mon hoc vao he dao tao
		
		// dao tao dai han
		List<MonHoc> daotaodaihan = new ArrayList<MonHoc>();
		daotaodaihan.add(new TinHocVanPhong(gvclt));
		daotaodaihan.add(new LapTrinhCoBan(gvntl));
		daotaodaihan.add(new LapTrinhWebFrontend(gvclt));
		daotaodaihan.add(new LapTrinhPHPMySQL(gvntl));
		daotaodaihan.add(new LapTrinhJavaCoBan(gvtmt));
		daotaodaihan.add(new LapTrinhJavaWeb(gvtmt));
		daotaodaihan.add(new QuiTrinhDuAn(gvclt));

		// dao tao ngan han java
		List<MonHoc> daotaojavanganhan = new ArrayList<MonHoc>();
		daotaojavanganhan.add(new LapTrinhJavaCoBan(gvtmt));
		daotaojavanganhan.add(new LapTrinhJavaWeb(gvclt));
		// dao tao ngan han php
		List<MonHoc> daotaophpnganhan = new ArrayList<MonHoc>();
		daotaophpnganhan.add(new LapTrinhWebFrontend(gvclt));
		daotaophpnganhan.add(new LapTrinhPHPMySQL(gvntl));	
		
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoNganHanPHP heDaoTaoPHP = new HeDaoTaoNganHanPHP();
		HeDaoTaoNganHanJava heDaoTaoJava = new HeDaoTaoNganHanJava();
		
		heDaoTaoDaiHan.setDsMonHoc(daotaodaihan);
		heDaoTaoPHP.setDsMonHoc(daotaophpnganhan);
		heDaoTaoJava.setDsMonHoc(daotaojavanganhan);
		
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " + hsHoQuanHieu.getThongTinSinhVien());
		System.out.println("   - Mã Hệ Đào Tạo : " + hsHoQuanHieu.getThongTinHeDaoTao());
		System.out.println("   - Loại Hình Đào Tạo : " + hsHoQuanHieu.getCheDoHoc());
		System.out.println("	- Môn Học: ");
		for (MonHoc monHoc : daotaodaihan) {
			System.out.println("			* " + monHoc.getTenMonHoc());
			System.out.println("				Giảng Viên: " + monHoc.getTenGiangVien());
			System.out.println("				Email  : " + monHoc.getEmailGiangVien());
		}
		
		
		
		
	}
	

	
	
	
	

}