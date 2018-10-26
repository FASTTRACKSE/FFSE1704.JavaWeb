package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class LapTrinhCoBan implements MonHoc {

	public LapTrinhCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	GiangVien giangVien;

	public LapTrinhCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}

	@Override
	public String getTenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình cơ bản";
	}

	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return  giangVien.getTenGiangVien();
	}
	
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return  giangVien.getEmail();
	}
	

}
