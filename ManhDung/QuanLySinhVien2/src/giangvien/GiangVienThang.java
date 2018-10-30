package giangvien;

public class GiangVienThang implements GiangVien {
	String tenGiangVien = "Nguyễn Thắng ";
	public GiangVienThang() {
		super();
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
	public GiangVienThang(String tenGiangVien, String emailGiangVien) {
		super();
		this.tenGiangVien = tenGiangVien;
		this.emailGiangVien = emailGiangVien;
	}
	String emailGiangVien = "Thang@fasttrack.edu.vn";
}
