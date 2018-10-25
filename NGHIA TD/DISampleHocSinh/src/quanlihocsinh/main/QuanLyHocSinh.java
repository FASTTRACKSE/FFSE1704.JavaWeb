package quanlihocsinh.main;
import quanlihocsinh.entity.*;
public class QuanLyHocSinh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
HocSinh hsNghia =new HocSinh("Trương Đại Nghĩa",1993,"Duy Xuyên ,Quảng Nam","090000999","Nghia@gmail.com",new HeDaoTaoDaiHan(),new DaoTaoOnline());
HocSinh hsVy =new HocSinh("Ngô Gia Vỹ",1995,"Sơn Trà ,DN","090994999","vi@gmail.com",new HeDaoTaoNganHanJaVa(),new DaoTaoOffLine());
HocSinh hsMy =new HocSinh("Du Học Sinh",1991,"Quế Sơn ,Quảng Nam","090676767","hihihihi@gmail.com",new HeDaoTaoHavardFastTrack(),new DaoTaoOnline());

	System.out.println("thông tin sinh viên 1:");
	System.out.println("  - " +hsNghia.getThongTinSinhVien() );
	System.out.println("  - " +hsNghia.getThongTinHeDaoTao() );
	System.out.println("  - " +hsNghia.getThongTinLoaiDaoTao());

	System.out.println("thông tin sinh viên 2:");
	System.out.println("  - " +hsVy.getThongTinSinhVien() );
	System.out.println("  - " +hsVy.getThongTinHeDaoTao() );
	System.out.println("  - " +hsVy.getThongTinLoaiDaoTao());
	
	System.out.println("thông tin sinh viên 3:");
	System.out.println("  - " +hsMy.getThongTinSinhVien() );
	System.out.println("  - " +hsMy.getThongTinHeDaoTao() );
	System.out.println("  - " +hsMy.getThongTinLoaiDaoTao());
	}

}
