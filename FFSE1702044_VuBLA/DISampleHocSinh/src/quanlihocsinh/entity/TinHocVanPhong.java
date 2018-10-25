package quanlihocsinh.entity;

public class TinHocVanPhong {
	String giangVien="";
	String tenMonHoc="Tin Học Văn Phòng";
	public TinHocVanPhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TinHocVanPhong(String giangVien, String tenMonHoc) {
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
