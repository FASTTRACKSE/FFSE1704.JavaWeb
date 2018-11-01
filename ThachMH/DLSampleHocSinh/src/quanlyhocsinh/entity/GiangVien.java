package quanlyhocsinh.entity;

public class GiangVien {
	String TenGiangVien;
	String EmailGV;

	public GiangVien() {
		super();
	}

	public GiangVien(String tenGiangVien, String emailGV) {
		super();
		TenGiangVien = tenGiangVien;
		EmailGV = emailGV;
	}

	public String getTenGiangVien() {
		return TenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		TenGiangVien = tenGiangVien;
	}

	public String getEmailGV() {
		return EmailGV;
	}

	public void setEmailGV(String emailGV) {
		EmailGV = emailGV;
	}

}
