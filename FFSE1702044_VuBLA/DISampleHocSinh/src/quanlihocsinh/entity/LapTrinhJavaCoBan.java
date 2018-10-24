package quanlihocsinh.entity;

public class LapTrinhJavaCoBan {
	String giangVien="";
	String tenMonHoc="Lập Trình Java Cơ Bản";
	public LapTrinhJavaCoBan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LapTrinhJavaCoBan(String giangVien, String tenMonHoc) {
		super();
		this.giangVien = giangVien;
		this.tenMonHoc = tenMonHoc;
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
