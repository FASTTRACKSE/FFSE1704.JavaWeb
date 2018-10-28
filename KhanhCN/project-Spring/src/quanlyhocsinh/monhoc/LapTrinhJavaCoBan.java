package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class LapTrinhJavaCoBan implements MonHoc {

	GiangVien giangVien;

	public LapTrinhJavaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình java cơ bản ";

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

	public LapTrinhJavaCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
