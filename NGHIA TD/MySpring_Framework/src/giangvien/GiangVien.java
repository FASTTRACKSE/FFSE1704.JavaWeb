package giangvien;

import quanlihocsinh.monhoc.MonHoc;

public class GiangVien {
	private String tenGiangVien;
	private String email;
	public GiangVien() {
		super();
	}
	public GiangVien(String tenGiangVien, String email) {
		super();
		this.tenGiangVien = tenGiangVien;
		this.email = email;
	}
	public String getTenGiangVien() {
		return tenGiangVien;
	}
	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
