package monhoc.entity;

import giangvien.entity.GiangVien;

public class LapTrinhCoBan implements MonHoc {
	String tenMonHoc ;
	GiangVien giangVien;
	public LapTrinhCoBan(String tenMonHoc, GiangVien giangVien) {
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
	public LapTrinhCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
