package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class LapTrinhCoBan implements MonHoc {
	GiangVien giangVien;
	public LapTrinhCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập trình cơ bản";
	}
	@Override
	public String getGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGiangVien();
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}
