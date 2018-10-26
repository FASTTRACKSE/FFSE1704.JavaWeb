package giangvien;

public class GiangVien {
	public String TenGiangVien;
	public String emailGiangVien;

	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(String tenGiangVien, String emailGiangVien) {
		super();
		TenGiangVien = tenGiangVien;
		this.emailGiangVien = emailGiangVien;
	}

	public String getTenGiangVien() {
		return TenGiangVien;
	}

	public void setTenGiangVien(String tenGiangVien) {
		TenGiangVien = tenGiangVien;
	}

	public String getEmailGiangVien() {
		return emailGiangVien;
	}

	public void setEmailGiangVien(String emailGiangVien) {
		this.emailGiangVien = emailGiangVien;
	}

	

}
