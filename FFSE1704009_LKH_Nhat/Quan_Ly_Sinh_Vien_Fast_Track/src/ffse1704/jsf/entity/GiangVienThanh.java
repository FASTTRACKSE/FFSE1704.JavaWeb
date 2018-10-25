package ffse1704.jsf.entity;

import ffse1704.jsf.giangvien.GiangVien;

public class GiangVienThanh implements GiangVien {
	private String tenGiangVien = "Cao Lê Thành";
	private String emailGiangVien = "ThanhCL@fasttrack.edu.vn";

	public GiangVienThanh() {
		super();
	}

	public GiangVienThanh(String tenGiangVien, String emailGiangVien) {
		super();
		this.tenGiangVien = tenGiangVien;
		this.emailGiangVien = emailGiangVien;
	}

	public String getTenGiangVien() {
		return tenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		this.tenGiangVien = tenGiangVien;
	}

	public String getEmailGiangVien() {
		return emailGiangVien;
	}

	public void setEmailGiangVien(String emailGiangVien) {
		this.emailGiangVien = emailGiangVien;
	}

}
