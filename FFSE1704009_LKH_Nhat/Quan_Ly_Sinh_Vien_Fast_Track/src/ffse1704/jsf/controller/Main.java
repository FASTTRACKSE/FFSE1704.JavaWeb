package ffse1704.jsf.controller;

import java.util.ArrayList;
import java.util.List;

import ffse1704.jsf.entity.GiangVien;
import ffse1704.jsf.entity.HeDaoTaoDaiHan;
import ffse1704.jsf.entity.HeDaoTaoJavaCapToc;
import ffse1704.jsf.entity.HeDaoTaoPHPCapToc;
import ffse1704.jsf.entity.LoaiHinhDaoTaoOffline;
import ffse1704.jsf.entity.MonLapTrinhCoBan;
import ffse1704.jsf.entity.MonLapTrinhFrontend;
import ffse1704.jsf.entity.MonLapTrinhJavaCoBan;
import ffse1704.jsf.entity.MonLapTrinhJavaWeb;
import ffse1704.jsf.entity.MonLapTrinhPHPMySQL;
import ffse1704.jsf.entity.MonQuyTrinhDuAn;
import ffse1704.jsf.entity.MonTinHocVanPhong;
import ffse1704.jsf.entity.SinhVien;
import ffse1704.jsf.entity.monhoc.MonHoc;


public class Main {

	public static void main(String[] args) {
		
		GiangVien thanhCL = new GiangVien("Cao Lê Thành", "ThanhCL@fasttrack.edu.vn");
		GiangVien lamNT = new GiangVien("Nguyễn Thành Lâm", "LamNT@fasttrack.edu.vn");
		GiangVien thangTM = new GiangVien("Trần Minh Thắng", "ThangTM@fasttrack.edu.vn");
		
		List<MonHoc> dtDaiHan = new ArrayList<MonHoc>();
		dtDaiHan.add(new MonTinHocVanPhong( thanhCL));
		dtDaiHan.add(new MonLapTrinhCoBan( thanhCL));
		dtDaiHan.add(new MonLapTrinhFrontend(lamNT));
		dtDaiHan.add(new MonLapTrinhPHPMySQL( lamNT));
		dtDaiHan.add(new MonLapTrinhJavaCoBan(thangTM));
		dtDaiHan.add(new MonLapTrinhJavaWeb( thanhCL));
		dtDaiHan.add(new MonQuyTrinhDuAn( thanhCL));
		
		List<MonHoc> dtNganHanPHP = new ArrayList<MonHoc>();
		dtNganHanPHP.add(new MonLapTrinhFrontend( lamNT));
		dtNganHanPHP.add(new MonLapTrinhPHPMySQL( lamNT));
		
		List<MonHoc> dtNganHanJava = new ArrayList<MonHoc>();
		dtNganHanJava.add(new MonLapTrinhJavaCoBan(thangTM));
		dtNganHanJava.add(new MonLapTrinhJavaWeb(thanhCL));
		
		HeDaoTaoDaiHan heDaoTaoDaiHan = new HeDaoTaoDaiHan();
		HeDaoTaoPHPCapToc heDaoTaoPHPCapToc = new HeDaoTaoPHPCapToc();
		HeDaoTaoJavaCapToc heDaoTaoJavaCapToc = new HeDaoTaoJavaCapToc();
		
		heDaoTaoDaiHan.setDanhSachMonHoc(dtDaiHan);
		heDaoTaoPHPCapToc.setDanhSachMonHoc(dtNganHanPHP);
		heDaoTaoJavaCapToc.setDanhSachMonHoc(dtNganHanJava);
		
		
		
		SinhVien nhat = new SinhVien("FFSE1704009", "Lê Khả Hồng Nhật", "1998", "Thanh Hóa", "01697804698",
				"ffse1704009@st.fasttrack.edu.vn", heDaoTaoDaiHan, new LoaiHinhDaoTaoOffline() );
		System.out.println("Thông tin sinh viên:   ");
		System.out.println("-----" + nhat.getThongTinSinhVien());
		System.out.println("-----" + nhat.getThongTinHLoaiHinhDaoTao());
		System.out.println("-----" + nhat.getThongTinHeDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : nhat.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getMaMonHoc() + " \n 	" + monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("********************************************************");
		
		
		
		SinhVien dai = new SinhVien("FFSE1704002", "Phan Phạm Quang Đại", "1991", "Đà Nẵng", "01697804698",
				"ffse1704002@st.fasttrack.edu.vn", heDaoTaoPHPCapToc, new LoaiHinhDaoTaoOffline() );
		System.out.println("Thông tin sinh viên:   ");
		System.out.println("-----" + dai.getThongTinSinhVien());
		System.out.println("-----" + dai.getThongTinHLoaiHinhDaoTao());
		System.out.println("-----" + dai.getThongTinHeDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : dai.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getMaMonHoc() + " \n 	" + monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("********************************************************");
		
		
		
		SinhVien minh = new SinhVien("FFSE1704006", "Trương Quang Minh", "1996", "Quảng Bình", "01697804698",
				"ffse1704006@st.fasttrack.edu.vn", heDaoTaoJavaCapToc, new LoaiHinhDaoTaoOffline() );
		System.out.println("Thông tin sinh viên:   ");
		System.out.println("-----" + minh.getThongTinSinhVien());
		System.out.println("-----" + minh.getThongTinHLoaiHinhDaoTao());
		System.out.println("-----" + minh.getThongTinHeDaoTao());
		System.out.println("Môn Học:");
		for (MonHoc monHoc : minh.getHeDaoTao().getDanhSachMonHoc()) {
			System.out.println("     * " + monHoc.getMaMonHoc() + " \n 	" + monHoc.getTenMonHoc() + " \n 	"
					+ "Giảng Viên: " + monHoc.getTenGiangVien() + " \n 	" + monHoc.getEmailGiangVien());
		}
		System.out.println("********************************************************");
		
	}

}
