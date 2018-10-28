package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class LapTrinhJavaWeb implements MonHoc {

	GiangVien giangVien;

	public LapTrinhJavaWeb(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return " Lập trình java Web";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return giangVien.getEmail();
	}

	public LapTrinhJavaWeb() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
