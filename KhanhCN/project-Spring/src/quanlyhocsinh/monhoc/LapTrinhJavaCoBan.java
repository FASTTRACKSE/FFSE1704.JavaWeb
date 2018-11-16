package quanlyhocsinh.monhoc;

import quanlyhocsinh.giangvien.GiangVien;

public class LapTrinhJavaCoBan implements MonHoc {

	 String tenMonHoc;
	GiangVien giangVien;

	public LapTrinhJavaCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LapTrinhJavaCoBan(String tenMonHoc, GiangVien giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
	}

	public String getTenMonHoc() {
		return tenMonHoc;
	}

	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}

	public GiangVien getGiangVien() {
		return giangVien;
	}

	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
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

}
