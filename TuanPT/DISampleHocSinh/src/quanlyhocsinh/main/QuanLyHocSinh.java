package quanlyhocsinh.main;

import HeDaoTao.HeDaoTaoDaiHan;
import LoaiHinhDaoTao.DaoTaoOffline;
import MonHoc.LapTrinhJavaWeb;
import SinhVien.HocSinh;
import quanlyhocsinh.entity.*;

public class QuanLyHocSinh {

	public static void main(String[] args) {
		HocSinh hsTuan = new HocSinh("Thanh Tuấn",1998,"Quế Sơn","0342181917","thanhtuan@gmail.com", 
				             new HeDaoTaoDaiHan(), new DaoTaoOffline() , new LapTrinhJavaWeb());
		
		
		
		System.out.println("Thông tin sinh viên 1: ");
		System.out.println("   - " +hsTuan.getThongTinSinhVien());
		System.out.println("   - " + hsTuan.getThongTinHeDaoTao());
		System.out.println("   -" + hsTuan.getThongTin());
		System.out.println("    -" + hsTuan.getThongTinMonHoc());

		
	}

}
