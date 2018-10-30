package quanlyhocsinh.main;

import java.util.ArrayList;
import java.util.List;

import giangvien.GiangVien;
import loaihinhdaotao.LoaiHinhDaoTaoOffLine;
import loaihinhdaotao.LoaiHinhDaoTaoOnLine;
import monhoc.MonDaoTaoJavaCapToc;
import monhoc.MonHoc;
import monhoc.MonLapTrinhCanBan;
import monhoc.MonLapTrinhWebFrontend;
import monhoc.MonLapTrinhWebPHPMySQL;
import monhoc.MonQuyTrinhDuAn;
import monhoc.MonTinHocVanHoc;
import monhoc.MonDaoTaoJavaWed;
import quanlyhocsinh.entity.HeDaoTaoDaiHan;
import quanlyhocsinh.entity.HeDaoTaoNganHanJava;
import quanlyhocsinh.entity.HeDaoTaoNganHanPHP;
import quanlyhocsinh.entity.HocSinh;

public class main {

	public static void main(String[] args) {
		//ba heej dao tao 
		HeDaoTaoDaiHan heDaoTaoDaihan =new HeDaoTaoDaiHan();
		HeDaoTaoNganHanJava heDaoTaoNganHanJava= new HeDaoTaoNganHanJava();
		HeDaoTaoNganHanPHP heDaoTaoNganHanPHP=new HeDaoTaoNganHanPHP();

		
		//gắn già Trị giang vien Nhập từ bàn phím
		GiangVien ClThanh = new GiangVien(" Cao Lê Thành","Email: ThanhCL@gmail.com");
		GiangVien NTLam = new GiangVien("Nguyễn Thành Lâm","Email: NguyenLam@gmail.com");
		GiangVien TMThang = new GiangVien("Trần Minh Thắng","Email: TranMinhThang@gmail.com");
		
		//taoj arraylisst để luu thông tin
		List<MonHoc> daoTaoDaiHan= new ArrayList<>();
		daoTaoDaiHan.add(new MonDaoTaoJavaWed(ClThanh));
		daoTaoDaiHan.add(new MonDaoTaoJavaCapToc(TMThang));
		daoTaoDaiHan.add(new MonLapTrinhWebPHPMySQL(NTLam));
		daoTaoDaiHan.add(new MonTinHocVanHoc(NTLam));
		daoTaoDaiHan.add(new MonLapTrinhCanBan(TMThang));
		daoTaoDaiHan.add(new MonQuyTrinhDuAn(ClThanh));
		daoTaoDaiHan.add(new MonLapTrinhWebFrontend(ClThanh));
		
		List<MonHoc> daoTaoNganHanPHP=new ArrayList<>();
		daoTaoNganHanPHP.add(new MonLapTrinhWebPHPMySQL(NTLam));
		daoTaoNganHanPHP.add(new MonLapTrinhCanBan(NTLam));
		
		
		List<MonHoc> daoTaoNganHanJava=new ArrayList<>();
		daoTaoNganHanJava.add(new MonDaoTaoJavaCapToc(TMThang));
		
		//add thoong tinhvaof ba he dao tao
		heDaoTaoDaihan.setDanhsachmonhoc(daoTaoNganHanPHP);
		heDaoTaoNganHanJava.setDanhsachmonhoc(daoTaoNganHanJava);
		heDaoTaoNganHanPHP.setDanhsachmonhoc(daoTaoNganHanPHP);
	

		//gắn già Trị hoc sinh Nhập từ bàn phím
		
		HocSinh hsTruongQuangMinh = new HocSinh("Trương Quang Minh ", 1996, "Quảng Bình", "01669938191",
				"Minh@gmail.com", new LoaiHinhDaoTaoOffLine() ,heDaoTaoNganHanPHP);

		HocSinh hsTranXuanKy = new HocSinh("Trần Xuân Kỳ", 1998, "Quảng Nam", "01685545184212", "kybody@gmail.com",
				new LoaiHinhDaoTaoOffLine(),heDaoTaoDaihan);

		HocSinh hsLeKhaHongNhat = new HocSinh("Lê Khả Hồng Nhật", 1998, "Thanh Hoá", "01685112021512", "LKHN@gmail.com", new LoaiHinhDaoTaoOnLine(),heDaoTaoNganHanJava );
		
		
		System.out.println("Thông tin của học sinh 1");
		System.out.println( hsTruongQuangMinh.getThongTinHocSinh());
		System.out.println( hsTruongQuangMinh.getThongTinHeDaoTao());
		for (MonHoc c : hsTruongQuangMinh.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("*Môn học:" + c.getThongTinMonHoc() +  "\n"
					+ "*Giảng Viên: " + c.getTenGiangVien() + "\n" + c.getEmailGiangVien());
		}
		
		System.out.println("\n");
		System.out.println("Thông tin của học sinh 2");
		System.out.println(hsTranXuanKy.getThongTinHocSinh());
		System.out.println(hsTranXuanKy.getThongTinHeDaoTao());
		for (MonHoc c : hsTranXuanKy.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("*Môn học:" + c.getThongTinMonHoc() +  "\n"
					+ "*Giảng Viên: " + c.getTenGiangVien() + "\n" + c.getEmailGiangVien());
		}
		System.out.println("\n");
		System.out.println("Thông tin của học sinh 3");
		System.out.println(hsLeKhaHongNhat.getThongTinHocSinh());
		System.out.println(hsLeKhaHongNhat.getThongTinHeDaoTao());
		for (MonHoc c : hsLeKhaHongNhat.getHeDaoTao().getDanhsachmonhoc()) {
			System.out.println("*Môn học:" + c.getThongTinMonHoc() +  "\n"
					+ "*Giảng Viên: " + c.getTenGiangVien() + "\n" + c.getEmailGiangVien());
		}
	}

}
