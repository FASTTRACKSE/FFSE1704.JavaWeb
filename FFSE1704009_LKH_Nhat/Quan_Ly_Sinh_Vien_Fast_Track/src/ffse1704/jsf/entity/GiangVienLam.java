package ffse1704.jsf.entity;

import ffse1704.jsf.giangvien.GiangVien;

public class GiangVienLam implements GiangVien {
	private String tenGiangVien = "Nguyễn Thành lâm";
	private String emailGiangVien = "LamNT@fasttrack.edu.vn";

	public GiangVienLam() {
		super();
	}

	public GiangVienLam(String tenGiangVien, String emailGiangVien) {
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
