package quanlihocsinh.entity;

public class LapTrinhJavaWeb {
	String giangVien="";
	String tenMonHoc="Lập trình Java Web";
	public LapTrinhJavaWeb(String giangVien, String tenMonHoc) {
		super();
		this.giangVien = giangVien;
		this.tenMonHoc = tenMonHoc;
	}
	public LapTrinhJavaWeb() {
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
