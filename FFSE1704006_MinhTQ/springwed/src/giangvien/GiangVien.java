package giangvien;

public class GiangVien {
	public String TenGiangVien;
	public String EmailGiangVien;

	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String tenGiangVien, String emailGiangVien) {
		super();
		TenGiangVien = tenGiangVien;
		EmailGiangVien = emailGiangVien;
	}

	public String getTenGiangVien() {
		return TenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		TenGiangVien = tenGiangVien;
	}

	public String getEmailGiangVien() {
		return EmailGiangVien;
	}

	public void setEmailGiangVien(String emailGiangVien) {
		EmailGiangVien = emailGiangVien;
	}

}
