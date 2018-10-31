package quanlyhocsinh.entity;

public class GiangVien2 implements GiangVien {
	String tenGiangVien = "Cao Lê Thành";
	String email = "thanhcl@fasttrack.edu.vn";

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

	public GiangVien2(String tenGiangVien, String email) {
		super();
		this.tenGiangVien = tenGiangVien;
		this.email = email;
	}

	public GiangVien2() {
		super();
		// TODO Auto-generated constructor stub
	}

}
