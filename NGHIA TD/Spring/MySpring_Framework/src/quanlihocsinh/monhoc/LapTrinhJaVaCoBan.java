package quanlihocsinh.monhoc;

import giangvien.GiangVien;

public class LapTrinhJaVaCoBan implements MonHoc {
	GiangVien giangVien;
	public LapTrinhJaVaCoBan(GiangVien giangVien) {
		super();
		this.giangVien = giangVien;
	}
	@Override
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return null;
	}
	public LapTrinhJaVaCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}



	
}
