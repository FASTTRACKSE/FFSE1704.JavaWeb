package entity;

public class GiangVien {
	private String tenGiangVien;
	private String emailGiangVien;

	public GiangVien() {
		super();
	}

	public GiangVien(String tenGiangVien, String emailGiangVien) {
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
