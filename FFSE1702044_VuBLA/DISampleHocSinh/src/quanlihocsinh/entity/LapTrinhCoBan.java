package quanlihocsinh.entity;

public class LapTrinhCoBan {
	String giangVien="";
	String tenMonHoc="Lập Trình Cơ Bản";
	public LapTrinhCoBan(String giangVien, String tenMonHoc) {
		super();
		this.giangVien = giangVien;
		this.tenMonHoc = tenMonHoc;
	}
	public LapTrinhCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(String giangVien) {
		this.giangVien = giangVien;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	
}
