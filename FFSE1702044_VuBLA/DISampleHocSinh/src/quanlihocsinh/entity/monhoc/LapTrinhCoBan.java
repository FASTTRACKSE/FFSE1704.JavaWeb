package quanlihocsinh.entity.monhoc;

import quanlihocsinh.entity.giangvien.GiangVien;

public class LapTrinhCoBan implements MonHoc{
	
	String tenMonHoc;
	GiangVien giangVien;
	String EmailGV;
	public String gettenMonHoc() {
		// TODO Auto-generated method stub
		return "Lập Trình Cơ Bản";
	}
	
	
	public LapTrinhCoBan(String tenMonHoc, GiangVien giangVien) {
		super();
		this.tenMonHoc = tenMonHoc;
		this.giangVien = giangVien;
	}
	public LapTrinhCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTenGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getTenGV();
	}
	public String getEmailGiangVien() {
		// TODO Auto-generated method stub
		return giangVien.getEmaiGV();
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

	

	
	
	
}
