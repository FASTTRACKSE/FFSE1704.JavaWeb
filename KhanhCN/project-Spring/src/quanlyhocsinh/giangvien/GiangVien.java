package quanlyhocsinh.giangvien;

public class GiangVien {

	String tenGiangVien;
	String email;

	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
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
