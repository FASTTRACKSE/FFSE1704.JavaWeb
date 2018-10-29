package giangvien;

public class GiangVienThanh implements GiangVien {
	String tenGiangVien = "Cao Le Thành ";
	String emailGiangVien = "ThanhCL@fasttrack.edu.vn";
	public GiangVienThanh() {
		super();
		// TODO Auto-generated constructor stub
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
